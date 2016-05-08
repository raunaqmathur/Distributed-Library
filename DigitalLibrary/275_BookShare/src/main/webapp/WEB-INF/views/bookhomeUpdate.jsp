<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 295 BOOK SHARE</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>

<script >


		$(document).ready(function(){
		    if(document.getElementById('active').value == 0)
				document.getElementById('activeX').checked = true;
		    else
		    	document.getElementById('activeX').checked = false;
			
			
		});



	function changeRemove()
	{
		
		var x = document.getElementById('activeX').checked;
		
		//alert('' + document.getElementById('active').value);
		
		if(x == true)
			document.getElementById('active').value = 0;
		else
			document.getElementById('active').value = 1;
		
		
		//alert('' + document.getElementById('active').value);
		
	}

	
	
</script>
</head>
<body>
    <form:form id="bookhomeUpdate" action="${path}" method="POST" 
        commandName="bookdetails">
        <table>
            <tr>
                <td colspan="3"><h3>Enter Book Details</h3></td>
            </tr>
            
            
            <tr>
                <td><label>Title</label></td>
                <td><form:input path="title"></form:input><form:input type="hidden" path="bookId"></form:input><form:input type="hidden" path="status"></form:input></td>
                <td><font color="red"><form:errors path="title"></form:errors></font></td>
            </tr>
           
            <tr>
                <td><label>Author</label></td>
                <td><form:input path="author" ></form:input></td>
                <td><font color="red"><form:errors path="author"></form:errors></font></td>
                
            </tr>
            
             <tr>
                <td><label>ISBN</label></td>
                <td><form:input path="isbn" ></form:input></td>
                <td><font color="red"><form:errors path="isbn"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Description</label></td>
                <td><form:input path="description" ></form:input></td>
                
                
            </tr>
             <tr>
                <td><label>Picture</label></td>
                <td>
                <form:input path="pictureId" ></form:input></td>
                
                <td></td>
            </tr>
             <tr>
                <td><label>Price</label></td>
                <td><form:input path="price"></form:input></td>
                
            </tr>
            <tr>
                <td><label>Condition</label></td>
                <td><form:input path="condition" ></form:input></td>
                <td><font color="red"><form:errors path="condition"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Keywords</label></td>
                <td><form:input path="keywords" ></form:input></td>
                
                
            </tr>
            <tr>
                <td><label>Category</label></td>
                <td><input type="text" name="categoryX" id="categoryX" ></input></td>
                
                
            </tr>
           <tr>
                <td><label>Pickup Address</label></td>
                <td><form:input path="pickupAddress" ></form:input></td>
                <td><font color="red"><form:errors path="pickupAddress"></form:errors></font></td>
                
            </tr>
             <tr>
                <td></td>
                 <td><input type="checkbox" name="activeX" id="activeX" value="1" onClick="javascript: changeRemove();"></input><label>Remove</label> 
                <form:input type="hidden" path="active"></form:input></td>
                <td></td>
                
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Update"  /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form></body>
</html>