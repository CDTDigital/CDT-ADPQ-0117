<!DOCTYPE html>
<%@page import="com.chaos.stanfield.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>Chaos App</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat" 	rel="stylesheet" type="text/css">


<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Data Tables JS -->
<link href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>


 <script src="dist/js/bootstrap-submenu.min.js" defer></script>




<script type="text/javascript">
$(document).ready(function() {
	  $("#header").load("header");
	  $("#footer").load("footer");
});
</script>

<body>

<div id="header"></div>


      <div class="container-fluid">
            <div class="row">
       
            <div class="col-lg-12" >
	
	   	<div class="panel panel-default">
 			<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> Compare</div>
			<div class="panel-body">
			
				<div class="row">
    	        <div class="col-lg-12" >
    	        
    	        <h3>Compare Products </h3>	
				<hr>
									<table  class="table table-bordered table-hover table-striped"  width="100%">
									<thead>
									
									<tr>
											<th></th>
											<th>
											<div style="text-align: center;">
													<a href="${pageContext.request.contextPath}/removeProductFromCompare?id=${product1.id}">
													 <span class="glyphicon glyphicon-remove"></span>
											    	</a>
												</div>
											
											</th>
											<th>
											<div style="text-align: center;">
													<a href="${pageContext.request.contextPath}/removeProductFromCompare?id=${product2.id}">
													 <span class="glyphicon glyphicon-remove"></span>
											    	</a>
												</div>
											</th>
											<th>
											<div style="text-align: center;">
													<a href="${pageContext.request.contextPath}/removeProductFromCompare?id=${product3.id}">
													 <span class="glyphicon glyphicon-remove"></span>
											    	</a>
												</div>
											</th>
										</tr>	
									
									<tr>
											<th>Items</th>
											<th style="background-color: rgba(139, 195, 74, 0.38)" >${product1.name}  
											</th>
											<th style="background-color: rgba(244, 67, 54, 0.33)">${product2.name}</th>
											<th style="background-color:rgba(255, 152, 0, 0.53);">${product3.name}</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td><b>Name:</b></td>
										<td>${product1.name}</td>
										<td>${product2.name}</td>
										<td>${product3.name}</td>
									</tr>
									<tr>
										<td><b>Description:</b></td>
										<td>${product1.description}</td>
										<td>${product2.description}</td>
										<td>${product3.description}</td>
									</tr>
									<tr>
										<td><b>Category:</b></td>
										<td>${product1.category.name}</td>
										<td>${product2.category.name}</td>
										<td>${product3.category.name}</td>
									</tr>
									<tr>
										<td><b>Price:</b></td>
										<td>${product1.price}</td>
										<td>${product2.price}</td>
										<td>${product3.price}</td>
									</tr>
									<tr>
										<td><b>Discount:</b></td>
										<td>${product1.discount}</td>
										<td>${product2.discount}</td>
										<td>${product3.discount}</td>
									</tr>
									<tr>
										<td><b>CLIN:</b></td>
										<td>${product1.CLIN}</td>
										<td>${product2.CLIN}</td>
										<td>${product3.CLIN}</td>
									</tr>
									<tr>
										<td><b>OEM:</b></td>
										<td>${product1.OEM}</td>
										<td>${product2.OEM}</td>
										<td>${product3.OEM}</td>
									</tr>
									<tr>
										<td><b>OEM_NAME:</b></td>
										<td>${product1.OEM_NAME}</td>
										<td>${product2.OEM_NAME}</td>
										<td>${product3.OEM_NAME}</td>
									</tr>
									<tr>
										<td><b>SKU:</b></td>
										<td>${product1.SKU}</td>
										<td>${product2.SKU}</td>
										<td>${product3.SKU}</td>
									</tr>
									<tr>
										<td><b>UNSPSC:</b></td>
										<td>${product1.UNSPSC}</td>
										<td>${product2.UNSPSC}</td>
										<td>${product3.UNSPSC}</td>
									</tr>
									</tbody>
									</tbody>
									</table>
				</div>
				</div>					
		</div>
		</div>
		
	</div>

	</div>
	</div>
	<div id="footer"></div>
	

</body>


</html>
