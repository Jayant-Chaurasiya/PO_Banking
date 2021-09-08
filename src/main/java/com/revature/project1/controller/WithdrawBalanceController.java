package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.dao.*;
import com.revature.project1.model.*;
import com.revature.project1.service.*;

/**
 * Servlet implementation class WithdrawBalanceController
 */
public class WithdrawBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawBalanceController() {
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
		int withdrawnBalance = Integer.parseInt(request.getParameter("balance"));
		String comment=request.getParameter("comment");
		CustomerService customerService=new CustomerServiceImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		int customerId=(Integer) session.getAttribute("customerId");
		boolean res=customerService.withdraw(customerId,withdrawnBalance);
		TransactionService transactionService=new TransactionServiceImpl();
		TransactionLog transactionLog=new TransactionLog(customerId,withdrawnBalance,comment);
		System.out.println(transactionLog);
		transactionService.addWithdrawTransaction(transactionLog);
			
		if(res) {			
			out.println("<p>AMount of INR "+withdrawnBalance+" successfully withdrawn from Your Account</p>");
			RequestDispatcher rd=request.getRequestDispatcher("viewBalance.jsp");
			rd.include(request, response);			
		}else {
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			
			out.println("<h2 align=center style=color:red>Insufficient Balance Please Try Again</h2>");
			session =request.getSession();
			Customer customer=(Customer)session.getAttribute("customer");
			session.setAttribute("customerId", customer.getCustomerId());
			out.println("<a href=withdraw.jsp>Back</a>");
			
		}
	}

}
