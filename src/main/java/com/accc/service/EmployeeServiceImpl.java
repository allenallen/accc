package com.accc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accc.domain.model.Employees;
import com.accc.repository.EmployeeRepository;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employees> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employees findOne(String id) {
		Employees e = employeeRepository.findOne(id);
		return e;
	}

}
