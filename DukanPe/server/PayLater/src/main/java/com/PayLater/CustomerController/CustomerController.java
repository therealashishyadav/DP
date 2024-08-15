package com.PayLater.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.PayLater.CustomerRepository.CustomerRepository;
import com.PayLater.model.Customer;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
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

            Customer updatedCustomerEntity = customerRepository.save(customer);
            return new ResponseEntity<>(updatedCustomerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Get customer by customerName
    @GetMapping("/{customerName}")
    public ResponseEntity<Customer> getCustomerByCustomerName(@PathVariable String customerName) {
        Optional<Customer> customerOptional = customerRepository.findByCustomerName(customerName);
        return customerOptional.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
