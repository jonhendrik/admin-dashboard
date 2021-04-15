$(document).ready(function () {
	$.ajax({
		type: "GET",
      	url: "/api/accounts",
    }).done(function (data) {
		console.log(data);
		$("#accountList").append("<ul>");
		for (var account of data) {
			console.log(account);
			$("#accountList").append("<li>" + account.name + "</li>");
			$("#accountList").append("<ul id=\"account_" + account.id + "\">");
			for (var customer of account.customerList) {
				console.log(customer);
				var accountId = "#account_" + account.id;
				$(accountId).append("<li>"+ customer.name + "</li>");
				$(accountId).append("<input type=\"button\" class=\"btn btn-default editCustBtn\" value=\"Edit\" id=\"" + customer.id + "\"></input>");
				$(accountId).append("<input type=\"button\" class=\"btn btn-default deleteCustBtn\" value=\"Delete\" id=\"" + customer.id + "\"></input>");
				$(accountId).append("<ul id=\"customer_" + customer.id + "\">");
				
				for (var invoice of customer.invoiceList) {
					console.log(invoice);
					var customerId = "#customer_" + customer.id;
					$(customerId).append("<li>"+ invoice.description + "</li>");
					$(customerId).append("<input type=\"button\" class=\"btn btn-default editInvBtn\" value=\"Edit\" id=\"" + invoice.id + "\"></input>");
					$(customerId).append("<input type=\"button\" class=\"btn btn-default deletInveBtn\" value=\"Delete\" id=\"" + invoice.id + "\"></input>");
				}
			}
		};
		$("#accountList").append("</ul></ul></ul>");
		
		$(".editCustBtn").click(function() {
    		console.log("delete " + this.id);

			var successUrl = "createCustomer";
    		window.location.href = successUrl;
	
		    event.preventDefault();
		});
		
		$(".deleteCustBtn").click(function() {
    		console.log("delete " + this.id);

			$.ajax({
				type: "DELETE",
		      	url: "/api/customers/" + this.id,
		    }).done(function (data) {
				console.log(data);
				var successUrl = "dashboard";
	    		window.location.href = successUrl;
		    });
	
		    event.preventDefault();
		});
		
		$(".editInvBtn").click(function() {
    		var successUrl = "createInvoice";
	    	window.location.href = successUrl;
	
		    event.preventDefault();
		});
		
		$(".deleteInvBtn").click(function() {
    		console.log("delete " + this.id);

			$.ajax({
				type: "DELETE",
		      	url: "/api/invoices/" + this.id,
		    }).done(function (data) {
				console.log(data);
				var successUrl = "dashboard";
	    		window.location.href = successUrl;
		    });
	
		    event.preventDefault();
		});
    });

	$("button").click(function() {
    	console.log("edit " + this.id);
	});
	
	
	$(".editBtn").click(function() {
    	console.log("edit " + this.id);
	});
});
