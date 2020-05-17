<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Files</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<form enctype="application/x-www-form-urlencoded">
		<input type="file" id="file" name="file" onchange="uploadFile();">
		<img alt="Imagem" src="" id="target" width="200" height="200">
	</form>
</body>

<script type="text/javascript">
    function uploadFile() {
		
		var target = document.querySelector("img");
		var file = document.querySelector('input[type=file]').files[0];
	
		var reader = new FileReader();
	
		reader.onloadend = function () {
			target.src = reader.result;

			//-----Upload Ajax-----
			
			$.ajax({
				method: "POST",
				url: "fileUpload",  //Para qual servlet?
				data: { fileUpload : reader.result}
			})
				.done(function (response) {// resposta ok - nenhum erro
					alert("Suceso " + response);
			})
				.fail(function(xhr, status, errorThrown) {// resposta erro -  algum problema ocorreu
					alert("Error: " + xhr.responseText); // Mostra resposta do servidor
			});
			reader.readAsDataURL(file);
				//-----Fim Upload Ajax-----
		};
	
		if (file) {
			reader.readAsDataURL(file);
		}else {
			target.src="";
		}
    }
</script>
</html>