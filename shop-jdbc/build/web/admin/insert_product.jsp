<%-- 
    Document   : insert_product
    Created on : Jan 1, 2017, 1:37:37 PM
    Author     : hieut
--%>

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
                    <h3>Thêm sản phẩm</h3>

                    <form action="/shop-jdbc/ManagerProductServlet" method="POST" enctype="multipart/form-data">
                        <input name ="command" type="hidden" value="insert">
                        <table width="100%">
                            <tr>
                                <td>
                                    <b style="float: right">Danh mục</b>
                                </td>
                                <td>
                                    <select name="category_id">
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
                                <input type="text" name="product_name">
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
                                <input type="text" name="product_price" />
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <b style="float: right">Mô tả</b>
                            </td>
                            <td>
                                <textarea name="product_description"></textarea>
                                <script>
                                    CKEDITOR.replace('product_description');
                                </script>
                            </td>
                        </tr> 
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Thêm">
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
