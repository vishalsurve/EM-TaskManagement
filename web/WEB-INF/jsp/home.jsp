<%-- 
    Document   : Welcome
    Created on : Feb 26, 2013, 10:38:27 PM
    Author     : vishal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/styles.css" />
        <%--       <link rel="stylesheet" href="<c:url value="CSS/styles.css"/>"/> --%>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <table border="1" style="width: available">
                <tr><center>
                    <!--<a href="workspace">Add Workspace</a>-->
                    <form action="addworkspace" method="POST">
                        Add Workspace :<input type="text" name="workspacename" /><input type="submit" value="add" />
                    </form>
                    
                </center></tr>
            <tr valign="top">
                <td width="250px" NOWRAP>
                    <h2 style="margin: 0px; padding: 5px 0px 0px 8px; height: 21px;	background-color: #1b4376; font-size: 14px; color: #FFFFFF;">
                        Functions :
                    </h2>
                    <table border="1">
                        <tbody>
                            <tr><a href="addworkspace">Edit</a></tr><br>
            <tr><a href="addworkspace">Delete</a></tr><br>
        <tr><a href="addworkspace">View</a></tr><br>
    <tr><a href="addworkspace">Assigned by me</a></tr><br>
<tr><a href="addworkspace">Assigned to me</a></tr><br>
</tbody>
</table></td>

<td width="1600px" NOWRAP>
    <h2 style="margin: 0px; padding: 5px 0px 0px 8px; height: 21px;background-color: #1b4376; font-size: 14px; color: #FFFFFF;">
        TASK :</h2>
<marquee style="font-size: 13px; color: red;">New Task</marquee>

<center><table border="1" bgcolor="gainsboro">
        <tbody>

        </tbody>
    </table>
</center></td></tr>
</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
