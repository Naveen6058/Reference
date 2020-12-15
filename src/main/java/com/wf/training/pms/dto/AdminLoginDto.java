package com.wf.training.pms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdminLoginDto {

	@NotBlank(message="Password is Mandatory")
	private String password;
	
	@NotBlank(message="Login id is Mandatory")
	private String adminUserId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuperUserId() {
		return adminUserId;
	}

	public void setSuperUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	

}
