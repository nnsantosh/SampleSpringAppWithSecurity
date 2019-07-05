package com.test.service;

import com.test.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomersByLastName(String lastName) throws Exception;

    public Customer saveCustomerInformation(Customer customer) throws Exception;
}
