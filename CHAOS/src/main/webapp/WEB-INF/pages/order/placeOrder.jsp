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
<!-- <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css"> -->
<!-- <link href="http://fonts.googleapis.com/css?family=Montserrat" 	rel="stylesheet" type="text/css"> -->


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
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-th-list"></span> Place Order
					</div>
					<div class="panel-body">
					<div>
					<form role="form" class="form-inline" action="getProducts" " method="POST">
							<div class="form-group">
								<label>Category</label>
								<select class="form-control" name="category" id="category" style=" width: initial;">
								    <c:forEach items="${categories}" var="category">
								             <c:choose>
								    			<c:when test="${category.id eq selectedCategory.id}">
								   					            <option value="${category.id}" selected="selected">${category.name}</option>
								    			</c:when>
												<c:otherwise>
												 <option value="${category.id}">${category.name}</option>
												 </c:otherwise>
											   </c:choose>
								    </c:forEach>
								</select>
							</div>
								 <button type="submit" name="submit" id="submit" class="btn btn-default" ><span class="glyphicon glyphicon-search"></span></button>
					</form>
						
						<hr>
									
				<c:if test="${filtered==1}">
							<table id="productDatatable" class="table table-striped table-bordered"  width="100%">
								<thead>
									<tr>
										<th>View</th>
										<th>Name</th>
										<th>Description</th>
										<th>Price</th>
										<th>OEM_NAME</th>
										
									</tr>
								</thead>
								<c:forEach var="items" items="${listProducts}">
								<tr>
										<td style="text-align: center;">
											<a href="${pageContext.request.contextPath}/showProductDescription?id=${items.id}">
												 <span class="glyphicon glyphicon-eye-open"></span>
											</a>
										</td>
										<td>${items.name}</td>
										<td>${items.description}</td>
										<td>${items.price}</td>
										<td>${items.OEM_NAME}</td>
										
									</tr>
								</c:forEach>
								</tbody>
							</table>
					</c:if>	
				
					
		  
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#productDatatable').DataTable();
		} );
	</script>

</body>


</html>
