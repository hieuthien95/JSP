<%-- 
    Document   : login
    Created on : Jan 22, 2017, 7:42:01 AM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">
                            <div class="login-form"><!--login form-->
                                <h2>Login to your account</h2>
                            ${error}
                            <form action="${pageContext.request.contextPath}/user/login" method="POST">
                                <input type="text" placeholder="Username" name="username" />
                                <input type="password" placeholder="Password" name="password" />
                                <button type="submit" class="btn btn-default">Đăng nhập</button>
                            </form>
                        </div><!--/login form-->
                    </div>
                    <div class="col-sm-1">
                        <h2 class="or">OR</h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="signup-form"><!--sign up form-->
                            <h2>New User Signup!</h2>
                            ${error}
                            <form action="${pageContext.request.contextPath}/user/register" method="POST">
                                <input type="text" placeholder="Username" name="username"/>
                                <input type="password" placeholder="Password" name="password"/>
                                <button type="submit" class="btn btn-default">Đăng ký</button>
                            </form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
