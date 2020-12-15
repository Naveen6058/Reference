package com.wf.training.pms.dto;

import javax.validation.constraints.NotBlank;

public class AdminLoginDto {
	
	@NotBlank(message="User ID is Mandatory")
	private String adminUserId;
	
	@NotBlank(message="Password is Mandatory")
	private String password;
	
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
