<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>CMPE 295B BOOK SHARE</title>
</head>
<body>
    <form:form id="userpage" method="post" action="/275_LAb_2/homepage/${userpageDetails.id}" commandName="userpageDetails">
        <table>
         <tr>
                <td colspan="3"><label>${Message}</label></td>
            </tr>
            <tr>
                <td colspan="3"><h3>Welcome 2 Your Page</h3></td>
            </tr>
            
            <tr>
                <td><label>ID</label></td>
                <td><form:label path="id" >${userpageDetails.id}</form:label></td>
            </tr>
            <tr>
                <td><label>First Name</label></td>
                <td><form:input path="firstname" ></form:input></td>
                <td><font color="red"><form:errors path="firstname"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>Last Name</label></td>
                <td><form:input path="lastname" ></form:input></td>
               
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><form:input path="email" ></form:input></td>
                
            </tr>
            <tr>
                <td><label>Address</label></td>
                <td><form:input path="address" ></form:input></td>
                
            </tr>
            <tr>
                <td><label>Organization</label></td>
                <td><form:input path="organization" ></form:input></td>
               
            </tr>
            <tr>
                <td><label>About Myself</label></td>
                <td><form:input path="aboutMyself" ></form:input></td>
                
            </tr>
             
            <tr>
               <td colspan="2" align="center"><input type="submit" name="update"
                    value="Update" /></td>
                    
                <td>
                
                <td colspan="2" align="center"><input type="submit" name="delete"
                    value="Delete" /></td>
                    
                <td>
            
		</td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>