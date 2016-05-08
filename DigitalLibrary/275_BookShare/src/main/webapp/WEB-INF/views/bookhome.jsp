<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script>
	function checkCat()
	{
		if(document.getElementById("categoryX").value == '')
			document.getElementById("errorCat").value = "Category can't be left blank";
	}
	</script>
</head>

<body>	
	<div class="container-fluid">
	<form class="form-horizontal col-md-offset-4 col-md-4" id="bookhome" action="${path}" method="post" commandName="bookdetails">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Book Details</div>
        
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-4 control-label" for="textinput">Title</label>  
				<div class="col-md-7">
					<input id="title" name="title" type="text" placeholder="" value="${bookdetails.title}" class="form-control input-md">
					<input id="bookId" name="bookId" type="hidden" value="${bookdetails.bookId}">
					<input id="status" name="status" type="hidden" value="${bookdetails.status}">
					<font color="red"><form:errors path="title"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Author</label>
				<div class="col-md-7">
					<input id="author" name="author" type="text" placeholder=""
						value="${bookdetails.author}" class="form-control input-md">
					<font color="red"><form:errors path="author"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">ISBN</label>
				<div class="col-md-7">
					<input id="isbn" name="isbn" type="text" placeholder=""
						value="${bookdetails.isbn}" class="form-control input-md">
					<font color="red"><form:errors path="isbn"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Description</label>
				<div class="col-md-7">
					<input id="description" name="description" type="text"
						placeholder="" value="${bookdetails.description}"
						class="form-control input-md"> <font color="red"><form:errors
							path="description"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Picture</label>
				<div class="col-md-7">
					<input id="pictureId" name="pictureId" type="text" placeholder=""
						value="${bookdetails.pictureId}" class="form-control input-md">
					<font color="red"><form:errors path="pictureId"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Price</label>
				<div class="col-md-7">
					<input id="price" name="price" type="text" placeholder=""
						value="${bookdetails.price}" class="form-control input-md">
					<font color="red"><form:errors path="price"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Condition</label>
				<div class="col-md-7">
					<input id="condition" name="condition" type="text" placeholder=""
						value="${bookdetails.condition}" class="form-control input-md">
					<font color="red"><form:errors path="condition"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Keywords</label>
				<div class="col-md-7">
					<input id="keywords" name="keywords" type="text" placeholder=""
						value="${bookdetails.keywords}" class="form-control input-md">
					<font color="red"><form:errors path="keywords"></form:errors></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Category</label>
				<div class="col-md-7">
					<input id="categoryX" name="categoryX" type="text" placeholder=""
						value="${categ}" class="form-control input-md"> <font
						color="red"><label id="errorCat"></label></font>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Pickup
					Address</label>
				<div class="col-md-7">
					<input id="pickupAddress" name="pickupAddress" type="text"
						placeholder="" value="${bookdetails.pickupAddress}"
						class="form-control input-md"> <font color="red"><form:errors
							path="pickupAddress"></form:errors></font>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-7">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary" type="submit" value="${buttonX} onClick="
						javascript:checkCat();">Submit</button>
				</div>
			</div>

			<div><font color="red"><form:errors /></font></div>
		</div>
	</form>
</div>
</body>
</html>