package edu.bzu.ordermanagement.controller;


import edu.bzu.ordermanagement.entity.Stock;
import edu.bzu.ordermanagement.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the stocks"),
            @ApiResponse(responseCode = "404", description = "Stocks not found")
    })
    @Operation(summary = "Get all stocks")
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the stock"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @Operation(summary = "Create a new stock")
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.createStock(stock);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the stock"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @Operation(summary = "Update stock by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock, @PathVariable Long id) {
        Stock updatedStock = stockService.updateStock(stock, id);
        if (updatedStock != null) {
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted the stock"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @Operation(summary = "Delete stock by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the stock"),
            @ApiResponse(responseCode = "404", description = "Stock not found")
    })
    @Operation(summary = "Get stock by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the stocks"),
            @ApiResponse(responseCode = "404", description = "Stocks not found")
    })
    @Operation(summary = "Get stocks by product ID")
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Stock>> getStocksByProductId(@PathVariable Long id) {
        List<Stock> stocks = stockService.getStocksByProductId(id);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}