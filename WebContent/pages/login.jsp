<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="estilo.css" rel="StyleSheet" type="text/css" id="css" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<title>LOGIN</title>
</head>
<body>
	<% String user = (String) session.getAttribute("user");
if (user == null){ %>
	<s:form action="loginProcess" cssClass="form-login">
	<s:textfield name="user" label="Usuario" cssClass="form-control"/>
		
		<s:password name="password" label="Contraseņa"/>
		<s:submit value="Ingresar"  class="btn btn-lg btn-info btn-block"/>
	</s:form>
	<%} %>
	
	

	
	
</body>
</html>