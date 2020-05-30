<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendário</title>
<link href='../script/demo-to-codepen.css' rel='stylesheet' />
<link href='../script/fullcalendar.min.css' rel='stylesheet' />
<link href='../script/fullcalendar.print.css' rel='stylesheet'
	media='print' />
<script src='../script/moment.min.js'></script>
<script src='../script/jquery.min.js'></script>
<script src='../script/fullcalendar.min.js'></script>
<script src='../script/demo-to-codepen.js'></script>

<style>
html, body {
	margin: 0;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 40px auto;
}
</style>
<link href='../script/cupertino-jquery-ui.css' rel='stylesheet' />

</head>
<body>
	<h1>Calendário</h1>
	<div id='calendar'></div>
	<script>
		$(function() {

			$.get("buscarCalendarioDatas", function(response) { ///Início do ajax GET Servlet
				
				var datas = JSON.parse(response);
	
			
				$('#calendar').fullCalendar({
					themeSystem : 'jquery-ui',
					header : {
						left : 'prev,next today',
						center : 'title',
						right : 'month,agendaWeek,agendaDay,listMonth'
					},
					weekNumbers : true,
					eventLimit : true, // allow "more" link when too many events
					//events: 'https://fullcalendar.io/demo-events.json'
					events : datas

				});
			}); ///Fim do ajax GET
		});
	</script>


</body>
</html>














