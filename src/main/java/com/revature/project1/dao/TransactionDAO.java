package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.model.TransactionLog;



public interface TransactionDAO {
	
	public boolean addWithdrawTransaction(TransactionLog transaction);
	public boolean addDepositTransaction(TransactionLog transaction);
	public boolean addTransferTransaction(TransactionLog transaction);
	public List<TransactionLog> getAllTransaction();

}
