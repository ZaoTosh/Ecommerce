<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="container" style="margin-top:20px;">    
  	<div class="row">

		<c:forEach var="elem" items="${listaprodotti }">
			<div class="col-sm-4"> 
      			<div class="panel panel-warning">
       			 	<div class="panel-heading">${elem.nome} </div>
       				<div class="panel-body"><img src="${elem.urlImmagine}" class="img-responsive" style="width:400px; height:200px;" alt="Image"></div>
        			<div class="panel-footer">${elem.descrizione}</div>
      				</div>
    		</div>

		</c:forEach>
	</div>
</div>

</body>
</html>