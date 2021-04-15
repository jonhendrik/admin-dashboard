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
<h1>Customer</h1>
<form id="customerForm" method="post">
	<input type="hidden" name="account" value="${account}">  
	<input type="text" class="form-control" id="name" name="name" placeholder="Name">
	Select Account:&nbsp;
    <select name="account" id="account">
        <c:forEach items="${accountList}" var="account">
            <option value="${account.id}">
                ${account.name}
            </option>
        </c:forEach>
    </select>
	<button type="submit" class="btn btn-primary">Save</button>
</form>
</body>
</html>