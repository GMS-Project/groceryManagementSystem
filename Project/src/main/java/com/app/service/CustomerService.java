package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.addNewCustomerDto;
import com.app.entities.Customer;

public interface CustomerService {
	Customer  addNewCustomer(addNewCustomerDto dto);
	
	List<Customer> getAllCustomer();
	
	Optional<Customer> getCustomer(Long customerId);
}
