package be.bstorm.tf_java2024_demospringapi.pl.models.product;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record ProductForm(
        @NotBlank
        @Size(max = 100)
        String name,

        @Size(max = 255)
        String description,

        @NotNull
        @Range(min = 0)
        Double price,

        @NotNull
        @Range(min = 0)
        Integer quantity
) {

    public Product toEntity() {
        return new Product(name, description, price, quantity);
    }
}
