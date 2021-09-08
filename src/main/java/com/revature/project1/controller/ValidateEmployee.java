package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.project1.model.*;
import com.revature.project1.dao.*;
import com.revature.project1.service.*;

/**
 * Servlet implementation class ValidateEmployee
 */
public class ValidateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger("ValidateEmployee");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateEmployee() {
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
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeePassword = request.getParameter("employeePassword");
		EmployeeService employeeService=new EmployeeServiceImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		if(employeeService.validateEmployee(employeeId, employeePassword)) {
			
			TransactionService transactionService=new TransactionServiceImpl();
			List<TransactionLog> transactionlist=transactionService.getAllTransaction();
			HttpSession session=request.getSession();
			session.setAttribute("employeeId", employeeId);
			Employee employee=employeeService.getEmployeeById(employeeId);
			session.setAttribute("employee", employee);
			session.setAttribute("transactionlist", transactionlist);
			RequestDispatcher rd=request.getRequestDispatcher("employeeDashboard.jsp");
			rd.forward(request, response);				
		}else {
			out.println("<BR>");
			out.println("<BR>");
			out.println("<BR>");
			out.println("<h2 style=align:center;color:red;>Sorry Incorrect username or password</h2>");
			logger.warn("Employee has tried to login with Incorrect Id/Password");
			out.println("<BR>");
			out.println("<a href=login.html>Back</a>");
			
			
		}
	}

}
