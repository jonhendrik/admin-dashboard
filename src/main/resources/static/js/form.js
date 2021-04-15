$(document).ready(function () {
	$("#loginForm").submit(function (event) {
		var formData = {
			username: $("#name").val(),
	      	password: $("#email").val()
	    };
	
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
				var successUrl = "dashboard"; // might be a good idea to return this URL in the successful AJAX call
    			window.location.href = successUrl;
			} else {
				
			}
	    });

	    event.preventDefault();
	  });
});