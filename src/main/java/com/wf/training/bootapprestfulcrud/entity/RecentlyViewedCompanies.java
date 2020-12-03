package com.wf.training.bootapprestfulcrud.entity;

import java.time.LocalDateTime;

public class RecentlyViewedCompanies {

	private int investorId;
	private int companyCode;
	private LocalDateTime dateTime;
	
	public RecentlyViewedCompanies(int investorId, int companyCode, LocalDateTime dateTime) {
		super();
		this.investorId = investorId;
		this.companyCode = companyCode;
		this.dateTime = dateTime;
	}
	public int getInvestorId() {
		return investorId;
	}
	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
