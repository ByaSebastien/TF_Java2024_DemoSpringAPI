package be.bstorm.tf_java2024_demospringapi.pl.controllers;

import be.bstorm.tf_java2024_demospringapi.bll.services.ProductService;
import be.bstorm.tf_java2024_demospringapi.pl.models.product.ProductDetailsDTO;
import be.bstorm.tf_java2024_demospringapi.pl.models.product.ProductForm;
import be.bstorm.tf_java2024_demospringapi.pl.models.product.ProductShortDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductShortDTO>> getAllProducts() {
        List<ProductShortDTO> products = productService.getAll().stream()
                .map(ProductShortDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id:^\\d+}")
    public ResponseEntity<ProductDetailsDTO> getProduct(@PathVariable long id) {
        ProductDetailsDTO product = ProductDetailsDTO.fromEntity(productService.getById(id));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductForm form){
        Long id = productService.create(form.toEntity());
        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id:^\\d+}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @Valid @RequestBody ProductForm form){
        productService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:^\\d+}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
