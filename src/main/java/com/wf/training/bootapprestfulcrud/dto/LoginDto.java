package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {

	@NotBlank(message="Login id is Mandatory")
	private String loginKey;
	
	@NotBlank(message="Password is Mandatory")
	private String password;

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
