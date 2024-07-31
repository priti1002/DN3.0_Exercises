package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.service.CustomerService;
import com.example.Customer;

public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        // Create a customer object
        Customer newCustomer = new Customer(1, "John Doe", "john.doe@example.com");

        // Add customer using the service
        customerService.addCustomer(newCustomer);

        // Get customer details
        Customer customer = customerService.getCustomerDetails(1);
        System.out.println(customer);  // Output: Customer{id=1, name='John Doe', email='john.doe@example.com'}
    }
}