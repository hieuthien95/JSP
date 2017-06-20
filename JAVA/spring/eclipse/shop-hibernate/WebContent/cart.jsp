<%@page import="model.Item"%>
<%@page import="model.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="model.Product"%>
<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
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
				<li class="active">Shopping Cart</li>
			</ol>
		</div>
		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
					<tr class="cart_menu">
						<td class="image">Sản phẩm</td>
						<td class="description">Mô tả</td>
						<td class="price">Giá</td>
						<td class="quantity">Số lượng</td>
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
								$<%=list.getValue().getProduct().getPrice()%></p>
						</td>
						<td class="cart_quantity">
							<div class="cart_quantity_button">
								<a class="cart_quantity_up" href="CartServlet?command=plus&productID=<%=list.getValue().getProduct().getProduct_id()%>"> + </a> <input
									class="cart_quantity_input" type="text" name="quantity"
									value="<%=list.getValue().getQuantity()%>" off" size="2">
							</div>
						</td>
						<td class="cart_total">
							<p class="cart_total_price">
								$<%=list.getValue().getProduct().getPrice()*list.getValue().getQuantity()%></p>
						</td>
						<td class="cart_delete"><a class="cart_quantity_delete"
							href="CartServlet?command=removeItem&productID=<%=list.getValue().getProduct().getProduct_id()%>"><i
								class="fa fa-times"></i></a></td>
					</tr>


					<tr>
						<td><a class="btn btn-default update" href="index.jsp">Tiếp
								tục mua hàng</a></td>
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

	<section id="do_action">
	<div class="container">
		<div class="heading">
			<h3>What would you like to do next?</h3>
			<p>Choose if you have a discount code or reward points you want
				to use or would like to estimate your delivery cost.</p>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="chose_area">
					<ul class="user_option">
						<li><input type="checkbox"> <label>Use Coupon
								Code</label></li>
						<li><input type="checkbox"> <label>Use Gift
								Voucher</label></li>
						<li><input type="checkbox"> <label>Estimate
								Shipping & Taxes</label></li>
					</ul>
					<ul class="user_info">
						<li class="single_field"><label>Country:</label> <select>
								<option>United States</option>
								<option>Bangladesh</option>
								<option>UK</option>
								<option>India</option>
								<option>Pakistan</option>
								<option>Ucrane</option>
								<option>Canada</option>
								<option>Dubai</option>
						</select></li>
						<li class="single_field"><label>Region / State:</label> <select>
								<option>Select</option>
								<option>Dhaka</option>
								<option>London</option>
								<option>Dillih</option>
								<option>Lahore</option>
								<option>Alaska</option>
								<option>Canada</option>
								<option>Dubai</option>
						</select></li>
						<li class="single_field zip-field"><label>Zip Code:</label> <input
							type="text"></li>
					</ul>
					<a class="btn btn-default update" href="">Get Quotes</a> <a
						class="btn btn-default check_out" href="">Continue</a>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="total_area">
					<ul>
						<li>Cart Sub Total <span>$59</span></li>
						<li>Eco Tax <span>$2</span></li>
						<li>Shipping Cost <span>Free</span></li>
						<li>Total <span>$61</span></li>
					</ul>
					<a class="btn btn-default check_out" href="checkout.jsp">Thanh toán</a>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--/#do_action-->



	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>