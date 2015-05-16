<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>PANEL admin</title>
</head>
<body>
<h1>PERFIL ADMIN</h1>
<%@include file="admin/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Denuncias</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Usuario denunciado</th>
							<th>Comentario</th>
							<th>Denunciante</th>
							<th>Estado</th>						
						</tr>
					</thead>
					<tbody>
						<s:iterator value="allComplaints">
						<tr>
							<td>
								Alguien
							</td>
							<td>
								<s:property value="comment"/>
							</td>
							<td>
								<s:property value="owner.name"/>
							</td>
							<td>
								<s:property value="state"/>
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