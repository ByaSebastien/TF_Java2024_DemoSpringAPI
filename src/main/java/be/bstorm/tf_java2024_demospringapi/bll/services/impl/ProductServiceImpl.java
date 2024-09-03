package be.bstorm.tf_java2024_demospringapi.bll.services.impl;

import be.bstorm.tf_java2024_demospringapi.bll.services.ProductService;
import be.bstorm.tf_java2024_demospringapi.dal.repositories.ProductRepository;
import be.bstorm.tf_java2024_demospringapi.dl.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    @Override
    public Long create(Product product) {
        if(productRepository.existsByName(product.getName())){
            throw new RuntimeException("Product with name " + product.getName() + " already exists");
        }
        return productRepository.save(product).getId();
    }

    @Override
    public void update(Long id, Product product) {
        Product existingProduct = getById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        productRepository.save(existingProduct);
    }

    @Override
    public void delete(Long id) {
        Product existingProduct = getById(id);
        productRepository.delete(existingProduct);
    }
}
