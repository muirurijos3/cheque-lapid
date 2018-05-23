package com.ke.chequelapid.controller;

import com.ke.chequelapid.domain.Customer;
import com.ke.chequelapid.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.dom.exception.InvalidAccessException;

@RequestMapping(value = "customer", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "customer/{customerId}",method = {RequestMethod.PUT})
    @ResponseBody
    public Customer saveCheque(@PathVariable(value = "customerId")Customer customer, @RequestBody Customer updatedCustomer){
        if(customer.getId() != updatedCustomer.getId()){
            throw new InvalidAccessException("Sorry the customers arent the same");
        }
        return customerService.updateCustomer(customer, updatedCustomer);
    }
}
