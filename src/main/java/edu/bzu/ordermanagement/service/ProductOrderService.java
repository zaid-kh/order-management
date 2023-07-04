package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.ProductOrder;

import java.util.List;
import java.util.Optional;

public interface ProductOrderService {
    ProductOrder createProductOrder(ProductOrder productOrder);

    List<ProductOrder> getProductOrders();

    List<ProductOrder> getProductOrdersByProductID(Long productId);

    List<ProductOrder> getProductOrdersByOrderID(Long orderId);

    Optional<ProductOrder> getProductOrder(Long orderId, Long productId);

    ProductOrder updateProductOrder(ProductOrder productOrder, Long orderId, Long productId);

    void deleteProductOrder(Long orderId, Long productId);

}
