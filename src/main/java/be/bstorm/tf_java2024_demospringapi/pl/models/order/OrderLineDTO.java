package be.bstorm.tf_java2024_demospringapi.pl.models.order;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderLineDTOBusiness;

public record OrderLineDTO(
        Long id,
        int quantity,
        String productName
) {

    public static OrderLineDTO fromBusiness(OrderLineDTOBusiness ol){
        return new OrderLineDTO(ol.id(), ol.quantity(), ol.productName());
    }
}
