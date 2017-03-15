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
 			<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> Shopping Cart  </div>
			<div class="panel-body">
		<h3>Shopping Cart </h3>	
		<hr>
		<table id="" class="table table-striped table-bordered"  width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Discount</th>
					<th>Total Price</th>
					<th>Update</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tfoot><tr>
					<th colspan="4" style="text-align: right;">Total Price</th>
					<th>${totalPrice}</th>
				<tr>
			</tfoot>
			<c:forEach var="items" items="${listProducts}">
			<tr>
					<td>${items.name}</td>
					<td>${items.quantity}</td>
					<td>${items.price}</td>
					<td>${items.discount}</td>
					<td>${items.price * items.quantity}</td>
					<td>
							<div class="btn-group" role="group"	aria-label="Password operations">
																
																<form action="updateShoppingCartQuantity" class="form-inline" method="Post">
																	<input type="text" id="productId" name="productId"  hidden="true" value="${items.id}">
							                          		 		 Quantity: <input id="quantity" name="quantity" class="form-control" type="number" step="1" min="1" value="${items.quantity}" style="width:80px;"> &nbsp;
							                          		 		<button id="submit" class="btn btn-default" >Update </button> 
							                          		 	</form>
													</div>
					</td>
					<td>
																<form action="removeProductShoppingCart" class="form-inline" method="Post">
																	<input type="text" id="productId" name="productId"  hidden="true" value="${items.id}">
							                          		 		<button id="submit" class="btn btn-default" >Remove</button> 
							                          		 	</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<form action="proceedOrder" method="Post" >
		              	<button id="submit" class="btn btn-success" >Proceed Order </button> 
		</form>
		
		</div>
		</div>
		
	</div>

	</div>
	</div>
	<div id="footer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#datatable1').DataTable();
		} );
	</script>

</body>


</html>
