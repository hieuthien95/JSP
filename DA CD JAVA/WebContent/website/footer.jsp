<%@page import="java.util.ArrayList"%>
<%@page import="dao.LoaiSanPhamDAO"%>
<%@page import="model.LoaiSanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<LoaiSanPham> getAllLoaiSanPham = (ArrayList<LoaiSanPham>)new LoaiSanPhamDAO().getAllLoaiSanPham();
%>

<footer id="footer">
	<!--Footer-->
	<div class="footer-top" style="background: #f7f7f7">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-3">
					<div class="companyinfo wow fadeInLeft">
						<h2>
							<span>ICON</span>CLUB
						</h2>
						<p>Icon Club vận hành chuỗi bán lẻ là thientdt.esy.es
							trong những năm qua, công ty đã liên tục phát triển nhanh và ổn
							định bất chấp tình hình kinh tế thuận lợi hay khó khăn.</p>
					</div>
				</div>
				<div class="col-md-8 col-sm-9 wow fadeInRight">
					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/website/view/thanhtoan/VISA.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="glyphicon glyphicon-ok-circle"></i>
								</div>
							</a>
							<p>Ví điện tử</p>
							<h2>Hàng đầu</h2>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/website/view/thanhtoan/JCB.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="glyphicon glyphicon-ok-circle"></i>
								</div>
							</a>
							<p>Ngân Lượng</p>
							<h2>Thanh toán trực tuyến</h2>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/website/view/thanhtoan/MASTER.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="glyphicon glyphicon-ok-circle"></i>
								</div>
							</a>
							<p>Chuyển, rút tiền</p>
							<h2>Linh hoạt và dễ dàng</h2>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/website/view/thanhtoan/PayPal.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="glyphicon glyphicon-ok-circle"></i>
								</div>
							</a>
							<p>Chính sách thanh toán</p>
							<h2>An toàn tuyệt đối</h2>
						</div>
					</div>

					<div class="col-sm-2">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="/website/view/thanhtoan/MOL.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="glyphicon glyphicon-ok-circle"></i>
								</div>
							</a>
							<p>Chính sác hoàn trả</p>
							<h2>Đơn giản</h2>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="footer-widget wow fadeInLeft">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Sản phẩm</h2>
						<ul class="nav nav-pills nav-stacked">
							<%
								for (LoaiSanPham i : getAllLoaiSanPham) {
							%>
							<li><a
								href="./?command=ds-products&loaisp=<%=i.getTenloai()%>"><%=i.getTenloai()%></a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Tin tức</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="./?command=ds-news">Tin tức, bài viết</a></li>
							<li><a href="./?command=ds-videos">Video</a></li>
							<li><a href="./?command=ds-news?ac=km">Tin khuyến mãi</a></li>
							<li><a href="./?command=ds-news?ac=td">Tuyển dụng</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Chính sách</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Điều khoản công ty</a></li>
							<li><a href="#">Quyền riêng tư</a></li>
							<li><a href="#">Hoàn tiền khi lỗi</a></li>
							<li><a href="#">Hệ thống thanh toán</a></li>
							<li><a href="#">Hệ thống trả góp</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Icon Club</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Thông tin công ty</a></li>
							<li><a href="#">Tuyển dụng</a></li>
							<li><a href="#">Chi nhánh</a></li>
							<li><a href="#">Gửi góp ý, khiếu nại</a></li>
							<li><a href="#">Nhập tin nhanh từ email</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="single-widget">
						<h2>Vị trí công ty</h2>
						<div class="address">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.807620411301!2d106.63129986386193!3d10.749305162635302!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752e7e1e45851d%3A0x6a95474c2cfc9439!2zTDM2LzM5LzE5RCBDxrAgWMOhIFBow7ogTMOibSBBLCBwaMaw4budbmcgMTIsIFF14bqtbiA2LCBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1484496056233"
								width="100%" frameborder="0" style="border: 0" allowfullscreen></iframe>


						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="footer-bottom"
		style="background: url('website/view/images/sites/header.jpg');">
		<div class="container">
			<div class="row">
				<p class="pull-left" style="color: #fff">Copyright 2017</p>
				<p class="pull-right" style="color: #fff">
					Designed by <span><a target="_blank" href="thientdt.esy.esy"
						style="color: #fff">Hiếu Thiện</a></span>
				</p>
			</div>
		</div>
	</div>

</footer>
<!--/Footer-->

<script src="/website/js/jquery.js"></script>
<script src="/website/js/bootstrap.min.js"></script>
<script src="/website/js/price-range.js"></script>
<script src="/website/js/jquery.prettyPhoto.js"></script>

<script src="/website/js/main.js"></script>

<script src="website/js/my-jquery.zoom.js"></script>

