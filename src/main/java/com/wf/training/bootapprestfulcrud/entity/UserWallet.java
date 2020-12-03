package com.wf.training.bootapprestfulcrud.entity;

import java.time.LocalDateTime;

public class UserWallet {

	private int investorID;
	private String currency;
	private LocalDateTime dateTime; 
	private String transactionType;
	private Float amount;
	private int userWalletTransactionID;
	private int shareTransactionID; 
	private float balance;
	
	public UserWallet(int investorID, String currency, LocalDateTime dateTime, String transactionType, Float amount,
			int userWalletTransactionID, int shareTransactionID, float balance) {
		super();
		this.investorID = investorID;
		this.currency = currency;
		this.dateTime = dateTime;
		this.transactionType = transactionType;
		this.amount = amount;
		this.userWalletTransactionID = userWalletTransactionID;
		this.shareTransactionID = shareTransactionID;
		this.balance = balance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public int getUserWalletTransactionID() {
		return userWalletTransactionID;
	}
	public void setUserWalletTransactionID(int userWalletTransactionID) {
		this.userWalletTransactionID = userWalletTransactionID;
	}
	public int getInvestorID() {
		return investorID;
	}
	public void setInvestorID(int investorID) {
		this.investorID = investorID;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getShareTransactionID() {
		return shareTransactionID;
	}
	public void setShareTransactionID(int shareTransactionID) {
		this.shareTransactionID = shareTransactionID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}	
}
