<%-- 
    Document   : login
    Created on : Jan 22, 2017, 7:42:01 AM
    Author     : hieut
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        
        <%
            User user = (User) session.getAttribute("user");
        %>
        
        <jsp:include page="header.jsp"></jsp:include>

            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                    <div class="col-sm-6">
                        <div class="signup-form"><!--sign up form-->
                            <h2>Change info</h2>
                            ${error}
                            <form action="${pageContext.request.contextPath}/user/update" method="POST">
                                <input type="text" placeholder="Username" name="username" disabled="true" value="<%=user.getUsername()%>"/>
                                <input type="password" placeholder="Password" name="password"/>
                                <button type="submit" class="btn btn-default">Cập nhật</button>
                            </form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
