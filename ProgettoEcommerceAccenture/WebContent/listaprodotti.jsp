<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/navbar.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

<div class="container" style="margin-top:20px;">    
  	<div class="row">

		<c:forEach var="elem" items="${listaprodotti}">
			<div class="col-sm-4"> 
      			<div class="panel panel-warning">
       			 	<div class="panel-heading">${elem.nome} </div>
       				<div class="panel-body"><img src="${elem.url}" class="img-responsive" style="width:400px; height:200px;" alt="Image"></div>
        			<div class="panel-footer">${elem.descrizione}</div>
      				</div>
    		</div>

		</c:forEach>
	</div>
</div>
<c:out value="${msg}"/>
<jsp:include page="footer.jsp" />
</body>
</html>