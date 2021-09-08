package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.model.Employee;
import com.revature.project1.service.*;



/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
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
		
		String employeeName = request.getParameter("employeeName");
		String employeeContact =request.getParameter("employeeContact");
		String employeeEmail =request.getParameter("employeeEmail");
		String employeePassword = request.getParameter("employeePassword");
		String employeeAddress = request.getParameter("employeeAddress");

		Employee employee=new Employee(0, employeeName, employeeContact, employeeEmail, employeePassword, employeeAddress);
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		int employeeId=employeeService.addEmployee(employee);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		
		out.println("Employee Name : "+ employeeName);
		out.println("Your Data  is saved successfully");
		out.println("<p> Please remember your unique id for further Processing : "+employeeId+"</p>");
		out.println("<br/><br/><a href=home.html>Home</a>");

		out.println("</body></html>");
		
	}

}
