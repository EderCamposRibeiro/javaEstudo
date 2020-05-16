<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de Progresso</title>

<style type="text/css">

#myProgress { /* fundo da barra de progresso*/
	width: 100%;
	background-color: #ddd; /* fundo da barra de progresso - cor cinza*/
}
/*Cor da barra de progresso*/
#myBar {
	width: 0.5%;
	height: 30px;
	background-color: #4CAF50;
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
	
	<script type="text/javascript">
		function exibirBarra() {
			var elem = document.getElementById("myBar");
			var width = 1;
			var id = setInterval(() => {
				if (width >= 100) {
					clearInterval(id);
				} else {
					width++;
					elem.style.width = width + "%";
				}
			}, 10);
			

		}
	</script>
</body>
</html>












