<%-- 
    Document   : save
    Created on : 3 May, 2013, 2:33:58 PM
    Author     : Bhavin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <jsp:include page="header.jsp"></jsp:include>
        <h1>List of Users</h1>

        <table width="100%" cellpadding="0" cellspacing="1" border="0">
            <tr bgcolor="cccccc" >
                <th valign="top" width="7%" align="center" ><strong>First Name</strong></th>
                <th valign="top" width="7%" align="center" ><strong>Last Name</strong></th>

                <th valign="top" width="7%" align="center" ><strong>Is Admin?</strong></th>
                <th valign="top" width="7%" align="center" ><strong>Active/Not-Active</strong></th>


                <th valign="top" width="7%" align="center" ><strong>Update User</strong></th>
                <th valign="top" width="7%" align="center" ><strong>Delete User</strong></th>
            </tr>	
            <c:forEach var="userdata" items="${userList}">
                <tr>
                    <td><c:out value="${userdata.firstname}"/></td>
                    <td><c:out value="${userdata.lastname}"/> </td>

                    <td><c:out value="${userdata.isAdmin}"/> </td>
                    <td><c:out value="${userdata.active_inactive}"/> </td>

                    <td><a href="edit/${userdata.userid}">edit</a></td>
                    <td><a href="delete/${userdata.userid}">delete</a></td>
                </tr>
            </c:forEach>  
        </table>
    </body>
    <jsp:include page="footer.jsp"></jsp:include>
</html>
