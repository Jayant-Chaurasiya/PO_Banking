package com.revature.project1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "transactionsLog")



public class TransactionLog{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column(columnDefinition = "integer")
	private int customerId;

	@Column(columnDefinition = "integer default 0")
	private int depositedAmount;

	@Column(columnDefinition = "integer default 0")
	private int withdrawnAmount;

	@Column(columnDefinition = "integer default 0")
	private int transferredAmount;

	@Column(columnDefinition = "integer default 0")
	private int transferToCustId;

	@Column(columnDefinition = "varchar(255) default 'For Use'")
	private String comment;

	public TransactionLog() {
		// TODO Auto-generated constructor stub
	}

	public TransactionLog(int customerId, int withdrawnAmount, String comment) {
		super();
		this.customerId = customerId;
		this.withdrawnAmount = withdrawnAmount;
		this.comment = comment;
	}

	public TransactionLog(int customerId, int depositedAmount) {
		super();
		this.customerId = customerId;
		this.depositedAmount = depositedAmount;
	}
	
	

	public TransactionLog(int customerId, int transferredAmount, int transferToCustId) {
		super();
		this.customerId = customerId;
		this.transferredAmount = transferredAmount;
		this.transferToCustId = transferToCustId;
	}

	

	public TransactionLog(int transactionId, int customerId, int depositedAmount, int withdrawnAmount,
			int transferredAmount, int transferToCustId, String comment) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.depositedAmount = depositedAmount;
		this.withdrawnAmount = withdrawnAmount;
		this.transferredAmount = transferredAmount;
		this.transferToCustId = transferToCustId;
		this.comment = comment;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDepositedAmount() {
		return depositedAmount;
	}

	public void setDepositedAmount(int depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

	public int getWithdrawnAmount() {
		return withdrawnAmount;
	}

	public void setWithdrawnAmount(int withdrawnAmount) {
		this.withdrawnAmount = withdrawnAmount;
	}

	public int getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(int transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	public int getTransferToCustId() {
		return transferToCustId;
	}

	public void setTransferToCustId(int transferToCustId) {
		this.transferToCustId = transferToCustId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customerId=" + customerId + ", depositedAmount="
				+ depositedAmount + ", withdrawnAmount=" + withdrawnAmount + ", transferredAmount=" + transferredAmount
				+ ", transferToCustId=" + transferToCustId + ", comment=" + comment + "]";
	}

}
