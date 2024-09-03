package be.bstorm.tf_java2024_demospringapi.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
public class OrderLine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne
    private Order order;

    public OrderLine(int quantity) {
        this.quantity = quantity;
    }
}
