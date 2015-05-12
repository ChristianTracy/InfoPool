<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>PANEL VIAJERO</title>
</head>
<body>
	<%@include file="traveler/navbar.jsp" %>
	<div class="content-container container">
		<div class="row">
			<div class="col-md-3">
				<h2>Mis datos</h2>
				<ul class="list-group">
					<li class="list-group-item">
						<h4>Nombre: <small><s:property value="traveler.name"/> <s:property value="traveler.surname"/></small></h4>
					</li>
					<li class="list-group-item">
						<h4>Email: <small><s:property value="traveler.email"/></small></h4>
					</li>
					<li class="list-group-item">
						<h4>Teléfono: <small> <s:property value="traveler.telephone"/></small></h4>
					</li>
					<li class="list-group-item">
						<h4>Como conductor: <small><s:property value="myTravels.size"/></small></h4>
					</li>
					<li class="list-group-item">
						<h4>Como pasajero: <small><s:property value="traveler.otherTravels.size"/></small></h4>
					</li>
				</ul>
				
			</div>
			<div class="col-md-9">
				<h1>Mis viajes creados</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Desde</th>
							<th>Hasta</th>
							<th>Salida</th>
							<th>Regreso</th>
							<th>Asientos </th>		
							<th>Evento</th>
						</tr>
					</thead>
					
					<tbody>
					<s:iterator value="myTravels">
						  <tr>
						  	<td>
						  		<s:property value="fromAdress"/>
						  	</td>
						  	<td>
						  		<s:property value=" toAdress"/>
						  	</td>
						  	<td>
						  		<s:property value="date"/>
						  	</td>
						  	<td>
						  		<s:property value="returnTime"/>
						  	</td>
						  	<td>
						  		<s:property value=" seats"/>
						  	</td>
						  	<td>
						  		<s:property value="event.name"/>
						  	</td>
						  </tr>
						</s:iterator>
					</tbody>
				</table>			
				<hr>
				<h1>Viajes en los que participa</h1>

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Desde</th>
							<th>Hasta</th>
							<th>Salida</th>
							<th>Regreso</th>
							<th>Asientos </th>		
							<th>Evento</th>
							<th>Denuncia</th>
						</tr>
					</thead>
					
					<tbody>
					<s:iterator value="traveler.otherTravels">
						  <tr>
						  	<td>
						  		<s:property value="fromAdress"/>
						  	</td>
						  	<td>
						  		<s:property value=" toAdress"/>
						  	</td>
						  	<td>
						  		<s:property value="date"/>
						  	</td>
						  	<td>
						  		<s:property value="returnTime"/>
						  	</td>
						  	<td>
						  		<s:property value=" seats"/>
						  	</td>
						  	<td>
						  		<s:property value="event.name"/>
						  	</td>
						  	<td>
						  		<i class="btn btn-danger fa fa-bullhorn"></i>
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