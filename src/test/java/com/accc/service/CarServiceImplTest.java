package com.accc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.forms.CarForm;
import com.accc.repository.CarRepository;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {

	@InjectMocks
	private CarServiceImpl carService;

	@Mock
	private CarRepository carRepository;

	private Car car;

	private ArgumentCaptor<Car> captor;

	private Customer customer;

	@Before
	public void init() {
		customer = new Customer("Test", "Test", "Test", "Test");
		car = new Car("Test", "Test", "Test", "Test", customer);

		captor = ArgumentCaptor.forClass(Car.class);
	}

	@Test
	public void create_success() {
		carService.create(car);

		verify(carRepository).save(captor.capture());

		Car saved = captor.getValue();

		assertEquals("Test", saved.getMake());
	}

	@Test
	public void update_success() {
		CarForm form = new CarForm("Edited", "Test", "Test", "Test");

		carService.update(car, form);

		verify(carRepository).save(captor.capture());

		Car updated = captor.getValue();

		assertEquals("Edited", updated.getMake());
	}

	@Test
	public void findByCustomer_success() {
		when(carService.findByCustomer(customer)).thenReturn(Lists.newArrayList(car));

		List<Car> found = carService.findByCustomer(customer);

		assertEquals(1, found.size());
	}
}
