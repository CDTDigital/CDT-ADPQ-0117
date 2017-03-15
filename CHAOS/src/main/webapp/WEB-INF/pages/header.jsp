<%@page import="com.chaos.stanfield.model.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function() {
 
	// For the Second level Dropdown menu, highlight the parent	
	$( ".dropdown-menu" )
	.mouseenter(function() {
		$(this).parent('li').addClass('active');
	})
	.mouseleave(function() {
		$(this).parent('li').removeClass('active');
	});
 
});
 
</script>

<style>
.dropdown-submenu {
  position: relative;
}
.dropdown-submenu > .dropdown-menu {
  top: 0;
  left: 100%;
  margin-top: -6px;
  margin-left: -1px;
}
.dropdown-submenu:hover > .dropdown-menu {
  display: block;
}
.dropdown-submenu:hover > a:after {
  border-left-color: #fff;
}
.dropdown-submenu.pull-left {
  float: none;
}
.dropdown-submenu.pull-left > .dropdown-menu {
  left: -100%;
  margin-left: 10px;
}
 
</style>

<nav class="navbar navbar-inverse" style="border-radius:0px;">
  <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/home">CHAOS</a>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
      
       <c:if test="${sessionScope.userInfo.userRole.name eq 'admin'}">
      
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
<%--           <li><a href="${pageContext.request.contextPath}/categories">Category</a></li> --%>
<%--           <li><a href="${pageContext.request.contextPath}/products">Product</a></li> --%>
         
          <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Category<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/categories">List</a></li>			                  
			          <li><a href="${pageContext.request.contextPath}/create-category-form">Create</a></li>
			        </ul>
		  </li>
          
          <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Product<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/products">List</a></li>			                  
			          <li><a href="${pageContext.request.contextPath}/create-product-form">Create</a></li>
			        </ul>
		  </li>
    
          <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Status<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/statues">List</a></li>			                  
			          <li><a href="${pageContext.request.contextPath}/create-status-form">Create</a></li>
			        </ul>
		  </li>		
    
          
        </ul>
      </li>
      </c:if>
         <c:if test="${sessionScope.userInfo.userRole.name eq 'admin'}">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Order
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
           <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Customer Orders<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/customerOrders">List</a></li>			                  
			          <li><a href="#">Create</a></li>
			        </ul>
		  </li>		
    	  
     	  	  
       	  <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Order Products<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/orderProducts">List</a></li>			                  
			          <li><a href="#">Create</a></li>
			        </ul>
		  </li>		
    
       	  
          <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Status<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/statues">List</a></li>			                  
			          <li><a href="#">Create</a></li>
			        </ul>
		  </li>		
    
       	  
       	  
        </ul>
      </li>
      </c:if>
      
      
         <c:if test="${sessionScope.userInfo.userRole.name eq 'admin'}">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">User
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
               
<%--           <li><a href="${pageContext.request.contextPath}/userRoles">User Role</a></li> --%>
<!--           <li><a href="#">Users</a></li> -->
        
        <li class="dropdown-submenu">
			        <a tabindex="-1" href="#">User Role<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/userRoles">List</a></li>			                  
			          <li><a href="${pageContext.request.contextPath}/create-userRole-form">Create</a></li>
			        </ul>
		</li>		
    	
    	<li class="dropdown-submenu">
			        <a tabindex="-1" href="#">Users<i class="fa fa-chevron-right"></i></a>
			        <ul class="dropdown-menu">
			          <li><a tabindex="-1" href="${pageContext.request.contextPath}/userInfoes">List</a></li>			                  
			          <li><a href="${pageContext.request.contextPath}/create-userInfo-form">Create</a></li>
			        </ul>
		</li>		
    	
        
        
        </ul>
      </li>
      </c:if>
     
      
      <li><a href="${pageContext.request.contextPath}/placeOrder"><span class="glyphicon glyphicon-plus"></span> Order</a></li>
        <c:if test="${sessionScope.compareProduct != null}">
     		 <li><a href="${pageContext.request.contextPath}/showComparision" style="color: rgba(139, 195, 74, 0.81)"><b>Compare</b></a></li>
		</c:if>
		<c:if test="${sessionScope.compareProduct == null}">
     		 <li><a href="${pageContext.request.contextPath}/showComparision">Compare</a></li>
		</c:if>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
    	     <c:if test="${sessionScope.cartProduct != null}">
    	 			 <li><a href="${pageContext.request.contextPath}/showShoppingCart" style="color: rgba(255, 152, 0, 0.91)"><span  class="glyphicon glyphicon-shopping-cart"></span><b> Cart</b></a></li>
    	    </c:if>
    	    <c:if test="${sessionScope.cartProduct == null}">
    	 			 <li><a href="${pageContext.request.contextPath}/showShoppingCart"><span  class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    	    </c:if>
    	  <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
     </ul>
    </div>
  </div>
</nav>
