package com.PayLater.CustomerService;

import java.util.List;
import java.util.Optional;

import com.PayLater.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    
    Customer updateCustomer(Long id, Customer updatedCustomer);
    
    void deleteCustomer(Long id);
    
    List<Customer> getAllCustomers();
    
    Optional<Customer> getCustomerByCustomerName(String customerName);
}
