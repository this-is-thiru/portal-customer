package com.infy.portal.customer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CustomerPersonalDetailsDTO {
	String emailAddress;
	@NotBlank(message="FirstName should be maximum of 15 characters")
	@Size(max=15,message="FirstName should be maximum of 15 characters")
	String firstName;
	@NotBlank(message="LastName should be maximum of 15 characters")
	@Size(max=15,message="LastName should be maximum of 15 characters")
	String lastName;
	
	public CustomerPersonalDetailsDTO(String emailAddress, String firstName, String lastName) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerPersonalDetailsDTO [emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
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

}
