package com.accc.service;

import java.util.List;

import com.accc.domain.model.Customer;
import com.accc.forms.CustomerForm;

public interface CustomerService {

	Customer create(Customer customer);

	Customer update(Customer customer, CustomerForm form);

	List<Customer> findAll();

	List<Customer> search(String name);
}
