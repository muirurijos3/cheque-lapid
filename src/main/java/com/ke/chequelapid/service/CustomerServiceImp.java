package com.ke.chequelapid.service;

import com.ke.chequelapid.domain.Customer;
import com.ke.chequelapid.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer updateCustomer(Customer customer, Customer updatedCustomer) {
//        customer.merge(updatedCustomer);
        return customerRepository.save(updatedCustomer);
    }
}
