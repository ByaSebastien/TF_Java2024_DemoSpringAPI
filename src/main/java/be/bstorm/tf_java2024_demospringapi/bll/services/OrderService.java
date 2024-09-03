package be.bstorm.tf_java2024_demospringapi.bll.services;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderDTOBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderFormBusiness;

public interface OrderService {

    void addOrder(OrderFormBusiness form);
    OrderDTOBusiness getOrder(Long orderId);
}
