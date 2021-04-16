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

	<% 
		String account = null;
		if (session.getAttribute("account") == null) {
			account = request.getParameter("username");
			session.setAttribute("account", account);
		} else {
			account = (String) session.getAttribute("account");
		}
		 
	%> 

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Admin Dashboard</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<form action="createCustomer" method="post" class="navbar-form navbar-right">
					<input type="hidden" name="account" value="${account}"> 
					<input class="btn btn-default" type="submit" value="Create Customer" onclick="javascript:document.forms[0].action = 'createCustomer'; return true;">
			        <input class="btn btn-default" type="submit" value="Create Invoice" onclick="javascript:document.forms[0].action = 'createInvoice'; return true;"></input>
			      </form>
			</div>
		</div>
	</nav>
	
	<form action="dashboard" method="post">
		<!-- <input type="hidden" name="account" value="${account}">  
		<div><input class="btn btn-default" type="submit" value="Create Customer" onclick="javascript:document.forms[1].action = 'createCustomer'; return true;"></div>
		<div><input class="btn btn-default" type="submit" value="Create Invoice" onclick="javascript:document.forms[1].action = 'createInvoice'; return true;"></input></div>
		<div>
			<div id="accountList"></div>
		</div>
		-->
		<div class=row>
			<div class="col-md-10 col-md-offset-1">
				<table class="table table-bordered" id="dashtable"></table>
			</div>
		</div>
	</form>
</body>
</html>