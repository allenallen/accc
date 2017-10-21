package com.accc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;

public interface CarRepository extends JpaRepository<Car, String>{

	List<Car> findByCustomer(Customer customer);
}
