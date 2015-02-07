<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="ar.edu.unlp.info.infopool.model.User"%>
<title>Eventos</title>
</head>
	<body>
	<%@include file="admin/navbar.jsp" %>
		<div class="container">
			<div class="form-event">
				<form action="newEvent" method="post">
					<div class="form-group">
					 	<label for="name">Nombre del evento</label>
						<input type="text" name="name" class="form-control" id="name">	
					</div>
					
	            <div class="form-group">
	            <label for="date">Fecha:</label>
	                <div class='input-group date' id='datetimepicker'>
	                    <input type='text' class="form-control"  id="date" name="date"/>
	                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>		
	            </div>
					<div class="form-group">
						<label for="description">Descripción</label>
						<textarea name="description" rows="10" cols="50"></textarea>
<!-- 						<input type="textarea" name="description" class="form-control" id="description">	 -->
					</div>
					<div class="form-group">
						<label for="location">Dirección</label>
						<input type="text" name="location" class="form-control" id="location">
					</div>					
					<button type="submit" class="btn btn-lg btn-success btn-block">Agregar un evento</button>
				</form>	
			</div>
		</div>


        <script type="text/javascript">
        $(function () {
            $('#datetimepicker').datetimepicker({
            	format:'YYYY-MM-DD HH:mm'
            });
        });
        </script>
<%@include file="footer.jsp" %>
	</body>
	
</html>

