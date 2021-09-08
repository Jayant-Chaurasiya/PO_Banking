package com.revature.project1.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project1.model.Customer;
import com.revature.project1.dao.*;

public class CustomerServiceImplTest {
	CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerDAO=new CustomerDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		customerDAO=null;
	}

	@Test
	public void testAddCustomer() {
		Customer customer=new Customer(1, "Jayant", "Jayant@123", 5000, "9865741230", "jay@gmail.com", new Date());
		assertEquals(true,customerDAO.addCustomer(customer));
	}

	@Test
	public void testDeleteCustomer() {
		int customerId=2;
		assertEquals(true,customerDAO.deleteCustomer(customerId));
	}

	@Test
	public void testUpdateCustomer() {
		int customerId = 1;
		Customer customer = new Customer(customerId,"Anaya","Anaya@123",5000,"9658741230","anaya@g.com",new Date());
		customer.setCustomerId(customerId);
		assertEquals(true, customerDAO.updateCustomer(customer));
	}

	@Test
	public void testGetCustomerById() {
		int customerId=3;
		Customer customer=customerDAO.getCustomerById(customerId);
		assertNotNull(customer);
	}

	@Test
	public void testGetCustomers() {
		List<Customer> customers =customerDAO.getCustomers();
		assertEquals(1, customers.size());
	}

	@Test
	public void testIsCustomerExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeposit() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithdraw() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransferAmount() {
		fail("Not yet implemented");
	}

}
