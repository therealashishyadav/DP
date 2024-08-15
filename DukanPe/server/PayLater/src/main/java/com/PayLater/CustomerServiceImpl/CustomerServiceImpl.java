package com.PayLater.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PayLater.CustomerRepository.CustomerRepository;
import com.PayLater.CustomerService.CustomerService;
import com.PayLater.model.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setCustomerName(updatedCustomer.getCustomerName());
            customer.setCustomerPhone(updatedCustomer.getCustomerPhone());
            customer.setCustomerEmail(updatedCustomer.getCustomerEmail());
            customer.setCustomerAddress(updatedCustomer.getCustomerAddress());
            customer.setCustomerIdType(updatedCustomer.getCustomerIdType());
            customer.setCustomerId(updatedCustomer.getCustomerId());
            customer.setItemsPurchased(updatedCustomer.getItemsPurchased());
            customer.setAmountToBePaid(updatedCustomer.getAmountToBePaid());
            customer.setPurchaseDate(updatedCustomer.getPurchaseDate());
            customer.setDueDate(updatedCustomer.getDueDate());

            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with ID " + id + " not found");
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
}
