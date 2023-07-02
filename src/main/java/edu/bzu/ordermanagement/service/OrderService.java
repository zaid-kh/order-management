package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getAllOrders();

    Optional getOrderById(Long id);

    List<Order> getOrdersByCustomerId(Long id);

    Order updateOrder(Order order, Long id);

    void deleteOrder(Long id);

}
