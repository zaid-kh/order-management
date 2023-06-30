package edu.bzu.ordermanagement.service;

import edu.bzu.ordermanagement.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create(Customer customer);

    List<Customer> getAllCustomers();

    Customer update(Customer customer, Long id);

    Optional getCustomerById(Long id); // optional is a container object used to contain not-null objects and avoid null pointer exception

    void delete(Long id);

}
