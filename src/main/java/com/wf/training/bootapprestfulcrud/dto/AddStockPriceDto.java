package com.wf.training.bootapprestfulcrud.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddStockPriceDto {
	
	private String companyName;

	@DecimalMin("0.1")
	@NotNull(message="Share price should not be blank")
	private Float sharePrice;
	
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
