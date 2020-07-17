<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="ecommerce.user.model.IndirizzoBean" %>
<%@ page import="ecommerce.prodotto.model.ProdottoBean" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/cart.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
  <link rel="stylesheet" href="css/navbar.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<jsp:include page="navbar.jsp" />
<body style="background-color:#E3981C">
	
	<% HashMap<IndirizzoBean,ArrayList<ProdottoBean>> lista = (HashMap<IndirizzoBean,ArrayList<ProdottoBean>>) session.getAttribute("lista");%>
	<div style="text-align:center;">
	<c:forEach var="entry" items="${lista}">
		<p>L'ordine sarà spedito presso:</p>
		Via: <c:out value="${entry.key.via}"/>
		Numero: <c:out value="${entry.key.numero}"/>
		Citta: <c:out value="${entry.key.citta}"/>
		Cap: <c:out value="${entry.key.cap}"/>
			
	</c:forEach>
	
	
	

    <!-- Cart -->
    <div class="col-lg-9 col-md-9 col-sm-12">
        <div class="col-lg-12 col-sm-12">
            <span class="title">SHOPPING CART</span>
        </div>
        <div class="col-lg-12 col-sm-12 hero-feature">
            <div class="table-responsive">
                <table class="table table-bordered tbl-cart">
                    <thead>
                        <tr>
                            <td class="hidden-xs">Image</td>
                            <td>Nome prodotto</td>
                            <td>Qta</td>
                            <td>Prezzo</td>
                            <td>Remove</td>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="entry" items="${lista}">
							<c:forEach var="prodotto" items="${entry.value}">
								
								<tr>
								<td class="hidden-xs">
									<a href="#">
                                    <img src="https://via.placeholder.com/200x200/" alt="#" title="" width="47" height="47">
                                	</a>
								</td>
								<td><c:out value="${prodotto.nome}"/></td>
								<td><div class="input-group bootstrap-touchspin">
									<span class="input-group-btn">
										<button class="btn btn-default bootstrap-touchspin-down" type="button" onclick="removeQuantity(${prodotto.idProdotto},this)">-</button>
									</span>
									<span class="input-group-addon bootstrap-touchspin-prefix" style="display: none;"></span>
									<input type="text" name="" value="<c:out value="${prodotto.quantitaDisponibile}"/>" class="input-qty form-control text-center" style="display: block;">
									<span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span>
									<span class="input-group-btn">
										<button class="btn btn-default bootstrap-touchspin-up" type="button" onclick="addQuantity(${prodotto.idProdotto},this)">+</button>
									</span>
									<!-- </div><c:out value="${prodotto.quantitaDisponibile}"/> -->
									</div>
								</td>
								<td class="price"><c:out value="${prodotto.prezzo}"/></td>
								<td>
									<a href="#" class="remove_cart" rel="2"><i class="fa fa-trash-o"></i></a>
								</td>
								</tr>
						</c:forEach>	
					</c:forEach>
                    	<!--<c:forEach var="entry" items="${lista}">
						<tr>
							<td><c:out value="${prodotto.nome}"/></td>
							<td>${employee[1]}</td>
							<td align="center">${employee[2]}</td>
							<td align="center">${employee[3]}</td>
						</tr>
						</c:forEach>
                        	<tr>
                            <td class="hidden-xs">
                                <a href="#">
                                    <img src="https://via.placeholder.com/200x200/" alt="#" title="" width="47" height="47">
                                </a>
                            </td>
                            <td><a href="#">Age Of Wisdom Tan Graphic Tee</a>
                            </td>
                            <td>
                                <select name="">
                                    <option value="" selected="selected">S</option>
                                    <option value="">M</option>
                                </select>
                            </td>
                      
                            <td>
                                <div class="input-group bootstrap-touchspin"><span class="input-group-btn"><button class="btn btn-default bootstrap-touchspin-down" type="button">-</button></span><span class="input-group-addon bootstrap-touchspin-prefix" style="display: none;"></span><input type="text" name="" value="1" class="input-qty form-control text-center" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span><span class="input-group-btn"><button class="btn btn-default bootstrap-touchspin-up" type="button">+</button></span></div>
                            </td>
                            <td class="price">$ 122.21</td>
                            <td>$ 122.21</td>
                            <td class="text-center">
                                <a href="#" class="remove_cart" rel="2">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td class="hidden-xs">
                                <a href="#">
                                    <img src="https://via.placeholder.com/200x200/" alt="Adidas Men Red Printed T-shirt" title="" width="47" height="47">
                                </a>
                            </td>
                            <td><a href="#">Adidas Men Red Printed T-shirt</a>
                            </td>
                            <td>
                                <select name="">
                                    <option value="">S</option>
                                    <option value="" selected="selected">M</option>
                                </select>
                            </td>
                
                            <td>
                                <div class="input-group bootstrap-touchspin"><span class="input-group-btn"><button class="btn btn-default bootstrap-touchspin-down" type="button">-</button></span><span class="input-group-addon bootstrap-touchspin-prefix" style="display: none;"></span><input type="text" name="" value="2" class="input-qty form-control text-center" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span><span class="input-group-btn"><button class="btn btn-default bootstrap-touchspin-up" type="button">+</button></span></div>
                            </td>
                            <td class="price">$ 20.63</td>
                            <td>$ 41.26</td>
                            <td class="text-center">
                                <a href="#" class="remove_cart" rel="1">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6" align="right">Total</td>
                            <td class="total" colspan="2"><b>$ 163.47</b>
                            </td>
                        </tr> -->
                    </tbody>
                </table>
               </div>
            <div class="btn-group btns-cart">
                <button type="button" class="btn btn-primary"><i class="fa fa-arrow-circle-left"></i> Continue Shopping</button>
                <button type="button" class="btn btn-primary">Update Cart</button>
                <button type="button" class="btn btn-primary" onclick="checkout()">Checkout <i class="fa fa-arrow-circle-right"></i></button>
            </div>
    </div>
    <!-- End Cart -->
    <p>Inserire, se l'indirizzo di default non è ritenuto adatto, il nuovo indirizzo di spedizione</p>
                <div class="inputfield">
			      <label>Via</label>
			      <input id="via" name="via" type="text" class="input" required>
			      <label style="margin-left: 10px">Numero</label>
			      <input id="numero" name="numero" type="text" class="input" required>
			    </div>
			    <div class="inputfield">
			      <label>Citta'</label>
			      <input id="citta" name="citta" type="text" class="input" required>
			      <label style="margin-left: 10px">CAP</label>
			      <input id="cap" name="cap" type="number" class="input" required>
			    </div>
			    <div id="errorIndirizzo" class="hideDiv alert alert-danger" role="alert">
				</div>
            </div>
</div>
<jsp:include page="footer.jsp" />
</body>
<script src="js/ordine.js"></script>
</html>