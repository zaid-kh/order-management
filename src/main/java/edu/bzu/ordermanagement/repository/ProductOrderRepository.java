package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.ProductOrder;
import edu.bzu.ordermanagement.entity.id.ProductOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId> {

    // custom queries
    @Query("SELECT po FROM ProductOrder po WHERE po.order.id = ?1 AND po.product.id = ?2")
    Optional<ProductOrder> findByOrderIdAndProductId(Long orderId, Long productId);

    @Query("SELECT po FROM ProductOrder po WHERE po.order.id = ?1")
    List<ProductOrder> findByOrderId(Long orderId);

    @Query("SELECT po FROM ProductOrder po WHERE po.product.id = ?1")
    List<ProductOrder> findByProductId(Long productId);


}
