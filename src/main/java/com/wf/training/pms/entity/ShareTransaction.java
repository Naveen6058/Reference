package com.wf.training.pms.entity;

import java.time.LocalDateTime;

public class ShareTransaction {

	private int shareTransactionId;
	private String transactionType;
	private int transactionShareCount;
	private LocalDateTime dateTime;
	private float transactionAmount;
	private float commission;
	
	public ShareTransaction(int shareTransactionId, String transactionType, int transactionShareCount,
			LocalDateTime dateTime, float transactionAmount, float commission) {
		super();
		this.shareTransactionId = shareTransactionId;
		this.transactionType = transactionType;
		this.transactionShareCount = transactionShareCount;
		this.dateTime = dateTime;
		this.transactionAmount = transactionAmount;
		this.commission = commission;
	}
	
	public int getShareTransactionId() {
		return shareTransactionId;
	}
	public void setShareTransactionId(int shareTransactionId) {
		this.shareTransactionId = shareTransactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getTransactionShareCount() {
		return transactionShareCount;
	}
	public void setTransactionShareCount(int transactionShareCount) {
		this.transactionShareCount = transactionShareCount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	
}
