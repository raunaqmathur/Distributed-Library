<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" />
<html>

<body>

<div class="container-fluid">
	<form class="form-horizontal col-md-offset-4 col-md-4" id="resetPassword" action="resetPassword" method="post" commandName="resetpassword">		
		<div class="panel panel-primary">
			<div class="panel-heading">Log In</div>
			
			<input name="message" id="message" value="${message}" type="hidden">
			<input name="id" id="id" value="${id}" type="hidden">
			<input name="flag" id="flag" value="${flag}" type="hidden">
			<hr>
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-3 control-label" for="textinput">New Password</label>  
			  <div class="col-md-8">
				  <input id="password" name="password" type="password" placeholder="Enter new password" class="form-control input-md" required=true>
				  
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-3 control-label" for="textinput">Password</label>  
			  <div class="col-md-8">
				  <input id="confirmPassword" name="confirmPassword" type="password" placeholder="Confirm password" class="form-control input-md" required=true>
				
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-3 control-label" for="singlebutton"></label>
			  <div class="col-md-8">
			    <button id="resetPassword" name="singlebutton" class="btn btn-primary" onclick="return passwordMatch()" type="button">Reset Password</button>
			  </div>
			  
			</div>
		</div>
	</div>
	</form>
</div>
</body>

<script>

$(document).ready(function() {
	
	var flag = document.getElementById('flag').value;
	var msg = document.getElementById('message').value;
	var z = document.getElementById('id').value;

	if(x != null && x!="" && flag=="S"){
		alert(msg);
		document.location.href="/Distributed-Library";
	}
	else if(x != null && x!="" && flag=="E"){
		alert(msg);
		document.location.href="/Distributed-Library";
	}
});	

	
	function passwordMatch(){
		
		var enteredPassword = $("#password").val();
		var confirmPassword = $("#confirmPassword").val();
		
		if(enteredPassword != confirmPassword){
			alert("Your entered password and confirmed password should be same !\n");
			return false;
		}else{
			document.getElementById("resetPassword").submit();
		}
		
	}

</script>
</html>