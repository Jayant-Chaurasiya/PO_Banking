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
import com.revature.project1.service.CustomerService;
import com.revature.project1.service.CustomerServiceImpl;
import com.revature.project1.service.EmployeeService;
import com.revature.project1.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ConfirmCustomerDenyController
 */
public class ConfirmCustomerDenyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmCustomerDenyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		EmployeeService employeeService=new EmployeeServiceImpl();
		CustomerService customerService=new CustomerServiceImpl();
		employeeService.denyCustomer(customerId);
		
	
		HttpSession session = request.getSession();
		
		
		List<Customer> customers = employeeService.approvedCustomers();
		System.out.println(customers.size());
		if(customers.size()!=0) {
			session.setAttribute("message", "Disapproval of account with AccountId : "+customerId+ " is  successfull");
			
		}else {
			session.setAttribute("message", "All Customers Are Disapproved Now");
		}
		session.setAttribute("allCustomers", customers);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("customerSearch.jsp");
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
