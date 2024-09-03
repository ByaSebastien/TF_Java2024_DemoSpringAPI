package be.bstorm.tf_java2024_demospringapi.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 100)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = true)
    private Integer quantity;

    public Product(String name, String description, Double price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
