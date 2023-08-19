package com.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.addNewCustomerDto;
import com.app.entities.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/Customer")
@Validated
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<?> allCustomers() {
		System.out.println("find all Users" );
		
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getAllCustomer());
	}
	
	
	@PostMapping
	public ResponseEntity<?> addNewCustomer(@RequestBody @Valid addNewCustomerDto dto) {
		System.out.println("add new Customer " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addNewCustomer(dto));
	}
	
	
	@GetMapping(value="/{CustomerId}")
	public ResponseEntity<?> finById(@PathVariable Long CustomerId ) {
	//public ResponseEntity<?> findUserById( Long Id ) {
		System.out.println("find user having id--" + CustomerId);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomer(CustomerId));
	}
	
}
