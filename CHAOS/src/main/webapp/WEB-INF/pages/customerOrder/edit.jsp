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
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Data Tables JS -->
<link
	href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>


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
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
			    <div class="panel panel-default">
	 			<div class="panel-heading"> <span class="	glyphicon glyphicon-edit"></span> Edit Customer Order </div>
				<div class="panel-body">
					<form role="form" class="form-horizontal" action="updateCustomerOrder"  method="POST">
						
						<input type="text" id="id" name="id" value="${customerOrder.id}" hidden="true">
						
						<div class="form-group">
								<label class="control-label col-sm-2">User</label>
								<div class="col-sm-10">
								<select class="form-control" name="userInfo" id="userInfo">
								    <c:forEach items="${userInfoes}" var="userInfo">
								    		<c:choose>
								    			<c:when test="${userInfo.id eq customerOrder.userInfo.id}">
								   					            <option value="${userInfo.id}" selected="selected">${userInfo.displayName}</option>
								    			</c:when>
												<c:otherwise>
												 <option value="${userInfo.id}">${userInfo.displayName}</option>
												 </c:otherwise>
								    		</c:choose>
								    </c:forEach>
								</select>
								</div>
						</div>
						
							<div class="form-group">
								<label class="control-label col-sm-2">Status</label>
								<div class="col-sm-10">
								<select class="form-control" name="status" id="status">
								    <c:forEach items="${statuses}" var="status">
								    		<c:choose>
								    			<c:when test="${status.id eq customerOrder.status.id}">
								   					            <option value="${status.id}" selected="selected">${status.name}</option>
								    			</c:when>
												<c:otherwise>
												 <option value="${status.id}">${status.name}</option>
												 </c:otherwise>
								    		</c:choose>
								    </c:forEach>
								</select>
								</div>
							</div>
						
						<div class="form-group">
							<label class="control-label col-sm-2">Order Date</label>
							<div class="col-sm-10"> 
								<input	type="date"  class="form-control" id="orderDate" name="orderDate" value="${customerOrder.orderDate.time}"> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Total Price</label>
							<div class="col-sm-10"> 
								<input	type="text" class="form-control" id="totalPrice" name="totalPrice" value="${customerOrder.totalPrice}"> 
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
									 <button type="submit" style="background-color: #1abc9c" name="submit" id="submit" class="btn btn-success" >Update</button>
									  <button type="button"  name="cancel" id="cancel" class="btn btn-primary" >Cancel</button>
	        				</div>
						</div>
			      </form>
			   </div>
			   </div>   
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
	<div id="footer"></div>
	

</body>
</html>
