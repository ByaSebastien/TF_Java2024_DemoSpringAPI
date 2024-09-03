package be.bstorm.tf_java2024_demospringapi.pl.models.order;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderDTOBusiness;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record OrderDTO(
        Long id,
        String comment,
        LocalDateTime orderDate,
        Set<OrderLineDTO> orderLines
) {

    public static OrderDTO fromBusiness(OrderDTOBusiness o) {
        return new OrderDTO(o.getId(),
                o.getComment(),
                o.getOrderDate(),
                o.getOrderLines().stream()
                        .map(OrderLineDTO::fromBusiness)
                        .collect(Collectors.toSet()));
    }
}
