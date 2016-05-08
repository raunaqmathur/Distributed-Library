<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />
<html>

<body>

<div class="container-fluid">

	<form class="form-horizontal col-md-offset-4 col-md-4" id="userhome" action="signup" method="post" commandName="userdetails">
		<div class="panel panel-primary">
			<div class="panel-heading">Register</div>
			
			<!-- Text input-->
			<div class="form-group" style="margin-top:15px">
				<label class="col-md-4 control-label" for="textinput">Name</label> 
				<div class="col-md-7">
					<input id="name" name="name" type="text" placeholder="Enter your name" class="form-control input-md">
					<font color="red"><form:errors path="name" required="true"></form:errors></font> 
					<font color="red"><form:errors path="name"></form:errors></font>
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Date Of Birth</label> 
				<div class="col-md-7">
					<input id="dob" name="dob" type="text" placeholder="Enter your Date of birth" class="form-control input-md"> 
					
					<font color="red"><form:errors path="dob" ></form:errors></font> 
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Email</label> 
				<div class="col-md-7">
					<input id="emailId" name="emailId" type="email" placeholder="Enter your email" class="form-control input-md">
					<font color="red"><form:errors path="emailId" required="true"></form:errors></font> 
					<font color="red"><label>${msg}</label></font>
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Phone</label> 
				<div class="col-md-7">
					<input id="phone" name="phone" type="number" placeholder="Enter your phone" class="form-control input-md">
					<font color="red"><form:errors path="phone" ></form:errors></font> 
				</div>
			</div>
		
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Category of Books You like</label> 
				<div class="col-md-7">
					<input id="category" name="category" type="text" placeholder="Enter your category" class="form-control input-md">
					<font color="red"><form:errors path="category" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Email of family member previously joined</label> 
				<div class="col-md-7">
					<input id="parentId" name="parentId" type="text" placeholder="Enter your parentId" class="form-control input-md">
					<font color="red"><form:errors path="parentId" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Street Number</label> 
				<div class="col-md-7">
					<input id="street" name="street" type="text" placeholder="Enter your Street Number" class="form-control input-md">
					<font color="red"><form:errors path="street" ></form:errors></font> 
				</div>
			</div>
            
            <!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Apt#</label> 
				<div class="col-md-7">
					<input id="aptNo" name="aptNo" type="text" placeholder="Enter your Apartment Number" class="form-control input-md">
					<font color="red"><form:errors path="aptNo" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">City</label> 
				<div class="col-md-7">
					<input id="city" name="city" type="text" placeholder="Enter your City" class="form-control input-md">
					<font color="red"><form:errors path="city" ></form:errors></font> 
				</div>
			</div>
			
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">State</label> 
				<div class="col-md-7">
					<input id="state" name="state" type="text" placeholder="Enter your State" class="form-control input-md">
					<font color="red"><form:errors path="state" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Country</label> 
				<div class="col-md-7">
					<input id="country" name="country" type="text" placeholder="Enter your Country" class="form-control input-md">
					<font color="red"><form:errors path="country" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Zip</label> 
				<div class="col-md-7">
					<input id="zip" name="zip" type="text" placeholder="Enter your Zip" class="form-control input-md">
					<font color="red"><form:errors path="zip" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group control-label">
				<label class="col-md-4 control-label" for="textinput">Proof of residence</label> 
				<div class="col-md-7">
					<input id="attachmentId" name="attachmentId" type="text" placeholder="Enter your Attachment" class="form-control input-md">
					<font color="red"><form:errors path="attachmentId" ></form:errors></font> 
				</div>
			</div>
			
	        <!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Password</label> 
				<div class="col-md-7">
					<input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md">
					<font color="red"><form:errors path="password" ></form:errors></font> 
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Confirm password</label> 
				<div class="col-md-7">
					<input id="confirmPassword" name="confirmPassword" type="password" placeholder="Enter your password again" class="form-control input-md">
					<font color="red"><form:errors path="confirmPassword" ></form:errors></font> 
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-7">
					<button id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit">Register</button>
					<div><font color="red"><form:errors /></font></div>
				</div>
			</div>
			
		</div>
</form>
</div>
</body>
</html>
	