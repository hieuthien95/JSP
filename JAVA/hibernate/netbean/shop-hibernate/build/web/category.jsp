<%@page import="model.Category"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>
</head>
<body>

	<%
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
	%>

	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>Danh mục</h2>
			<div class="panel-group category-products" id="accordian">
				<!--category-productsr-->
				<div class="panel panel-default">

					<%
						for (Category i : categoryDAOImpl.getCategoryByParent()) {
					%>
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian"
								href="#<%=i.getName()%>"> <span class="badge pull-right"><i
									class="fa fa-plus"></i></span> <%=i.getName()%>
							</a>
						</h4>
					</div>
					<%
						if (categoryDAOImpl.getCategoryByChildren(i.getCategory_id()).size() > 0) {
					%>
					<div id="<%=i.getName()%>" class="panel-collapse collapse">
						<div class="panel-body">
							<ul>
								<%
									for (Category j : categoryDAOImpl.getCategoryByChildren(i.getCategory_id())) {
								%>
								<li><a href="/shop-hibernate/index.jsp?category_id=<%=j.getCategory_id()%>"><%=j.getName()%>
								</a></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
					<%
						}
						}
					%>
				</div>
			</div>
			<!--/category-products-->






			<div class="brands_products">
				<!--brands_products-->
				<h2>Brands</h2>
				<div class="brands-name">
					<ul class="nav nav-pills nav-stacked">
						<li><a href="#"> <span class="pull-right">(50)</span>Acne
						</a></li>
						<li><a href="#"> <span class="pull-right">(56)</span>Grüne
								Erde
						</a></li>
						<li><a href="#"> <span class="pull-right">(27)</span>Albiro
						</a></li>
						<li><a href="#"> <span class="pull-right">(32)</span>Ronhill
						</a></li>
						<li><a href="#"> <span class="pull-right">(5)</span>Oddmolly
						</a></li>
						<li><a href="#"> <span class="pull-right">(9)</span>Boudestijn
						</a></li>
						<li><a href="#"> <span class="pull-right">(4)</span>Rösch
								creative culture
						</a></li>
					</ul>
				</div>
			</div>
			<!--/brands_products-->

			<div class="price-range">
				<!--price-range-->
				<h2>Price Range</h2>
				<div class="well text-center">
					<input type="text" class="span2" value="" data-slider-min="0"
						data-slider-max="600" data-slider-step="5"
						data-slider-value="[250,450]" id="sl2"><br /> <b
						class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
				</div>
			</div>
			<!--/price-range-->

			<div class="shipping text-center">
				<!--shipping-->
				<img src="images/home/shipping.jpg" alt="" />
			</div>
			<!--/shipping-->

		</div>
	</div>

</body>
</html>