package be.bstorm.tf_java2024_demospringapi.bll.models;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Order;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTOBusiness{

    private Long id;

    private String comment;

    private LocalDateTime orderDate;

    private Set<OrderLineDTOBusiness> orderLines;

    public OrderDTOBusiness(Long id, String comment, LocalDateTime orderDate) {
        this.id = id;
        this.comment = comment;
        this.orderDate = orderDate;
    }

    public static OrderDTOBusiness fromEntity(Order o){
        return new OrderDTOBusiness(o.getId(), o.getComment(), o.getOrderDate());
    }
}
