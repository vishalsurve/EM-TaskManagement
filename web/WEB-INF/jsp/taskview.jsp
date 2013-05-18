<%-- 
    Document   : taskview
    Created on : 15 May, 2013, 11:37:52 AM
    Author     : emserver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
           <c:forEach var="userdata" items="${taskList}">
        ${userdata} <br>
    </c:forEach>
        </body>
    <jsp:include page="footer.jsp"></jsp:include>
</html>
