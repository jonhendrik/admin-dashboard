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
				"accountId": 1
  			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
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
			    "purchaseDate": new Date(),
			    "purchasePrice": $("#price").val(),
			    "customerId": 98
			}),
	      	dataType: "json",
			contentType: "application/json"
	    }).done(function (data) {
			console.log(data);
	    });

	    event.preventDefault();
	  });
});