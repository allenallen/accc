package com.accc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.accc.domain.model.Customer;
import com.accc.forms.CustomerForm;
import com.accc.repository.CustomerRepository;
import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Mock
	CustomerRepository customerRepository;
	
	private Customer customer;
	
	private ArgumentCaptor<Customer> captor;
	
	@Before
	public void init() {
		customer = new Customer("Test", "Test", "Test", "Test");
		captor = ArgumentCaptor.forClass(Customer.class);
	}
	
	@Test
	public void create_success() {
		customerService.create(customer);
		
		verify(customerRepository).save(captor.capture());
		Customer saved = captor.getValue();
		
		assertEquals("Test", saved.getFirstName());
	}
	
	@Test
	public void update_success() {
		CustomerForm form = new CustomerForm("Edited", "Test", "Test", "Test");
		
		customerService.update(customer, form);
		
		verify(customerRepository).save(captor.capture());
		Customer updated = captor.getValue();

		assertEquals("Edited", updated.getFirstName());
	}
	
	@Test
	public void findAll_success() {
		when(customerService.findAll()).thenReturn(Lists.newArrayList(customer));
		
		List<Customer> found = customerService.findAll();
		
		assertEquals(1, found.size());
	}
	
	@Test
	public void search_success() {
		when(customerService.search("T")).thenReturn(Lists.newArrayList(customer));
		
		List<Customer> found = customerService.search("T");
		
		assertEquals(1, found.size());
	}
}
