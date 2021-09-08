<%@page import="com.revature.project1.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
session=request.getSession();
Customer customer=(Customer)session.getAttribute("customer"); 


%>








<h2>
Customer Balance Enquiry
</h2>

<h4>Balance of Customer having Id : <%=customer.getCustomerId() %>  is <%= customer.getCustomerBalance() %> INR</h4>

<a href="customerBalance.jsp">Back</a>


</body>
</html>