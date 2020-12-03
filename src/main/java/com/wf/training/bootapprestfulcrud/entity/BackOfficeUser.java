package com.wf.training.bootapprestfulcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "backofficeuser")
public class BackOfficeUser {
	
	@Column(name="FirstName")
	@NotBlank(message="First Name is Mandatory")
	private String firstName;
	@Column(name="LastName")
	@NotBlank(message="Last Name is Mandatory")
	private String lastName;
	@Column(name="EmailID")
	@Email
	@NotBlank(message="Email is Mandatory")
	private String emailId;
	@Column(name="Password")
	@NotBlank(message="Password is Mandatory")
	private String password;
	@Id
	@Column(name="LoginId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer loginId;
	public BackOfficeUser(String firstName, String lastName, String emailId, String password, Integer loginId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.loginId = loginId;
	}
	public BackOfficeUser() {
		// TODO Auto-generated constructor stub
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
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	
	
}
