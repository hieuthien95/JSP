<%@page import="java.util.ArrayList"%>
<%@page import="tool.StringAction"%>
<%@page import="dao.LoaiSanPhamDAO"%>
<%@page import="model.LoaiSanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	@SuppressWarnings("unchecked")
	ArrayList<SanPham> getNewSanPham = (ArrayList<SanPham>)request.getAttribute("getNewSanPham");

	@SuppressWarnings("unchecked")
	ArrayList<SanPham> getAllSanPham = (ArrayList<SanPham>)request.getAttribute("getAllSanPham");

	@SuppressWarnings("unchecked")
	ArrayList<LoaiSanPham> getAllLoaiSanPham = (ArrayList<LoaiSanPham>)request.getAttribute("getAllLoaiSanPham");
%>

<meta charset="UTF-8">
<div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">

	<div class="features_items">
		<!--features_items-->
		<h2 class="title text-center">Sản phẩm mới</h2>

		<ul id='content'>
			<% 	int count =0;
				for (SanPham i : getNewSanPham) {
			%>
			<li>
				<div class="col-lg-3 col-md-4 col-sm-4 <%=++count<=24?" wow fadeInRight":""%>">
					<div class="product-image-wrapper">
						<div class="single-products" style="">
							<div class="productinfo text-center"
								style="padding: 10px; height: 100%">
								<img src="<%=i.getHinhanh()%>" alt="<%=i.getTen()%>"
									style="width: 80%" />
								<h2 style="font-size: 18px"><%=StringAction.numberFormat(i.getGia())%>đ
								</h2>
								<p><%=i.getHangsx() + " " + i.getTen()%></p>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<p>
										<b>Display: </b><%=i.getManhinh()%></p>
									<p>
										<b>OS: </b><%=i.getHdh()%></p>
									<p>
										<b>CPU: </b><%=i.getCpu()%></p>
									<p>
										<b>Camera: </b><%=i.getCamera()%></p>
									<p>
										<b>Pin: </b><%=i.getPin()%></p>
									<p>
										<b>KM: </b><%=i.getKm()%></p>
								</div>
							</div>
						</div>
						<div class="choose">
							<ul class="nav nav-pills nav-justified">
								<li><a
									href="CartServlet?command=plus&productID=<%=i.getStt()%>"><i
										class="fa fa-shopping-cart"></i>Thêm</a></li>
								<li><a
									href="CompareServlet?command=plus&productID=<%=i.getStt()%>"><i
										class="fa fa-plus-square"></i>So sánh</a></li>
								<li><a
									href="/?command=tt-san-pham&stt=<%=i.getStt()%>">o
										o o</a></li>
							</ul>
						</div>
					</div>
				</div>
			</li>
			<%
				}
			%>
		</ul>
		
		<div class="clearfix"></div>
		<input type='hidden' id='current_page' /> 
		<input type='hidden' id='show_per_page' />
		<div style="text-align: center; margin-bottom: 20px" id="page_navigation" class="wow fadeInRight"></div>
		<!--2 <input>, <ul> id='content', <li>, id='page_navigation' của phân trang-->
		
	</div>
	<!--features_items-->

	
	<div class="category-tab" id = "sanpham">
		<!--category-tab-->
		<div class="col-sm-12">
			<ul class="nav nav-tabs wow fadeInRight">
				<%
					count = 0;
					for (LoaiSanPham i : getAllLoaiSanPham) {
				%>
				<li class="<%if (++count == 1)
					out.print("active");%>"><a
					href="#<%=i.getStt()%>" data-toggle="tab"><%=i.getTenloai()%></a>
				</li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="tab-content">
			<%
				count = 0;
				for (LoaiSanPham i : getAllLoaiSanPham) {
					int countTmp = 0;
			%>
			<div
				class="tab-pane fade <%if (++count == 1)
					out.print(" active in");%>"
				id="<%=i.getStt()%>">
				<%
					for (SanPham p : getAllSanPham)
							if (p.getLoaisp().equals(i.getTenloai())) {
								if (countTmp++ == 12)
									break;
				%>
				<div class="col-lg-3 col-md-4 col-sm-6 <%=count==1?" wow fadeInLeft":""%>">
					<div class="product-image-wrapper">
						<div class="single-products" style="">
							<div class="productinfo text-center"
								style="padding: 10px; height: 100%">
								<img src="<%=p.getHinhanh()%>" alt="<%=p.getTen()%>"
									style="width: 70%" />
								<h2 style="font-size: 18px"><%=StringAction.numberFormat(p.getGia())%>đ
								</h2>
								<p><%=p.getHangsx() + " " + p.getTen()%></p>
								<a href="CartServlet?command=plus&productID=<%=i.getStt()%>"
									class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Thêm </a> <a
									class="btn btn-default add-to-cart"
									href="/?command=tt-san-pham&stt=<%=p.getStt()%>">
									o o o </a>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<p>
										<b>Display: </b><%=p.getManhinh()%></p>
									<p>
										<b>OS: </b><%=p.getHdh()%></p>
									<p>
										<b>CPU: </b><%=p.getCpu()%></p>
									<p>
										<b>Camera: </b><%=p.getCamera()%></p>
									<p>
										<b>Pin: </b><%=p.getPin()%></p>
									<p>
										<b>KM: </b><%=p.getKm()%></p>
									<a href="CartServlet?command=plus&productID=<%=p.getStt()%>"
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Thêm </a> <a
										class="btn btn-default add-to-cart"
										href="/?command=tt-san-pham&stt=<%=p.getStt()%>">
										o o o </a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>

			</div>
			<%
				}
			%>

		</div>
	</div>
	<!--/category-tab-->

	<!--recommend-products-->
	<jsp:include page="recommend-products.jsp"></jsp:include>
	<!--/recommend-products-->

</div>