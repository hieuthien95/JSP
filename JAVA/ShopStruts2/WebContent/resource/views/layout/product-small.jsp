<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
									
									<div class="product-image-wrapper wow fadeInRight">
										<div class="single-products" style="padding: 10px">
											<div class="productinfo text-center">
												<a href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#sp.id" />">
													<img src="upload/sanpham/<s:property value="#sp.hinhanh" />" style="width: 60%"/>
												</a>
												<h2 style="font-size: 18px"><s:property value="getText('{0,number,#,##0}',{#sp.gia})" /> VNĐ</h2>
												<p><s:property value="#sp.hangsx + ' ' + #sp.ten" /></p>
												<a href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="#sp.id" />" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm</a>
											</div>
											
										</div>
									</div>