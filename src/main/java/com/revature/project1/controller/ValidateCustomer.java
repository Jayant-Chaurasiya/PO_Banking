package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.project1.service.*;
import com.revature.project1.dao.*;
import com.revature.project1.model.Customer;

/**
 * Servlet implementation class ValidateCustomer
 */
public class ValidateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger("ValidateCustomer");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String customerPassword = request.getParameter("customerPassword");
		CustomerService customerService=new CustomerServiceImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
			String customerStatus=customerService.getCustomerStatus(customerId);
			if(customerStatus.equals("Approved")) {
				if(customerService.validateCustomer(customerId, customerPassword)) {			
					HttpSession session=request.getSession();
					session.setAttribute("customerId", customerId);
					Customer customer=customerService.getCustomerName(customerId, customerPassword);
					session.setAttribute("customer", customer);
					RequestDispatcher rd=request.getRequestDispatcher("customerDashboard.jsp");
					rd.forward(request, response);			
					}else {
						out.println("<h2>Sorry Incorrect username or password</h2>");	
						logger.warn("Customer has tried to login with Incorrect Id/Password");
					}
			}else {
				out.println("<h2>Sorry User is Not Approved</h2>");
				logger.warn("Customer has not been approved yet");
			}
		
		
	}

}
