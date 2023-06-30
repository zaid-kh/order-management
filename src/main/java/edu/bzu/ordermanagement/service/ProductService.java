package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Optional getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct( Product product, Long id);

    void deleteProduct(Long id);


}
