<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>



    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>

<body>
	
	
	
	<jsp:include page="layout/header.jsp"/>
	
	
	
	<section>
		<div class="container">
			<div class="row">
			
			<s:if test="#session.compare !=null && #session.compare.countItem() == 2">
			<s:iterator var="sp" value="#session.compare.getDsItem().entrySet()">
			<s:set var="sanpham" value="#sp.getValue().getProduct()"></s:set>

				<div class="col-sm-6 padding-right">
					<img src="upload/sanpham/<s:text name="#sanpham.hinhanh"/>" style="width: 60%" />
					
					<div class="product-details">
						<div class="col-sm-12">
							<div class="product-information">
							
								<h2><s:text name="#sanpham.ten"/></h2>
								<p>
									<b>ID:</b>
									<s:text name="#sanpham.id"/>
								</p>
								<p>
									<b>Tinh Trang:</b>
									<s:text name="#sanpham.sl"/>
								</p>
								<p>
									<b>HSX:</b>
									<s:text name="#sanpham.hangsx"/>
								</p>
								<p>
									<b>KM:</b>
									<s:text name="#sanpham.km"/>
								</p>

								<span> <span><s:property value="getText('{0,number,#,##0}',{#sanpham.gia})" /> VNĐ</span>
								</span>  <br>
								<a target="_blank" href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="#sanpham.id" />"> <img
									style="margin-bottom: 10px"
									src="images/sites/thanhtoan.png" />
								</a> <a href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="#sanpham.id" />"
									type="button" class="btn btn-fefault cart" style="color: #fff">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>
							</div>
						</div>

					</div>
					<!--/product-details-->

					<div class="category-tab shop-details-tab">
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details">
								<div class="col-sm-12" style="padding: 5px">
									<p>
										<b>Display: </b><s:text name="#sanpham.manhinh"/></p>
									<p>
										<b>OS: </b><s:text name="#sanpham.hdh"/></p>
									<p>
										<b>CPU: </b><s:text name="#sanpham.cpu"/></p>
									<p>
										<b>Camera: </b><s:text name="#sanpham.camera"/></p>
									<p>
										<b>Pin: </b><s:text name="#sanpham.pin"/></p>
									<p>
										<b>KM: </b><s:text name="#sanpham.km"/></p>
									<p>
										<b>Other: </b><s:text name="#sanpham.nhieuhon"/></p>
								</div>
							</div>

						</div>

						<div class="col-sm-12">
						hinh anh san pham
						</div>
					</div>

				</div>
			</s:iterator>
			</s:if>
			
			</div>
		</div>
	</section>
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
	
</body>
</html>