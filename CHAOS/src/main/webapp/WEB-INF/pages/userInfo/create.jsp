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

	
	<div class="container-fluid content">
		
		
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
			   <div class="panel panel-default">
 				<div class="panel-heading"> <span class="glyphicon glyphicon-plus"></span> Add User Info </div>
				
				 <div class="panel-body">
				<form role="form" class="form-horizontal" action="createUserInfo"  method="POST">
					<div class="form-group">
						<label class="control-label col-sm-2">Display Name</label>
						<div class="col-sm-10"> 
							<input	type="text" class="form-control" id="displayName" name="displayName" placeholder="Display Name"> 
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2">User Name</label>
						<div class="col-sm-10"> 
							<input	type="text" class="form-control" id="username" name="username" placeholder="User Name"> 
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2">User Role</label>
						<div class="col-sm-10">
						<select class="form-control" name="userRole" id="userRole">
						    <c:forEach items="${userRoles}" var="userRole">
						            <option value="${userRole.id}">${userRole.name}</option>
						    </c:forEach>
						</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2">Password</label>
						<div class="col-sm-10"> 
							<input	type="password" class="form-control" id="password" name="password" placeholder="Password"> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2">Confirm Password</label>
						<div class="col-sm-10"> 
							<input	type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password"> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2">Email</label>
						<div class="col-sm-10"> 
							<input	type="text" class="form-control" id="email" name="email" placeholder="Email Address"> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2">Address</label>
						<div class="col-sm-10"> 
							<input	type="text" class="form-control" id="address" name="address" placeholder="Mailing Address"> 
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2">Phone</label>
						<div class="col-sm-10"> 
							<input	type="text"  class="form-control input-medium bfh-phone" data-country="US" id="phone" name="phone" placeholder="Phone Number"> 
							
						</div>
					</div>
					
				
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" style="background-color: #1abc9c" name="submit" id="submit" class="btn btn-success" >Save</button>
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
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#categoryDatatable').DataTable();
		} );
	</script>

</body>
</html>
