<%@page import="com.revature.project1.model.Employee"%>
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
          <a class="nav-link active" aria-current="page" href="customerDashboard.jsp"><%= employee.getEmployeeName() %> | DashBoard</a>
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





<h2>Welcome To Balance-Enquiry Section </h2>
<br>
<p>Be Careful During your Transaction</p>
<br>
<div>
<form action="BalanceEnquiryController" onsubmit="return balanceenquiry()" method="post">
<table>

<tr>
<td>
Please Enter Customer Id : 
</td>
<td> <input type="number" id="customerId" class="form-control" name="customerId"></td>
</tr>


<tr><td colspan="2"></td></tr>
<tr>
<td colspan="1"><input type="submit" class="btn btn-primary" value="Balance Enquiry"></td>
<td colspan="1">
<input type="reset" class="btn btn-primary" value="Reset">
</td>
</tr>

</table>
</form>
</div>





</body>
</html>