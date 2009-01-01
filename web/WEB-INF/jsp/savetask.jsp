<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task Details</title>
        <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <script type="text/javascript">
            var contexPath = "<%=request.getContextPath()%>";
        </script>
        <script src="<%=request.getContextPath()%>/js/task.js"></script>

        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/app.css">
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <center>
            <form action="addtask" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Field :</th>
                            <th>Values :</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><div id="error" class="error"></div></td>
                        </tr>
                        <tr>
                            <td>Task Name :</td>
                            <td><input type="text" name="taskname" id="taskname"/></td>
                        </tr>
                        <tr>
                            <td>Start Date :</td>
                            <td><input type="text" name="startdate" id="startdate"/></td>
                        </tr>
                        <tr>
                            <td>End Date :</td>
                            <td><input type="text" name="enddate" id="enddate"/></td>
                        </tr>
                        <tr>
                            <td>Priority :</td>
                            <td><input type="text" name="priority" id="priority"/></td>
                        </tr>

                        <tr>
                            <td><input type="button" value="Add Task" onclick="addTask();"/></td>
                            <td><input type="button" value="show Task" onclick="taskList();"><br/></td>
                        <tr>
                            <td> <div id="info" class="success"></div></td>
                        </tr>
                       
                        </tr>

                    </tbody>
                </table>
            </form>
        </center>
    </body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
