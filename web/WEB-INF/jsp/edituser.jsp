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
    <center>
        <c:forEach var="userdata" items="${employeeobject}">
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
                            <td>User_id :</td>
                            <td><input type="text" name="userid" value="${userdata.userid}" /></td>
                        </tr>
                        <tr>
                            <td>First Name :</td>
                            <td><input type="text" name="firstname" value="${userdata.firstname}"/></td>
                        </tr>
                        <tr>
                            <td>Last Name :</td>
                            <td><input type="text" name="lastname" value="${userdata.lastname}"/></td>
                        </tr>
                        
                        <tr>
                            <td>E-Mail :</td>
                            <td><input type="text" name="email" value="${userdata.email}"/></td>
                        </tr>

                        <tr>
                            <td>Is the User Admin?</td><td>
                                <input type="radio" name="isAdmin" value="true">Yes
                                <input type="radio" name="isAdmin" value="false">No
                            </td>
                        </tr>

                        <tr>
                            <td>Password :</td>
                            <td><input type="password" name="password" value="${userdata.password}"/></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" value="update" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:forEach>
    </center>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>