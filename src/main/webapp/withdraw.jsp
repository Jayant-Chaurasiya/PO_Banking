<%@page import="com.revature.project1.model.Customer"%>
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
Customer customer=(Customer)session.getAttribute("customer");
session.setAttribute("customerId", customer.getCustomerId());

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

<h2>Welcome To Deposit Section </h2>
<br>
<p>Be Careful During your Transaction</p>
<br>
<div>
<form action="WithdrawBalanceController" onsubmit="return withdraw()" method="post">
<table>
<tr>
<td>
Please Enter Your Balance To Withdraw 
</td>
<td> <input type="number" id="balance" class="form-control" name="balance"></td>
</tr>
<tr>
<td>
Please Enter Your Comment
</td>
<td> <input type="text" id="comment" class="form-control" name="comment"></td>
</tr>
<tr><td colspan="2"></td></tr>
<tr>
<td colspan="1"><input type="submit" class="btn btn-primary" value="WithDraw"></td>
<td colspan="1">
<input type="reset" class="btn btn-primary" value="Reset">
</td>
</tr>

</table>
</form>
</div>


</body>
</html>