<%-- 
    Document   : manager_product
    Created on : Jan 1, 2017, 1:26:26 PM
    Author     : hieut
--%>

<%@page import="java.io.File"%>
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
        <title>product</title>
    </head>
    <body>


        <%
//            String uploadPath = getServletContext().getRealPath("")
//                + File.separator + "upload";
//            String filePath = uploadPath + File.separator + "hieu.png";
//
//            File f = new File(filePath);
//            f.delete();
            
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Product> listProduct = new ArrayList<>();
            listProduct = productDAO.getListProduct();
            
CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> listCategory = new ArrayList<>();
            listCategory = categoryDAO.getListCategory();
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 

                <div id="rightContent">
                    <h3 style="text-align: center">Sản phẩm</h3>
                    <a href="/shop/admin/insert_product.jsp">Thêm sản phẩm</a>

                    <table class="data">

                        <tr class="data">
                            <th class="data" width="30px"></th>
                            <th class="data">Mã sản phẩm</th>
                            <th class="data">Mã danh mục</th>
                            <th class="data">Tên sản phẩm</th>
                            <th class="data">Hình ảnh</th>
                            <th class="data">Giá</th>
                            <th class="data">Mô tả</th>
                            <th class="data" width="60px"></th>
                        </tr>
                    <%
                        int count = 0;
                        for (Product i : listProduct) {
                            count++;
                    %>
                    <tr class="data">
                        <td class="data"><%=count%></td>
                        <td class="data"><%=i.getProductID()%></td>
                        <td class="data"><%=i.getCategoryID()%>(<%=categoryDAO.getCategory(i.getCategoryID()).getCategoryName()%>)</td>
                        <td class="data"><%=i.getProductName()%></td>
                        <td class="data"><image width="200" src="../<%=i.getProductImage()%>"></td>
                        <td class="data"><%=i.getProductPrice()%></td>
                        <td class="data"><%=i.getProductDescription()%></td>
                        <td class="data">
                            <a href="/shop/admin/update_product.jsp?product_id=<%=i.getProductID()%>&category_id=<%=i.getCategoryID()%>&product_name=<%=i.getProductName()%>&product_price=<%=(int)i.getProductPrice()%>&product_description=<%=i.getProductDescription()%>&product_image=<%=i.getProductImage()%>">Sửa</a> |
                            <a href="/shop/ManagerProductServlet?command=delete&product_id=<%=i.getProductID()%>&product_image=<%=i.getProductImage()%>">Xóa</a>
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
