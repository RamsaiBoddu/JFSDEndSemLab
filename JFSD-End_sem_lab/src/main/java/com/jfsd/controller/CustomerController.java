package com.jfsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jfsd.model.Customer;
import com.jfsd.repository.CustomerRepository;

import java.util.Date;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, 
                                                   @RequestParam String name, 
                                                   @RequestParam String address) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(name);
        customer.setAddress(address);

        customerRepository.save(customer);

        return ResponseEntity.ok(customer);
    }

    @PostMapping("/add-customers")
    public ResponseEntity<String> addCustomer() {
        Customer customer1 = new Customer();
        customer1.setName("Gowtham");
        customer1.setEmail("gow@gmail.com");
        customer1.setPhoneNumber("7418529630");
        customer1.setAddress("KHM");
        customer1.setDateOfBirth(new Date());

        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Eshwar");
        customer2.setEmail("esh@gmail.com");
        customer2.setPhoneNumber("7418529630");
        customer2.setAddress("Hyd");
        customer2.setDateOfBirth(new Date());

        customerRepository.save(customer2);

        return ResponseEntity.ok("Customers added successfully!");
    }
}
