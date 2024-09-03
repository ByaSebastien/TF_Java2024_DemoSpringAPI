package be.bstorm.tf_java2024_demospringapi.pl.models.product;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;

public record ProductDetailsDTO(
        Long id,
        String name,
        String description,
        Double price
) {

    public static ProductDetailsDTO fromEntity(Product product) {
        return new ProductDetailsDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
