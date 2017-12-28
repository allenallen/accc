package com.accc.service;

import java.util.List;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.forms.CarForm;

public interface CarService {

	Car create(CarForm form);

	Car update(Car car, CarForm form);

	List<Car> findByCustomer(Customer customer);
	
	List<Car> findAll();

	Car findById(String id);
}
