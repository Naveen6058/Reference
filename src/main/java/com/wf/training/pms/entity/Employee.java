package com.wf.training.pms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Employee {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	private String email;
	private String contact;
	private Double basicSalary;
	private Double hra;
	private Double ta;
	private Double da;
	private Double pfDeduction;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public Double getHra() {
		return hra;
	}
	public void setHra(Double hra) {
		this.hra = hra;
	}
	public Double getTa() {
		return ta;
	}
	public void setTa(Double ta) {
		this.ta = ta;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getPfDeduction() {
		return pfDeduction;
	}
	public void setPfDeduction(Double pfDeduction) {
		this.pfDeduction = pfDeduction;
	}
	
	
}
