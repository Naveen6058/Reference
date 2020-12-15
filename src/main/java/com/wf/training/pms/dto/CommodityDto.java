package com.wf.training.pms.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommodityDto {

	@NotBlank(message="Commodity Name is required")
	private String commodityName;
	@NotBlank(message="Currency is required")
	private String currency;
	@NotNull(message="Price is required")
	private Float price;
	
	private String dateTime;
	private int commodityId;
	private int boUserId;
	
	public CommodityDto(String commodityName, String currency, Float price, String dateTime, int commodityId,
			int boUserId) {
		super();
		this.commodityName = commodityName;
		this.currency = currency;
		this.price = price;
		this.dateTime = dateTime;
		this.commodityId = commodityId;
		this.boUserId = boUserId;
	}
	
	public CommodityDto() {

	}

	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getBoUserId() {
		return boUserId;
	}
	public void setBoUserId(int boUserId) {
		this.boUserId = boUserId;
	}
	
	
	
}
