package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.*;
import com.revature.project1.model.TransactionLog;

public class TransactionServiceImpl implements TransactionService {
	TransactionDAO transactionDAO=new TransactionDAOImpl();
	public boolean addWithdrawTransaction(TransactionLog transactionLog) {
		return transactionDAO.addWithdrawTransaction(transactionLog);
	}

	public boolean addDepositTransaction(TransactionLog transactionLog) {
		return transactionDAO.addDepositTransaction(transactionLog);
	}

	public boolean addTransferTransaction(TransactionLog transactionLog) {
		return transactionDAO.addTransferTransaction(transactionLog);
	}

	public List<TransactionLog> getAllTransaction() {
		return transactionDAO.getAllTransaction();
	}

}
