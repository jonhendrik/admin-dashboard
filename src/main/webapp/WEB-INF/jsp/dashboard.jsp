<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    
    <c:url value="/js/rest.js" var="restJs" />
	<script src="${restJs}"></script>
	
</head>
<body>
	<h1>Admin Dashboard</h1>
	<% 
		String account = null;
		if (session.getAttribute("account") == null) {
			account = request.getParameter("username");
			session.setAttribute("account", account);
		} else {
			account = (String) session.getAttribute("account");
		}
		
		out.print("Welcome "+ account);
		 
	%> 
	<form action="dashboard" method="post">
		<input type="hidden" name="account" value="${account}">  
		<div><input class="btn btn-default" type="submit" value="Create Customer" onclick="javascript:document.forms[0].action = 'createCustomer'; return true;"></div>
		<div><input class="btn btn-default" type="submit" value="Create Invoice" onclick="javascript:document.forms[0].action = 'createInvoice'; return true;"></input></div>
		<div>
			<div id="accountList"></div>
		</div>
	</form>
</body>
</html>