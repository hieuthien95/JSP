<%-- 
    Document   : insert_product
    Created on : Jan 1, 2017, 1:37:37 PM
    Author     : hieut
--%>

<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>insert product</title>
    </head>
    <body>

        <%
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> listCategory = new ArrayList<>();
            listCategory = categoryDAO.getListCategory();
        %>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
                <div id="rightContent">
                    <h3>Cập nhật sản phẩm</h3>

                    <form action="/shop/ManagerProductServlet" method="POST"  enctype="multipart/form-data">
                        <input name ="command" type="hidden" value="update">
                        <input name ="product_image" type="hidden" value="<%=request.getParameter("product_image")%>">
                        <input name ="product_id" type="hidden" value="<%=request.getParameter("product_id")%>">
                        <table width="100%">
                            <tr>
                                <td>
                                    <b style="float: right">Danh mục</b>
                                </td>
                                <td>
                                    <select name="category_id">
                                        <option value="<%=request.getParameter("category_id")%>"><%=categoryDAO.getCategory(Long.parseLong(request.getParameter("category_id"))).getCategoryName()%></option>
                                        <% for (Category i : listCategory) {%>
                                        <option value="<%=i.getCategoryID()%>"><%=i.getCategoryName()%></option>
                                        <% }%>
                                    </select>
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <b style="float: right">Tên sản phẩm</b>
                                </td>
                                <td>
                                    <input type="text" name="product_name" value="<%=request.getParameter("product_name")%>">
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <b style="float: right">Hình ảnh</b>
                                </td>
                                <td>
                                    <input type="file" name="uploadFile" />
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <b style="float: right">Giá</b>
                                </td>
                                <td>
                                    <input type="text" name="product_price" value="<%=request.getParameter("product_price")%>" />
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <b style="float: right">Mô tả</b>
                                </td>
                                <td>
                                    <input type="text" name="product_description" value="<%=request.getParameter("product_description")%>"/>
                                </td>
                            </tr> 
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" value="Cập nhật">
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
