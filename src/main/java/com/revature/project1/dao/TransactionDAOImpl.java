package com.revature.project1.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.project1.model.Customer;
import com.revature.project1.model.TransactionLog;
import com.revature.project1.util.HibernateUtil;

public class TransactionDAOImpl implements TransactionDAO {
	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	public boolean addWithdrawTransaction(TransactionLog transactionLog) {
		
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.createSQLQuery("insert into transactionsLog(customerId,withdrawnAmount,comment) values("+transactionLog.getCustomerId() +","+transactionLog.getWithdrawnAmount()+",'"+transactionLog.getComment()+"')");
		int row=query.executeUpdate();transaction.commit();
		if(row==1) 		
			return true;
		else
			return false;
	}

	public boolean addDepositTransaction(TransactionLog transactionLog) {
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.createSQLQuery("insert into transactionsLog(customerId,depositedAmount) values("+transactionLog.getCustomerId() +","+transactionLog.getDepositedAmount()+")");
		int row=query.executeUpdate();transaction.commit();
		if(row==1) 		
			return true;
		else
			return false;
	}

	public boolean addTransferTransaction(TransactionLog transactionLog) {
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.createSQLQuery("insert into transactionsLog(customerId,transferredAmount,transferToCustId) values("+transactionLog.getCustomerId() +","+transactionLog.getTransferredAmount()+","+transactionLog.getTransferToCustId()+")");
		int row=query.executeUpdate();transaction.commit();
		if(row==1) 		
			return true;
		else
			return false;
	}

	public List<TransactionLog> getAllTransaction() {
		Query<TransactionLog> query=session.createQuery("from com.revature.project1.model.TransactionLog");
		List<TransactionLog> transactionlist=query.list();
		return transactionlist;
	}

}
