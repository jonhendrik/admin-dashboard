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
			<a class="navbar-brand" href="#">Invoice</a>
		</div>
	</div>
</nav>
<c:choose>
   <c:when test="${ invoice.id == null }">
       <form id="invoiceForm" method="post">
			<input type="hidden" name="account" value="${account}">
			<div class="row">
				<div class="col-md-6 col-md-offset-2">
					<div class="row form-group">
						<div class="col-md-3">
							Invoice Description: 
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control" id="description" name="description" placeholder="Description">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Purchase Date: 
						</div>
						<div class="col-md-9">
							<input type="date" class="form-control" id="purchDate" name="purchDate">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Purchase Price: 
						</div>
						<div class="col-md-9">
							<input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Price">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Select Customer:
						</div>
						<div class="col-md-9">
							<select name="customer" class="form-control" id="customer">
						        <c:forEach items="${customerList}" var="customer">
						            <option value="${customer.id}">
						                ${customer.name}
						            </option>
						        </c:forEach>
						    </select>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-2 col-md-offset-9">
							<div class="row">
								<div class="col-md-6">
									<input type="button" class="btn btn-primary" onclick="javascript:window.location.href='/dashboard'" value="Back"></input>
								</div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>    
		</form>
   </c:when>
   <c:otherwise>
   <form id="invoiceFormUpd" method="post">
			<input type="hidden" name="account" value="${account}">
			<div class="row">
				<div class="col-md-6 col-md-offset-2">
					<div class="row form-group">
						<div class="col-md-3">
							Invoice Description: 
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control" id="description" name="description" placeholder="Description" value="${invoice.description}">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Purchase Date: 
						</div>
						<div class="col-md-9">
							<input type="date" class="form-control" id="purchDate" name="purchDate" value="${invoice.purchaseDate}">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Purchase Price: 
						</div>
						<div class="col-md-9">
							<input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Price" value="${invoice.purchasePrice}">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							Select Customer:
						</div>
						<div class="col-md-9">
							<select name="customer" class="form-control" id="customer">
						        <c:forEach items="${customerList}" var="customer">
						            <option value="${customer.id}">
						                ${customer.name}
						            </option>
						        </c:forEach>
						    </select>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-2 col-md-offset-9">
							<div class="row">
								<div class="col-md-6">
									<input type="button" class="btn btn-primary" onclick="javascript:window.location.href='/dashboard'" value="Back"></input>
								</div>
								<div class="col-md-6">
									<button type="submit" class="btn btn-primary">Update</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>  
			
			<input type="hidden" id="customer" name="customer" value="${customer.id}">
		    <input type="hidden" id="invoice" name="invoice" value="${invoice.id}">  
		</form>
   </c:otherwise>
</c:choose>
</body>
