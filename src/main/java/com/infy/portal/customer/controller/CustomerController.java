package com.infy.portal.customer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.portal.customer.dto.CustomerDTO;
import com.infy.portal.customer.dto.CustomerPersonalDetailsDTO;
import com.infy.portal.customer.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("insert")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customerDTO){
		
		return customerService.addCustomer(customerDTO);
		
//		return new ResponseEntity<String>(customerDTO.toString(),HttpStatus.OK);
	}
	
//	 RestPointApi-5
	@PostMapping("validation/idproof")
	public ResponseEntity<String> customerIdProofValidation(@Valid @RequestBody CustomerDTO customerDTO){
		return customerService.customerIdProofValidation(customerDTO);
	}
	
	
	//RestPointApi-3
	@PostMapping("validation/personaldetails")
	public ResponseEntity<String> customerPersonalDetailsValidation(@Valid @RequestBody CustomerPersonalDetailsDTO customerPersonalDetailsDTO){
		return customerService.customerPersonalDetailsValidation(customerPersonalDetailsDTO);
	}
	
	
	
}
