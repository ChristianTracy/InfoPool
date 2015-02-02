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
		<div class="container">
			<div class="form-event">
				<form action="newevent" method="post">
					<div class="form-group">
					 	<label for="name">Nombre del evento</label>
						<input type="text" name="name" class="form-control" id="name">	
					</div>
					<div class="form-group">
						<label for="date">Fecha del evento</label>
						<input type="datetime-local" name="date" class="form-control" id="date">
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="date">hora del evento</label> -->
<!-- 						<input type="time" name="date" class="form-control" id="date"> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="description">Descripcion</label>
						<textarea name="description" rows="10" cols="50"></textarea>
<!-- 						<input type="textarea" name="description" class="form-control" id="description">	 -->
					</div>
					<div class="form-group">
						<label for="location">Direccion</label>
						<input type="text" name="location" class="form-control" id="location">
					</div>					
					<button type="submit" class="btn btn-lg btn-success btn-block">Agregar un evento</button>
				</form>	
			</div>
		</div>
	</body>
	<a href="/InfoPool">boton para volver</a> 
	
</html>
<%-- <%@ taglib uri="/struts-tags" prefix="s"%> --%>
<%-- <s:form action="event"> --%>
<%-- 	<s:date name="date" format="yyyy/MM/dd"></s:date> --%>
<%-- 	<s:textfield name="description" label="Description"></s:textfield> --%>
<%-- 	<s:textfield name="location" label="Location"></s:textfield> --%>
<%-- 	<s:textfield name="name" label="Name"></s:textfield> --%>
<%-- 	<s:submit value="register"></s:submit> --%>
<%-- </s:form> --%>


