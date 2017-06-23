<%@page import="java.util.ArrayList"%> 
<%@page import="tool.StringAction"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<SanPham> getTopSanPham = new SanPhamDAO().getTopSanPham();
%>
        
<div class="recommended_items wow fadeInRight">

        <h2 class="title text-center">Sản phẩm bán chạy</h2>

      
        <div id="recommended-item-carousel" class="carousel slide"
             data-ride="carousel">
            <div class="carousel-inner">
                <div class="item active">
                    <% for(int i = 0; i<3; i++){ %>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div>
                                <div class="productinfo text-center">
                                    <a href="/?command=tt-san-pham&stt=<%=getTopSanPham.get(i).getStt()%>">
                                    	<img src="<%=getTopSanPham.get(i).getHinhanh() %>" style="width: 60% !important; padding: 10px"/>
                                    </a>
                                    <h2 style="font-size: 18px"><%=StringAction.numberFormat(getTopSanPham.get(i).getGia()) %>đ</h2>
                                    <p><%=getTopSanPham.get(i).getHangsx() + " " + getTopSanPham.get(i).getTen() %></p>
                                    <a href="CartServlet?command=plus&productID=<%=getTopSanPham.get(i).getStt()%>" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm
									</a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <% } %>
                </div>
                <div class="item">
                    <% for(int i = 4; i<7; i++){ %>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div>
                                <div class="productinfo text-center">
                                    <a href="/?command=tt-san-pham&stt=<%=getTopSanPham.get(i).getStt()%>">
                                    	<img src="<%=getTopSanPham.get(i).getHinhanh() %>"  style="width: 50% !important; padding: 10px" />
                                    </a>
                                    <h2 style="font-size: 18px"><%=StringAction.numberFormat(getTopSanPham.get(i).getGia()) %>đ</h2>
                                    <p><%=getTopSanPham.get(i).getHangsx() + " " + getTopSanPham.get(i).getTen() %></p>
                                    <a href="CartServlet?command=plus&productID=<%=getTopSanPham.get(i).getStt()%>" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm</a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
            <a class="left recommended-item-control"
               href="#recommended-item-carousel" data-slide="prev"> <i
                    class="fa fa-angle-left"></i>
            </a> <a class="right recommended-item-control"
                    href="#recommended-item-carousel" data-slide="next"> <i
                    class="fa fa-angle-right"></i>
            </a>
        </div>
    </div>