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



        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
        <script type="text/javascript">
            function doAjaxPost() {
                // get the form values
                var name = $('#name').val();
                var education = $('#education').val();

                $.ajax({
                    type: "POST",
                    url: "adduser",
                    //                    data: "name=" + name + "&education=" + education,
                    data: "name=" + firstname + "lastname=" + lastname + "email=" + email + "password=" + password,
                    success: function(response){
                        // we have the response
                        $('#info').html(response);
                        $('#name').val('');
                        $('#education').val('');
                    },
                    error: function(e){
                        alert('Error: ' + e);
                    }
                });
            }
        </script>
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
                        <td>is Admin?</td>
                        <td><input type="radio" name="isAdmin" value="true">Yes<br>
                            <input type="radio" name="isAdmin" value="false">No</td>
                    </tr>
                    <tr>
                        <td>Active/Inactive :</td>
                        <td><input type="radio" name="active_inactive" value=0>Active<br>
                            <input type="radio" name="active_inactive" value=1>Inactive</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="submit" onclick="doAjaxPost()" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="/EM-TaskManagement/listuser">Click Here</a> for List of Users!
    </center>

    <div id="info"></div>
</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>
