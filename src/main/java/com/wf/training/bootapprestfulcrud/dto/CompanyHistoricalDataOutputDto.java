package com.wf.training.bootapprestfulcrud.dto;

public class CompanyHistoricalDataOutputDto {
	
	private Long companyCode;
	private String companyName;
	private float stockPrice; 
	private String dateTime;
	
	public String getCompanyId() {
		return companyName;
	}
	public void setCompanyId(String companyId) {
		this.companyName = companyId;
	}
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public float getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	

}
