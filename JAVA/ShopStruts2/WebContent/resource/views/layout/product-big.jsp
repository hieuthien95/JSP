<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
							
                            <div class="product-image-wrapper wow fadeInRight">
                                <div class="single-products" style="">
                                    <div class="productinfo text-center" style="padding: 10px; height: 100%">
                                        <img src="upload/sanpham/<s:property value="#sp.hinhanh" />" style="width: 80%" />
                                        <h2 style="font-size: 18px"><s:property value="getText('{0,number,#,##0}',{#sp.gia})" /> VNĐ</h2>
                                        <p><s:property value="#sp.hangsx + ' ' + #sp.ten" /></p>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <p>
                                                <b>Display: </b><s:property value="#sp.manhinh" /></p>
                                            <p>
                                                <b>OS: </b><s:property value="#sp.hdh" /></p>
                                            <p>
                                                <b>CPU: </b><s:property value="#sp.cpu" /></p>
                                            <p>
                                                <b>Camera: </b><s:property value="#sp.camera" /></p>
                                            <p>
                                                <b>Pin: </b><s:property value="#sp.pin" /></p>
                                            <p>
                                                <b>KM: </b><s:text name="#sp.km" /></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a
                                            href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:property value="#sp.id" />"><i
                                                class="fa fa-shopping-cart"></i>Thêm</a></li>
                                        <li><a
                                            href="${pageContext.request.contextPath}/add-to-so-sanh?sanpham.id=<s:property value="#sp.id" />"><i
                                                class="fa fa-plus-square"></i>So sánh</a></li>
                                        <li><a
                                            href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#sp.id" />">o
                                                o o</a></li>
                                    </ul>
                                </div>
                            </div>
