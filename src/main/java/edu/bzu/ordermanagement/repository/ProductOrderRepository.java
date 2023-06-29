package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
