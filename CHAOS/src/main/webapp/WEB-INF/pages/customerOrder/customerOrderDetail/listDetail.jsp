<!DOCTYPE html>
<%@page import="com.chaos.stanfield.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div class="col-sm-2" ></div>
            <div class="col-sm-8" >
			
			<div class="panel panel-default">
 			<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> Customer Order </div>
			<div class="panel-body">
			  <table class="table table-bordered">
			    <tbody>
			      <tr>
			        <td><b>User</b></td>
			        <td>${customerOrder.userInfo.displayName}</td>
			      </tr>
			       <tr>
			        <td><b>Status</b></td>
			        <td>${customerOrder.status.name} </td>
			      </tr>
			      <tr>
			        <td><b>Order Date</b></td>
			        <td><fmt:formatDate value="${customerOrder.orderDate.time}" type="date" dateStyle="long" />
			        </td>
			      </tr>
			      <tr>
			        <td><b>Total Price</b></td>
			        <td>${customerOrder.totalPrice}</td>
			      </tr>
			    </tbody>
			  </table>
		
			<center><h5><b>Order Details</b></h5></center>
			<hr>
			<table id="datatable1" class="table table-striped table-bordered"  cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Product</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Customer Order Id</th>
						<th>Options</th>
					</tr>
				</thead>
			
				<c:forEach var="items" items="${customerOrder.orderProducts}">
					<tr>
						<td>${items.product.name}</td>
						<td>${items.quantity}</td>
						<td>${items.price}</td>
						<td>${items.customerOrder.id}</td>
						<td>
							<div class="btn-group" role="group"	aria-label="Password operations">
												<a href="${pageContext.request.contextPath}/deleteCustomerOrder?id=${items.id}">
												  <span class="glyphicon glyphicon-trash"></span>
												</a> &nbsp;
												<a href="${pageContext.request.contextPath}/editCustomerOrder?id=${items.id}">
												  <span class="glyphicon glyphicon-pencil"></span>
												</a>
									</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			</div>
	</div>
	<div class="col-sm-2">
	
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
