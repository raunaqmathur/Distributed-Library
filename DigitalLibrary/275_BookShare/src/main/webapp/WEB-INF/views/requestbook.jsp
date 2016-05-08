<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<div class="container">
	<form class="form-horizontal col-md-offset-4 col-md-4" id="requestbook" action="requestbook" method="post" commandName="requestbookdetails">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Book Request</div>
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-4 control-label" for="textinput">Request</label>  
				<div class="col-md-7">
					<input id="message" name="message" type="text" placeholder="Request a book" class="form-control input-md">
	  				<font color="red"><form:errors path="message"></form:errors></font> 
				</div>
			</div>
	
			<div class="form-group">
			  <label class="col-md-4 control-label" for="singlebutton"></label>
			  <div class="col-md-4">
			    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
			  </div>
			</div>
	
			<div><font color="red"><form:errors /></font></div>
			<font color="red"><label>${msg}</label></font>
				
		</div>
	</form>
</div>
</body>
</html>