package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
//import com.app.custom_exceptions.ApiException;
//import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.AddProductDto;

import com.app.dto.ProductRespDTO;
//import com.app.entities.Address;
import com.app.entities.Category;

import com.app.entities.Product;
//import com.app.entities.Project;
//import com.app.repository.AddressRepository;
import com.app.respository.CategoryRepo;
import com.app.respository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public List<ProductRespDTO> getAllProductsFromCat(Long catId) {
//		List<Employee> empList = empRepo.findByDeptId(deptId);
//		return empList.stream() //Stream<Emp>
//				.map(emp -> mapper.map(emp, EmployeeRespDTO.class)) //Stream<DTO>
//				.collect(Collectors.toList());
		System.out.println("in service  prod get");
		List<Product> prodList=prodRepo.findByCategory(catId);
		
		
		return prodList.stream() //Stream<Emp>
				.map(prod ->mapper.map(prod, ProductRespDTO.class))//Stream<DTO>
				.collect(Collectors.toList());
	}

	@Override
	public String deleteProdDetails(Long prodId) {
		Product prod =prodRepo.findById(prodId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid prod id"));
		prodRepo.delete(prod);
		return "Prod Details deleted.....";
	}

	@Override
	public ProductRespDTO addNewProduct(AddProductDto dto) {
//		// validate confirm password --o.w throw the exc
//				if (dto.getConfirmPassword().equals(dto.getPassword())) {
//					// validate dept --o.w throw the exc
//					Department dept = deptRepo.findById(dto.getDeptId())
//							.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept id !!!"));
//					// dept : PERSISTENT
//					// set up a bi dir relationship
//					Employee employee = mapper.map(dto, Employee.class);
//					dept.addEmployee(employee);//cascade on save
//					//IMPORTANT : since you have not explicitly called save : hib has NOT YET assigned the id
//					//only for sending correct id to the REST clnt --> call save
//					// map entity --> dto n return
//					return mapper.map(empRepo.save(employee), EmployeeRespDTO.class);
//				} else
//					throw new ApiException("Passwords don't match!!!!!");
			Category cat = catRepo.findById(dto.getCatId())
					.orElseThrow(()->new ResourceNotFoundException("Invalid Cat id !!!"));
//			// dept : PERSISTENT
//			// set up a bi dir relationship
			Product product =mapper.map(dto, Product.class);
			cat.addProduct(product);//cascade on save
//			//IMPORTANT : since you have not explicitly called save : hib has NOT YET assigned the id
//			//only for sending correct id to the REST clnt --> call save
//			// map entity --> dto n return
			
		return mapper.map(prodRepo.save(product),ProductRespDTO.class);
		
	}

	@Override
	public ProductRespDTO updateProduct(Long prodID, AddProductDto dto) {
		
		Product prod = prodRepo.findById(prodID)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Prod ID , Prod not found !!!!"));
		Category cat = catRepo.findById(dto.getCatId())
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Cat Id"));
		mapper.map(dto,prod);
		prod.setProductId(prodID);
		cat.addProduct(prod);
						
		return mapper.map(prod, ProductRespDTO.class);
	}

	@Override
	public ProductRespDTO getProductDetails(Long catId, Long prodID) {
//		Employee employee = empRepo.findById(empId)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
//		if (employee.getDept().getId() != deptId)
//			throw new ResourceNotFoundException("Dept id does not match !!!");
//		return mapper.map(employee, EmployeeRespDTO.class);
		
		Product product = prodRepo.findById(prodID)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Prod ID!!!"));
		if (product.getCategory().getCategoryId() !=catId)
			throw new ResourceNotFoundException("Cat id does not match !!!");
		return null;
	}
	
	
	

}
