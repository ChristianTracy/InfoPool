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
	<s:form action="loginAction">
		<s:textfield name="usuario" label="Usuario" maxlength="20" />
		<s:password name="pass" label="Contraseña" maxlength="20" />
		<s:submit value="Ingresar" />
	</s:form>
	<%} %>
</body>
</html>