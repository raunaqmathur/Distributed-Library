<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.sjsu.digitalLibrary.prj.models.bookAvail" %>
<jsp:include page="header.jsp"></jsp:include>

<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
   <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> 
  
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<style type="text/css">
.star-rating {
font-size: 0;
white-space: nowrap;
display: inline-block;
width: 150px;
height: 30px;
overflow: hidden;
position: relative;
background:
url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjREREREREIiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
background-size: contain ;
}

.star-rating i {
opacity: 0;
position: absolute;
left: 0;
top: 0;
height: 100%;
width: 20%;
z-index: 1;
background:
url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjRkZERjg4IiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
background-size: contain;
}

.star-rating input {
-moz-appearance: none;
-webkit-appearance: none;
opacity: 0;
display: inline-block;
width: 20%;
height: 100%;
margin: 0;
padding: 0;
z-index: 2;
position: relative;
}

.star-rating input:hover+i, .star-rating input:checked+i {
opacity: 1;
}

.star-rating i ~ i {
width: 40%;
}

.star-rating i ~ i ~ i {
width: 60%;
}

.star-rating i ~ i ~ i ~ i {
width: 80%;
}

.star-rating i ~ i ~ i ~ i ~ i {
width: 100%;
}

.choice {
position: fixed;
top: 0;
left: 0;
right: 0;
text-align: center;
padding: 20px;
display: block;
}



</style>
	
	
	<script type="text/javascript">
	
	function noteRating(id,value){
		
		//alert('' + id + ' - ' + value);
		
		$.ajax({ 
			   type: "POST",
			   url: "../feedback/" + id + "/" + value,
			   success: function(res){  
				   $("#" + id +"span").attr('title', 'Feedback already submitted!');
					for (var a =1;a <= 5; a++)
						$( "#" + id +'' +  a ).prop( 'disabled', true );
			      	alert('feedback submitted');
			   	}
			});
		
		
	}
	
	function setPreviousRating(){
		
		<c:forEach items='${userOrdersDetails}' var='ord' varStatus='i'>
		
		var orderid = ${ord.id};
		var feedback = ${ord.feedback} ;
			if(feedback != '0')	{
				var id = orderid +'' +  feedback;
				document.getElementById(id).checked=true;
				$("#" + orderid +"span").attr('title', 'Feedback already submitted!');
				for (var a =1;a <= 5; a++)
					$( "#" + orderid +'' +  a ).prop( 'disabled', true );
			}
		
	
	</c:forEach>
		
}
	
	
	</script>
</head>

<body onLoad ="setPreviousRating()">


<div class="table-responsive col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">Orders</div>
				
				<table class="table">	
				 <tr class="active">
			                <td><label>Order #</label></td>
			                <td><label>Book Id</label></td>
			                <td><label>Confirmation #</label></td>
			                <td><label>Date ordered</label></td>
			                <td><label>Start Date</label></td>
			                <td><label>End Date</label></td>
			                <td><label>Choose a rating</label></td>
			            </tr>
				            
			            
		            <c:forEach items="${userOrdersDetails}" var="result">
			            
			            <tr class="info">
			                
			                <td><label>${result.id}</label></td>
			                
			            
			               
			                <td><a  href="${pageContext.request.contextPath}/convertToParentBook/${result.bookId}" >${result.bookId}</a>
			                </td>
			           
			                <td><label>${result.confirmationNumber}</label></td>
			           
			                <td><label>${result.dateOfOrder}</label></td>
			            
			                <td><label>${result.startDate}</label></td>
				       
			                <td><label>${result.endDate}</label></td>
			                
			                <td>
			                <span id="${result.id}span" class="star-rating">
									  <input type="radio" name="${result.id}1" id="${result.id}1" value="1" onClick = "noteRating(${result.id}, 1);"><i></i>
									  <input type="radio" name="${result.id}2" id="${result.id}2" value="2" onClick = "noteRating(${result.id}, 2);"><i></i>
									  <input type="radio" name="${result.id}3" id="${result.id}3" value="3" onClick = "noteRating(${result.id}, 3);"><i></i>
									  <input type="radio" name="${result.id}4" id="${result.id}4" value="4" onClick = "noteRating(${result.id}, 4);"><i></i>
									  <input type="radio" name="${result.id}5" id="${result.id}5" value="5" onClick = "noteRating(${result.id}, 5);"><i></i>
							</span>
							
			                </td>
			                
				        </tr>
		             	
<%-- 	             		<c:if test="${result.sellerFeedback == 0}"> --%>
<!-- 						   <td colspan="2" align="right"> -->
<%-- 			                	<a class="btn btn-primary" href="${pageContext.request.contextPath}/feedback/seller/${result.transactionId}" role="button">Feedback</a> --%>
<!-- 			                </td> -->
<%-- 						</c:if>	 --%>
						            
					</c:forEach>					
				</table>
			</div>
		</div>



    				
</body>
</html>