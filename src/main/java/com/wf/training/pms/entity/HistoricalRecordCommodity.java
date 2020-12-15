package com.wf.training.pms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HistoricalRecordCommodity {

	@Id
	private int commodityId;
	private String CommodityPrice; 
	private LocalDateTime dateTime;
		
	public HistoricalRecordCommodity(int commodityId, String commodityPrice, LocalDateTime dateTime) {
		super();
		this.commodityId = commodityId;
		CommodityPrice = commodityPrice;
		this.dateTime = dateTime;
	}
	public HistoricalRecordCommodity() {
		// TODO Auto-generated constructor stub
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getCommodityPrice() {
		return CommodityPrice;
	}
	public void setCommodityPrice(String commodityPrice) {
		CommodityPrice = commodityPrice;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
