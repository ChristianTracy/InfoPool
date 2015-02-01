<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="ar.edu.unlp.info.infopool.model.User"%>
<title>Registrarse</title>
</head>
	<body>
		<% User user = (User) session.getAttribute("user");
	if (user == null){ %>
		<div class="container">
			<div class="form-register">
				<form action="registerSubmit" method="post">
				<center><i class="registericon fa fa-user-plus"></i></center>
					<div class="form-group">
					 	<label for="name">Nombre</label>
						<input type="text" name="name" class="form-control" id="name">	
					</div>
					<div class="form-group">
						<label for="surname">Apellido</label>
						<input type="text" name="surname" class="form-control" id="surname">
					</div>
					<div class="form-group">
						<label for="username">Nombre de usuario</label>
						<input type="text" name="username" class="form-control" id="username">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" name="password" class="form-control" id="password">
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="text" name="email" class="form-control" id="email">	
					</div>
					<div class="form-group">
						<label for="telephone">Teléfono</label>
						<input type="text" name="telephone" class="form-control" id="telephone">
					</div>					
					<button type="submit" class="btn btn-lg btn-success btn-block">Registrarme</button>
				</form>	
			</div>
		</div>
		<%} %>
	</body>
</html>

