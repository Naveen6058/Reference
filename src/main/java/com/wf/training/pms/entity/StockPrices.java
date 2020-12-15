package com.wf.training.pms.entity;

import java.time.LocalDateTime;

public class StockPrices {

	private int companyCode;
	private float currentPrice;
	private LocalDateTime dateTime;
	private String stockExchange;
		
	public StockPrices(int companyCode, float currentPrice, LocalDateTime dateTime, String stockExchange) {
		super();
		this.companyCode = companyCode;
		this.currentPrice = currentPrice;
		this.dateTime = dateTime;
		this.stockExchange = stockExchange;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	} 
	
}
