<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
</head>
<body>

	<%
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		List<Product> ds = productDAOImpl.getListProduct();

		String page1 = "", page2 = "";
		int start = 0, end = 0;

		if (request.getParameter("start") == null) {
			start = 0;
			end = 9;
		} else {
			start = Integer.parseInt(request.getParameter("start"));
			end = Integer.parseInt(request.getParameter("end"));
		}

		List<Product> list = productDAOImpl.getListProductByPages(ds, start, end);
	%>

	<jsp:include page="header.jsp"></jsp:include>

	<section>
	<div class="container">
		<div class="row">
			<jsp:include page="category.jsp"></jsp:include>
			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Danh sách sản phẩm</h2>

					<%
						for (Product i : list) {
					%>

					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/shop/product12.jpg" alt="" />
									<h2>
										$<%=i.getPrice()%></h2>
									<p><%=i.getName()%></p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>
								<div class="product-overlay">
									<div class="overlay-content">
										<h2>
											$<%=i.getPrice()%></h2>
										<p><%=i.getName()%></p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
							</div>
							<div class="choose">
								<ul class="nav nav-pills nav-justified">
									<li><a href=""><i class="fa fa-plus-square"></i>Add to
											wishlist</a></li>
									<li><a href=""><i class="fa fa-plus-square"></i>Add to
											compare</a></li>
								</ul>
							</div>
						</div>
					</div>

					<%
						}
					%>

					<div class="clearfix"></div>

					<ul class="pagination">

						<%
							int a, b;
							int limit = ds.size() / 9;
							if (limit * 9 < ds.size())
								limit++;
							for (int i = 1; i <= limit; i++) {
								a = (i - 1) * 9;
								b = i * 9;
								if (b > ds.size()) {
									b = ds.size();
								}
						%>

						<li class="active"><a href="shop.jsp?start=<%=a%>&end=<%=b%>"><%=i%></a></li>

						<%
							}
						%>
					</ul>
				</div>
				<!--features_items-->
			</div>

		</div>
	</div>
	</section>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>