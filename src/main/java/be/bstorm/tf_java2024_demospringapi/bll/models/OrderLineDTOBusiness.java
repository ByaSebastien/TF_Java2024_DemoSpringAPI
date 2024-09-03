package be.bstorm.tf_java2024_demospringapi.bll.models;

import be.bstorm.tf_java2024_demospringapi.dl.entities.OrderLine;

public record OrderLineDTOBusiness(
        Long id,
        int quantity,
        String productName
){

    public static OrderLineDTOBusiness fromEntity(OrderLine ol){
        return new OrderLineDTOBusiness(ol.getId(),ol.getQuantity(),ol.getProduct().getName());
    }
}
