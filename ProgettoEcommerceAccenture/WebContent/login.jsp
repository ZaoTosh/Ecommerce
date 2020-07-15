<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="css/login.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  <title>Sign in</title>
</head>
<body>

<div class="main">
  <p class="sign" align="center">Sign in</p>
  <form class="form1" action="LoginServlet" id="formLogin" method="post">
    <input id="username" class="un " type="text" align="center" placeholder="Username">
    <input id="password" class="pass" type="password" align="center" placeholder="Password">
    <button type = "submit" class="submit" form="formLogin" align="center">Sign in</button>
    <p class="forgot" align="center"><a href="#">Forgot Password?</a></p>
    <p class="forgot" align="center"><a href="registration.jsp" style="color: #E3981C">Registrati</a></p>
  </form>
  <p align="left"> <c:out value="${msg}" /> </p>
</div>

</body>
</html>