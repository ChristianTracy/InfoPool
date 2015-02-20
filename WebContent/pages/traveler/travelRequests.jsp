<!DOCTYPE html>
<html>
<head>
<%@include file="../head.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Nuevo Recorrido</title>
</head>
<body>
	<%@include file="../footer.jsp" %>
</body>
	<table class="table table-striped">
		<thead>
			<th>Nombre</th>
			<th>Locación</th>
			<th>Fecha</th>
			<th>Descripción</th>
		</thead>
		<tbody>
			<s:iterator value="travelRequests">
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
</html>