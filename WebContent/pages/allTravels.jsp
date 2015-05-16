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
	 	
	    sorterOptions = { 
	    	sortList: [[1,1]],
	        	widthFixed: true, 
	           	widgets: ['zebra']
		}
	    
	    pagerOptions = {
	    	container: $("#pager")
		}
	    
		$("#travels").tablesorter(sorterOptions).tablesorterPager(pagerOptions);  
    })();

});
</script>

<title>Listado de Recorridos</title>
</head>
<script type="text/javascript">
 function postRequest(idTravel){
 	var url = 'postRequest';
 	var data={
 			selectedTravelId:idTravel	
 	};
 	var success = function(response){
 		alert(response);
 	};
 	$.ajax({
 	type: "POST",
 	url: url,
 	data: data,
 	success: success
 	})
 }
  
</script>

<body>
	<%@include file="traveler/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Recorridos</h1>
				<table class="table table-striped" id="travels">
					
					<thead>
						<tr>
							<th>id <i class="fa fa-sort"></i></th>
							<th>Conductor <i class="fa fa-sort"></i></th>
							<th>Desde <i class="fa fa-sort"></i></th>
							<th>Hasta <i class="fa fa-sort"></i></th>
							<th>Salida <i class="fa fa-sort"></i></th>
							<th>Regreso <i class="fa fa-sort"></i></th>
							<th>Asientos  <i class="fa fa-sort"></i></th>		
						</tr>
					</thead>
					
					<tbody>
					<s:iterator value="travelCollection">
						  <tr>
						  	<td>
						  		<s:property value="id"/>
						  	</td>
						  	<td>
						  		<s:property value="driver.name"/>
						  	</td>
						  	<td>
						  		<s:property value="fromAdress"/>
						  	</td>
						  	<td>
						  		<s:property value=" toAdress"/>
						  	</td>
						  	<td>
						  		<s:property value="date"/>
						  	</td>
						  	<td>
						  		<s:property value="returnTime"/>
						  	</td>
						  	<td>
						  		<s:property value=" seats"/>
						  	</td>
						  	<td>
						  	
						  		<button class="btn btn-info" onClick="postRequest(<s:property value="id"/>)">Enviar Solicitud</button>
						  		
						  	</td>
						  </tr>
						</s:iterator>
					</tbody>
				</table>			
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div id="pager" class="custom-pager" >
					<form class="form-inline">
						<i class="btn btn-warning fa fa-angle-double-left first"></i>
						<i class="btn btn-primary fa fa-angle-left prev"></i>
						<input type="text" class="form-control pagedisplay custom-pagedisplay">
						<i class="btn btn-primary fa fa-angle-right next"></i>
						<i class="btn btn-warning fa fa-angle-double-right last"></i>
						<select class="pagesize form-control">
							<option selected="selected" value="10">10 resultados por página</option>
							<option value="20">20 resultados por página</option>
							<option value="50">50 resultados por página</option>
							<option value="100">100 resultados por página</option>
						</select>
					</form>
				</div>			
			</div>
		</div>
		
	</div>
	
<%@include file="footer.jsp" %>
	
</body>
</html>