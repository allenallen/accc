package com.accc.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.accc.domain.model.Employees;

import lombok.Data;

@Data
public class EmployeeDTO {
	private final String firstName;
	private final String lastName;
	private final String id;

	public static EmployeeDTO buildFromEntity(Employees employee) {
		EmployeeDTO e = new EmployeeDTO(employee.getFirstName(), employee.getLastName(), employee.getId());
		return e;
	}
	
	public static List<EmployeeDTO> buildFromEntities(List<Employees> employees){
		return employees.stream().map(employee -> buildFromEntity(employee)).collect(Collectors.toList());
	}
}
