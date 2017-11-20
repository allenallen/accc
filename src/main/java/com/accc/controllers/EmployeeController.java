package com.accc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accc.domain.model.Employees;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@GetMapping("/get_employee")
	public Employees getEmployee() {
		return null;
	}
}
