<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="imports.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Digital Library</title>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
	      		<a class="navbar-brand" href="${pageContext.request.contextPath}">
	        		<img style="max-width:50px; margin-top: -15px;" alt="Brand" src="http://blindlibrary.utah.gov/images/logoBook.gif">
	      		</a>
	    	</div>
	    
	    	<!-- Brand and toggle get grouped for better mobile display -->
	    	<div class="navbar-header">
	      		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
	      		</button>
	      
	      		<a class="navbar-brand" href="${pageContext.request.contextPath}">Distributed Library</a>
	    	</div>
	    
	    	<!-- Collect the nav links, forms, and other content for toggling -->
	    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">	      
	      		<form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/search" method="get">
	        		<div class="form-group">
	          			<input type="text" class="form-control" placeholder="Search" name="searchbox">
	        		</div>
	        		<button type="submit" class="btn btn-default">Submit</button>
	      		</form>

	      		<ul class="nav navbar-nav navbar-right">
<%-- 			      	<li><a href="${pageContext.request.contextPath}/advanceSearch">Advance Search</a></li> --%>
<%-- 			      	<li><a href="${pageContext.request.contextPath}/bookhome">Sell</a></li> --%>
				  	<% if(null == session.getAttribute("USERID")){ %>
	              		<li><a href="${pageContext.request.contextPath}/login">Login/Register</a></li>
	              	<% } else { %>
	              		<li class="dropdown">
				          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Hi ${sessionScope.USERNAME} <span class="caret"></span></a>
				          	<ul class="dropdown-menu" role="menu">
					            <li><a href="${pageContext.request.contextPath}/showuser/${sessionScope.USERID}">Profile</a></li>
<%-- 							    <li><a href="${pageContext.request.contextPath}/transactions">View Transactions</a></li> --%>
<%-- 							    <li><a href="${pageContext.request.contextPath}/requestbook">Make a request</a></li> --%>
							    <li><a href="${pageContext.request.contextPath}/logout">Signout</a></li>
				          	</ul>
			       		</li>
			       	<% } %>
				</ul>
			</div>  
		</div>
	</nav>
	<div class="container-fluid" style="margin-top:60px"></div>
</body>
</html>