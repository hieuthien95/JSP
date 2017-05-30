<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
	<section id="slider"><!--slider-->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#slider-carousel" data-slide-to="1"></li>
                            <li data-target="#slider-carousel" data-slide-to="2"></li>
                            <li data-target="#slider-carousel" data-slide-to="3"></li>
                            <li data-target="#slider-carousel" data-slide-to="4"></li>
                        </ol>
                        
                        <div class="carousel-inner">

                        <s:set var="rowPrinted" value="0"/>
						<s:iterator var="sp" value="dstopsanpham">
						<s:if test="#rowPrinted < 5">
                            <div class="item  <s:if test='#rowPrinted == 0'>active</s:if> " >

                                <div class="col-sm-6 wow fadeInUpBig">
                                    <h1><span>ICON</span>Club</h1>
                                    <h2> <s:property value="#sp.hangsx + ' ' + #sp.ten"/> </h2>
                                    <p> <s:property value="#sp.cpu + ' ' + #sp.pin + ' ' + #sp.hangsx + ' ' + #sp.hdh"/></p>
                                    <a type="button" class="btn btn-default get" style="color: #FFF" href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#sp.id" />">Mua ngay</a>
                                </div>
                                
                                <div class="col-sm-6 wow fadeInDownBig">
	                                <a href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#sp.id" />">
	                                    <img src="upload/sanpham/<s:property value='#sp.hinhanh'/>" class="girl img-responsive" style="padding: 15px; width: 70%" />
	                                </a>
                                </div>
                                
                            </div>
                            <s:set var="rowPrinted" value="#rowPrinted + 1"/>
                        </s:if>
                        </s:iterator>
                            
                        </div>
                        
                        <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                    
                </div>
            </div>
        </div>
    </section><!--/slider-->
