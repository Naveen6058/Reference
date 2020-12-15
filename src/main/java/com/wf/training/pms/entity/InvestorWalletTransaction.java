package com.wf.training.pms.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class InvestorWalletTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long invWalletTransactionId;
	
	private long walletId;
	private String transactionType;
	private double amount;
	private String dateTime;
	private long shareTransactionId;
	
	public long getInvWalletTransactionId() {
		return invWalletTransactionId;
	}
	public void setInvWalletTransactionId(long invWalletTransactionId) {
		this.invWalletTransactionId = invWalletTransactionId;
	}
	public long getWalletId() {
		return walletId;
	}
	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public long getShareTransactionId() {
		return shareTransactionId;
	}
	public void setShareTransactionId(long shareTransactionId) {
		this.shareTransactionId = shareTransactionId;
	}

}
