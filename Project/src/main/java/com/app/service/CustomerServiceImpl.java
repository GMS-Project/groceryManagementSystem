package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.addNewCustomerDto;
import com.app.entities.Customer;
import com.app.respository.CustomerRepo;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer addNewCustomer(addNewCustomerDto dto) {
		if(dto.getConfirmPassword().equals(dto.getPassword())) {
			Customer user = mapper.map(dto, Customer.class);
			System.out.println("dto"+dto);
			System.out.println(user);
			mapper.map(customerRepo.save(user), addNewCustomerDto.class);
			return user;
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		Optional<Customer> user = customerRepo
.findByCustomerId(customerId);
		return user;

	}
	
	
	
}
