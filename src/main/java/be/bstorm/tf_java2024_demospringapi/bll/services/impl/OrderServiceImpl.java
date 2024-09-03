package be.bstorm.tf_java2024_demospringapi.bll.services.impl;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderFormBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderLineFormBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.services.OrderService;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.OrderLineRepository;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.OrderRepository;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.ProductRepository;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Order;
import be.bstorm.tf_java2024_demospringapi.dl.entities.OrderLine;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void addOrder(OrderFormBusiness form) {
        Order order = new Order(form.comment());
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);

        for(OrderLineFormBusiness ol : form.orderLines()){
            Product p = productRepository.findById(ol.productId()).orElseThrow();
            if(p.getQuantity() < ol.quantity()){
                throw new RuntimeException("Not enough stock");
            }
            OrderLine orderLine = new OrderLine(ol.quantity());
            orderLine.setProduct(p);
            orderLine.setOrder(order);
            orderLineRepository.save(orderLine);
        }
    }
}
