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
        <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <script type="text/javascript">
            var contexPath = "<%=request.getContextPath()%>";
        </script>
        <script src="<%=request.getContextPath()%>/js/workspace.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/app.css">
    </head>
    <body>
        <header>
            <table width="100%">
                <tr><td>
                        <div id="Layer1" align="right" style="">
                            <a href="aboutus" style="color: #FFFFFF">About Us</a>&nbsp;&nbsp;
                            <a href="saveuser" style="color: #FFFFFF">Signup</a>&nbsp;&nbsp;
                            <a href="login" style="color: #FFFFFF">Login</a>&nbsp;&nbsp;
                            <a href="logout" style="color: #FFFFFF">LogOut</a>&nbsp;&nbsp;
                            <a href="#"></a>
                        </div><br>
                    </td></tr>
                <tr>
                <img src="images/nature.jpg" height="80px " width="100%">
                </tr>
            </table>
        </header>
        <!--    <center><table border="1" style="width: available">
                    <tr>
                        <td colspan="2"><div id="error" class="error"></div></td>
                    </tr>
                    <tr>
                        <td>Add Workspace :<input type="text" id="workspacename"><br/></td>
                        <td><input type="button" value="Add Workspace" onclick="doAjaxPost();"><br/></td>
                        <td><input type="button" value="show Workspace" onclick="showList();"><br/></td>
                    </tr>
                    <tr>
                        <td><div id="info" class="success">
        
                            </div></td>
                    </tr>
                </table></center>-->


        <table border="1" style="width: available">
            <tr valign="top">
                <td width="250px" NOWRAP>
                    <h2 style="margin: 0px; padding: 5px 0px 0px 8px; height: 21px;	background-color: #1b4376; font-size: 14px; color: #FFFFFF;">
                        Functions :
                    </h2>
                    <table border="1">
                        <tbody> <c:if  test="${!empty workspacename}">
                                <!--                            <tr><a href="addworkspace">Edit</a></tr><br>
                                            <tr><a href="addworkspace">Delete</a></tr><br>-->
                                <tr> <form action="updateworkspace" method="POST">
                                <td>  <input type="text" name="workspacename" /></td>
                                <td>   <input type="submit" value="UpdateWorkspaceName" ><br/></td>
                            </form></tr>

                <tr> <form action="deleteworkspace">
                    <input type="submit" value="DeleteWorkspace"><br/> 
                </form></tr>

            <tr><a href="addworkspace">View</a></tr><br>
        <tr><input type="submit" value="AssignedByMe" onclick="AssignedByMe();"><br>
        <td><div id="info" class="success"></div></td>
    </tr>

    <tr><input type="submit" value="AssignedToMe" onclick="AssignedToMe();"><br></tr>

    </tbody></c:if>
</table></td>

<td width="1600px" NOWRAP>
    <h2 style="margin: 0px; padding: 5px 0px 0px 8px; height: 21px;background-color: #1b4376; font-size: 14px; color: #FFFFFF;">
        TASK :</h2>
<marquee style="font-size: 13px; color: red;">New Task</marquee>
<c:if  test="${!empty workspacename}">
<form action="adduser" method="POST">
    <table border="1">
        <tbody> <tr>
                <td colspan="2"><div id="error" class="error"></div></td>
            </tr>
            <tr> <input type="text" name="workspacename" value="${workspacename}"/></tr>
        <tr>
            <td>
                select
                <c:forEach var="userdata" items="${userList}">
                    <br> <INPUT NAME="userdata" TYPE="checkbox" VALUE="${userdata}">${userdata}
                </c:forEach>  
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>

        </tbody>
    </table>
</form>
<form action="createTask" method="POST">
    <!--Add Task :<input type="text" name="taskname" />-->
    <input type="submit" value="AddTask" />
</form>
</c:if>
</td></tr>
</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
