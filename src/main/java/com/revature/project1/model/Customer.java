package com.revature.project1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.*;



@Entity
@Table(name="customers")

@NamedQueries({
	@NamedQuery(name="deposit",query="update Customer set customerBalance=customerBalance+:amount where customerId=:customerId"),
	@NamedQuery(name="withdraw",query="update Customer set customerBalance=customerBalance-:amount where customerId=:customerId"),
	@NamedQuery(name="approveCustomer",query="update Customer set customerStatus=:customerStatus where customerId=:customerId"),
	@NamedQuery(name="denyCustomer",query="update Customer set customerStatus=:customerStatus where customerId=:customerId"),
})



public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;	
	
	@Column
	private String customerName;
	
	@Column
	private String customerPassword;
	
	@Column
	private int customerBalance;
	
	@Column
	private String customerContact;
	
	@Column
	private String customerEmail;
	
	@Column
	private Date customerRegistrationDate;
	
	@Column
	private String customerStatus="Not Approved";
	
	
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(int customerId, String customerName, String customerPassword, int customerBalance,
			String customerContact, String customerEmail,Date customerRegistrationDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerBalance = customerBalance;
		this.customerContact = customerContact;
		this.customerEmail = customerEmail;
		this.customerRegistrationDate = customerRegistrationDate;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public int getCustomerBalance() {
		return customerBalance;
	}


	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}


	public String getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public Date getCustomerRegistrationDate() {
		return customerRegistrationDate;
	}


	public void setCustomerRegistrationDate(Date customerRegistrationDate) {
		this.customerRegistrationDate = customerRegistrationDate;
	}


	public String getCustomerStatus() {
		return customerStatus;
	}


	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", customerBalance=" + customerBalance + ", customerContact=" + customerContact
				+ ", customerEmail=" + customerEmail + ", customerRegistrationDate=" + customerRegistrationDate
				+ ", customerStatus=" + customerStatus + "]";
	}


	
	
	
	

}
