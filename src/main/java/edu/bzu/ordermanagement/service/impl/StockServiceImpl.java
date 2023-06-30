package edu.bzu.ordermanagement.service.impl;

import edu.bzu.ordermanagement.entity.Product;
import edu.bzu.ordermanagement.entity.Stock;
import edu.bzu.ordermanagement.repository.StockRepository;
import edu.bzu.ordermanagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
    public Optional getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Optional getStockByProductId(Long productId) {
        Stock stockExample = new Stock();
        Product product = new Product();
        product.setId(productId);
        stockExample.setProduct(product);
        Example<Stock> example = Example.of(stockExample);
        return stockRepository.findOne(example);
    }
}
