package com.revature.project1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.model.Customer;
import com.revature.project1.model.Employee;
import com.revature.project1.service.EmployeeService;
import com.revature.project1.service.EmployeeServiceImpl;

/**
 * Servlet implementation class DenyCustomerController
 */
public class DenyCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeService = new EmployeeServiceImpl();
		HttpSession session=request.getSession();
		Employee employee=(Employee)session.getAttribute("employee");
		List<Customer> customers = employeeService.approvedCustomers();
		
		
		if(customers.size()!=0) {
			session.setAttribute("message", "");
		}else {
			session.setAttribute("message", "Disapproval of all acount is already Completed.");
		}
		session = request.getSession();
		session.setAttribute("allCustomers", customers);
		session.setAttribute("employee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("denyCustomer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
