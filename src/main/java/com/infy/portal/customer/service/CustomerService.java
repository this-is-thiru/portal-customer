package com.infy.portal.customer.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.portal.customer.dto.CustomerDTO;
import com.infy.portal.customer.dto.CustomerPersonalDetailsDTO;
import com.infy.portal.customer.dto.SimDetailsDTO;
import com.infy.portal.customer.entity.Customer;
import com.infy.portal.customer.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository; 
	
	public ResponseEntity<String> addCustomer(CustomerDTO customerDTO){
		Customer customer = new Customer();
		customer.setUniqueIdNumber(customerDTO.getUniqueIdNumber());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailAddress(customerDTO.getEmailAddress());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setIdType(customerDTO.getIdType());
		customer.setCustomerAddress_addressId(customerDTO.getCustomerAddress_addressId());
		customer.setSimId(customerDTO.getSimId());
		customer.setState(customerDTO.getState());
		
		customerRepository.saveAndFlush(customer);
		return new ResponseEntity<String>(customer.toString(),HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<String> customerIdProofValidation(CustomerDTO customerDTO){
		Long uniqueIdNumber = customerDTO.getUniqueIdNumber();
		LocalDate dob = customerDTO.getDateOfBirth();
		String firstName = customerDTO.getFirstName();
		String lastName = customerDTO.getLastName();
		Optional<Customer> optionalCustomer=customerRepository.findById(uniqueIdNumber);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if(customer.getFirstName().equals(firstName)==false || customer.getLastName().equals(lastName)==false) {
				return new ResponseEntity<String>("Invalid details",HttpStatus.BAD_REQUEST);
			}
			else {
				if(customer.getDateOfBirth().equals(dob)==false) {
					return new ResponseEntity<String>("Incorrect date of birth details",HttpStatus.BAD_REQUEST);
				}
				else {
					int simId=customer.getSimId();
					SimDetailsDTO simDetailsDTO=new RestTemplate().getForObject("http://localhost:9100/simdetails/fetchbyid/"+simId, SimDetailsDTO.class);
					return new ResponseEntity<String>("Successfully activated the sim"+"\n"+simDetailsDTO.toString(),HttpStatus.OK);
				}
			}
		}
		else {
			return new ResponseEntity<String>("Invalid details",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<String> customerPersonalDetailsValidation(CustomerPersonalDetailsDTO customerPersonalDetailsDTO){
		String firstName=customerPersonalDetailsDTO.getFirstName();
		String lastName=customerPersonalDetailsDTO.getLastName();
		String email=customerPersonalDetailsDTO.getEmailAddress();
		Optional<Customer> optionalCustomer=customerRepository.findByFirstNameAndLastName(firstName, lastName);
		if(optionalCustomer.isPresent()) {
			if(optionalCustomer.get().getEmailAddress().equals(email)) {
				return new ResponseEntity<String>("Success",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Invalid email details!!",HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return new ResponseEntity<String>("No customer found for the provided details",HttpStatus.BAD_REQUEST);
		}
	}

}
