package com.accc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.forms.CarForm;
import com.accc.repository.CarRepository;
import com.accc.repository.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional(readOnly = false)
	public Car create(CarForm form) {
		Customer customer = customerRepository.findOne(form.getCustomerId());
		Car car = Car.createFromForm(form, customer);
		
		return carRepository.save(car);
	}

	@Override
	public Car update(Car car, CarForm form) {
		car.updateFromForm(form);
		return carRepository.save(car);
	}

	@Override
	public List<Car> findByCustomer(Customer customer) {
		return carRepository.findByCustomer(customer);
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

}
