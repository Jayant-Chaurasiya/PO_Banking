<%@page import="com.revature.project1.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.project1.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script type="text/javascript" src="js/validator.js"></script>
</head>
<body>
<%  
session=request.getSession();
Employee employee=(Employee)session.getAttribute("employee");
String message=(String)session.getAttribute("message");
%>
<nav class=" navbar navbar-expand-lg  navbar-dark bg-dark">
	
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Revature Bank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav" >
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="employeeDashboard.jsp"><%= employee.getEmployeeName() %> | DashBoard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ApproveCustomerController">Approve-Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="DenyCustomerController">Deny-Customer</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="customerBalance.jsp">Check-Balance</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="transaction.jsp">Transactions</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="EmployeeLogoutController" >LogOut</a>
        </li>
        
      </ul>
    </div>
  </div>

</nav>


<hr>
<h2>Customer details</h2>
	<%
	List <Customer > customers =(List<Customer>)session.getAttribute("allCustomers");
	%>
	<table cellpadding="10" cellspacing="10">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Balance</th>
		<th>Contact</th>
		<th>Email</th>
		<th>RegistrationDate</th>
		<th>Status</th>
		<th>Action</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%= customer.getCustomerId() %></td>
			<td><%= customer.getCustomerName() %></td>
			<td><%= customer.getCustomerBalance() %></td>
			<td><%= customer.getCustomerContact() %></td>
			<td><%= customer.getCustomerEmail() %></td>
			<td><%= customer.getCustomerRegistrationDate() %></td>
			<td><%= customer.getCustomerStatus() %></td>
			
			
			<td><a href="ConfirmCustomerDenyController?customerId=<%=customer.getCustomerId() %>">Deny</a></td>
		</tr>
		<%
		}
		%>

	</table>

<h4><%=message %></h4>


</body>
</html>