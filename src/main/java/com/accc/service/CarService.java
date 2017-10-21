package com.accc.service;

import java.util.List;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.forms.CarForm;

public interface CarService {

	Car create(Car car);

	Car update(Car car, CarForm form);

	List<Car> findByCustomer(Customer customer);
}
