package com.wf.training.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class AdminUser {
	
	@Id
	@Column(name="adminUserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer adminUserId;
	@Column(name="Name",unique = true)
	private String name;
	@Column(name="Password")
	private String password;
	public AdminUser(String name, Integer adminUserId, String password) {
		super();
		this.name = name;
		this.adminUserId = adminUserId;
		this.password = password;
	}
	public AdminUser() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSuperUserId() {
		return adminUserId;
	}
	public void setSuperUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
