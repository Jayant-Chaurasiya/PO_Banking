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
import com.revature.project1.dao.CustomerDAOImpl;
import com.revature.project1.model.Customer;
import com.revature.project1.model.TransactionLog;
import com.revature.project1.service.TransactionService;
import com.revature.project1.service.TransactionServiceImpl;

/**
 * Servlet implementation class DepositBalanceController
 */
public class DepositBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositBalanceController() {
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
		
		CustomerDAO customerDAO=new CustomerDAOImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		int customerId=(Integer) session.getAttribute("customerId");
		int amount=customerDAO.deposit(customerId,balance);
		TransactionService transactionService=new TransactionServiceImpl();
		TransactionLog transactionLog=new TransactionLog(customerId,balance);
		
		transactionService.addDepositTransaction(transactionLog);
		if(amount>0) {
			
						
			
			
			RequestDispatcher rd=request.getRequestDispatcher("viewBalance.jsp");
			rd.forward(request, response);
			
			
		}else {
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<h2>SomeThing Went Wrong ! Please Try Again</h2>");
			
		}
	}

}
