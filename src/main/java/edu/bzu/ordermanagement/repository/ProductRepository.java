package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
