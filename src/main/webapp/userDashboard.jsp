<%@page import="com.revature.project1.model.User"%>
<%@page import="com.revature.project1.model.Customer"%>
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
User user=(User)session.getAttribute("user");
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
          <a class="nav-link active" aria-current="page" href="userDashboard.jsp"><%= user.getUserName() %> | DashBoard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="customerSignupForm.html">Add Customer</a>
        </li>
        
        
        <!-- <li class="nav-item">
          <a class="nav-link" href="deposit.jsp">Deposit</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="transfer.jsp">Transfer
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="withdraw.jsp">Withdraw</a>
        </li> -->
        
        
        <li class="nav-item">
          <a class="nav-link" href="CustomerLogoutController" >LogOut</a>
        </li>
        
      </ul>
    </div>
  </div>

</nav>
</body>
</html>