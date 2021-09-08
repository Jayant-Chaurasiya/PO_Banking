package com.revature.project1.service;

import java.util.List;

import com.revature.project1.model.Customer;
import com.revature.project1.model.Employee;

public interface EmployeeService {
	public int addEmployee(Employee employee);

	public boolean deleteEmployee(int employeeId);
	
	public List<Employee> getEmployeeByName(String employeeName);

	public Employee getEmployeeById(int employeeId); 

	public List<Employee> getAllEmployee();
	
	public boolean validateEmployee(int employeeId,String employeePassword);
	
	public boolean isEmployeeExists(int productId);
	
	public List<Customer> approvedCustomers();
	
	public List<Customer> notApprovedCustomers();
	
	public boolean approveCustomer(int customerId);
	
	public boolean denyCustomer(int customerId);

}
