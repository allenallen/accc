package com.accc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accc.domain.model.JobOrder;
import com.accc.repository.JobOrderRepository;
import com.google.common.collect.Lists;

@Service
public class JobOrderService {

	@Autowired
	JobOrderRepository joRepo;

	public List<JobOrder> getAll() {
		return Lists.newArrayList(joRepo.findAll());
	}

	public JobOrder addJobOrder(JobOrder jo) {
		return joRepo.save(jo);
	}
}
