package com.app.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
	
	Optional<Customer> findByCustomerId(Long customerId);
	
	List<Customer> findAll();
	
	
	
}
