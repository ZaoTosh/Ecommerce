<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Registrazione</title>

</head>
<body>
	<h1>Pagina di Registrazione</h1>
	<form action="" method="post" name="myForm" onsubmit="return Validate()">
		<label for="user">Username</label><br>
		<input type="text" id="user" name="user" placeholder="Inserisci username"><br>
		<div id="userError"></div><br>
		<label for="pass">Password</label><br>
		<input type="password" id="pass" name="pass" placeholder="Inserisci password"><br>
		<div id="passError"></div><br>
		<label for="name">Nome </label><br>
		<input type="text" id="name" name="name" placeholder="Inserisci il tuo nome"><br>
		<div id="nameError"></div><br>
		<label for="lastname">Cognome</label><br>
		<input type="text" id="surname" name="surname" placeholder="Inserisci il tuo cognome"><br>
		<div id="surnameError"></div><br>
		<label>Data di nascita:</label> <br>
		<input type="text" name="data_nascita" required> <br>
		<div id="dateError"></div><br>

		<button type="submit" name="registrati">Registrati</button>
	</form>
</body>
<script src="js/registrazione.js"></script>

</html>