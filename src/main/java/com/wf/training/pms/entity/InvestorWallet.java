package com.wf.training.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class InvestorWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long walletId;
	@Column(unique = true)
	private int investorID;
	private String dateTime; 
	
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public int getInvestorID() {
		return investorID;
	}
	public void setInvestorID(int investorID) {
		this.investorID = investorID;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
