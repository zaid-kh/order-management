package edu.bzu.ordermanagement.service.impl;

import edu.bzu.ordermanagement.entity.Stock;
import edu.bzu.ordermanagement.repository.StockRepository;
import edu.bzu.ordermanagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock, Long id) {
        stock.setId(id);
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> getStocksByProductId(Long productId) {

        return stockRepository.findByProductId(productId);
    }
}
