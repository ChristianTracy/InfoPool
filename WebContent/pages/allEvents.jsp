<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<title>Listado de Eventos</title>
</head>
<body>
<h1>Eventos</h1>

<table class="table table-striped">
	<thead>
		<th>Nombre</th>
		<th>Locación</th>
		<th>Fecha</th>
		<th>Descripción</th>
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
		  </tr>
		</s:iterator>	
	</tbody>
</table>



</body>
</html>