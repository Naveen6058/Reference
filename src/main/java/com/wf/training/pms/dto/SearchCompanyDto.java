package com.wf.training.pms.dto;

import javax.validation.constraints.NotBlank;

public class SearchCompanyDto {
	@NotBlank
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
