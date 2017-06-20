<%-- 
    Document   : insert_category
    Created on : Jan 1, 2017, 1:37:29 PM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update category</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
                <div id="rightContent">
                    <h3 style="text-align: center">Sửa danh mục</h3>
                    <form action="/shop/ManagerCategoryServlet" method="POST">
                        <table width="100%">
                            <tr>
                                <td>
                                    <b style="float: right">Tên danh mục</b>
                                </td>
                                <td>
                                    <input type="text" name="category_name" value="<%=request.getParameter("category_name")%>">
                                <input type="hidden" name="category_id" value="<%=request.getParameter("category_id")%>">
                            </td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td>
                                <input name ="command" type="hidden" value="update">
                                <input type="submit">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
