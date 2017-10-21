package com.accc.service;

import java.time.Month;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accc.domain.model.Car;
import com.accc.domain.model.Customer;
import com.accc.domain.model.JobOrder;
import com.accc.repository.JobOrderRepository;
import com.google.common.collect.Lists;

@Service
@Transactional(readOnly = true)
public class JobOrderServiceImpl implements JobOrderService {

	@Autowired
	JobOrderRepository joRepo;

	@Override
	public List<JobOrder> getAll() {
		return Lists.newArrayList(joRepo.findAll());
	}

	@Transactional(readOnly = false)
	@Override
	public JobOrder addJobOrder(JobOrder jo) {
		JobOrder lastJo = joRepo.findTopByJobOrder();

		if (Objects.nonNull(lastJo)) {
			jo.setJoNumber(lastJo.getJoNumber() + 1);
		} else {
			jo.setJoNumber(1);
		}

		return joRepo.save(jo);
	}

	@Override
	public JobOrder findByJoNumber(String joNumber) {
		return joRepo.findByJoNumber(joNumber);
	}

	@Override
	public List<JobOrder> findAllByCar(Car car) {
		return joRepo.findAllByCar(car);
	}

	@Override
	public List<JobOrder> findAllByCustomer(Customer customer) {
		return joRepo.findAllByCustomer(customer);
	}

	@Override
	public List<JobOrder> findAllByMonth(Month month) {
		return joRepo.findByMonth(month.getValue());
	}
}
