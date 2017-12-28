package com.accc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accc.domain.model.Employees;
import com.accc.dto.EmployeeDTO;
import com.accc.dto.Response;
import com.accc.service.EmployeeService;
import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController extends BaseController{

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response<List<EmployeeDTO>> getEmployee() {
		try {
			List<Employees> employees = employeeService.findAll();
			return new Response<List<EmployeeDTO>>(EmployeeDTO.buildFromEntities(employees));
		} catch (Exception e) {
			return new Response<List<EmployeeDTO>>(HttpStatus.INTERNAL_SERVER_ERROR, Lists.newArrayList());
		}
	}
}
