<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 295B BOOK SHARE</title>
</head>
<body>
    <form:form id="userhome" action="userhome" method="post"
        commandName="userdetails">
        <table>
            <tr>
                <td colspan="3"><h3>Welcome 2 HomePage</h3></td>
            </tr>
            
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name" ></form:input></td>
                <td><font color="red"><form:errors path="name"></form:errors></font></td>
            </tr>
            <tr>
                <td><label>Age</label></td>
                <td><form:input path="age"></form:input></td>
               
            </tr>
           
            <tr>
                <td><label>Email</label></td>
                <td><form:input path="emailId" ></form:input></td>
                <td><font color="red"><form:errors path="emailId"></form:errors></font></td>
                
            </tr>
             <tr>
                <td><label>Phone Number</label></td>
                <td><form:input path="phone"></form:input></td>
                
            </tr>
            <tr>
                <td><label>Address</label></td>
                <td><form:input path="address" ></form:input></td>
                
            </tr>
            
<<<<<<< HEAD:275_BookShare/src/main/webapp/WEB-INF/views/userhome.jsp
           
=======
           <tr>
                <td><label>Password</label></td>

                <td><form:input type="password" path="password" required="true" ></form:input></td>

                <td><form:input path="password" ></form:input></td></tr>
>>>>>>> parent of 7f74ba9... SignUp and Session:275_BookShare/src/main/webapp/WEB-INF/views/userhome.jsp
            <tr>
                <td colspan="2" align="center"><input type="submit"
                    value="Create" /></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><font color="red"><form:errors /></font></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
