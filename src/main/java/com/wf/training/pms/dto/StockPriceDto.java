package com.wf.training.pms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;

import java.time.LocalDateTime;

public class StockPriceDto {
	
	@DecimalMin("0.1")
	@NotNull(message="Share price should not be empty")
	private Float sharePrice;
	
	private String companyName;
	
	private LocalDateTime dateTime;
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Float getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(Float sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
