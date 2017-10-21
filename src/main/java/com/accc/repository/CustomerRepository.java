package com.accc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accc.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

	//@Query("SELECT customer FROM Customer customer WHERE customer.name LIKE %:name%")
	List<Customer> findByNameContaining(String name);
}
