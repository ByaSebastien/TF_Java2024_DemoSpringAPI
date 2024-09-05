package be.bstorm.tf_java2024_demospringapi.bll.services;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderDTOBusiness;
import be.bstorm.tf_java2024_demospringapi.bll.models.OrderFormBusiness;
import be.bstorm.tf_java2024_demospringapi.dl.entities.User;

public interface OrderService {

    void addOrder(OrderFormBusiness form, User user);
    OrderDTOBusiness getOrder(Long orderId);
}
