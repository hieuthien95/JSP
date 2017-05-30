<%-- 
    Document   : index
    Created on : Jan 1, 2017, 12:50:23 PM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang quản trị</title>
    </head> 
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
                <jsp:include page="menu.jsp"></jsp:include> 
                <jsp:include page="content.jsp"></jsp:include>
                <jsp:include page="footer.jsp"></jsp:include>
            </div>
    </body>
</html>
