<%@page import="java.util.ArrayList"%>
<%@page import="tool.StringAction"%>
<%@page import="dao.HinhAnhDAO"%>
<%@page import="model.HinhAnh"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String stt = request.getParameter("stt");
	if(stt != null) {
	
		SanPham sp = new SanPhamDAO().getSanPhamByStt(Integer.parseInt(stt));
		if(sp!=null) {
			// cap nhat luot xem
			sp.setLuotxem(sp.getLuotxem() + 1);
			new SanPhamDAO().update(sp);
%>

	<section style="margin-top: 30px">
		<div class="container">
			<div class="row">

				<jsp:include page="/website/menu.jsp"></jsp:include>

				<!-- script xử lý hình ảnh -->
				<script>
					$(document).ready(function() {
						
						// sự kiện zoom của id='img'
						$('#img').zoom({
							on : 'click'
						});
						
						// sự kiện bấm vô hình ảnh bất kỳ
						$('.item>img').on({
						    'click': function(){
						    	
						    	// thay doi hinh ảnh
						    	$('#img_kq').attr('src',$(this).attr('src'));
						    	
						    	// sự kiện zoom của id='img'
						    	$('#img').zoom({
									on : 'click'
								});
						    }
						});
						
					});
				</script>
				<!-- thêm jquery.zoom.js, jquery.min.js -->

				<div class="col-md-9 col-sm-8 padding-right">
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
						<%
						ArrayList<HinhAnh> dsHA = new HinhAnhDAO().getAllHinhAnhBySttSP(sp.getStt());
						if (dsHA != null) {
						%>
							<div id="similar-product" class="carousel slide"
								data-ride="carousel">

								<!-- Wrapper for slides -->
								<div class="carousel-inner">

									<%
									
										int i = 0 ;
									%>
									<div class="item active">
										<img src="<%=sp.getHinhanh()%>" width="27%"> 
									<% if(i <= dsHA.size()-1) {%>
										<img src="<%=dsHA.get(i++).getHinhAnh()%>" width="27%">
									<%} %>
									<% if(i <= dsHA.size()-1) {%>
										<img src="<%=dsHA.get(i++).getHinhAnh()%>" width="27%">
									<%} %>
									</div>

									<% 
									while (i <= dsHA.size()-1)  {
									%>
									<div class="item">
									<% if(i <= dsHA.size()-1) {%>
										<img src="<%=dsHA.get(i++).getHinhAnh()%>" width="27%">
									<%} %>
									<% if(i <= dsHA.size()-1) {%>
										<img src="<%=dsHA.get(i++).getHinhAnh()%>" width="27%">
									<%} %>
									<% if(i <= dsHA.size()-1) {%>
										<img src="<%=dsHA.get(i++).getHinhAnh()%>" width="27%">
									<%} %>
									</div>
									<%
									}
									
									
									%>
								</div>

								<!-- Controls -->
								<a class="left item-control" href="#similar-product"
									data-slide="prev"> <i class="fa fa-angle-left"></i>
								</a> <a class="right item-control" href="#similar-product"
									data-slide="next"> <i class="fa fa-angle-right"></i>
								</a>
							</div>
						
						<%} %>	
							
							<!-- đặt id ở đâu tùy ý, phải chứa hình ảnh cần zoom -->
							<div id="img" style="display: inline-block"
							
								class="view-product">
								<img id="img_kq" src="<%=sp.getHinhanh()%>" style="height: auto; margin-top: 10px"/>
								<h3 style="padding: 8px 10px"><i class="glyphicon glyphicon-search"></i></h3>
							</div>
							

						</div>
						<div class="col-sm-7">
							<div class="product-information">
								<!--/product-information-->
								<h2><%=sp.getTen()%></h2>
								<p>
									<b>ID:</b>
									<%=sp.getStt()%>
								</p>
								<p>
									<b>Tinh Trang:</b>
									<%=sp.getSl()%>
								</p>
								<p>
									<b>HSX:</b>
									<%=sp.getHangsx()%>
								</p>
								<p>
									<b>KM:</b>
									<%=sp.getKm()%>
								</p>

								<span><span> <%=StringAction.numberFormat(sp.getGia()) %>đ</span> </span> <br>
								 
								<a target="_blank" href="CartServlet?command=getnow&productID=<%=sp.getStt()%>"> <img
									style="margin-bottom: 10px" src="website/view/images/sites/thanhtoan.png" />
								</a> 
								<a href="CartServlet?command=plus&productID=<%=sp.getStt()%>"
									type="button" class="btn btn-fefault cart" style="color: #fff">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>

							</div>
							<!--/product-information-->
						</div>
					</div>
					<!--/product-details-->

					<div class="category-tab shop-details-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#details" data-toggle="tab">Chi
										tiết</a></li>
								<li><a href="#tag" data-toggle="tab"><%=sp.getLoaisp()%></a></li>
								<li><a href="#companyprofile" data-toggle="tab"><%=sp.getHangsx()%></a></li>
								<li><a href="#reviews" data-toggle="tab">Bình luận</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details">
								<div class="col-sm-12" style="padding: 5px">
									<p>
										<b>Display: </b><%=sp.getManhinh()%></p>
									<p>
										<b>OS: </b><%=sp.getHdh()%></p>
									<p>
										<b>CPU: </b><%=sp.getCpu()%></p>
									<p>
										<b>Camera: </b><%=sp.getCamera()%></p>
									<p>
										<b>Pin: </b><%=sp.getPin()%></p>
									<p>
										<b>KM: </b><%=sp.getKm()%></p>
									<p>
										<b>Other: </b><%=sp.getNhieuhon()%></p>
								</div>
							</div>

							<div class="tab-pane fade" id="companyprofile">
								<%
									for (SanPham i : new SanPhamDAO().searchSanPham(sp.getHangsx())) {
								%>

								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>">
													<img src="<%=i.getHinhanh()%>" alt="" style="width: 70%; padding: 5px" /></a>
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia()) %>
													VNĐ
												</h2>
												<p><%=i.getTen()%></p>
												<a href="CartServlet?command=plus&productID=<%=i.getStt()%>" class="btn btn-default add-to-cart">
													<i class="fa fa-shopping-cart"></i>Thêm
												</a>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>

							<div class="tab-pane fade" id="tag">

								<%
									for (SanPham i : new SanPhamDAO().getSanPhamByLoai(sp.getLoaisp())) {
								%>

								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>">
													<img src="<%=i.getHinhanh()%>" alt="" style="width: 70%; padding: 5px" /></a>
												<h2 style="font-size: 18px">
													<%=StringAction.numberFormat(i.getGia()) %>
													VNĐ
												</h2>
												<p><%=i.getTen()%></p>
												<a href="CartServlet?command=plus&productID=<%=i.getStt()%>" class="btn btn-default add-to-cart">
													<i class="fa fa-shopping-cart"></i>Thêm
												</a>
											</div>
										</div>
									</div>
								</div>
								<%
									}
								%>
							</div>

							<div class="tab-pane fade" id="reviews">
								<div class="col-sm-12">
									<!--
									<ul>
										<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
										<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
										<li><a href=""><i class="fa fa-calendar-o"></i>31 DEC
												2014</a></li>
									</ul>  
									-->
									<div class="fb-comments"
										data-href="http://www.thiensu.com/DAJAVA/?ac=sanpham&stt=<%=sp.getStt()%>"
										data-colorscheme="light" data-numposts="5" data-width="100%"></div>
								</div>
							</div>

						</div>
					</div>
					<!--/category-tab-->

					<!--recommend-products-->
					<jsp:include page="/website/recommend-products.jsp"></jsp:include>
					<!--/recommend-products-->

				</div>

			</div>
		</div>
	</section>
<%
	} else {response.sendRedirect("/");}
} else {response.sendRedirect("/");}
%>