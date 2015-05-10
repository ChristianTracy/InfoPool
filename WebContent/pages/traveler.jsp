<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				información personal
			</div>
			<div class="col-md-9">
				<h1>Mis viajes</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Desde <i class="fa fa-sort"></i></th>
							<th>Hasta <i class="fa fa-sort"></i></th>
							<th>Salida <i class="fa fa-sort"></i></th>
							<th>Regreso <i class="fa fa-sort"></i></th>
							<th>Asientos  <i class="fa fa-sort"></i></th>		
						</tr>
					</thead>
					
					<tbody>
					<s:iterator value="mytravels">
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