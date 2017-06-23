<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="tool.StringAction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>
<%@page import="model.Item"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<section style="margin-top: 30px">
		<div class="container">
			<div class="row">

				<jsp:include page="/website/menu.jsp"></jsp:include>
				
				<div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">
					<div class="features_items">
						<ul id='content'>
							<%
							

							String minmax = request.getParameter("minmax");
							if(minmax != null) {
								String arr[] = minmax.split(",");
								List<String> arrvl = Arrays.asList(arr);
								int min = Integer.parseInt(arrvl.get(0));
								int max = Integer.parseInt(arrvl.get(1));
								
								for(SanPham i: new SanPhamDAO().getAllSanPham(min, max)) {
								%>
								
								<li>
								<div class="col-lg-3 col-md-4 col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products" style="">
											<div class="productinfo text-center"
												style="padding: 10px; height: 100%">
												<img src="<%=i.getHinhanh()%>" alt="<%=i.getTen()%>" />
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia())%>đ
												</h2>
												<p><%=i.getTen()%></p>
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
							}
							
							else if (request.getParameter("loaisp") != null && request.getParameter("tenhang") != null) {
								for (SanPham i : new SanPhamDAO()
											.searchSanPham(request.getParameter("loaisp") + request.getParameter("tenhang"))) {
							%>
							<li>
								<div class="col-lg-3 col-md-4 col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products" style="">
											<div class="productinfo text-center"
												style="padding: 10px; height: 100%">
												<img src="<%=i.getHinhanh()%>" alt="<%=i.getTen()%>" />
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia())%>đ
												</h2>
												<p><%=i.getTen()%></p>
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
							}

							else if (request.getParameter("keyword") != null) {
								for (SanPham i : new SanPhamDAO().searchSanPham((String) request.getParameter("keyword"))) {
							%>
							<li>
								<div class="col-lg-3 col-md-4 col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products" style="">
											<div class="productinfo text-center"
												style="padding: 10px; height: 100%">
												<img src="<%=i.getHinhanh()%>" alt="<%=i.getTen()%>" />
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia())%>đ
												</h2>
												<p><%=i.getTen()%></p>
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
							}
							
							else if (request.getParameter("minmax") == null && request.getParameter("keyword") == null) {
								for (SanPham i : new SanPhamDAO().getAllSanPham()) {
							%>
							<li>
								<div class="col-lg-3 col-md-4 col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products" style="">
											<div class="productinfo text-center"
												style="padding: 10px; height: 100%">
												<img src="<%=i.getHinhanh()%>" alt="<%=i.getTen()%>" />
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia())%>đ
												</h2>
												<p><%=i.getTen()%></p>
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
							} 
							%>
						</ul>
						<div class="clearfix"></div>
						<input type='hidden' id='current_page' /> 
						<input type='hidden' id='show_per_page' />
						<div style="text-align: center; margin: 10px" id="page_navigation"></div>
						<!--2 <input>, <ul> id='content', <li>, id='page_navigation' của phân trang-->
		
					</div>
					<!--features_items-->
				</div>				
				
			</div>
		</div>
	</section>


	
<jsp:include page="so-sanh-fixed.jsp"></jsp:include>



