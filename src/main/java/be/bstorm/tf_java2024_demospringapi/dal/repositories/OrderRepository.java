package be.bstorm.tf_java2024_demospringapi.dal.repositories;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
