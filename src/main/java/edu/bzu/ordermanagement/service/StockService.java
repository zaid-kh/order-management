package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Stock;

import java.util.Optional;

public interface StockService {
    Stock createStock(Stock stock);

    Stock updateStock(Stock stock, Long id);

    void deleteStock(Long id);

    Optional getStockById(Long id);

    Optional getStockByProductId(Long id);
}
