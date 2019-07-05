package com.test.repository;

import com.test.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("Select c from Customer c where c.lastName = :lastName")
    List<Customer> findByLastName(@Param("lastName") String lastName);


}