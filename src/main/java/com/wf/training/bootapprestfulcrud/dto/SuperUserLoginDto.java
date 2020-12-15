package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SuperUserLoginDto {

	@NotBlank(message="Password is Mandatory")
	private String password;
	
	@NotBlank(message="Login id is Mandatory")
	private String superUserId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuperUserId() {
		return superUserId;
	}

	public void setSuperUserId(String superUserId) {
		this.superUserId = superUserId;
	}

	

}
