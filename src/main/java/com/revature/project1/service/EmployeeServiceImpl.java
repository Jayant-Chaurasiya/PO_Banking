package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.*;
import com.revature.project1.model.Customer;
import com.revature.project1.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	public int addEmployee(Employee employee) {
		int employeeId=employeeDAO.addEmployee(employee);
		return employeeId;
	}

	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Employee> getEmployeeByName(String employeeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeById(int employeeId) {
		return employeeDAO.getEmployeeById(employeeId);
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateEmployee(int employeeId,String employeePassword) {
		return employeeDAO.validateEmployee(employeeId, employeePassword);
	}

	public boolean isEmployeeExists(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Customer> approvedCustomers(){
		return employeeDAO.approvedCustomers();
	}

	public List<Customer> notApprovedCustomers(){
		return employeeDAO.notApprovedCustomers();
	}

	public boolean approveCustomer(int customerId) {
		return employeeDAO.approveCustomer(customerId);
	}

	public boolean denyCustomer(int customerId) {
		return employeeDAO.denyCustomer(customerId);
	}

}
