$(document).ready(function () {
	$("#loginForm").submit(function (event) {
	    $.ajax({
			type: "POST",
	      	url: "/auth",
	      	data: JSON.stringify({
			    "username": $("#username").val(),
			    "password": $("#password").val()
  			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
			if (data == true) {
				var successUrl = "dashboard";
    			window.location.href = successUrl;
			} else {
				
			}
	    });

	    event.preventDefault();
	  });
});

$(document).ready(function () {
	$("#customerForm").submit(function (event) {

	    $.ajax({
			type: "POST",
	      	url: "/api/customers",
	      	data: JSON.stringify({
			    "name": $("#name").val(),
			    "invoiceList": [],
				"accountId": $("#account").val()
  			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
			var successUrl = "/dashboard";
    		window.location.href = successUrl;
	    });
	    event.preventDefault();
	  });

	$("#customerFormUpd").submit(function (event) {
	    $.ajax({
			type: "PUT",
	      	url: "/api/customers/" + $("#customer").val(),
	      	data: JSON.stringify({
				"id": $("#customer").val(),
			    "name": $("#name").val(),
			    "invoiceList": [],
				"accountId": $("#account").val()
  			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
			var successUrl = "/dashboard";
    		window.location.href = successUrl;
	    });
	    event.preventDefault();
	  });
});

$(document).ready(function () {
	$("#invoiceForm").submit(function (event) {
	    $.ajax({
			type: "POST",
	      	url: "/api/invoices",
	      	data: JSON.stringify({
			    "description": $("#description").val(),
			    "purchaseDate": $("#purchDate").val(),
			    "purchasePrice": $("#price").val(),
			    "customerId": $("#customer").val()
			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
			var successUrl = "/dashboard";
    		window.location.href = successUrl;
	    });

	    event.preventDefault();
	  });
});