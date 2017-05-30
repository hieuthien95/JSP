<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Sản phẩm mới</h2>
						
						<s:set var="rowPrinted" value="0"/>
						<s:iterator var="sp" value="dssanpham">
							<s:if test="#rowPrinted < 24 && #sp.loaisp != 'Phụ kiện'">
								<div class="col-sm-4">
									<jsp:include page="product-big.jsp"/>
								</div>
								<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>	
							</s:if>					
						</s:iterator>
						
					</div><!--features_items-->
					
					<div class="category-tab" id = "sanpham"><!--category-tab-->
						<div class="col-sm-12 wow fadeInRight">
							<ul class="nav nav-tabs">
								<s:set var="rowPrinted" value="0"/>
								<s:iterator var="loai" value="dsloaisp">
								<li class="<s:if test='#rowPrinted == 0'>active</s:if>">
									<a href="#DM<s:property value="#loai.id" />" data-toggle="tab">
										<s:property value="#loai.ten" />
									</a>
								</li>

								<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>		
								</s:iterator>
							</ul>
						</div>
						<div class="tab-content">
							<s:set var="rowPrinted1" value="0"/>
							<s:iterator var="loai" value="dsloaisp">
							<div class="tab-pane fade  <s:if test='#rowPrinted1 == 0'>active in</s:if>" id="DM<s:property value="#loai.id" />" >
								
								<s:set var="rowPrinted" value="0"/>
								<s:iterator var="sp" value="dssanpham">
									<s:if test="#rowPrinted < 12 && #loai.ten == #sp.loaisp">
										<div class="col-sm-4">
											<jsp:include page="product-small.jsp"/>
										</div>
									<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>
									</s:if>								
								</s:iterator>
								
							</div>
							<s:set var="rowPrinted1" value="%{#rowPrinted1 + 1}"/>						
							</s:iterator>
							
							
						</div>
					</div><!--/category-tab-->
					
					
					
					
					<jsp:include page="product-recommend.jsp"/>
					
					
					
					
				</div>
