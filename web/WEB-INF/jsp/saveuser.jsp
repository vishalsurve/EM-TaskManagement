<%-- 
    Document   : saveuser
    Created on : 15 May, 2013, 11:37:52 AM
    Author     : emserver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
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
                            <td><input type="radio" name="active_inactive" value=0>Active<br>
                                <input type="radio" name="active_inactive" value=1>Inactive</td>
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
<jsp:include page="footer.jsp"></jsp:include>
</html>
