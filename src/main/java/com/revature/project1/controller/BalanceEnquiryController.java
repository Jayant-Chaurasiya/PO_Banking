package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.model.Customer;
import com.revature.project1.service.CustomerService;
import com.revature.project1.service.CustomerServiceImpl;

/**
 * Servlet implementation class BalanceEnquiryController
 */
public class BalanceEnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceEnquiryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		CustomerService customerService=new CustomerServiceImpl();
		Customer customer=customerService.getCustomerById(customerId);
		if(customer!=null) {
			session.setAttribute("customer", customer);
			RequestDispatcher rd=request.getRequestDispatcher("customerBalanceResult.jsp");
			rd.forward(request, response);
			
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Customer Does Not Exist With this Id : "+customerId);
			out.println("<a href=customerBalance.jsp>Back</a>");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
