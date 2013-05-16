<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>--%>

<%-- 
    Document   : addEmployee
    Created on : 6 May, 2013, 5:30:43 PM
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

        <div style="height: 100%">
                <center>
                    <form action="authenticate" method="POST">
                        <table border="1">
                            <tbody>
                                <tr>
                                    <td>UserName :</td>
                                    <td> <input type="text" name="email" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Password :</td>
                                    <td> <input type="password" name="password" value="" /></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Login" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </center>    
            </div>
        </body>
    <jsp:include page="footer.jsp"></jsp:include>
</html>
