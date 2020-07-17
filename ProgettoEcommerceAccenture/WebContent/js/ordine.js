var listaProdotti = [];


function aggiungiCarrello(id, prezzo, thiss){
	
	var cart = new Object();
	
	cart.idProdotto=id;
	//cart.prezzoProdotto=prezzo;
	var qta = $(thiss).prev().val();
	cart.quantita = qta;
	listaProdotti.push(cart);
	//console.log(qta);
	//sessionStorage.setItem("shoppingCart",JSON.stringify(listaProdotti));
	console.log(listaProdotti);
	aggiornaCarrello(qta);
	
}

var totale = 0;

function aggiornaCarrello(qta){
	qta = parseInt(qta);
	console.log(qta);
	totale += qta;
	document.querySelector('.cart span').textContent = "(" + totale + ")";
	sessionStorage.setItem("qtaTot",totale);
}

function creaCarrello(){
	sessionStorage.setItem("shoppingCart",JSON.stringify(listaProdotti));
}

function sendCart(thiss){
	creaCarrello();
	var url = 'CartServlet';
	/*var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:9910/mymagic/mymagic");
	xhr.setRequestHeader("content-type", "application/json");
	xhr.send(sessionStorage.getItem("shoppingCart"));*/
	
	$.ajax({
		url: "CartServlet",
		type:"POST",
		dataType: "json",
		data: sessionStorage.getItem("shoppingCart"),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    async:false,
	    success:function(data){
	    	window.location.replace('cart.jsp');
		}
	});	
}



function loadCart(){
	listaProdotti = JSON.parse(sessionStorage.getItem("shoppingCart"));
}
function addQuantity(id,thiss){
	$.each(listaProdotti, function(i,prodotto){
		if(prodotto.idProdotto == id){
			prodotto.quantita++;
			$(thiss).parent().siblings(".input-qty").val(prodotto.quantita);
			aggiornaCarrello(prodotto.quantita);
		}
	});
	
}
function removeQuantity(id,thiss){
	$.each(listaProdotti,function(i,prodotto){
		if(prodotto.idProdotto == id){
			prodotto.quantita--;
			$(thiss).parent().siblings(".input-qty").val(prodotto.quantita);
			aggiornaCarrello(prodotto.quantita);
		}
	});
}
function checkout(){
	var indirizzo = new Object();
	//indirizzo.id= $("#idIndirizzo").val();
	var json={
			products:[],
			address:{
				
			}
	}
	$.each(listaProdotti,function(i,prodotto){
		json.products.push({"id" : prodotto.idProdotto, "quantity": prodotto.quantita});
	})
	json.address["via"] = $("#via").val();
	json.address["numero"] = $("#numero").val();
	json.address["citta"] = $("#citta").val();
	json.address["cap"] = $("#cap").val();
	/*indirizzo.via = $("#via").val();
	indirizzo.numero = $("#numero").val();
	indirizzo.citta= $("#citta").val();
	indirizzo.cap = $("#cap").val();*/
	
	
	
	var obj = JSON.stringify(json);
	console.log(obj);
	$.ajax({
		url: "OrdineServlet",
		type:"POST",
		dataType: "json",
		data: obj,
		contentType: 'application/json',
	    mimeType: 'application/json',
	    success:function(data){
	    	alert("Ordine effettuato con successo!");
		}
	});	
}
function removeProduct(id){
	$.each(listaProdotti,function(i,prodotto){
		if(prodotto.idProdotto == id){
			for(a= i,b=i+1; b< listaProdotti.length;a++){
				listaProdotti[a]=listProdotti[b];
			}
			listaProdotti[listaProdotti.length-1]=null;		
		}
	});
}
if(sessionStorage.getItem("shoppingCart") != null){
	loadCart();
}

if(sessionStorage.getItem("qtaTot") != null){
	//sessionStorage.removeItem("qtaTot");
	document.querySelector('.cart span').textContent = "(" + sessionStorage.getItem("qtaTot") + ")";
}

