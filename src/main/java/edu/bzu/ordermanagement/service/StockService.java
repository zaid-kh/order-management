package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock createStock(Stock stock);

    Stock updateStock(Stock stock, Long id);

    void deleteStock(Long id);

    List<Stock> getAllStocks();

    Optional getStockById(Long id);

    List<Stock> getStocksByProductId(Long id);
}
