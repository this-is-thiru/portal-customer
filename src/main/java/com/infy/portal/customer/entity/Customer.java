package com.infy.portal.customer.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	Long uniqueIdNumber;
	LocalDate dateOfBirth;
	String emailAddress;
	String firstName;
	String lastName;
	String idType;
	Integer customerAddress_addressId;
	Integer simId;
	String state;
	
	
	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", customerAddress_addressId=" + customerAddress_addressId + ", simId=" + simId + ", state=" + state
				+ "]";
	}
	
	
	public Long getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(Long uniqueIdNumber) {
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
