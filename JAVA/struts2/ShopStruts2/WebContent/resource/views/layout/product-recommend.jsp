<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">Sản phẩm nổi bật</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									
									<s:set var="rowPrinted" value="0"/>
									<s:iterator var="sp" value="dstopsanpham">
										<s:if test="#rowPrinted < 3">
											<div class="col-sm-4">
												<jsp:include page="product-small.jsp"/>
											</div>
										</s:if>	
										<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>							
									</s:iterator>
									
								</div>
								<div class="item">	
									
									<s:set var="rowPrinted" value="0"/>
									<s:iterator var="sp" value="dstopsanpham">
										<s:if test="#rowPrinted >= 3 && #rowPrinted < 6">
											<div class="col-sm-4">
												<jsp:include page="product-small.jsp"/>
											</div>
										</s:if>	
										<s:set var="rowPrinted" value="%{#rowPrinted + 1}"/>							
									</s:iterator>
									
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->