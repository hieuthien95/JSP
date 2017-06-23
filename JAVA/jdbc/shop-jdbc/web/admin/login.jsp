<%-- 
    Document   : login
    Created on : Jan 1, 2017, 1:32:07 PM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <div id="loginForm">
            <div class="headLoginForm">
                Login Administrator
            </div>
            <div class="fieldLogin">
                <form method="POST" action="">
                    <label>Username</label><br>
                    <input type="text" class="login"><br>
                    <label>Password</label><br>
                    <input type="password" class="login"><br>
                    <input type="submit" class="button" value="Login">
                </form>
            </div>
        </div>

    </div>
</body>
</html>
