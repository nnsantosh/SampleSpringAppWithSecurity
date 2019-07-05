package com.test.service;

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomersByLastName(String lastName) throws Exception{
        if(StringUtils.isBlank(lastName)){
            throw new Exception("last name cannot be null or empty");
        }
        return customerRepository.findByLastName(lastName);
    }

    public Customer saveCustomerInformation(Customer customer) throws Exception{
        if(StringUtils.isBlank(customer.getFirstName())){
                throw new Exception("first name cannot be null or empty");
        }
        if(StringUtils.isBlank(customer.getLastName())){
            throw new Exception("last name cannot be null or empty");
        }
        return customerRepository.save(customer);

    }
}
