<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de Progresso</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/redmond/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">

/* fundo da barra de progresso - cor cinza*/
#myProgress { 
	width: 100%;
	background-color: #ddd; 
}

/*Cor da barra de progresso*/
#myBar {
	width: 0.5%;
	height: 30px;
	background-color: #4CAF50;
}

.ui-progressbar{
position: : relative;
}

.progress-label{
position: relative;
left: 50%;
top: 4px;
font-weight: bold;
text-shadow: 1px 1px 0 #fff;
} 

</style>

</head>
<body>
	<h1>Exemlo com java script</h1>
	<div id="myProgress"> <!-- Fundo da barra -->
		<div id="myBar"></div> <!-- Barra de progresso -->
	</div>
	<br/>
	<button onclick="exibirBarra();">Iniciar a barra de progresso</button>

	<br/>
	<h1>Barra de progresso com jQuery</h1>
	<div id="progressbar">
		<div class="progress-label">Carregando...</div>
	</div>

	<script type="text/javascript">
	// script da barra de progresso por jQuery
	$(function() {
		var progressbar = $("#progressbar"), progresslabel = $(".progress-label");
		
		progressbar.progressbar({ //cria a barra no div
			value : false,
			change : function() {
				progresslabel.text(progressbar.progressbar('value') + "%");
			}, 
			complete : function() {
				progresslabel.text('Completo!');
			}
		});
		function progress() {
			var val = progressbar.progressbar("value") || 0;
			
			progressbar.progressbar("value", val + 2);
			
			if (val < 99) {
				setTimeout(progress, 80);
			}
		} 
		setTimeout(progress, 2000);// Chamado ao abrir a tela
	});
	
	
	
	// script da barra de progresso por javascript
		function exibirBarra() {
			var elem = document.getElementById("myBar");
			var width = 1;
			var id = setInterval(progress, 10);
			
			function progress() {
				if (width >= 100) {
					clearInterval(id);
				} else {
					width++;
					elem.style.width = width + '%';
				}
			}

		}
	</script>
</body>
</html>












