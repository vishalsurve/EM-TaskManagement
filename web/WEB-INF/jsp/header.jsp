<%-- 
    Document   : header
    Created on : 15 May, 2013, 3:13:12 PM
    Author     : emserver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/styles.css" />
        <title>JSP Page</title>

        <script type="text/javascript">
            function logout() {
                var x;
                x = alert("You are logout");

            }

            function login() {

            }
        </script>
    </head>
    <body>
        <header>
            <table width="100%">
                <tr><td>
                        <div id="Layer1" align="right" style="">
                            <a href="aboutus" style="color: #FFFFFF">About Us</a>&nbsp;&nbsp;
                            <a href="saveuser" style="color: #FFFFFF">Signup</a>&nbsp;&nbsp;
                            <a href="login" style="color: #FFFFFF">Login</a>&nbsp;&nbsp;
                            <input type="button" value="Log Out" onclick="logout();" style="color: skyblue" />
                            <a href="#"></a>
                        </div><br>
                    </td></tr>
                <tr>
                <img src="images/nature.jpg" height="80px " width="100%">
                </tr>
            </table>
        </header>
    </body>
</html>