<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 

<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="container-fluid">
		<form:form class="form-horizontal col-md-offset-4 col-md-4" id="advanceSearch" action="advanceSearch" method="post" commandName="advanceSearchDetails" modelAttribute="advanceSearchDetails">
			<div class="panel panel-primary">
				<div class="panel-heading">Advance Search</div>
				
				<div class="checkbox" style="margin-left:15px">
					<label><b><input type="checkbox" id="byAuthChkBox" name="byAuthChkBox" VALUE="BAuth"> By Author Name</b></label>
				</div>
				<div>
					<input id="byAuthTxt" name="byAuthTxt" type="text" placeholder="Enter author name" style="margin-left:35px">
				</div>
        		
        		<div class="checkbox" style="margin-left:15px">
					<label><b><input type="checkbox" id="byPubChkBox" name="byPubChkBox" VALUE="PAuth"> By Publisher Name</b></label>
				</div>
				<div>
					<input id="byPubTxt" name="byPubTxt" type="text" placeholder="Enter Publisher name" style="margin-left:35px">
				</div>
				<div class="checkbox" style="margin-left:15px">
					<label><b><input type="checkbox" id="byDescChkBox" name="byDescChkBox" VALUE="PAuth"> By Description</b></label>
				</div>
				<div>
					<input id="byDescTxt" name="byDescTxt" type="text" placeholder="Enter Description" style="margin-left:35px">
				</div>
				
        		

				
				<div class="checkbox" style="margin-left:15px" style="margin-top:15px">
					<label><b><input type="checkbox" id="byCategChkBoxP" name="byCategChkBoxP" VALUE="BCateg"> By Categories</b></label>
				</div>
				
<%-- 				<c:forEach items="${advanceSearchDetails.getCatie()}" var="result" varStatus="status"> --%>
<%-- 					<form:checkbox style="margin-left:35px" path="catie" value="result.getSelected()}" name="result[${status.index}].getCat().getName()" id="result[${status.index}].getCat().getName()" ></form:checkbox> --%>
<%-- 					<label> ${result.getCat().getName()}</label> --%>
<%-- 				</c:forEach> --%>
				<form:checkboxes items="${advanceSearchDetails.getCatName()}"
 						path="catName" /> 
				<br>

				<label style="margin-left:15px" style="margin-top:35px">Make sure to check the filter you want</label>
				
				<div>
					<button style="margin-left:150px" id="submit" name="submit" class="btn btn-primary" type="submit" value="Submit" onclick="submitForm();">Submit</button>
					<div><font color="red"><form:errors /></font></div>
				</div>
				
				<label></label>
				
			</div>
		</form:form>
	</div>
</body>
</html>