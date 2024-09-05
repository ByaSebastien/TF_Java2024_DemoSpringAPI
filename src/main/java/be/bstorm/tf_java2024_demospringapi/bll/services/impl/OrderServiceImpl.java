package be.bstorm.tf_java2024_demospringapi.bll.services.impl;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderDTOBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderFormBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderLineDTOBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderLineFormBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.services.OrderService;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.OrderLineRepository;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.OrderRepository;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.ProductRepository;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Order;
import be.bstorm.tf_java2024_demospringapi.dl.entities.OrderLine;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void addOrder(OrderFormBusiness form, User user) {
        Order order = new Order(form.comment());
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        orderRepository.save(order);

        for(OrderLineFormBusiness ol : form.orderLines()){
            Product p = productRepository.findById(ol.productId()).orElseThrow();
            if(p.getQuantity() < ol.quantity()){
                throw new RuntimeException("Not enough stock");
            }
            OrderLine orderLine = new OrderLine(ol.quantity());
            orderLine.setProduct(p);
            orderLine.setOrder(order);
            p.setQuantity(p.getQuantity() - ol.quantity());
            orderLineRepository.save(orderLine);
        }
    }

    @Override
    public OrderDTOBusiness getOrder(Long orderId) {
        OrderDTOBusiness order = OrderDTOBusiness.fromEntity(orderRepository.findById(orderId).orElseThrow());
        Set<OrderLineDTOBusiness> orderLines = orderLineRepository.findByOrderId(orderId).stream()
                .map(OrderLineDTOBusiness::fromEntity)
                .collect(Collectors.toSet());
        order.setOrderLines(orderLines);
        return order;
    }
}
