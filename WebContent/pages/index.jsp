<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ar.edu.unlp.info.infopool.model.User"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>InfoPool</title>
</head>
<body class="index">
<% User user = (User) session.getAttribute("user"); %>

	<div class="container main-container">
	<% if (user != null){ %>
	<div class="row">
		<%if ( user.isAdmin() ){ %>
			<a href="panelAdmin" class="btn btn-success">Mi Inicio</a>
		<% }
		else{%>
			<a href="panelTraveler" class="btn btn-success">Mi Inicio</a>
		<%} %>
		
		<a href="logOut" class="btn btn-info">Cerrar sessión</a>
		
	</div>		
		
	<% } %>

	      <div class="jumbotron text-center">       
	        <h1> Bienvenido a InfoPool</h1>
	         <h1><i class="fa fa-car"></i></h1>
	        <p class="lead">Sistema de carpooling creado para alumnos y profesores de la facultad de informática de la Universidad Nacional de La Plata </p>
		        
		       <% if (user == null){ %>
			        <p><a class="btn btn-lg btn-success" href="register" role="button">Registrarme</a></p>
			        <a href="#" data-toggle="modal" data-target="#myModal">¿Ya estás registrado?</a> 		        
		        <%} %>
   
	      </div>

	</div> 
	<%@include file="footer.jsp" %>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <div class="modal-body">
		<div class="container-fluid">
			<div class="form-signin">
				<form action="loginProcess" method="post">
					<div class="form-group">
						<input type="text" name="user" class="form-control" placeholder="Nombre de usuario">	
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder ="Contraseña" class="form-control">			
					</div>
					<button type="submit" class="btn btn-lg btn-default btn-block">Ingresar</button>
				</form>			
			</div>
		</div>
      </div>
    </div>
  </div>
</div>


</body>
</html>