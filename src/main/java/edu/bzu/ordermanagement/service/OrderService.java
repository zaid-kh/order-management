package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Order;

import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Optional getOrderById(Long id);

    Optional getOrderByCustomerId(Long id);

    Order updateOrder(Order order, Long id);

    void deleteOrder(Long id);

}
