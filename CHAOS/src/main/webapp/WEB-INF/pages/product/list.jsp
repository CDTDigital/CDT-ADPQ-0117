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
 			<div class="panel-heading"> <span class="glyphicon glyphicon-th-list"></span> Products </div>
			<div class="panel-body">
	
	
		<table id="categoryDatatable" class="table table-striped table-bordered"  width="100%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Category</th>
					<th>Quantity</th>
					<th>MSRP</th>
					<th>Price</th>
					<th>Discount</th>
					<th>CLIN</th>
					<th>OEM</th>
					<th>OEM_NAME</th>
					<th>SKU</th>
					<th>Measure</th>
					<th>UNSPSC</th>
					<th>Options</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Category</th>
					<th>Quantity</th>
					<th>MSRP</th>
					<th>Price</th>
					<th>Discount</th>
					<th>CLIN</th>
					<th>OEM</th>
					<th>OEM_NAME</th>
					<th>SKU</th>
					<th>Measure</th>
					<th>UNSPSC</th>
					<th>Options</th>
				</tr>
			</tfoot>
			<c:forEach var="items" items="${listProduct}">
			<tr>
					<td>${items.name}</td>
					<td>${items.description}</td>
					<td>${items.category.name}</td>
					<td>${items.quantity}</td>
					<td>${items.MSRP}</td>
					<td>${items.price}</td>
					<td>${items.discount}</td>
					<td>${items.CLIN}</td>
					<td>${items.OEM}</td>
					<td>${items.OEM_NAME}</td>
					<td>${items.SKU}</td>
					<td>${items.unitMeasure}</td>
					<td>${items.UNSPSC}</td>
					<td>
						<div class="btn-group" role="group"	aria-label="Password operations">
											<a href="${pageContext.request.contextPath}/deleteProduct?id=${items.id}">
											  <span class="glyphicon glyphicon-trash"></span>
											</a> &nbsp;
											<a href="${pageContext.request.contextPath}/editProduct?id=${items.id}">
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

	</div>
	</div>
	<div id="footer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#categoryDatatable').DataTable();
		} );
	</script>

</body>


</html>
