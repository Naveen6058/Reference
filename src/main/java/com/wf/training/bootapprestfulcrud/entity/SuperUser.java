package com.wf.training.bootapprestfulcrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name = "superuser")
public class SuperUser {
	@Column(name="Name")
	private String name;
	@Id
	@Column(name="SuperUserID")
	@NotNull(message = "User ID is mandatory!")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer superUserId;
	@Column(name="Password")
	@NotBlank(message = "password is mandatory!")

	private String password;
	public SuperUser(String name, Integer superUserId, String password) {
		super();
		this.name = name;
		this.superUserId = superUserId;
		this.password = password;
	}
	public SuperUser() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSuperUserId() {
		return superUserId;
	}
	public void setSuperUserId(Integer superUserId) {
		this.superUserId = superUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
