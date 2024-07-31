package com.example.service;

public interface CustomerService {
    Customer getCustomerDetails(int customerId);
    void addCustomer(Customer customer);
}