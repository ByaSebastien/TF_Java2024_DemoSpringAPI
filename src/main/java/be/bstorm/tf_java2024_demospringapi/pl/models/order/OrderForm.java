package be.bstorm.tf_java2024_demospringapi.pl.models.order;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderFormBusiness;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.stream.Collectors;

public record OrderForm(
        @Size(max = 255)
        String comment,
        @NotNull
        Set<OrderLineForm> orderLines
) {

    public OrderFormBusiness toBusiness(){
        return new OrderFormBusiness(comment,orderLines.stream().map(OrderLineForm::toBusiness).collect(Collectors.toSet()));
    }
}
