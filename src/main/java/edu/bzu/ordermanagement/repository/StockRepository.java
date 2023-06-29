package edu.bzu.ordermanagement.repository;

import edu.bzu.ordermanagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
