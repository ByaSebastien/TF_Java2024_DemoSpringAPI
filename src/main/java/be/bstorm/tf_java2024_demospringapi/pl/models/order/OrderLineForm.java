package be.bstorm.tf_java2024_demospringapi.pl.models.order;

import be.bstorm.tf_java2024_demospringapi.bll.models.OrderLineFormBusiness;
import org.hibernate.validator.constraints.Range;

public record OrderLineForm(
        @Range(min = 0)
        int quantity,
        Long productId
) {

    public OrderLineFormBusiness toBusiness() {
        return new OrderLineFormBusiness(quantity, productId);
    }
}
