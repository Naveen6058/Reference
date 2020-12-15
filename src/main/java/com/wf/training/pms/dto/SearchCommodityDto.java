package com.wf.training.pms.dto;

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
