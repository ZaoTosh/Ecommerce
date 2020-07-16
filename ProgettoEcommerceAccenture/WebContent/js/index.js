$(document).ready(function(){
	$.ajax({
		url:"CategoriaServlet",
		method:"GET",
		dataType:"json",
		contentType: 'application/json',
        mimeType: 'application/json',
		success:function(data){
			var testo = new String();
			$.each(data,function(i,categoria){
				testo += '<div class="col-sm-4"><div class="panel panel-warning">';
				testo += '<div class="panel-heading">'+categoria.nome+' </div>';
				testo +='<div class="panel-body"> <a href= "WelcomeServlet?id='+categoria.idCategoria+'">  <img src= "'+categoria.urlImmagine+'" class="img-responsive" style="width:400px; height:200px;" alt="Image" ></a></div>';
				testo += '</div></div>';
        		
      			
			});
			
			$('#row').html(testo);
		}
	});
});
