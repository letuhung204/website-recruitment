function ajaxDeleteEmployee(id) {
	// DO DELETE
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/employee/deleteEmpoyee?elpId=" + id,
		success : function(result) {
			/*location.reload();*/
			console.log(result);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			/*location.reload();*/
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
		}
	});
}

function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toUTCString();
	document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function checkCookie(cname) {
	var user = getCookie(cname);
	if (user != "") {
		return true;
	} else {
		return false;
	}
}

function deleteCookie(cname) {
    document.cookie = cname + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};
