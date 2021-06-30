<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ecommerce.prodotto.model.ProdottoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/contatti.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

<div id="box">
<h3>Questa pagina contiene tutti i contatti della nostra attività di Ecommerce.</h3><br>

<br>

	<div id="headerRowContacts">
		<h2 id="ecSrl"><strong>Ecommerce.srl</strong></h2>
	</div>
	<table id="tableContacts">
		<tr>
			<td valign="top">
				<div class="boxInfo">
					<h4><strong>Sede centrale</strong></h4>
					Via Don Carlo Gnocchi, 3<br>
					00166 - Roma<br>
					Tel 00000000<br>
					Fax 00000000<br>
					Numero Verde solo per informazioni richiesta di registrazione: 000.000.000.000<br>
					Posta Elettronica Certificata: xxx@xxx.it<br>
				</div>
			</td>
			<td valign="top">
				<div class="boxInfo">
					<h4><strong>Servizio clienti</strong></h4>
					Numero di telefono: 02345678<br>
					email: articoli@gmail.com<br>
				</div>
			</td>
		</tr>
	</table>
	



</div>
<jsp:include page="footer.jsp" />
</body>
</html>
