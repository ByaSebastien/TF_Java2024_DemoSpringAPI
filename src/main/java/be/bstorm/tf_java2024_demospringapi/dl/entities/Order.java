package be.bstorm.tf_java2024_demospringapi.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
@Entity
@Table(name = "order_")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderDate;

    private String comment;

    public Order(String comment) {
        this.comment = comment;
    }
}
