package edu.bzu.ordermanagement.service.impl;

import edu.bzu.ordermanagement.entity.Customer;
import edu.bzu.ordermanagement.entity.Order;
import edu.bzu.ordermanagement.repository.OrderRepository;
import edu.bzu.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional getOrderByCustomerId(Long id) {
        Order orderExample = new Order();
        Customer customer = new Customer();
        customer.setId(id);
        orderExample.setCustomer(customer);
        Example<Order> example = Example.of(orderExample);
        return orderRepository.findOne(example);
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
