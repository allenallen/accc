package com.accc.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import com.accc.domain.model.JobOrder;
import com.accc.repository.JobOrderRepository;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class JobOrderServiceImplTest {

	@InjectMocks
	private JobOrderServiceImpl jobOrderService;

	@Mock
	private JobOrderRepository jobOrderRepository;

	private JobOrder jobOrder;

	private Customer customer;

	private Car car;

	private LocalDate date;

	@Before
	public void init() {
		date = LocalDate.of(2005, 1, 1);
		customer = new Customer("Test", "Test", "Test", "Test");
		car = new Car("Test", "Test", "Test", "Test", customer);
		customer.addCar(car);

		jobOrder = new JobOrder(date, customer, car, Lists.newArrayList(), null, null, BigDecimal.ONE, date, date);
	}
	
	@Test
	public void getAll_success() {
		when(jobOrderService.getAll()).thenReturn(Lists.newArrayList(jobOrder));
		List<JobOrder> found = jobOrderService.getAll();
		assertEquals(1,found.size());
	}
	
	@Test
	public void create_success() {
		jobOrder.setJoNumber(2);
		when(jobOrderRepository.findTopByJobOrder()).thenReturn(jobOrder);
		
		jobOrderService.addJobOrder(jobOrder);
		
		ArgumentCaptor<JobOrder> captor = ArgumentCaptor.forClass(JobOrder.class);
		
		verify(jobOrderRepository).save(captor.capture());
		JobOrder saved = captor.getValue();
		
		assertEquals(Integer.valueOf(3),saved.getJoNumber());
	}
}
