package edu.bzu.ordermanagement.controller;

import edu.bzu.ordermanagement.entity.ProductOrder;
import edu.bzu.ordermanagement.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder createdProductOrder = productOrderService.createProductOrder(productOrder);
        return new ResponseEntity<>(createdProductOrder, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductOrder>> getProductOrdersByProductId(@PathVariable Long productId) {
        List<ProductOrder> productOrders = productOrderService.getProductOrdersByProductID(productId);
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<ProductOrder>> getProductOrdersByOrderId(@PathVariable Long orderId) {
        List<ProductOrder> productOrders = productOrderService.getProductOrdersByOrderID(orderId);
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<ProductOrder> getProductOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        Optional<ProductOrder> productOrder = productOrderService.getProductOrder(orderId, productId);
        return productOrder.map(po -> new ResponseEntity<>(po, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder,
                                                           @PathVariable Long orderId,
                                                           @PathVariable Long productId) {
        ProductOrder updatedProductOrder = productOrderService.updateProductOrder(productOrder, orderId, productId);
        if (updatedProductOrder != null) {
            return new ResponseEntity<>(updatedProductOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<Void> deleteProductOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        productOrderService.deleteProductOrder(orderId, productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
