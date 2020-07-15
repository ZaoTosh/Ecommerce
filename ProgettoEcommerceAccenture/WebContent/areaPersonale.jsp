<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="bootstrap.css">
  <link rel="stylesheet" href="css/navbar.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Modifica dati </title>
</head>
<body>
<jsp:include page="navbar.jsp" />


<div class="col-md-8 order-md-1">
	<h4 class="mb-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Indirizzo Di Fatturazione</font></font></h4>
		<form action="" method="POST">
			<div class="row">
				<div class="col-md-6 mb-3">
							<label for="firstName"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Nome</font></font></label>
							<input type="text" class="form-control" id="firstName" placeholder="" value="" disabled>

								<div class="invalid-feedback">
								</div>

						</div>

						<div class="col-md-6 mb-3">
							<label for="lastName"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Cognome</font></font></label>
							<input type="text" class="form-control" id="lastName" placeholder=""  disabled>

						
						</div>
					</div>

					<div class="mb-3">
						<label for="email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Email </font></font><span class="text-muted"><font style="vertical-align: inherit;"></font></span></label>
						<input type="email" class="form-control" id="email" value="" disabled>
								

					</div>

					<div class="mb-3">
						<label for="address"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">indirizzo</font></font></label>
						<input type="text" class="form-control" id="address" value="" disabled>
					</div>			
					<div class="mb-3">
						<label for="password"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">password</font></font></label>
						<input type="text" class="form-control" id="password" value="" disabled>
					</div>

					

				<a href=""><button class="btn btn-warning btn-lg btn-block" type="submit"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Modifica dati</font></font></button></a>
			</div>
		

</body>
<jsp:include page="footer.jsp" />

</html>