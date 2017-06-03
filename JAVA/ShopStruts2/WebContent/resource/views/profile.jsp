<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
<s:if test="#session.user !=null">
<s:set var="user" value="#session.user" />
	
<!DOCTYPE html>
<html lang="en">
<head>



    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>

<body>
	
	
	
	<jsp:include page="layout/header.jsp"/>

	<section style="margin-top: 30px">
		<div class="container">
			<div class="row">

				<div class="col-sm-12">
					<div class="category-tab shop-details-tab">
						<!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#change" data-toggle="tab">Thay
										đổi thông tin</a></li>
								<li><a href="#profile" data-toggle="tab">Cá nhân</a></li>
								<li><a href="#checkedout" data-toggle="tab">Đã thanh
										toán</a></li>
								<s:if test="#user.quyen !=  'Người dùng'">
								<li><a href="/admin">Trang quản lý</a></li>
								</s:if>
								<li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
							</ul>
						</div>
						<div class="tab-content">

							<div class="tab-pane fade active in" id="change"
								style="padding: 20px; text-align: center;">
								<div class="col-sm-8 col-sm-offset-2">
									<section id="form">
										<div class="signup-form">
											<!--update up form-->
											<img src="upload/taikhoan/<s:text name='#user.hinhanh' />" style="width: 50%; border-radius: 5000px; margin-bottom: 30px">
											<s:form action="change-info-process" method="post" enctype="multipart/form-data">
												<s:textfield name="user.email" placeholder="Email" value="%{#user.email}" readonly="true"/>
												<s:textfield name="user.name" placeholder="Name" value="%{#user.name}" />
												<s:textfield name="user.sdt" placeholder="Phone" value="%{#user.sdt}" />
												
												<s:file name="myFile" ></s:file>
												
												<s:password name="user.password" placeholder="Password" />
												<s:submit value="Update" />
											</s:form>
										</div>
									</section>
								</div>
							</div>

							<div class="tab-pane fade" id="profile"
								style="padding: 20px; text-align: center;">
								<div class="col-sm-12">

									<img src="upload/taikhoan/<s:text name='#user.hinhanh' />"
										style="width: 50%; border-radius: 5000px; margin-bottom: 30px">
									<h1>
										<b>Tên: </b><s:text name="#user.name" /></h1>
									<h4>
										<b>Điện thoại: </b><s:text name="#user.sdt" /></h4>
									<h4>
										<b>Email: </b><s:text name="#user.email" /></h4>
									<h4>
										<b>Quyền: </b><s:text name="#user.quyen" /></h4>
									<h4>
										<b>Điểm tích lũy: </b><s:text name="#user.diem" /></h4>

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

											<s:iterator var="i" value="dsdonhang">

											<tr>
												<td><h5><s:text name="#i.id"/></h5></td>
												<td><h5 style="color: #06F"><s:text name="getText('{0,number,#,##0}',{#i.gia})" />đ</h5></td>
												<td><h5 style="color: #06F"><s:text name="#i.sdt"/></h5></td>
												<td><h5><s:text name="#i.id"/></h5></td>
												<td><h5><s:text name="#i.magiaodich"/></h5></td>
												<td><h5><s:text name="#i.updated_at"/></h5></td>
											</tr>

											</s:iterator>

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

	<jsp:include page="layout/footer.jsp"/>

</body>
</html>

</s:if>


