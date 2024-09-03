package be.bstorm.tf_java2024_demospringapi.dal.repositories;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select count(p) > 0 from Product p where p.name ilike :name")
    boolean existsByName(@Param("name") String name);
}
