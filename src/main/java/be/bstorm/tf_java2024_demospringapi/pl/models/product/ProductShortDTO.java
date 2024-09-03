package be.bstorm.tf_java2024_demospringapi.pl.models.product;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;

public record ProductShortDTO(
        Long id,
        String name,
        Double price
) {

    public static ProductShortDTO fromEntity(Product product) {
        return new ProductShortDTO(product.getId(), product.getName(), product.getPrice());
    }
}
