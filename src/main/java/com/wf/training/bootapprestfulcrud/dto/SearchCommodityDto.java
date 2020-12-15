package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.NotBlank;

public class SearchCommodityDto {
	@NotBlank
	private String commodityName;

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}	

}
