package com.infy.portal.customer.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDTO {
	@Pattern(regexp="\\d{16}",message="Id should be 16 digit")
	String uniqueIdNumber;
	@NotNull(message="Date of Birth is mandatory.")
	@DateTimeFormat(pattern="yyyy-MM-dd",style="yyyy-MM-dd")
	LocalDate dateOfBirth;
	String emailAddress;
	@NotBlank(message="First Name is mandatory.")
	@Pattern(regexp="^[A-Za-z]+$",message="Name should contain Alphabets only.")
	String firstName;
	@NotBlank(message="Last Name is mandatory.")
	@Pattern(regexp="^[A-Za-z]+$",message="Name should contain Alphabets only.")
	String lastName;
	String idType;
	Integer customerAddress_addressId;
	Integer simId;
	String state;
	
	
	public CustomerDTO(String uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName,
			String lastName, String idType, Integer customerAddress_addressId, Integer simId, String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.customerAddress_addressId = customerAddress_addressId;
		this.simId = simId;
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "CustomerDTO [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", customerAddress_addressId=" + customerAddress_addressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}
	
	
	public Long getUniqueIdNumber() {
		return Long.parseLong(uniqueIdNumber);
	}
	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public Integer getCustomerAddress_addressId() {
		return customerAddress_addressId;
	}
	public void setCustomerAddress_addressId(Integer customerAddress_addressId) {
		this.customerAddress_addressId = customerAddress_addressId;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
