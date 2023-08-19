package com.app.service;

import java.util.List;


import com.app.dto.AddProductDto;

import com.app.dto.ProductRespDTO;



public interface ProductService {

//	//get list of emps from a specific dept
//		List<EmployeeRespDTO> getAllEmployeesFromDept(Long deptId);
//
//	//delete emp details
//		String deleteEmpDetails(Long empId);
//
//		EmployeeRespDTO addNewEmployee(AddEmployeeDTO dto);
//
//		EmployeeRespDTO updateEmployee(Long empId, AddEmployeeDTO dto);
//
//		EmployeeRespDTO getEmpDetails(Long deptId, Long empId);
	
	//get list of products from a specific category
	List<ProductRespDTO> getAllProductsFromCat(Long catId);
	
	//delete product details
	String deleteProdDetails(Long prodId);
	
	ProductRespDTO addNewProduct(AddProductDto dto);
	
	ProductRespDTO updateProduct(Long prodID,AddProductDto dto);
	
	ProductRespDTO getProductDetails(Long catId ,Long prodID);
	
	
}
