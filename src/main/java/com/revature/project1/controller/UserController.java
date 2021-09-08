package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.project1.model.User;
import com.revature.project1.service.UserService;
import com.revature.project1.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("UserController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		;
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		
		
		User user=new User(0,userName,userPassword);
		UserService userService=new UserServiceImpl();
		int userId=userService.addUser(user);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		
		out.println("User Name : "+ userName);
		out.println("Your Data  is saved successfully");
		out.println("<p> Please remember your unique id for further Processing : "+userId+"</p>");
		logger.info("Custromer With Customer Name "+userName+" has successfully completed his registration with id:"+userId);
		out.println("<br/><br/><a href=home.html>Home</a>");

		out.println("</body></html>");
		
	}

}
