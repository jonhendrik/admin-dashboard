<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">
    	<c:if test="${errorMessage != null }">
	    	<div class="row" style="margin-top: 2vh">
	    		<div class="col-md-4"></div>
	    		<div class="col-md-4 alert alert-danger" role="alert">
	    			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				  	<span class="sr-only">Error:</span> ${errorMessage}
				</div>
	    		<div class="col-md-4"></div>
	    	</div>
    	</c:if>
        <div class="row" style="margin-top: 40vh">
        	<div class="col-md-4"></div>
        	<div class="col-md-4">
	        	<form action="/auth" method="post">
	        		<div class="row form-group">
	        			<div class="col-md-12">
	        				<input type="text" class="form-control" id="username" name="username" placeholder="Username">
	        			</div>
	        		</div>
	        		<div class="row form-group">
	        			<div class="col-md-12">
	        				<input type="password" class="form-control" id="password" name="password" placeholder="Password">
	        			</div>
	        		</div>
	        		<div class="row form-group">
	        			<div class="col-md-3 col-md-offset-9">
	        				<button type="submit" class="btn btn-primary">Login</button>
	        			</div>
	        		</div>
	        	</form>
        	</div>
        	<div class="col-md-4"></div>
        </div>
    </div>

</body>
</html>