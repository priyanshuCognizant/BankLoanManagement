package com.cts.BM.controller;

import com.cts.BM.model.Customer;
import com.cts.BM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Endpoint for customer registration [cite: 27]
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    // Endpoint to get details for KYC verification [cite: 23, 27]
    @GetMapping("/{id}")
    public Customer getCustomerDetails(@PathVariable Integer id) {
        return customerService.getCustomerDetails(id);
    }

    // Endpoint to update account details [cite: 28]
    @PutMapping("/update/{id}")
    public Customer updateCustomerProfile(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
}
