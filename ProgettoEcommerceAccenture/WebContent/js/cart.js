

let carts = document.querySelectorAll('.addCart');

for(let i=0; i < carts.length; i++){
	carts[i].addEventListener('click', () => {
		cartNumbers();
	})
}

function cartNumbers(){
	let productNumbers = localStorage.getItem('cartNumbers');
	productNumbers = parseInt(productNumbers);
	if(productNumbers){
		localStorage.setItem('cartNumbers', productNumbers + 1);
		document.querySelector('.cart span').textContent = productNumbers + 1;
	}else{
		localStorage.setItem('cartNumbers',1);
		document.querySelector('.cart span').textContent = 1;
	}
}

var listaProdotti = [];


function aggiungiCarrello(id, prezzo, thiss){
	
	var cart = new Object();
	
	cart.idProdotto=id;
	cart.prezzoProdotto=prezzo;
	var qta = $(thiss).prev().val();
	cart.quantita = qta;
	listaProdotti.push(cart);
	//console.log(qta);
	//sessionStorage.setItem("shoppingCart",JSON.stringify(listaProdotti));
	console.log(listaProdotti);
	
}

function creaCarrello(){
	sessionStorage.setItem("shoppingCart",JSON.stringify(listaProdotti));
}

function sendCart(){
	creaCarrello();
	$.ajax({
		url: "CartServlet",
		type:"GET",
		dataType: "json",
		data: sessionStorage.getItem("shoppingCart"),
		contentType: 'application/json',
	    mimeType: 'application/json',
	    async:false 
	});	
}



function loadCart(){
	listaProdotti = JSON.parse(sessionStorage.getItem("shoppingCart"));
}

if(sessionStorage.getItem("shoppingCart") != null){
	loadCart();
}




