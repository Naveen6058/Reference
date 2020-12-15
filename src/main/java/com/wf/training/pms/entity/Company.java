package com.wf.training.pms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Company {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long companyCode;
	@Column(name = "company_title", unique = true)
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
	private float ipoPrice;
	
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
	public float getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}
//	public int getBoUserId() {
//		return boUserId;
//	}
//	public void setBoUserId(int boUserId) {
//		this.boUserId = boUserId;
//	}
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
	
	
}
