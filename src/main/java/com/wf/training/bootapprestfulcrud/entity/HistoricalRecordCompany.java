package com.wf.training.bootapprestfulcrud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class HistoricalRecordCompany {

	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long companyHistoricalDataId;
	private Long companyCode;
	private float stockPrice; 
	private String dateTime;
	
	public Long getCompanyHistoricalDataId() {
		return companyHistoricalDataId;
	}
	public void setCompanyHistoricalDataId(Long companyHistoricalDataId) {
		this.companyHistoricalDataId = companyHistoricalDataId;
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
