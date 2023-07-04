package edu.bzu.ordermanagement.controller;

import edu.bzu.ordermanagement.entity.ProductOrder;
import edu.bzu.ordermanagement.service.ProductOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    // get all product orders
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product orders"),
            @ApiResponse(responseCode = "404", description = "Product orders not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Operation(summary = "Get all product orders")
    @GetMapping
    public ResponseEntity<List<ProductOrder>> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderService.getProductOrders();
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the product order"),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @Operation(summary = "Create a new product order")
    @PostMapping
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder createdProductOrder = productOrderService.createProductOrder(productOrder);
        return new ResponseEntity<>(createdProductOrder, HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product orders"),
            @ApiResponse(responseCode = "404", description = "Product orders not found")
    })
    @Operation(summary = "Get product orders by product ID")
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductOrder>> getProductOrdersByProductId(@Parameter(description = "ID of product to find Orders for") @PathVariable Long productId) {
        List<ProductOrder> productOrders = productOrderService.getProductOrdersByProductID(productId);
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product orders"),
            @ApiResponse(responseCode = "404", description = "Product orders not found")
    })
    @Operation(summary = "Get product orders by order ID")
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ProductOrder>> getProductOrdersByOrderId(@PathVariable Long orderId) {
        List<ProductOrder> productOrders = productOrderService.getProductOrdersByOrderID(orderId);
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product order"),
            @ApiResponse(responseCode = "404", description = "Product order not found")
    })
    @Operation(summary = "Get Product-Order by order ID and product ID")
    @GetMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<ProductOrder> getProductOrder(@Parameter(description = "ID of order to be retrieved") @PathVariable Long orderId, @Parameter(description = "ID of product to be retrieved")
    @PathVariable Long productId) {
        Optional<ProductOrder> productOrder = productOrderService.getProductOrder(orderId, productId);
        return productOrder.map(po -> new ResponseEntity<>(po, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product order"),
            @ApiResponse(responseCode = "404", description = "Product order not found")
    })
    @Operation(summary = "Get Product-Order by order ID and product ID")
    @PutMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder,
                                                           @Parameter(description = "Order ID of productOrder to be updated")
                                                           @PathVariable Long orderId,
                                                           @Parameter(description = "Product ID of productOrder to be updated")
                                                           @PathVariable Long productId) {
        ProductOrder updatedProductOrder = productOrderService.updateProductOrder(productOrder, orderId, productId);
        if (updatedProductOrder != null) {
            return new ResponseEntity<>(updatedProductOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product order deleted"),
            @ApiResponse(responseCode = "404", description = "Product order not found")
    })
    @Operation(summary = "Delete Product-Order by order ID and product ID")
    @DeleteMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<Void> deleteProductOrder(@Parameter(description = "Order ID of productOrder to be deleted")
                                                   @PathVariable Long orderId,
                                                   @Parameter(description = "Product ID of productOrder to be deleted")
                                                   @PathVariable Long productId) {
        productOrderService.deleteProductOrder(orderId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
