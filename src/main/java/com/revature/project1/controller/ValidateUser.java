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

import com.revature.project1.model.Customer;
import com.revature.project1.model.User;
import com.revature.project1.service.UserService;
import com.revature.project1.service.UserServiceImpl;

/**
 * Servlet implementation class ValidateUser
 */
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("ValidateEmployee");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUser() {
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
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userPassword = request.getParameter("userPassword");
		
		UserService userService=new UserServiceImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		if(userService.validateUser(userId, userPassword)) {
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
//			Customer customer=customerService.getCustomerName(customerId, customerPassword);
			User user=userService.getUserById(userId);
			session.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("userDashboard.jsp");
			rd.forward(request, response);	
		}else {
			out.println("<BR>");
			out.println("<BR>");
			out.println("<BR>");
			out.println("<h2 style=align:center;color:red;>Sorry Incorrect username or password</h2>");
			logger.warn("User has tried to login with Incorrect Id/Password");
			out.println("<BR>");
			out.println("<a href=login.html>Back</a>");
			
		}
	}

}
