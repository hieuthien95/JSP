<%@page import="java.util.Map"%>
<%@page import="tool.StringAction"%>
<%@page import="model.User"%>
<%@page import="model.Item"%>
<%@page import="model.Cart"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	User user = (User) session.getAttribute("user");
	
	Cart cart = (Cart)session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<head>
<title>Thanh toán</title>
<link rel="icon" href="/website/view/images/sites/ICON1.png"/>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

	<jsp:include page="website/header.jsp"></jsp:include>

	<section id="cart_items" style="margin-top: 30px">
		<div class="container">
			<div class="step-one">
				<h2 class="heading">Bước 1</h2>
			</div>
			
			<%
				if (user == null) {
			%>
			
			<section id="form">
				<!--form-->
				<div class="container">
				
					<div class="breadcrumbs">
						<ol class="breadcrumb">
							<li><a href="/">Home</a></li>
							<li class="active">Thanh toán</li>
						</ol>
					</div><!--/breadcrums-->
					
					<div class="row">
						<div class="col-sm-4 col-sm-offset-1">
							<div class="login-form">
								<!--login form-->
								
								<form action="UserServlet" method="POST">
									<input type="text" placeholder="Username" name="username" /> 
									<input type="password" placeholder="Password" name="password" /> 
									<button name="command" type="submit" value="login" class="btn btn-default">Đăng nhập</button>
								</form>
								
							</div>
							<!--/login form-->
						</div>
						
					</div>
				</div>
			</section>
			
			<div class="register-req">
				<p>Hãy đăng nhập hoặc <a href="./login.jsp"> đăng ký </a> để được tích lũy điểm và lịch sử giao dịch</p>
			</div>
			
			<%} else {out.print("Đăng nhập thành công");} %>
			
			
			<div class="step-one">
				<h2 class="heading">Bước 2 (*)</h2>
			</div>
			
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Sản phẩm</td>
							<td class="description"></td>
							<td class="price">Giá</td>
							<td class="quantity">Số lượng</td>
							<td class="total">Tổng</td>
							<td>Xóa</td>
						</tr>
					</thead>
					<tbody>
					
					<%
						if(cart!=null) {
                        	for (Map.Entry<Long, Item> i : cart.getCartItems().entrySet()) {
					%>
						<tr>
							<td class="cart_product"><a href=""><img
									src="<%=i.getValue().getProduct().getHinhanh() %>" alt="" height="40"></a></td>
							<td class="cart_description">
								<h4>
									<a href="/?command=tt-san-pham&&stt=<%=i.getValue().getProduct().getStt()%>"><%=i.getValue().getProduct().getTen() %></a>
								</h4>
								<p>Mã: <%=i.getValue().getProduct().getStt() %></p>
							</td>
							<td class="cart_price">
								<p><%=StringAction.numberFormat(i.getValue().getProduct().getGia()) %>đ</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="CartServlet?command=plus&productID=<%=i.getValue().getProduct().getStt()%>"> + </a> <input
										class="cart_quantity_input" type="text" name="quantity"
										value="<%=i.getValue().getQuantity()%>" autocomplete="off" size="2"> <a
										class="cart_quantity_down" href="CartServlet?command=sub&productID=<%=i.getValue().getProduct().getStt()%>"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price"><%=StringAction.numberFormat(i.getValue().getProduct().getGia()) %>đ</p>
							</td>
							<td class="cart_delete"><a class="cart_quantity_delete"
								href="CartServlet?command=remove&productID=<%=i.getValue().getProduct().getStt()%>"><i class="fa fa-times"></i></a></td>
						</tr>
						
						<%} %>
						
						
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr class="shipping-cost">
										<td>Phí giao hàng</td>
										<td>Miễn phí</td>										
									</tr>
									<tr>
										<td>Tổng tiền</td>
										<td><span><%=StringAction.numberFormat((long)cart.total()) %>đ</span></td>
									</tr>
									<tr>
										<td>
											<a href="/CheckoutServlet?command=insert">
												<img src="website/view/images/sites/thanhtoan.png" />
											</a>
										<td>
									</tr>
								</table>
							</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!--/#cart_items-->

	<jsp:include page="website/footer.jsp"></jsp:include>

</body>
</html>
