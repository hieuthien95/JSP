<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="model.Item"%>
<%@page import="model.Cart"%>
<%@page import="model.User"%>
<%@page import="dao.HangSanXuatDAO"%>
<%@page import="model.HangSanXuat"%>
<%@page import="dao.LoaiSanPhamDAO"%>
<%@page import="model.LoaiSanPham"%>
<%@page import="dao.UserDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	User user = (User) session.getAttribute("user");

	Cart cart = (Cart) session.getAttribute("cart");
	
	ArrayList<LoaiSanPham> getAllLoaiSanPham = new LoaiSanPhamDAO().getAllLoaiSanPham();
	
	ArrayList<HangSanXuat> getAllHangSX = new HangSanXuatDAO().getAllHangSX();
	
	// cookie
    if(user == null) {
        String username = null, password = null;
    	Cookie []cookie = request.getCookies();
    	for(int i = 0; i<cookie.length; i++) {
    		if(cookie[i].getName().equals("username"))
    			username = cookie[i].getValue();
    		else if(cookie[i].getName().equals("password"))
    			password = cookie[i].getValue();
    	}
    	if(username!=null && password !=null) {
    		user = new UserDAO().login(username, password);
    		session.setAttribute("user", user);
    	}
    }
	
%>

<jsp:include page="head.jsp"></jsp:include>

<!-- vị trí hiển thị status sự kiện -->
<span id="scroll-status"></span>
<span id="mousemove-status"></span>

<header id="header">
	<!--header-->
	<div class="header_top"
		style="background: url('website/view/images/sites/header.jpg');">
		<!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-phone" style="color: #FFF"></i> 01653990370</a></li>
							<li><a href="http://www.thientdt.esy.es/congnghe/"
								style="color: #FFF"><i class="fa fa-envelope"
									style="color: #FFF"></i> Admin thientdt.esy.es</a></li>
						</ul>

					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-linkedin"></i></a></li>
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-dribbble"></i></a></li>
							<li><a href="#" style="color: #FFF"><i
									class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header_top-->

	<div class="header-middle" style="background: #F5F5F5">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-xs-12">
					<div class="logo pull-left">
						<a href="./"><img src="website/view/images/sites/logo.png"
							alt="" height="40" /></a>
					</div>

					<!-- Tìm kiếm -->

					<script type="text/javascript" src="/website/js/my-tim-kiem.js"></script>
					<!-- kem theo file search.jsp -->
					
					<form action="/" method="get" name="frmSearch"
						style="position: relative;" class="hidden-xs">
						<div class="search_box pull-right">
							<input type="text" name="keyword" autocomplete="off"
								placeholder="Tìm kiếm" onkeyup="search()"
								value="<%if (request.getParameter("keyword") != null) { out.print(request.getParameter("keyword"));}%>" />
							<input name="command" type="hidden" value="ds-products">
						</div>

						<!-- nơi hiện kết quả -->
						<span
							style="position: absolute; right: 0; background: #FFF; z-index: 9999; top: 40px; box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);"
							id="valueSearch"> </span>
					</form>


					<!-- /tìm kiếm -->
				</div>
				<div class="col-sm-6 col-xs-12" style="padding: 0">

					<div class="shop-menu pull-right">

						<!-- Tìm kiếm -->

						<form action="/" method="get"
							class="visible-xs col-xs-12">
							<div class="input-group">
								<input type="text" class="form-control" name="keyword"
									style="margin-top: 10px;"
									value="<%if (request.getParameter("keyword") != null) {out.print(request.getParameter("keyword"));}%>" />
								<input name="command" type="hidden" value="ds-products">
								<span class="input-group-btn"> <input type="submit"
									class="btn btn-default" value="Tìm" style="margin-top: 10px;" />
								</span>
							</div>
						</form>

						<!-- /tìm kiếm -->

						<ul class="nav navbar-nav">
							<%
								if (cart != null && cart.countItem()>0) {
							%>
							<li><a href="./checkout.jsp"><i class="fa fa-crosshairs"></i>
									Thanh toán</a></li>
							<li><a href="./cart.jsp"><i class="fa fa-shopping-cart"></i>
									Giỏ hàng(<%=cart.countItem()%>)</a></li>

							<%
								}
							%>
                                                        
                                                        
                                                        <%
								if (user != null) {
							%>
							<li><a href="./profile.jsp"> <i class="fa fa-user"></i>
									<%=user.getTen()%></a></li>
							<%
								} else {
							%>
							<li><a href="./login.jsp"><i class="fa fa-lock"></i>
									Đăng nhập</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle-->

	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="hidden-xs">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="./#sanpham">Sản phẩm</a></li>
							<%
								for (LoaiSanPham i : getAllLoaiSanPham) {
							%>
									<li class="dropdown"><a
										href="./?command=ds-products&tenhang=&loaisp=<%=i.getTenloai()%>"><%=i.getTenloai()%><i
											class="fa fa-angle-down"></i></a>
										<ul role="menu" class="sub-menu">
											<%
											for (HangSanXuat j : getAllHangSX) {
												String []arr = j.getSttloaisp().split(",");
												for(int k = 0; k < arr.length; k++){
													if(arr[k].equalsIgnoreCase(i.getStt()+"")) {
											%>
														<li> <a href="./?command=ds-products&tenhang=<%=j.getTenHang()%>&loaisp=<%=i.getTenloai()%>"><%=j.getTenHang()%></a></li>
											<%
													}
												}
											}
											%>
										</ul>
									</li>
							<%
								}
							%>


							<li class="dropdown hidden-sm"><a href="./#tintuc">Tin tức<i
									class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu">
									<li><a href="./?command=ds-news">Bài viết</a></li>
									<li><a href="./?command=ds-videos">Video</a></li>
								</ul></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!--/header-bottom-->
</header>
<!--/header-->




<!-- thêm jquery.min.js -->
<script type="text/javascript">
	$(window).scroll(function() {
		if ($(this).scrollTop() > 132) {
			$('#task_flyout').css("top", "0");
			$('#task_flyout').css("position", "fixed");
			$('#task_flyout').css("z-index", "99999");
			$('#task_flyout').css("display", "block");
			$('#task_flyout').css("width", $("#header").width());
			$('.header-bottom').css("padding-top", "8px");
			$('.header-bottom').css("padding-bottom", "0");
		} else {
			$('#task_flyout').css("display", "none");
			$('.header-bottom').css("padding-top", "30px");
			$('.header-bottom').css("padding-bottom", "20px");
		}
		

		if ($("#header").width() < 768) {
			$('#task_flyout').css("display", "none");
			$('.header-bottom').css("display", "none");
		}

	});
	

	
	// sự kiện chút chơi
	// $(window).scroll(function() {
	// 	var st = $(window).scrollTop();
	//	var sb = $(document).height() - $(window).height() - $(window).scrollTop();
	//	$('#scroll-status').replaceWith('<span id="scroll-status" style="position: fixed; right:0; bottom: 40px;">Top: ' + st + '<br>Bottom: ' + sb + '</span>');
	// });
	
	$(window).mousemove(function(event) {
		$('#mousemove-status').replaceWith("<span id='mousemove-status' style='position: fixed; right:0; bottom: 80px;'>X: " + event.pageX + "<br>Y: " + event.pageY + "</span>");;
        // $("#mousemove-status").text(event.pageX + ", " + event.pageY);
        
        var st = $(window).scrollTop();
		var sb = $(document).height() - $(window).height() - $(window).scrollTop();
		$('#scroll-status').replaceWith("<span id='scroll-status' style='position: fixed; right:0; bottom: 40px;'>T: " + st + "<br>B: " + sb + "</span>");
	});
	
</script>
<style>
/*.fixed {position:fixed; top:0}*/
#task_flyout {
	display: none
}
</style>

<header id="task_flyout">
	<div class="header-bottom hidden-xs wow fadeInDown"
		style="background: #FBFBFB; box-shadow: 4px 3px 10px rgba(0, 0, 0, 0.1)">
		<!--header-bottom-->
		<div class="container">
			<div class="row" >
				<div class="mainmenu">
					<ul class="nav navbar-nav collapse navbar-collapse">
						<li><a href="#sanpham">Sản phẩm</a></li>
						<%
							for (LoaiSanPham i : getAllLoaiSanPham) {
						%>
						<li class="dropdown"><a
							href="./?command=ds-products&tenhang=&loaisp=<%=i.getTenloai()%>"><%=i.getTenloai()%><i
								class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu">
								<%
									for (HangSanXuat j : getAllHangSX) {
								%>
								<li><a
									href="./?command=ds-products&tenhang=<%=j.getTenHang()%>&loaisp=<%=i.getTenloai()%>"><%=j.getTenHang()%></a></li>
								<%
									}
								%>

							</ul></li>
						<%
							}
						%>


						<li class="dropdown hidden-sm"><a href="#tintuc">Tin tức<i
								class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu">
								<li><a href="./?command=ds-news">Tin tức</a></li>
								<li><a href="../?command=ds-videos">Video</a></li>
							</ul></li>

					</ul>
				</div>

			</div>
		</div>
	</div>
</header>
<!--/header-->












				<div class="clearfix"></div>
				<%if(session.getAttribute("success")!=null) { %>
					<div class="alert alert-success" align="center">
						<%=session.getAttribute("success") %>
						<% session.removeAttribute("success"); %>
					</div>
				<%} %>
				
				<%if(session.getAttribute("error")!=null) { %>
					<div class="alert alert-danger" align="center">
						<%=session.getAttribute("error") %>
						<% session.removeAttribute("error"); %>
					</div>
				<%} %>
				<div class="clearfix"></div>
