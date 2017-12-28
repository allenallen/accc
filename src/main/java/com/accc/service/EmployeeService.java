package com.accc.service;

import java.util.List;

import com.accc.domain.model.Employees;

public interface EmployeeService {

	List<Employees> findAll();
	
	Employees findOne(String id);
	
}
