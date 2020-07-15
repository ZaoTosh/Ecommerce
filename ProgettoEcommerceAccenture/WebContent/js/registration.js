
var username = $("#username");
var password = $("#password");
var confPassword = $("#confirmPassword");
var nome = $("#nome");
var cognome = $("#cognome");
var via = $("#via");
var numero = $("#nuemero");
var citta = $("#citta");
var cap = $("#cap");
var dataNascita = $("#data_nascita");
var regex = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,16}/;

username.on('keyup',function(){
	checkUsername();});
password.on('keyup',function(){
	checkPassword();});
nome.on('keyup',function(){
	checkNome();});
cognome.on('keyup',function(){
	checkCognome();});
confPassword.on('keyup',function(){
	checkConfirmPassword();});
dataNascita.on('keyup',function(){
	checkData();});
via.on('keyup',function(){
	checkIndirizzo();});
numero.on('keyup',function(){
	checkIndirizzo();});
citta.on('keyup',function(){
	checkIndirizzo();});
cap.on('keyup',function(){
	checkIndirizzo();});

function Validate(){
	if(checkUsername() && checkNome() && checkCognome && chekPassword() && checkConfirmPassword() && checkData() && checkIndirizzo() )
		return true;
	else
		return false;
}

function checkUsername(){
	if(username.val() != "" && username.val().length > 6){
		$("#errorUsername").html("");
		$("#errorUsername").addClass("hideDiv");
		return true;
		
	}else{
		$("#errorUsername").html("l'username deve essere di almeno 6 caratteri");
		$("#errorUsername").removeClass("hideDiv");
		return false;
	}
}
function checkPassword(){
	if(password.val() != "" && password.val().match(regex)){
		$("#errorPassword").html("");
		$("#errorPassword").addClass("hideDiv");
		return true;
	}else{
		$("#errorPassword").html("almeno 6 caratteri, max 16, lettera maiuscola,minuscola,numero e car speciale");
		$("#errorPassword").removeClass("hideDiv");
		return false;
	}
}

function checkNome(){
	if(nome.val() != ""){
		$("#errorNome").html("");
		$("#errorNome").addClass("hideDiv");
		return true;
	}else{
		$("#errorNome").html("Il nome è obbligatorio");
		$("#errorNome").removeClass("hideDiv");
		return false;
	}
}

function checkCognome(){
	if(nome.val() != ""){
		$("#errorCognome").html("");
		$("#errorCognome").addClass("hideDiv");
		return true;
	}else{
		$("#errorCognome").html("Il cognome è obbligatorio");
		$("#errorCognome").removeClass("hideDiv");
		return false;
	}
}
function checkConfirmPassword(){
	if(password.val() == confPassword.val()){
		$("#errorConfermaPassword").html("");
		$("#errorConfermaPassword").addClass("hideDiv");
		return true;
	}else{
		$("#errorConfermaPassword").html("La due password sono diverse");
		$("#errorConfermaPassword").removeClass("hideDiv");
		return false;
	}
}
function checkData(){
	if(dataNascita.val() != ""){
		if(dataNascita.val() > "1900/01/01" && dataNascita.val() < "2020/01/01" ){
			$("#errorDataNascita").html("");
			$("#errorDataNascita").addClass("hideDiv");
			return true;
		}else{
			$("#errorDataNascita").html("La data deve essere compresa tra il 1900 e il 2019");
			$("#errorDataNascita").removeClass("hideDiv");
			return false;
		}
	}else{
		return true;
	}
}
function checkIndirizzo(){
	if(via.val()!="" && numero.val() != "" && citta.val() != "" && cap.val() != ""  ){
		$("#errorIndirizzo").html("");
		$("#errorIndirizzo").addClass("hideDiv");
		return true;
	}else{
		$("#errorIndirizzo").html("tutti i campi dell'indirizzo sono obbligatori");
		$("#errorIndirizzo").removeClass("hideDiv");
		return false;
	}
}
