<!DOCTYPE html>
<html>
<head>
<%@include file="../head.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Nuevo Recorrido</title>
</head>
	<body>
		<div class="container">
			<form action="submitTravel" method="post">
	            <div class="form-group">
	            <label for="date">Fecha:</label>
	                <div class='input-group date' id='datetimepicker1'>
	                    <input type='text' class="form-control"  id="date" name="date"/>
	                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>		
	            </div>
				<div class="form-group">
					<label for="fromAdress">Desde:</label>
					<input type="text" name="fromAdress" class="form-control" id="fromAdress">	
				</div>
				<div class="form-group">
					<label for="toAdress">Hasta:</label>
					<input type="text" name="toAdress" class="form-control" id="toAdress">	
				</div>	
	            <div class="form-group">
	            <label for="returnTime">Hora de vuelta:</label>
	                <div class='input-group date' id='datetimepicker2'>
	                    <input type='text' class="form-control"  id="returnTime" name="returnTime"/>
	                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>		
	            </div>
				<div class="form-group">
					<label for="seats">Cantidad de asientos:</label>
					<input type="text" name="seats" class="form-control" id="seats">	
				</div>
				<div class="form-group">
					<label for="event">Evento asociado:</label>
					<select class="form-control">
						<option value="">Ninguno</option>
					</select>
				</div>				
				<button class="btn btn-info" type="submit">Crear!</button>
			</form>
		</div>
		
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                	format:'YYYY-MM-DD HH:mm'
                });
            });
            $(function () {
                $('#datetimepicker2').datetimepicker({
                	format:'YYYY-MM-DD HH:mm'
                });
            });
        </script>
	</body>
</html>

