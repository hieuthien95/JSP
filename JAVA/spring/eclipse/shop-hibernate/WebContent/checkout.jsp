<%@page import="model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checkout</title>
</head>
<body>

	<%
		// giỏ hàng
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
	%>

	<jsp:include page="header.jsp"></jsp:include>

	<section id="cart_items">
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li class="active">Check out</li>
			</ol>
		</div>
		<!--/breadcrums-->

		<div class="shopper-informations">
			<div class="row">
				<div class="col-sm-3">
					<div class="shopper-info">
						<p>Thông tin giao hàng</p>
						<form action="CheckoutServlet" method="POST">
							<input type="text" placeholder="Địa chỉ giao hàng" name="dia_chi">
							<input type="text" placeholder="Điện thoại liên hệ"
								name="dien_thoai">
							<button type="submit" class="btn btn-primary">Xác nhận
								thanh toán</button>
							<input type="hidden" name="command" value="">
						</form>
						<a class="btn btn-primary" href="">Hũy mua hàng</a>
					</div>
				</div>
			</div>
		</div>
		<div class="review-payment">
			<h2>Thông tin đơn hàng</h2>
		</div>

		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
					<tr class="cart_menu">
						<td class="image">Sản phẩm</td>
						<td class="description">Mô tả</td>
						<td class="price">Giá</td>
						<td class="total">Tổng</td>
						<td></td>
					</tr>
				</thead>
				<tbody>

					<%
						for (Map.Entry<Long, Item> list : cart.getCartItems().entrySet()) {
					%>

					<tr>
						<td class="cart_product"><a href=""><img
								src="images/cart/one.png" alt=""></a></td>
						<td class="cart_description">
							<h4>
								<a href=""><%=list.getValue().getProduct().getName()%></a>
							</h4>
							<p>
								Web ID:
								<%=list.getValue().getProduct().getProduct_id()%></p>
						</td>
						<td class="cart_price">
							<p>
								$<%=list.getValue().getProduct().getPrice()%>
								x
								<%=list.getValue().getQuantity()%></p>
						</td>
						<td class="cart_total">
							<p class="cart_total_price">
								$<%=list.getValue().getProduct().getPrice() * list.getValue().getQuantity()%></p>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	</section>
	<!--/#cart_items-->

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>