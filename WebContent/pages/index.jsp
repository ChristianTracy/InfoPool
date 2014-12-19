<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InfoPool</title>
<!-- StyleSheets -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/customTemplate.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
<!-- End StyleSheets -->
</head>
<body>
<div class="container">
      <div class="masthead">
        <div role="navigation">
          <ul class="nav nav-justified">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="login">Login</a></li>
          </ul>
        </div>
      </div>
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Bienvenido a InfoPool</h1>
        <p class="lead">Sistema de carpooling creado para alumnos y profesores de la facultad de informática de la Universidad Nacional de La Plata</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">Registrarme</a></p>
      </div>
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-12">
          <h2>Más info...</h2>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sed pellentesque est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque eget nisi quis dolor vestibulum suscipit ac vehicula eros. </p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; Taller de Java -  2014 - Christian Tracy y Mariel Cordal</p>
      </footer>

    </div> <!-- /container -->
</div>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>