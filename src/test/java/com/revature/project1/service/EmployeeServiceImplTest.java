package com.revature.project1.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project1.dao.*;
import com.revature.project1.model.Employee;
public class EmployeeServiceImplTest {
	EmployeeDAO employeeDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeDAO=new EmployeeDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		employeeDAO=null;
	}

	@Test
	public void testAddEmployee() {
		Employee employee=new Employee(0, "Rahul", "9874633346", "r@g.com", "Rahul@123", "Kolkata");
		assertEquals(true, employeeDAO.addEmployee(employee));
		
	}

	@Test
	public void testDeleteEmployee() {
		int employeeId=2;
		assertEquals(true,employeeDAO.deleteEmployee(employeeId));
	}

	@Test
	public void testGetEmployeeByName() {
		List<Employee> employees =employeeDAO.getEmployeeByName("Jayant");
		assertEquals(1, employees.size());
	}

	@Test
	public void testGetEmployeeById() {
		int employeeId=2;
		Employee employee=employeeDAO.getEmployeeById(employeeId);
		assertNotNull(employee);
	}

	@Test
	public void testGetAllEmployee() {
		List <Employee> employees=employeeDAO.getAllEmployee();
		assertEquals(1,employees.size());
	}

	@Test
	public void testValidateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmployeeExists() {
		fail("Not yet implemented");
	}

}
