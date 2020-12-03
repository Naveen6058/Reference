package com.wf.training.bootapprestfulcrud.dto;

public class SearchCompanyOutputDto {

	private Long companyCode;
	private String companyTitle;
	private String operation;
	private int shareCount; 
	private float sharePrice;
	private String sector;
	private String currency; 
	private long turnover;
//	private int boUserId;
	private String dateTimeIPO;
	private String stockExchange;
	private String ipoPrice;
	
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
	public String getIpoPrice() {
		return ipoPrice;
	}
	public void setIpoPrice(String ipoPrice) {
		this.ipoPrice = ipoPrice;
	}

}
