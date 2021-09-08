package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.dao.CustomerDAO;
import com.revature.project1.model.Customer;
import com.revature.project1.model.TransactionLog;
import com.revature.project1.service.*;

/**
 * Servlet implementation class TransferBalanceController
 */
public class TransferBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferBalanceController() {
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
		int balance = Integer.parseInt(request.getParameter("balance"));
		int recieverId=Integer.parseInt(request.getParameter("recieverId"));
		CustomerService customerService=new CustomerServiceImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		int customerId=(Integer) session.getAttribute("customerId");
		if(customerService.isCustomerExists(recieverId)) {
			if(customerService.transferAmount( customerId, balance, recieverId)) {
				TransactionService transactionService=new TransactionServiceImpl();
				TransactionLog transactionLog=new TransactionLog(customerId,balance,recieverId);
				
				transactionService.addTransferTransaction(transactionLog);
				RequestDispatcher rd=request.getRequestDispatcher("viewBalance.jsp");
				rd.forward(request, response);						
			}else {
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				out.println("<h2 align=center style=color:red>Insufficient Balance Please Try Again</h2>");
				session =request.getSession();
				Customer customer=(Customer)session.getAttribute("customer");
				session.setAttribute("customerId", customer.getCustomerId());
				out.println("<a href=transfer.jsp>Back</a>");			
			}
			
		}else {
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<h2 align=center style=color:red>Customer Does Not Exist</h2>");
			session =request.getSession();
			Customer customer=(Customer)session.getAttribute("customer");
			session.setAttribute("customerId", customer.getCustomerId());
			out.println("<a href=transfer.jsp>Back</a>");
			
		}
		
		
	}

}
