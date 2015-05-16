<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="head.jsp" %>
<title>LISTADO DE EVENTOS</title>
</head>
<body>
<%@include file="admin/navbar.jsp" %>
<div class="content-container container">
		<div class="row">
			<div class="col-md-9">
				<h1>Eventos</h1>
				<table class="table table-striped">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Locación</th>
						<th>Fecha</th>
						<th>Descripción</th>
						<th>Acciones</th>
					</tr>
				</thead>
	
				<tbody>
					<s:iterator value="eventCollection">
					  <tr>
					  	<td>
					  		<s:property value="name"/>
					  	</td>
					  	<td>
					  		<s:property value="location"/>
					  	</td>
					  	<td>
					  		<s:property value="date"/>
					  	</td>
					  	<td>
					  		<s:property value="description"/>
					  	</td>
					  	<td>
					  		<input type="button" value="Borrar">
					  		<input type="button" value="Modificar"> 
					  	</td>	
					  	
					  </tr>
					</s:iterator>	
				</tbody>
				</table>
			</div>
	</div>
</div>
<%@include file="footer.jsp" %>


</body>
</html>