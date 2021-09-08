<%@page import="com.revature.project1.dao.*"%>
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
<body bgcolor="navyblue">
<div>
<%  
session =request.getSession();
Customer customer=(Customer)session.getAttribute("customer");
String msg=(String)session.getAttribute("msg");
CustomerDAO customerDAO=new CustomerDAOImpl();
int balance=customerDAO.viewBalance(customer.getCustomerId());

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
          <a class="nav-link active" aria-current="page" href="customerDashboard.jsp"><%= customer.getCustomerName() %> |Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="viewBalance.jsp">View Balance</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="deposit.jsp">Deposit</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="transfer.jsp">Transfer
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="withdraw.jsp">Withdraw</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CustomerLogoutController" >LogOut</a>
        </li>
        
      </ul>
    </div>
  </div>

</nav>
</div>


<div style="background-color: white;text-align: center;align-content:center ;display:inline-table;">

<table style="align-items: center;" >

<thead style="font-weight: bold;font-size:50px ;font-family:monospace;color: appworkspace;">Bank Balance</thead>

<tr></tr>
<tr><td>Your Current Bank Balance is : </td><td><%= balance %></td></tr>
<tr></tr>
<tr><td colspan="2">Thanks For Using This Application</td></tr>
</table>
</div>
</body>
</html>




