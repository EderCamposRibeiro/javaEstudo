<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Capturando exceções com jquery</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

	<h3>Capturando exceções com jquery</h3>
	<input type="text" value="valor informado" id="txtvalor">
	<input type="button" onclick="testarExcecao();" value="Testar Exceção">

</body>

<script type="text/javascript">
	function testarExcecao() {
		valorInformado = $('#txtvalor').val();
		
		$.ajax({
			method: "POST",
			url: "capturarExcecao",  //Para qual servlet?
			data: { valorParm : valorInformado}
		})
			.done(function (response) {// resposta ok - nenhum erro
				alert("Suceso " + response);
				//fazer algo
		})
			.fail(function(xhr, status, errorThrown) {// resposta erro -  algum problema ocorreu
				alert("Error: " + xhr.responseText); // Mostra resposta do servidor
				//fazer algo se der errado
		});
		
	}
</script>
</html>