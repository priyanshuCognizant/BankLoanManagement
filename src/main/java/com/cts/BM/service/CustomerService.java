package com.cts.BM.service;

import com.cts.BM.model.Customer;
import com.cts.BM.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Logic for account creation and KYC initialization [cite: 9, 32]
    public Customer registerCustomer(Customer customer) {
        // Business rule: All new accounts start with PENDING status [cite: 40]
        customer.setKycStatus(Customer.KycStatus.PENDING);
        return customerRepository.save(customer);
    }

    // Logic for account maintenance [cite: 9]
    public Customer getCustomerDetails(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Update customer profile logic [cite: 28]
    public Customer updateCustomer(Integer id, Customer updatedData) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(updatedData.getName());
            customer.setEmail(updatedData.getEmail());
            customer.setPhone(updatedData.getPhone());
            customer.setAddress(updatedData.getAddress());
            return customerRepository.save(customer);
        }).orElse(null);
    }
}