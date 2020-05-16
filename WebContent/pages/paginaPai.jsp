<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Pai</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1>Página Pai load jQuery</h1>
	<input type="button" value="Carregar página" onclick="carregar();">
	
	<div id="mostrarPaginaFilha"></div> <!-- Local de carregamento da página filha -->

</body>

<script type="text/javascript">
	function carregar() {
		$("#mostrarPaginaFilha").load('paginaFilha.jsp'); // load página em jQuery
	}

</script>

</html>