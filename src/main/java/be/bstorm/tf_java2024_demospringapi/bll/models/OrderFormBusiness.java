package be.bstorm.tf_java2024_demospringapi.bll.models;

import be.bstorm.tf_java2024_demospringapi.dl.entities.OrderLine;

import java.util.Set;

public record OrderFormBusiness(
    String comment,
    Set<OrderLineFormBusiness> orderLines
) {
}
