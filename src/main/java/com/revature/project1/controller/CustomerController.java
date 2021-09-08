package com.revature.project1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.project1.model.*;

import com.revature.project1.service.*;


public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger=Logger.getLogger("CustomerController");
       
    
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerName = request.getParameter("customerName");
		String customerPassword = request.getParameter("customerPassword");
		int customerBalance =Integer.parseInt(request.getParameter("customerBalance"));
		String customerContact =request.getParameter("customerContact");
		String customerEmail =request.getParameter("customerEmail");

		Customer customer=new Customer(0, customerName, customerPassword, customerBalance, customerContact, customerEmail, new java.util.Date());
		
		CustomerServiceImpl customerService=new CustomerServiceImpl();
		int customerId=customerService.addCustomer(customer);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><link rel=\"stylesheet\" href=\"https:"
				+ "//cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\""
				+ " integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\""
				+ " crossorigin=\"anonymous\"></head><body>");
		out.println("<div><nav class=\" navbar navbar-expand-lg  navbar-dark bg-dark\">\r\n"
				+ "	\r\n"
				+ "  <div class=\"container-fluid\">\r\n"
				+ "    <a class=\"navbar-brand\" href=\"#\">Revature Bank</a>\r\n"
				+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    </button>\r\n"
				+ "    <div class=\"collapse navbar-collapse\" id=\"navbarNav\" >\r\n"
				+ "      <ul class=\"navbar-nav\">\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"login.html\">Login</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"signUp.html\">SignUp</a>\r\n"
				+ "        </li>\r\n"
				+ "       <!--  <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"employeeSignupForm.html\">Employee SignUp</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"customerSignupForm.html\">Customer SignUp</a>\r\n"
				+ "        </li> -->\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"#\" tabindex=\"-1\" >About</a>\r\n"
				+ "        </li>\r\n"
				+ "         <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link\" href=\"#\" tabindex=\"-1\" >Contact Us</a>\r\n"
				+ "        </li>\r\n"
				+ "      </ul>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "</nav>\r\n"
				+ "</div>");
		out.println("<h2 style='color:green; text-align:center;'> SignUp Confirmation </h2>");
		logger.info("Custromer With Customer Name "+customerName+" has successfully completed his registration with id:"+customerId);
		out.println("Thank You "+ customerName +". You have successfully completed your SignUp process.");
		out.println("");
		out.println("<p> Please remember your unique id for further Processing : "+customerId+"</p>");
		out.println("<br/><br/><a href=home.html>Home</a>");

		out.println("</body></html>");
		
		
	}

}
