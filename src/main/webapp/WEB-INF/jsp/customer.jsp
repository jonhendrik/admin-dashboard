<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    
    <c:url value="/js/form.js" var="formsJs" />
	<script src="${formsJs}"></script>
	
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Customer</a>
		</div>
	</div>
</nav>
<c:choose>
   <c:when test="${ customer.id == null }">
       <form id="customerForm" method="post">
			<input type="hidden" name="account" value="${account}">  
			<div class="row">
				<div class="col-md-6 col-md-offset-2">
					<div class="row form-group">
						<div class="col-md-3">
							Customer Name: 
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control" id="name" name="name" placeholder="Name">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Select Account:
						</div>
						<div class="col-md-9">
							<select class="form-control" name="account" id="account">
						        <c:forEach items="${accountList}" var="account">
						            <option value="${account.id}">
						                ${account.name}
						            </option>
						        </c:forEach>
						    </select>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-2 col-md-offset-10">
							<button type="submit" class="btn btn-primary">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
   </c:when>
   <c:otherwise>
   		<form id="customerFormUpd" method="post">
			<input type="hidden" name="account" value="${account}">  
			<div class="row">
				<div class="col-md-6 col-md-offset-2">
					<div class="row form-group">
						<div class="col-md-3">
							Customer Name: 
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${customer.name}">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Select Account:
						</div>
						<div class="col-md-9">
							<select class="form-control" name="account" id="account">
						        <c:forEach items="${accountList}" var="account">
						            <option value="${account.id}">
						                ${account.name}
						            </option>
						        </c:forEach>
						    </select>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-2 col-md-offset-10">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</div>
				</div>
			</div>
			
			<input type="hidden" id="customer" name="customer" value="${customer.id}">  
	    	<input type="hidden" id="invoiceList" name="invoiceList" value="${invoiceList}"> 
		</form>
   </c:otherwise>
</c:choose>
</body>
</html>