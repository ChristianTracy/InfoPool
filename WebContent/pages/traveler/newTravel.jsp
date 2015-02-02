<!DOCTYPE html>
<html>
<head>
<%@include file="../head.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>">
<script src="<c:url value="/resources/js/moment.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.js"/>"></script>
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Nuevo Recorrido</title>
</head>
	<body>
		<div class="container">
			<form action="submitTravel" method="post">
			
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>		
            </div>
            
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
            
            	
			
				<div class="form-group">
					<label for="date">Fecha:</label>
					<input type="text" name="date" class="form-control" id="date">	
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
					<input type="text" name="returnTime" class="form-control" id="returnTime">	
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
	</body>
</html>

