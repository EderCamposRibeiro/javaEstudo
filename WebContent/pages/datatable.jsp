<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datatable jQuery</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
</head>
<body>
<table id="minhatabela" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Nome</th>
            </tr>
        </thead>
    </table>
</body>
<script type="text/javascript">
$(document).ready(function() {// Faz o processamento na hora que abre a tela
    $('#minhatabela').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable" // URL de Retorno dos dados do servidor (Resposta do servidor)
    } );
} );
</script>
</html>