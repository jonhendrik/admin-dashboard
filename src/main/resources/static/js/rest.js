$(document).ready(function () {
	$.ajax({
		type: "GET",
      	url: "/api/accounts",
    }).done(function (data) {
		console.log(data);
		
		// start table
		$("#dashtable").append("<tr><th scope=\"col\">Account Name</th><th scope=\"col\">Account Description</th><th scope=\"col\">Customer List</th><th scope=\"col\">Owned By</th></tr>");
		for (var account of data) {
			var html = "<tr><td>"+account.name+"</td><td>"+account.description+"</td><td><table class=\"table table-bordered\" id=\"accountTable_" + account.id + "\"> <tr><th scope=\"col\" style=\"width: 40%\">Customer Name</th><th scope=\"col\" style=\"width: 60%\">Invoice List</th></tr></table>"
				+"</td><td>"+account.ownedBy+"</td></tr>"
				
			$("#dashtable").append(html);
			for (var customer of account.customerList) {
				console.log(customer);
				var accountId = "#accountTable_" + account.id;
				$(accountId).append("<tr><td><p>"+ customer.name + "</p><div class=\"btn-group\" role=\"group\"><button type=\"button\" class=\"btn btn-warning editCustBtn\" id=\"" + customer.id + "\"><span class=\"glyphicon glyphicon-pencil\"></span></button><button type=\"button\" class=\"btn btn-danger deleteCustBtn\" id=\"" + customer.id + "\"><span class=\"glyphicon glyphicon-trash\"></span></button></div></td><td id=\"custTable_" + customer.id + "\"></td></tr>");
			
				for (var invoice of customer.invoiceList) {
					console.log(invoice);
					var customerId = "#custTable_" + customer.id;
					var dd = new Date(invoice.purchaseDate);
					var theDate = dd.getMonth()+1 + "/" + dd.getDate() + "/" + dd.getFullYear(); 
					$(customerId).append("<div class=\"row\"><div class=\"col-md-12\"><div class=\"thumbnail\"><div class=\"caption\"><h4>"+ invoice.description +"</h4><h6>Purchase Date: "+theDate+"</h6><h6>Purchase Price: "+invoice.purchasePrice+"</h6><div class=\"btn-group\" role=\"group\"><button id=\"" + invoice.id + "\" type=\"button\" class=\"btn btn-warning editInvBtn\"><span class=\"glyphicon glyphicon-pencil\"></span></button><button id=\"" + invoice.id + "\" type=\"button\" class=\"btn btn-danger deleteInvBtn\"><span class=\"glyphicon glyphicon-trash\"></span></button></div></div></div></div></div>");
				}
			}
			//$("#dashtable").append("<tr><td>"+account.name+"</td><td>"+account.description+"</td><td><table class=\"table table-bordere\"></table></td><td>"+account.ownedBy+"</td></tr>");
			//$("#dashtable").append("<td>"+account.name+"</td>");
			//$("#dashtable").append("<td>"+account.description+"</td>");
			//$("#dashtable").append("<td></td>");
			//$("#dashtable").append("<td>"+account.ownedBy+"</td>");
			//$("#dashtable").append("</tr>");
		}
		//end table
		
		
		$(".editCustBtn").click(function() {
    		console.log("delete " + this.id);

			var successUrl = "updateCustomer/" + this.id;
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
			console.log("edit " + this.id);
			
    		var successUrl = "updateInvoice/" + this.id;
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
