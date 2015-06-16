<!DOCTYPE html>
<html>
<head>
<%@include file="../head.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-datetimepicker.css"/>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>Aceptar o denegar participacion</title>
</head>
<body>
	<%@include file="../footer.jsp" %>
</body>
		
	<div class="container">
		<div class="row">
			<div class="col-md-12">
					<h1>Recorridos</h1>
				<table class="table table-striped" id="requests">
			
					<thead>
						<th>Quien quiere unirse</th>
						<th>Estado</th>
						<th>Recorrido</th>
					</thead>
					<tbody>
						<s:iterator value="travelRequests">
						  <tr>
						  	<td>
						  		<s:property value="owner.name"/>
						  	</td>
						  	<td>
						  		<s:property value="state"/>
						  	</td>
						  	<td>

						  	</td>
						  </tr>
						</s:iterator>	
					</tbody>
				</table>
			</div>
		</div>
	</div>
</html>