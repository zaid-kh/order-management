package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // Custom query to find stocks by productId
    @Query("SELECT s FROM Stock s WHERE s.product.id = :productId")
    List<Stock> findByProductId(@Param("productId") Long productId);

}
