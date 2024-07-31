package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRepositoryImpl;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl(customerRepository());
    }
}