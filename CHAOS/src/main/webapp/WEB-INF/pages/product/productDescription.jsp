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
 			<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> Product Description </div>
			<div class="panel-body">
				<div class="row">
    	        <div class="col-lg-9" >
	
									<table  class="table table-bordered table-hover table-striped"  width="100%">
												<tr><td><b>Name:</b></td><td>${product.name}</td></tr>
												<tr><td><b>Description:</b></td><td>${product.description}</td></tr>
												<tr><td><b>Category:</b></td><td>${product.category.name}</td></tr>
												<tr><td><b>Price:</b></td><td>${product.price}</td></tr>
												<tr><td><b>Discount:</b></td><td>${product.discount}</td></tr>
												<tr><td><b>CLIN:</b></td><td>${product.CLIN}</td></tr>
												<tr><td><b>OEM:</b></td><td>${product.OEM}</td></tr>
												<tr><td><b>OEM_NAME:</b></td><td>${product.OEM_NAME}</td></tr>
												<tr><td><b>SKU:</b></td><td>${product.SKU}</td></tr>
												<tr><td><b>UNSPSC:</b></td><td>${product.UNSPSC}</td></tr>
											</tbody>
									</table>
				</div>
				<div class="col-lg-3">
							<div class="panel panel-info">
				 			<div class="panel-heading"> <span class="glyphicon glyphicon-shopping-cart"></span>  Add to Cart </div>
							<div class="panel-body">
										<form action="addToCart" method="Post">
																	<input type="text" id="id" name="id" value="${product.id }" hidden="true">
																	<div class="form-group">
																	    <label for="email"> Quantity: </label>
																	    <input id="quantity" class="form-control" name="quantity" type="number" step="1" min="1" value="1" style="width:100px;">
																	 </div>
																	 <button id="submit" class="btn btn-info" ><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart </button> 
							             </form>				
							</div>
							</div>
							
							<div class="panel panel-success">
				 			<div class="panel-heading"> <span class="glyphicon glyphicon-shopping-cart"></span>  Compare </div>
							<div class="panel-body">
										<form action="addToCompare" method="Post">
																	<input type="text" id="id" name="id" value="${product.id }" hidden="true">
																	<button id="submit" class="btn" style="background-color: #d6e9c6;color: #3c763d"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Compare</button> 
							             </form>				
							</div>
							</div>
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
