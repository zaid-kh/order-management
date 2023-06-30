package edu.bzu.ordermanagement.service.impl;

import edu.bzu.ordermanagement.entity.Customer;
import edu.bzu.ordermanagement.repository.CustomerRepository;
import edu.bzu.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer, Long id) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public Optional getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
