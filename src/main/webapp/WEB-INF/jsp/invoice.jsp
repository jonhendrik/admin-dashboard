<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    
    <c:url value="/js/form.js" var="formsJs" />
	<script src="${formsJs}"></script>
	
</head>
<body>
<h1>Invoice</h1>
<form id="invoiceForm" method="post">
	<input type="hidden" name="account" value="${account}">  
	<input type="text" class="form-control" id="description" name="description" placeholder="Description">
	<input type="date" id="purchDate" name="purchDate">
	<input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Price">
	Select Customer:&nbsp;
    <select name="customer" id="customer">
        <c:forEach items="${customerList}" var="customer">
            <option value="${customer.id}">
                ${customer.name}
            </option>
        </c:forEach>
    </select>
	<button type="submit" class="btn btn-primary">Save</button>
</form>
</body>
