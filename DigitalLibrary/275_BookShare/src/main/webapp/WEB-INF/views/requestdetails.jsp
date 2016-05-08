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
	div#map_container{
		width:550px;
		height:350px;
	}
	</style> 
	<script>
	var dateRange = [];           // array to hold the range

	
	
function chooseBook(){
	var subBookId= document.getElementById('subbookId').value;
	var startDate = document.getElementById('datepicker').value
	window.location = "../orderbook/" + subBookId + "/" + startDate;
}
	
		function changeMap(subId, latitude, longitude){
			
			document.getElementById('divChoose').style.visibility='visible';
			
			
			 document.getElementById('subbookId').value = subId;
			 
			var p = document.getElementById(''+subId + 'Start').value + '';
			var q = document.getElementById(''+subId + 'End').value + '';
			p= p.replace("[","");
			p =p.replace("]","");
			var array = p.split(',');
			 console.log(array);
			 
			 
			 q= q.replace("[","");
				q =q.replace("]","");
				var arrayQ = q.split(',');
				 console.log(arrayQ);
			 
			 manageDates(array,arrayQ);
			 //alert('bye');
		
			 var geocoder = new google.maps.Geocoder();
				var address = "101 E San Fernando, San Jose, CA, 95112";
	    		geocoder.geocode( { 'address': address}, function(results, status) {
	      		if (status == google.maps.GeocoderStatus.OK) {
	    	  		
		    	   
		    	    var latlng = new google.maps.LatLng(latitude, longitude);
		    	    var myOptions = {
		    	      zoom: 15,
		    	      center: latlng,
		    	      mapTypeId: google.maps.MapTypeId.ROADMAP
		    	    };
		    	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
	    	 
		    	    var marker = new google.maps.Marker({
		    	      position: latlng, 
		    	      map: map, 
		    	      title:address
		    	    }); 
	      		
	      		} else {
	    	  
			    	var latlng = new google.maps.LatLng(37.3357192, -121.8867076);
			  	    var myOptions = {
			  	      zoom: 15,
			  	      center: latlng,
			  	      mapTypeId: google.maps.MapTypeId.ROADMAP
			  	    };
			  	    var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
			  	 
			  	    var marker = new google.maps.Marker({
			  	      position: latlng, 
			  	      map: map, 
			  	      title:'Book'
			  	    }); 
	    	  	}
	      
	        	}); 
	    		
	    	
	    		
	    		
	    		
	    		
		}
		
		function unavailableRange(date) {
			
			
		    var dateString = jQuery.datepicker.formatDate('yyyy-mm-dd', date);
		    return [dateRange.indexOf(dateString) == -1];
		}
		
		$(document).ready(function(){
			$( "#datepicker" ).datepicker({ minDate: +1, maxDate: "+1M" , dateFormat: "yy-mm-dd",  beforeShowDay: unavailableRange });
			//alert('ho');
			
		});
			function manageDates(start_date, end_date){
				
			//alert('here');
			dateRange= [];
			for(var x =0; x < start_date.length; x ++)
				{
					var dStart = new Date(start_date[x]);
					//var dStartFinal =  dStart.getDate();
					
					var dEnd = new Date(end_date[x]);
					//var dEndFinal =  dEnd.getDate();
					dEnd.setDate(dEnd.getDate() + 1)
					for (var d = dStart; d <= dEnd; d.setDate(d.getDate() + 1)) {
					    dateRange.push($.datepicker.formatDate("yyyy-mm-dd", d));
					}
					//dateRange.push($.datepicker.formatDate("yyyy-mm-dd", dEnd));
					var z=0;
					var d = new Date(start_date[x]);
					while( z < 6)
					{
					    dateRange.push($.datepicker.formatDate("yyyy-mm-dd", d));
					    d.setDate(d.getDate() - 1);
					    z++;
					}
					
				}
			$("#datepicker").datepicker("refresh");
		}
		
		
		
		
		
		
		
      		
	</script>
</head>

<body>

<div class="container-fluid" style="margin-top:15px"> <br/>
		<div class="row-fluid">
			<div class="container-fluid"> 
			 <% if(null != request.getAttribute("bookAvailDetails")) {%> 
				<c:forEach items="${bookAvailDetails}" var="bookAvail" varStatus="i"> 
          			<div class="col-md-2">
          			              <a class="btn btn-primary"  href="#" onClick="changeMap(${bookAvail.subId}, ${bookAvail.region_long}, ${bookAvail.region_lat});" role="button" > ${bookAvail.getRegion_name()} </a>
          						<input type="hidden" id="${bookAvail.subId}Start" value="${bookAvail.start_date}"></input>
          						<input type="hidden" id="${bookAvail.subId}End" value="${bookAvail.end_date}"></input>
					</div>
				</c:forEach>
				 <% } else
					 
				 {%> 
				 <label>No Availability</label>
				  <% }%> 
			</div>
		</div>
</div>
<br />
<div id="map_container" align="center">	
<br/>
<br/>
</div>
<div id="divChoose" style="visibility: hidden">
<input type="hidden" id="subbookId" value=""></input>
<p>Date: <input type="text" id="datepicker"></p>
<p>

<a class="btn btn-primary"  href="#" onClick="chooseBook();" role="button" > Choose </a></p>


</div>
    				
</body>
</html>