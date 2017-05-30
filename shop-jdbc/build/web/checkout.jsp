<%-- 
    Document   : checkout
    Created on : Dec 31, 2016, 11:57:57 AM
    Author     : hieut
--%>

<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>

        <% 
            Users users = (Users) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("/shop/login.jsp");
            }
        %>
        <jsp:include page ="header.jsp"></jsp:include>
            <div class="container">
                <div class="account">
                    <h2 class="account-in">Checkout</h2>
                    <form method="POST" action="CheckoutServlet">
                        <div>
                            <span>Address *</span>
                            <input type="text" name="address">
                        </div> 	
                        <div> 
                            <span class="word">Payment *</span>
                            <select name="payment">
                                <option value="Bank transfer" selected="true">Bank transfer</option>
                                <option value="Live">Live</option>
                            </select>
                        </div>	
                        <input type="submit" value="checkout"> 
                    </form>
                </div>
            </div>
        <jsp:include page ="footer.jsp"></jsp:include>
    </body>
</html>
