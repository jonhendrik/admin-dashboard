$(document).ready(function () {
	$.ajax({
		type: "GET",
      	url: "/api/accounts",
    }).done(function (data) {
		console.log(data);
		$("#accountList").append("<ul>");
		for (var account of data) {
			console.log(account);
			$("#accountList").append("<li>" + account.name + "</li><ul id=\"account_" + account.id + "\">");
			for (var customer of account.customerList) {
				console.log(customer);
				var accountId = "#account_" + account.id;
				$(accountId).append("<li>"+ customer.name + "</li><ul id=\"customer_" + customer.id + "\">");
				
				for (var invoice of customer.invoiceList) {
					console.log(invoice);
					var customerId = "#customer_" + customer.id;
					$(customerId).append("<li>"+ invoice.description + "</li>");
				}
			}
		};
		$("#accountList").append("</ul></ul></ul>");
    });
});