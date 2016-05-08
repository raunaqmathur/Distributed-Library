<%@    taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>CMPE 295B BOOK SHARE</title>
</head>
<body>
    <form:form id="category" action="category" method="post"
        commandName="categorydetails">
        <table>
            <tr>
                <td colspan="3"><h3>Enter Category Details</h3></td>
            </tr>
            
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name" ></form:input></td>
                <td><font color="red"><form:errors path="name"></form:errors></font></td>
            </tr>
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