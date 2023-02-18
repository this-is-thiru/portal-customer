package com.infy.portal.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.portal.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	Optional<Customer> findByFirstNameAndLastName(String firstName,String lastName);

}
