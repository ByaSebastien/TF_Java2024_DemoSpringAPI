package be.bstorm.tf_java2024_demospringapi.bll.services;

import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getById(Long id);
    Long create(Product product);
    void update(Long id, Product product);
    void delete(Long id);
}
