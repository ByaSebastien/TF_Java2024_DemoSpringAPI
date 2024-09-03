package be.bstorm.tf_java2024_demospringapi.dal.repositories;

import be.bstorm.tf_java2024_demospringapi.dl.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query("select ol from OrderLine ol join ol.order where ol.order.id = :orderId")
    public Set<OrderLine> findByOrderId(@Param("orderId") Long orderId);
}
