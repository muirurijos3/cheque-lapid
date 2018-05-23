package com.ke.chequelapid.service;

import com.ke.chequelapid.domain.Customer;

public interface CustomerService {
    Customer updateCustomer(Customer customer, Customer updatedCustomer);
}
