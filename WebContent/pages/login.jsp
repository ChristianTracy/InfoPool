<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="ar.edu.unlp.info.infopool.model.User"%>
<title>LOGIN</title>
</head>
	<body>
		<% User user = (User) session.getAttribute("user");
	if (user == null){ %>
		<div class="container">
			<div class="form-signin">
				<form action="loginProcess" method="post">
				<center><i class="usericon fa fa-user"></i></center>
					<div class="form-group">
						<input type="text" name="user" class="form-control" placeholder="Nombre de usuario">	
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder ="Contraseña" class="form-control">			
					</div>
					<button type="submit" class="btn btn-lg btn-info btn-block">Ingresar</button>
				</form>			
			</div>
		</div>
		<%} %>
	<%@include file="footer.jsp" %>
	</body>
</html>