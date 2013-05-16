<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("login.htm");%>--%>

<%-- 
    Document   : addEmployee
    Created on : 6 May, 2013, 5:30:43 PM
    Author     : emserver


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   --%>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form action="adduser" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Field :</th>
                        <th>Values :</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name :</td>
                        <td><input type="text" name="firstname" /></td>
                    </tr>
                    <tr>
                        <td>Last Name :</td>
                        <td><input type="text" name="lastname" /></td>
                    </tr>
                    <tr>
                        <td>Email :</td>
                        <td><input type="email" name="email" /></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td>Active/Inactive :</td>
                        <td><input type="radio" name="active_inactive" value=1>Active<br>
                            <input type="radio" name="active_inactive" value=0>Inactive</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>-->
