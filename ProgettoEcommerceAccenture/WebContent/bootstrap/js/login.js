
var username = document.forms[""]["user"];
var password = document.forms[""]["pass"];
var regex = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,16}/;


var user_error = document.getElementById('userError');
var password_error = document.getElementById('passError');


username.addEventListener('keyup', userVerify, true);
password.addEventListener('keyup', passVerify, true);


function Validate() {
	if(userVerify() && passVerify())
		return true;
	else
		return false;
}

function userVerify() {
	  if (username.value == "") {
		  username.style.border = "1px solid red";
		  user_error.innerHTML = "Username è obbligatorio";
		  username.focus();
		  return false;
	  }else if(username.value.length < 3){
		  username.style.border = "1px solid red";
		  user_error.innerHTML = "Username deve avere almeno 3 caratteri";
		  username.focus();
		  return false;
	  }else{
		  username.style.border="1px solid green";
		  user_error.innerHTML = "";
		  return true;
	  }
}

function passVerify() {
	  if (password.value == "") {
		  password.style.border = "1px solid red";
		  password_error.textContent = "La password è obbligatoria";
		  password.focus();
		  return false;
	  }else if(!password.value.match(regex)){
		  password.style.border = "1px solid red";
		  password_error.innerHTML = "La password deve contenere almeno: una lettera minuscola, maiuscola, un numero";
		  password.focus();
		  return false;
	  }else{
		  password.style.border = "1px solid green";
		  password_error.innerHTML = "";
		  return true;
	  }
}
