package com.accc.service;

import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.domain.model.JobOrder;
import com.accc.repository.JobOrderRepository;
import com.google.common.collect.Lists;

public interface JobOrderService {
	
	List<JobOrder> getAll();

	JobOrder addJobOrder(JobOrder jo);
	
	JobOrder findByJoNumber(String joNumber);
	
	List<JobOrder> findAllByCar(Car car);
	
	List<JobOrder> findAllByCustomer(Customer customer);
	
	List<JobOrder> findAllByMonth(Month month);
}
