package com.accc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accc.domain.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, String>{

}
