<%@page import="tool.StringAction"%>
<%@page import="dao.DonHangDAO"%>
<%@page import="model.DonHang"%>
<%@page import="model.User"%>
<%@page import="dao.HinhAnhDAO"%>
<%@page import="model.HinhAnh"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("./login.jsp");
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<title><%=user.getTen()%></title>
<link rel="icon" href="/website/view/images/sites/ICON1.png"/>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<jsp:include page="website/header.jsp"></jsp:include>

	<section style="margin-top: 30px">
		<div class="container">
			
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="/">Home</a></li>
					<li class="active">Trang cá nhân</li>
				</ol>
			</div><!--/breadcrums-->
		
			<div class="row">

				<div class="col-sm-12">
					<div class="category-tab shop-details-tab" style="margin: 0">
						<!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#change" data-toggle="tab">Thay
										đổi thông tin</a></li>
								<li><a href="#profile" data-toggle="tab">Cá nhân</a></li>
								<li><a href="#checkedout" data-toggle="tab">Đã thanh
										toán</a></li>
								<%
									if (user.getQuyen().equalsIgnoreCase("admin") || user.getQuyen().equals("nhân viên")) {
								%>
								<li><a href="/admin">Trang quản lý</a></li>
								<%
									}
								%>
								<li><a href="UserServlet?command=logout">Đăng xuất</a></li>
							</ul>
						</div>
						<div class="tab-content">

							<div class="tab-pane fade active in" id="change"
								style="padding: 20px; text-align: center;">
								<div class="col-sm-8 col-sm-offset-2">
									<section id="form">
										<div class="signup-form">
											<!--update up form-->
											<form action="UserServlet?command=update" method="POST"
												enctype="multipart/form-data">
												<img src="<%=user.getAvatar()%>"
													style="width: 30%; border-radius: 500px; margin-bottom: 30px">

												<input name="username" type="text"
													value="<%=user.getUsername()%>" readonly="readonly" /> <input
													name="quyen" type="text" value="<%=user.getQuyen()%>"
													readonly="readonly" /> <br> <input name="ten"
													type="text" value="<%=user.getTen()%>" /> <input
													name="sdt" type="tel" value="<%=user.getSdt()%>" /> <input
													name="email" type="email" value="<%=user.getEmail()%>" />
												<input name="avatar" type="file" /> <input name="password"
													type="password" placeholder="Password" />
												<%
													String error = (String) session.getAttribute("error");
														session.removeAttribute("error");
														if (error != null)
															out.print(error);
												%>
												<br> <input name="newpassword" type="password"
													placeholder="New password" /> <input name="repassword"
													type="password" placeholder="Conform password" />


												<button type="submit" class="btn btn-default">Xác nhận</button>

											</form>
										</div>
									</section>
								</div>
							</div>

							<div class="tab-pane fade" id="profile"
								style="padding: 20px; text-align: center;">
								<div class="col-sm-12">

									<%
										if (user != null) {
									%>

									<img src="<%=user.getAvatar()%>"
										style="width: 50%; border-radius: 5000px; margin-bottom: 30px">
									<h1>
										<b>Tên: </b><%=user.getTen()%></h1>
									<h2>
										<b>Username: </b><%=user.getUsername()%></h2>
									<h4>
										<b>Điện thoại: </b><%=user.getSdt()%></h4>
									<h4>
										<b>Email: </b><%=user.getEmail()%></h4>
									<h4>
										<b>Quyền: </b><%=user.getQuyen()%></h4>
									<h4>
										<b>Điểm tích lũy: </b><%=user.getDiemTichTuy()%></h4>

									<%
										}
									%>
								</div>
							</div>

							<div class="tab-pane fade" id="checkedout">
								<div style="padding: 20px">
									<table class="table table-condensed">
										<thead>
											<tr class="cart_menu">
												<td><h5>Stt</h5></td>
												<td><h5>Giá</h5></td>
												<td><h5>Sđt</h5></td>
												<td><h5>Ghi chú</h5></td>
												<td><h5>Mã giao dịch</h5></td>
												<td><h5>Thời gian</h5></td>
											</tr>
										</thead>
										<tbody>

											<%
												if (new DonHangDAO().getAllDonHangBySdt(user.getSdt()) != null)
														for (DonHang i : new DonHangDAO().getAllDonHangBySdt(user.getSdt())) {
											%>

											<tr>
												<td><h5><%=i.getStt()%></h5></td>
												<td><h5 style="color: #06F"><%=StringAction.numberFormat(i.getGia()) %>đ</h5></td>
												<td><h5 style="color: #06F"><%=i.getSdt()%></h5></td>
												<td><h5><%=i.getGhiChu()%></h5></td>
												<td><h5><%=i.getMaGiaoDich()%></h5></td>
												<td><h5><%=i.getThoiGian()%></h5></td>
											</tr>

											<%
												}
											%>

										</tbody>
									</table>
								</div>

							</div>

						</div>
					</div>
					<!--/category-tab-->

				</div>
			</div>
		</div>
	</section>

	<jsp:include page="website/footer.jsp"></jsp:include>

</body>
</html>
<%} %>
