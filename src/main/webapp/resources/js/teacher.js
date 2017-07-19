window.onload = function(){
	loadView();
}

String.prototype.capitalize = function() {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

function loadView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("loading teacher info");
			var data = JSON.parse(xhr.responseText);
			document.getElementById('username').innerHTML = data.u_username;
			document.getElementById('password').innerHTML = data.u_password;
			document.getElementById('name').innerHTML = data.u_fname.capitalize() + " " + data.u_lname.capitalize();
			document.getElementById('email').innerHTML = data.u_email;
		}
	}
	
	xhr.open("GET", "getPersonalInfo", true);
	xhr.send();
}