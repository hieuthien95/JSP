<%-- 
    Document   : product
    Created on : Dec 29, 2016, 11:48:22 AM
    Author     : hieut
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product</title>
    </head>
    <body>

        <%
            ProductDAO productDAO = new ProductDAO();
            long category_id = 0;
            if (request.getParameter("category") != null) {
                category_id = Long.parseLong(request.getParameter("category"));
            }

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            int pages = 0, firstResult = 0, maxResult = 0, total = 0;
            total = productDAO.countProductByCategory(category_id);
            if (request.getParameter("pages") != null) {
                pages = Integer.parseInt(request.getParameter("pages"));
                if (pages <= 0) {
                    pages = 1;
                }
            }
            if (total <= 8) {
                firstResult = 0;
                maxResult = total;
            } else {
                firstResult = (pages - 1) * 8;
                maxResult = 8;
            }
            ArrayList<Product> listProduct = productDAO.getListProductByPages(category_id, firstResult, maxResult);
        %>

        <jsp:include page ="header.jsp"></jsp:include>

            <div class="container">
                <div class="content">
                    <div class="content-top">
                        <h3 class="future">FEATURED</h3>
                        <div class="content-top-in">
                        <%
                            for (Product i : listProduct) {
                        %>
                        <div class="col-md-3 md-col">
                            <div class="col-md">
                                <a href="single.jsp?productID=<%=i.getProductID()%>"><img  src="<%=i.getProductImage()%>" alt="" /></a>	
                                <div class="top-content">
                                    <h5><a href="single.jsp?productID=<%=i.getProductID()%>"><%=i.getProductName()%></a></h5>
                                    <div class="white">
                                        <a href="CartServlet?command=plus&productID=<%=i.getProductID()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><span><%=i.getProductPrice()%></span><span>0</span></p>
                                        <div class="clearfix"></div>
                                    </div>

                                </div>							
                            </div>
                        </div>

                        <%
                            }
                        %>

                        <div class="clearfix"></div>
                    </div>
                </div>
                <!---->
                <ul class="start">
                    <li ><a href="products.jsp?category=<%=category_id%>&pages=<%=(pages - 1)%>"><i></i></a></li>
                                <%
                                    for (int i = 1; i <= (total / 8) + 1; i++) {
                                %>
                    <li class="arrow"><a href="products.jsp?category=<%=category_id%>&pages=<%=i%>"><%=i%></a></li>
                        <% }%>
                    <li ><a href="products.jsp?category=<%=category_id%>&pages=<%=(pages + 1)%>"><i  class="next"> </i></a></li>
                </ul>
            </div>
        </div>
        <jsp:include page ="footer.jsp"></jsp:include>
    </body>
</html>
