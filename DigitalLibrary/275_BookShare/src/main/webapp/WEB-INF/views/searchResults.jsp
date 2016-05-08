<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<div class="container-fluid" style="margin-top:40px">  
		<div class="row-fluid">
			<div class="container-fluid">
				<c:forEach items="${pagedetails}" var="result"> 
          			<div class="col-md-2">
          				<a href="${pageContext.request.contextPath}/showbook/${result.getBookId()}">
							<img class="img-thumbnail" src="${result.getImage()}" width="300" height="200">
						</a>
						<h4><a href="#">${result.title}</a></h4>
						<p>Price: $${result.getPrice()}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>