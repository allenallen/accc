package com.accc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accc.domain.model.Customer;
import com.accc.forms.CustomerForm;
import com.accc.repository.CustomerRepository;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(readOnly = true)
	@Override
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Transactional(readOnly = true)
	@Override
	public Customer update(Customer customer, CustomerForm form) {
		customer.updateFromForm(form);
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> search(String name) {
		return customerRepository.findByNameContaining(name);
	}

}
