<%-- 
    Document   : manager_category
    Created on : Jan 1, 2017, 1:17:22 PM
    Author     : hieut
--%>

<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
    </head>
    <body>

        <%
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> listCategory = new ArrayList<Category>();
            listCategory = categoryDAO.getListCategory();
        %>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 

                <div id="rightContent">
                    <h3 style="text-align: center">Danh mục</h3>
                    <a href="insert_category.jsp">Thêm danh mục</a>
                    
                    <table class="data">
                        
                    <tr class="data">
                        <th class="data" width="30px"></th>
                        <th class="data">Mã danh mục</th>
                        <th class="data">Tên danh mục</th>
                        <th class="data" width="60px"></th>
                    </tr>
                    <%
                        int count = 0;
                        for (Category i : listCategory) {
                            count++;
                    %>
                    <tr class="data">
                        <td class="data"><%=count%></td>
                        <td class="data"><%=i.getCategoryID()%></td>
                        <td class="data"><%=i.getCategoryName()%></td>
                        <td class="data">
                            <a href="update_category.jsp?category_id=<%=i.getCategoryID()%>&category_name=<%=i.getCategoryName()%>">Sửa</a> |
                            <a href="/shop/ManagerCategoryServlet?command=delete&category_id=<%=i.getCategoryID()%>">Xóa</a>
                        </td>
                    </tr>

                    <% }%>
                </table>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>

    </body>
</html>
