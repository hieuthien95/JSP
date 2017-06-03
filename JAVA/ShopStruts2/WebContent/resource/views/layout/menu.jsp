<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
				<div class="col-sm-3">
					<div class="left-sidebar">
					
					<script type="text/javascript">
						function accc() {
							var vl = $("#sl2").data('slider').getValue();
							$('#minmaxvl').val(vl);
						}
					</script>
					
					<h2>Tìm theo giá</h2>
						<div class="price-range wow fadeInLeft">
							<!--price-range-->
							<form class="well text-center" action="/" method="get" style="width: 100%">
								<input type="hidden" name="command" value="ds-products">
								 
								<input type="text" class="span2" data-slider-min="100000"
									data-slider-max="100000000" data-slider-step="100000"
									data-slider-value="[100000,50000000]" id="sl2">
								<input type="hidden" name="minmax" id="minmaxvl">
								<br /> <b class="pull-left">100K</b> <b class="pull-right">100Tr</b>
								
								<button class="btn btn-default" style="margin-top: 10px" type="submit" 
									onclick="accc()">Lọc</button>
							</form>
						</div>
						<!--/price-range-->
		
		
						<h2>Danh mục</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							
							<s:iterator var="loai" value="dsloaisp">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#LSP<s:property value="#loai.id" />">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<s:property value="#loai.ten" />
										</a>
									</h4>
								</div>
								<div id="LSP<s:property value="#loai.id" />" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<s:iterator var="hang" value="dshangsx">
                                    		<s:if test="#hang.parent == #loai.id">
											<li><a href="${pageContext.request.contextPath}/product-list?keyword=<s:property value="#loai.ten + ' ' + #hang.ten" />"><s:property value="#hang.ten" /></a></li>
											</s:if>
											</s:iterator>
										</ul>
									</div>
								</div>
							</div>
							</s:iterator>
							
							<div class="panel panel-default" id="tintuc">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#Ldsnews"> <span class="badge pull-right"><i
												class="fa fa-plus"></i></span> Tin tức
										</a>
									</h4>
								</div>
								<div id="Ldsnews" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="${pageContext.request.contextPath}/bai-viet-list">Bài viết</a></li>
											<li><a href="${pageContext.request.contextPath}/video-list">Video</a></li>
										</ul>
									</div>
								</div>
							</div>
							
						</div><!--/category-products-->
						
						<div class="left-sidebar hidden-xs" id="tintuc">
							<!--brands_products-->
							<h2><a href="${pageContext.request.contextPath}/bai-viet-list">Bài viết</a></h2>
							<div class="brands-name wow fadeInLeft" style="padding: 0">
								<ul style="padding: 0; margin: 0">
									
									<s:set var="count" value="0" />
									<s:iterator var="i" value="dsbaiviet" >
									<s:if test="#count < 6">
										<s:set name="count" value="%{#count + 1}" />
										<li style="padding: 5px">
											<img src="upload/baiviet/<s:text name='#i.hinhanh' />" width="20%"/>
											<a href="${pageContext.request.contextPath}/xem-bai-viet?baiviet.id=<s:text name='#i.id' />" style="color: #000; padding-left: 5px">
												<s:text name="#i.tieude"></s:text>
											</a>
										</li>
									</s:if>
									</s:iterator>
								</ul>
							</div>
						</div>
						<!--/brands_products-->
						
						<div class="left-sidebar hidden-xs">
							<!--brands_products-->
							<h2 style="margin-top: 30px"><a href="${pageContext.request.contextPath}/video-list">Video</a></h2>
							<div class="brands-name wow fadeInLeft" style="padding: 0">
								<ul style="padding: 0; margin: 0">
									
									<s:set var="count" value="0" />
									<s:iterator var="i" value="dsvideo" >
									<s:if test="#count < 6">
										<s:set name="count" value="%{#count + 1}" />
										<li style="padding: 5px">
											<img src="upload/video/<s:text name='#i.hinhanh' />" width="20%"/>
											<a href="${pageContext.request.contextPath}/xem-video?video.id=<s:text name='#i.id' />" style="color: #000; padding-left: 5px">
												<s:text name="#i.ten"></s:text>
											</a>
										</li>
									</s:if>
									</s:iterator>
								</ul>
							</div>
						</div>
						
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
						
						<jsp:include page="facebook-fanpage.jsp"></jsp:include>
						
						
					
					</div>
				</div>