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
			
				<jsp:include page="layout/menu.jsp"/>
				
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

				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
						
							<div id="similar-product" class="carousel slide" data-ride="carousel">
								 
								 <s:set var="rowPrinted" value="0"/>
								 
								 <!-- Wrapper for slides -->
								 <div class="carousel-inner">
									<div class="item active">
										<img src="upload/sanpham/<s:text name='sanpham.hinhanh' />" width="27%">
										<s:if test = "#rowPrinted < dshinhanh.size()-1">
											<img src="upload/hinhanh/<s:text name='dshinhanh.get(#rowPrinted).hinhanh' />" width="27%">
											<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
										</s:if>
										<s:if test = "#rowPrinted < dshinhanh.size()-1">
											<img src="upload/hinhanh/<s:text name='dshinhanh.get(#rowPrinted).hinhanh' />" width="27%">
											<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
										</s:if>
									</div>
										
									<s:iterator var="hinh" value="dshinhanh">
									<s:if test="#rowPrinted <= dshinhanh.size()-1">
										<div class="item">
											<s:if test = "#rowPrinted <= dshinhanh.size()-1">
												<img src="upload/hinhanh/<s:property value='dshinhanh[#rowPrinted].hinhanh' />" width="27%">
												<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
											</s:if>
											<s:if test = "#rowPrinted <= dshinhanh.size()-1">
												<img src="upload/hinhanh/<s:property value='dshinhanh[#rowPrinted].hinhanh' />" width="27%">
												<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
											</s:if>
											<s:if test = "#rowPrinted <= dshinhanh.size()-1">
												<img src="upload/hinhanh/<s:property value='dshinhanh[#rowPrinted].hinhanh' />" width="27%">
												<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
											</s:if>
										</div>
									</s:if>
									</s:iterator>
										
								</div>

								  <!-- Controls -->
								  <a class="left item-control" href="#similar-product" data-slide="prev">
									<i class="fa fa-angle-left"></i>
								  </a>
								  <a class="right item-control" href="#similar-product" data-slide="next">
									<i class="fa fa-angle-right"></i>
								  </a>
							</div>
						
						
							<div class="view-product" id="img" >
								<img id="img_kq" src="upload/sanpham/<s:text name="sanpham.hinhanh" />" alt=""  style="height: auto; margin-top: 10px"/>
								<h3>ZOOM</h3>
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<!--/product-information-->
								<h2><s:text name="sanpham.ten" /></h2>
								<p>
									<b>ID:</b>
									<s:text name="sanpham.id" />
								</p>
								<p>
									<b>Tinh Trang:</b>
									<s:text name="sanpham.sl" />
								</p>
								<p>
									<b>HSX:</b>
									<s:text name="sanpham.hangsx" />
								</p>
								<p>
									<b>KM:</b>
									<s:text name="sanpham.km" />
								</p>

								<span><span> <s:text name="getText('{0,number,#,##0}',{sanpham.gia})" /> VNĐ</span> </span> <br>
								 
								<a target="_blank" href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="sanpham.id" />"> <img
									style="margin-bottom: 10px" src="images/sites/thanhtoan.png" />
								</a> 
								<a href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="sanpham.id" />"
									type="button" class="btn btn-fefault cart" style="color: #fff">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					
					<div class="category-tab shop-details-tab"><!--category-tab-->
					
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#details" data-toggle="tab">Chi tiết</a></li>
								<li><a href="#companyprofile" data-toggle="tab">
									<s:text name="sanpham.loaisp" /></a>
								</li>
								<li><a href="#tag" data-toggle="tab">
									<s:text name="sanpham.hangsx" /></a>
								</li>
								<li><a href="#reviews" data-toggle="tab">Bình luận</a></li>
							</ul>
						</div>
						
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details" >
								<div class="col-sm-12" style="padding: 5px">
									<p>
										<b>Display: </b><s:text name="sanpham.manhinh" /></p>
									<p>
										<b>OS: </b><s:text name="sanpham.hdh" /></p>
									<p>
										<b>CPU: </b><s:text name="sanpham.cpu" /></p>
									<p>
										<b>Camera: </b><s:text name="sanpham.camera" /></p>
									<p>
										<b>Pin: </b><s:text name="sanpham.pin" /></p>
									<p>
										<b>KM: </b><s:text name="sanpham.km" /></p>
									<p>
										<b>Other: </b><s:text name="sanpham.nhieuhon" /></p>
								</div>
								
							</div>
							
							<div class="tab-pane fade" id="companyprofile" >
							
								<s:iterator var="sp" value="dssanpham">
								<s:if test="#sp.loaisp == sanpham.loaisp">
									<div class="col-sm-3">
										<jsp:include page="layout/product-small.jsp"></jsp:include>
									</div>
								</s:if>
								</s:iterator>
							
							</div>
							
							<div class="tab-pane fade" id="tag" >
								<s:iterator var="sp" value="dssanpham">
								<s:if test="#sp.hangsx == sanpham.hangsx">
									<div class="col-sm-3">
										<jsp:include page="layout/product-small.jsp"></jsp:include>
									</div>
								</s:if>
								</s:iterator>
							</div>
							<s:text name=""></s:text>
							<div class="tab-pane fade active in" id="reviews" >
								<div class="col-sm-12">
									<div class="fb-comments" 
										data-href="http://www.thiensu.com/DAJAVA/?ac=sanpham&id=<s:text name="sanpham.id"></s:text>"
										data-colorscheme="light" data-numposts="5" data-width="100%"></div>
								</div>
							</div>
							
						</div>
					</div><!--/category-tab-->
					
					
					
					<jsp:include page="layout/product-recommend.jsp"></jsp:include>
					
					
					
				</div>

			</div>
		</div>
	</section>
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
	
</body>
</html>