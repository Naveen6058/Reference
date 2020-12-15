package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BackofficeInputDto {
	
	@NotBlank(message="First Name is Mandatory")
	private String firstName;
	@NotBlank(message="Last Name is Mandatory")
	private String lastName;
	@Email
	@NotBlank(message="Email is Mandatory")
	private String emailId;
	
	@NotBlank(message="Password is Mandatory")
	private String password;
	
	private Integer loginId;

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
