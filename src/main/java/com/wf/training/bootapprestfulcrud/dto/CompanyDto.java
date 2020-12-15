package com.wf.training.bootapprestfulcrud.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CompanyDto {

	private Long companyCode;
	@NotBlank
	private String companyTitle;
	@NotBlank
	private String operation;
	@Min(value = 1000)
	private int shareCount; 
	@DecimalMin("0.1") 
	private float sharePrice;
	@NotBlank
	private String sector;
	@NotBlank
	private String currency;
	@Min(value = 1000)
	private long turnover;
	@NotBlank
	private String dateTimeIPO;
	@NotBlank
	private String stockExchange;
	@DecimalMin("0.1") 
	private float ipoPrice;
	
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyTitle() {
		return companyTitle;
	}
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public float getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getTurnover() {
		return turnover;
	}
	public void setTurnover(long turnover) {
		this.turnover = turnover;
	}
	public String getDateTimeIPO() {
		return dateTimeIPO;
	}
	public void setDateTimeIPO(String dateTimeIPO) {
		this.dateTimeIPO = dateTimeIPO;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public float getIpoPrice() {
		return ipoPrice;
	}
	public void setIpoPrice(float ipoPrice) {
		this.ipoPrice = ipoPrice;
	}

}
