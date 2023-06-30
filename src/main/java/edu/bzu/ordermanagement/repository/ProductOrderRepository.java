package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: change the key type
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
