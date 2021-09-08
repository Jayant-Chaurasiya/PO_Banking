package com.revature.project1.dao;

import java.util.List;

import org.hibernate.*;

import com.revature.project1.model.Customer;
import com.revature.project1.model.Employee;
import com.revature.project1.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();


	public int addEmployee(Employee employee) {
		Transaction transaction=session.beginTransaction();
		session.save(employee);
		transaction.commit();
		int employeeId=employee.getEmployeeId();
		return employeeId;
	}

	public boolean deleteEmployee(int employeeId) {
		Transaction transaction=session.beginTransaction();
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		session.delete(employee);
		transaction.commit();
		return true;
		
	}

	public List<Employee> getEmployeeByName(String employeeName) {
		Query<Employee> query=session.createQuery("from com.revature.project1.model.Employee where employeeName='"+employeeName+"'");
		return query.list();
	}

	public Employee getEmployeeById(int employeeId) {
		Employee employee=session.get(Employee.class, employeeId);
		return employee;
	}

	public List<Employee> getAllEmployee() {
		Query<Employee> query=session.createQuery("from com.revature.project1.model.Employee");
		return query.list();
		
	}

	public boolean validateEmployee(int employeeId,String employeePassword){
		Query query=session.createQuery("from com.revature.project1.model.Employee where employeeId="+employeeId + "and employeePassword='"+employeePassword+"'");
		if(query.list().size()==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean isEmployeeExists(int employeeId) {
		Employee employee =session.get(Employee.class, employeeId);
		if(employee==null) 
			return false;
		else
			return true;
	}

	public List<Customer> approvedCustomers() {
		String customerStatus="Approved";
		Query<Customer> query=session.createQuery("from com.revature.project1.model.Customer where customerStatus='"+customerStatus+"'");
		return query.list();
	}

	public List<Customer> notApprovedCustomers() {
		String customerStatus="Not Approved";
		Query<Customer> query=session.createQuery("from com.revature.project1.model.Customer where customerStatus='"+customerStatus+"'");
		return query.list();
	}

	public boolean approveCustomer(int customerId) {
		String customerStatus="Approved";
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.getNamedQuery("approveCustomer")
				.setParameter("customerStatus", customerStatus)
				.setParameter("customerId", customerId);
		query.executeUpdate();
		transaction.commit();
		return true;
		
	}

	public boolean denyCustomer(int customerId) {
		String customerStatus="Not Approved";
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.getNamedQuery("denyCustomer")
				.setParameter("customerStatus", customerStatus)
				.setParameter("customerId", customerId);
		query.executeUpdate();
		transaction.commit();
		return true;
	}

}
