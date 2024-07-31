package com.example.repository;

public interface CustomerRepository {
    Customer getCustomer(int customerId);
    void saveCustomer(Customer customer);
}