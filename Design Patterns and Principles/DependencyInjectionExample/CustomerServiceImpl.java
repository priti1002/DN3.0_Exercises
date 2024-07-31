package com.example.service;

import com.example.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getCustomerDetails(int customerId) {
        return repository.getCustomer(customerId);
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.saveCustomer(customer);
    }
}