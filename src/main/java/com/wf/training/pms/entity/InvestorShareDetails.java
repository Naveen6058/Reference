package com.wf.training.pms.entity;

public class InvestorShareDetails {

	private int investorID ;
	private int companyCode;
	private float currentPrice;
	private String commodityId;
	private String currency;
	private int shareTransactionId;
	
	public InvestorShareDetails(int investorID, int companyCode, float currentPrice, String commodityId,
			String currency, int shareTransactionId) {
		super();
		this.investorID = investorID;
		this.companyCode = companyCode;
		this.currentPrice = currentPrice;
		this.commodityId = commodityId;
		this.currency = currency;
		this.shareTransactionId = shareTransactionId;
	}
	public int getInvestorID() {
		return investorID;
	}
	public void setInvestorID(int investorID) {
		this.investorID = investorID;
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
	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getShareTransactionId() {
		return shareTransactionId;
	}
	public void setShareTransactionId(int shareTransactionId) {
		this.shareTransactionId = shareTransactionId;
	}
	
	
}
