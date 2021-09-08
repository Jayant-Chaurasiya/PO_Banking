

function transfer(){
	var recieverId=document.getElementById("recieverId").value
	var balance=document.getElementById("balance").value
	if(balance.length==0){
		alert("Please Enter The balance to Transfer");
		return false;		
	}else if(balance<=0){
		alert("Please Enter Valid Amount to Transfer");
		return false;
	}else if(recieverId<=0){
		alert("Please Enter Valid ID to Transfer");
		return false;
	}else if(recieverId.length==0){
		alert("Please Enter Id to Transfer");
		return false;
	}else{
		return true;
	}
	
}




function balanceenquiry(){
	var customerId=document.getElementById("customerId").value
	if(customerId.length==0){
		alert("Please Enter Your Customer Id")
		return false;
	}else if(customerId<=0){
		alert("Please Enter Valid Id")
		return false;
	}else{
		return true;
	}
	
}

function usf(){
	var userName=document.getElementById("userName").value
	var userPassword=document.getElementById("userPassword").value
	var confirmPassword=document.getElementById("confirmPassword").value
	if(userName.length==0){
		alert("Please Enter Your User Name")
		return false;
	}else if(userPassword.length==0){
		alert("Please Enter Your Password")
		return false;
	}else if(confirmPassword.length==0){
		alert("Please Confirm Your Password")
		return false;
	}else if(userPassword!=confirmPassword){
		alert("Password Does Not Match")
		return false;
	}else{
		return true;
	}
}



















function validate(){
	var customerId=document.getElementById("customerId").value
	var customerPassword=document.getElementById("customerPassword").value
	if(customerId.length==0){
		alert("Please Enter Your Customer Id")
		return false;
	}else if(customerId<=0){
		alert("Please Enter Valid Id")
		return false;
	}else if(customerPassword.length==0){
		alert("Please Enter Your Password")
		return false;
	}else{
		return true;
	}
}



function deposit(){
	
	var balance=document.getElementById("balance").value
	if(balance.length==0){
		alert("Please Enter The balance to deposit");
		return false;		
	}else if(balance<=0){
		alert("Please Enter Valid Amount to Deposit");
		return false;
	}else{
		return true;
	}
	
}

function withdraw(){
	
	var balance=document.getElementById("balance").value
	var comment=document.getElementById("comment").value
	if(balance.length==0){
		alert("Please Enter The balance to Withdraw");
		return false;		
	}else if(balance<=0){
		alert("Please Enter Valid Amount to Withdraw");
		return false;
	}else if(comment.length==0){
		alert("Please Enter Any Comment");
		return false;
	}else{
		return true;
	}
	
}


function elf(){
	var employeeId=document.getElementById("employeeId").value
	var employeePassword=document.getElementById("employeePassword").value
	if(employeeId.length==0){
		alert("Please Enter Your Employee Id")
		return false;
	}else if(employeeId<=0){
		alert("Please Enter Valid Id")
		return false;
	}else if(employeePassword.length==0){
		alert("Please Enter Your Password")
		return false;
	}else{
		return true;
	}
}

function csf(){
	var allFeilds=new Array();
	for(i=0;i<6;i++){
		allFeilds[i]=document.forms[0].elements[i].value;		
	}
	if(allFeilds[0].length==0){
		alert("Name Can't be Empty");
		return false;
	}else if(allFeilds[1].length==0){
		alert("Password Can't be Empty")		
		return false;
	}else if(allFeilds[1]!=allFeilds[2]) {
		alert("Passowrd Does not Match");
		return false;
	}else if(allFeilds[4].length!=10) {
		alert("Please Input Valid Number");
		return false;
	}else if(allFeilds[4]%1!=0){
		alert("Wrong Input : Mobile  Number");
		return false;
	}else if(allFeilds[5].length==0){
		alert("Please Input Email Id");
		return false;
	}else{
		return true;
	}
	

}





function ulf(){
	var userId=document.getElementById("userId").value
	var userPassword=document.getElementById("userPassword").value
	if(userId.length==0){
		alert("Please Enter Your User Id")
		return false;
	}else if(userId<=0){
		alert("Please Enter Valid Id")
		return false;
	}else if(userPassword.length==0){
		alert("Please Enter Your Password")
		return false;
	}else{
		return true;
	}
}