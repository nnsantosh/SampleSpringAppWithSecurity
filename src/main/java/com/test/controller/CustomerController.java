package com.test.controller;

import com.test.entity.Customer;

import com.test.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping(value = {"/saveCustomer"}, headers ={"Accept=application/json"})
    public Customer createCustomer(@RequestBody Customer customer) throws Exception{
        Customer savedCustomer = customerService.saveCustomerInformation(customer);
        return savedCustomer;
    }

    @RequestMapping(value = {"/getCustomerDetailsByLastName/{lastName}"},method = RequestMethod.GET)
    public @ResponseBody List<Customer> getCustomerDetailsByLastName(@PathVariable String lastName) throws Exception{
        List<Customer> customers = customerService.getCustomersByLastName(lastName);
        return customers;
    }
}
