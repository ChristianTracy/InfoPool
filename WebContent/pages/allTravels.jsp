<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="head.jsp" %>
<script type="text/javascript">
$(document).ready(function(){ 
           jQuery.browser = {};
           (function () {
               jQuery.browser.msie = false;
               jQuery.browser.version = 0;
               if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
                   jQuery.browser.msie = true;
                   jQuery.browser.version = RegExp.$1;
               }
           })();
           $("#travels").tablesorter({widgets: ['zebra']});
           });
</script>

<title>Listado de Recorridos</title>
</head>
<body>
<%@include file="admin/navbar.jsp" %>
<h1>Recorridos</h1>
<table class="table table-striped" id="travels">
	<thead>
		<th>id</th>
		<th>date</th>
		<th>desde</th>
		<th>hora de regreso</th>
		<th>asientos</th>
		<th>hasta</th>
		<th>conductor id</th>
	</thead>
	<tbody>
	<s:iterator value="travelCollection">
		  <tr>
		  	<td>
		  		<s:property value="id"/>
		  	</td>
		  	<td>
		  		<s:property value="date"/>
		  	</td>
		  	<td>
		  		<s:property value="fromAdress"/>
		  	</td>
		  	<td>
		  		<s:property value="returnTime"/>
		  	</td>
		  	<td>
		  		<s:property value="seats"/>
		  	</td>
		  	<td>
		  		<s:property value="toAdress"/>
		  	</td>
		  	<td>
		  		<s:property value="driver.name"/>
		  	</td>
		  </tr>
		</s:iterator>
	</tbody>
</table>
</body>
</html>