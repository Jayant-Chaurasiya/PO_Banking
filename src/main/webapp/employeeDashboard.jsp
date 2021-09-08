<%@page import="java.util.List"%>
<%@page import="com.revature.project1.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%  
session=request.getSession();
Employee employee=(Employee)session.getAttribute("employee");
session.setAttribute("employee",employee);

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
</body>
</html>