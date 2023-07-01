package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    ProductOrder createProductOrder(ProductOrder productOrder);

    List getProductOrdersByProductID(Long productId);

    List getProductOrdersByOrderID(Long orderId);

    ProductOrder updateProductOrder(ProductOrder productOrder, Long orderId, Long productId);

    void deleteProductOrder(Long orderId, Long productId);

}
