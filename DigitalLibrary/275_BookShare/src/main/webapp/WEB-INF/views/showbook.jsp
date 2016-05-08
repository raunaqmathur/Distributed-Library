<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.MongoBook" %>
<jsp:include page="header.jsp" />
<html>
<head>
	<!-- <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script> -->
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
  
	<style type="text/css">
	div#map_container{
		width:550px;
		height:350px;
	}
	</style> 

</head>

<body>
<% MongoBook Book = (MongoBook)request.getAttribute("bookdetails"); 
%>
	<div class="container-fluid">
		<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Book Details</div>
				<table class="table">					
					<tr class="active">
					    <td colspan="3">
					  		<img src="${bookdetails.getImage()}" height="100" width="100">
					    </td>
					</tr>
					
					<tr class="info">
					    <td><label>Title</label></td>
					    <td><label>${bookdetails.title}</label>
						<input type="hidden" id="bookId" value="${bookdetails.bookId}"></input>
						<input type="hidden" id="redirectTo" value="${redirectTo}"></input>
						<input type="hidden" id="redirectToBuy" value="${redirectToBuy}"></input>
						<input type="hidden" id="owner" value="${owner}"></input></td>
					    <td></td>
					</tr>
					
					<tr class="info">
					    <td><label>Author</label></td>
					    <td>
					    <ul>
					    	<c:forEach var="authorValue" items="${bookdetails.getAuthors()}">
							<li>${authorValue}</li>
							</c:forEach>
						</ul>
						</td>
					    <td></td>
					</tr>
					
					
					
					<tr class="info">
					    <td><label>Description</label></td>
					    <td>${bookdetails.description}</td>
					    <td></td>
					</tr>
					 
					
					
					<tr class="info">
					    <td><label>Rating</label></td>
					    <td>${bookdetails.rating}</td>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Language</label></td>
					    <td>${bookdetails.language}></td>
					    <td></td>
					    
					</tr>
					
					
					<tr class="info">
					    <td><label>Publisher</label></td>
					    <td>${bookdetails.publisher}</td>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Page Count</label></td>
					    <% if(0 != Book.getPageCount()){ %>
					    	<td>${bookdetails.pageCount}</td>
					    <% } else {%>
							<td>No Info available</td>
						<% } %>
					    <td></td>
					    
					</tr>
					
					
					<tr class="info">
					    <td><label>ISBN#</label></td>
					    <% if(!Book.getIsbn().equals("")){ %>
					    	<td>${bookdetails.isbn}</td>
					    <% } else {%>
							<td>No Info available</td>
						<% } %>
					    <td></td>
					    
					</tr>
					
					<tr class="info">
					    <td><label>Categories</label></td>
					    <td>
					    <ul>
					    	<c:forEach var="catValue" items="${bookdetails.getCategories()}">
							<li>${catValue}</li>
							</c:forEach>
						</ul>
						</td>
					    <td></td>
					</tr>
					
					
					
					<tr class="info">
					    
					    <% if(null != session.getAttribute("USERNAME")) {%> 
					    	<td colspan="2" align="right"><a class="btn btn-primary" href="${pageContext.request.contextPath}/requestbook/${bookdetails.bookId}" role="button">Make a request</a>
					    <% } %>
							
					   
					    
					</tr>
					
					
					
					
					
					<tr>
					    <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
					</tr>
				</table>
			</div>
		</div>
	    	
		
	</div>		
</body>
</html>