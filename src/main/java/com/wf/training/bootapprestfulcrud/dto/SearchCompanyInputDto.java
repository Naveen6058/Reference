package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class SearchCompanyInputDto {

	private String companyName;

	@NotNull
	@NotBlank
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


}
