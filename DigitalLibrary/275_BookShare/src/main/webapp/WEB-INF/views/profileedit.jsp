<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />
<html>

<body>

<div class="container-fluid">

	<form class="form-horizontal col-md-offset-4 col-md-4" id="userhome" action="${path}" method="post" commandName="userdetails" > 
		<div class="panel panel-primary">
			<div class="panel-heading">Please edit your details</div>
			<input type="hidden" id="id" value="${userdetails.id}"></input>
			<input type="hidden" id="emailId" value="${userdetails.emailId}"></input>
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-4 control-label" for="textinput">Name</label> 
				<div class="col-md-7">
					<input id="name" name="name" type="text" placeholder="Enter your name" class="form-control input-md" value="${userdetails.name}">
					<font color="red"><form:errors path="name" required="true"></form:errors></font> 
					<font color="red"><form:errors path="name"></form:errors></font>
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Date Of Birth</label> 
				<div class="col-md-7">
					<input id="dob" name="dob" type="text" placeholder="Enter your Date of birth" class="form-control input-md" value="${userdetails.dob}"> 
					
					<font color="red"><form:errors path="dob" ></form:errors></font> 
				</div>
			</div>
		
			
		
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Phone</label> 
				<div class="col-md-7">
					<input id="phone" name="phone" type="number" placeholder="Enter your phone" class="form-control input-md" value="${userdetails.phone}">
					<font color="red"><form:errors path="phone" ></form:errors></font> 
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Category of Books You like</label> 
				<div class="col-md-7">
					<input id="category" name="category" type="text" placeholder="Enter your category" class="form-control input-md" value="${userdetails.category}">
					<font color="red"><form:errors path="category" ></form:errors></font> 
				</div>
			</div>
			
					
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Password</label> 
				<div class="col-md-7">
					<input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md" value="${userdetails.password}">
					<font color="red"><form:errors path="password" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Confirm password</label> 
				<div class="col-md-7">
					<input id="confirmpassword" name="confirmpassword" type="password" placeholder="Enter your password again" class="form-control input-md" value="${userdetails.password}">
					<font color="red"><form:errors path="confirmpassword" ></form:errors></font> 
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-7">
					<button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Update</button>
					<div><font color="red"><form:errors /></font></div>
				</div>
			</div>
			
		</div>
</form>
</div>
</body>
</html>
	