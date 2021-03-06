<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
	<header id="header"><!--header-->
        <div class="header_top" style="background: url('images/sites/header.jpg');"><!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-phone" style="color: #FFF"></i> 01653990370</a></li>
                                <li><a href="http://www.thientdt.esy.es/congnghe/"
                                    style="color: #FFF"><i class="fa fa-envelope"
                                        style="color: #FFF"></i> Admin thientdt.esy.es</a></li>
                            </ul>

                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="https://www.facebook.com/thien.hieu.tdt" style="color: #FFF"><i
                                        class="fa fa-facebook"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-twitter"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-linkedin"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-dribbble"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header_top-->

        <div class="header-middle" style="background: #F5F5F5">
            <!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="logo pull-left">
                            <a href="/ShopStruts2/index"><img src="images/sites/logo.png" alt="" height="40"  /></a>
                        </div>


                        

	                    <!-- Tìm kiếm -->
	
						<script type="text/javascript" src="js/my-tim-kiem.js"></script>
						<!-- kem theo file search.jsp -->
						
						<form action="${pageContext.request.contextPath}/product-list" method="get" name="frmSearch"
							style="position: relative;" class="hidden-xs">
							<div class="search_box pull-right">
								<input type="text" name="keyword" autocomplete="off"
									placeholder="Tìm kiếm" onkeyup="search()" />
								<input name="command" type="hidden" value="ds-products">
							</div>
	
							<!-- nơi hiện kết quả -->
							<span id="valueSearch" style="position: absolute; right: 0; 
								background: #FFF; z-index: 9999; top: 40px; 
								box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);" > </span>
						</form>
	
						<!-- /tìm kiếm -->
						
					</div>
					<div class="col-sm-6 col-xs-12" style="padding: 0">
	
						<div class="shop-menu pull-right">
	
							<!-- Tìm kiếm -->
	
							<form action="${pageContext.request.contextPath}/product-list" method="get" name="frmSearch2" class="visible-xs col-xs-12">
								<div class="input-group">
									<input type="text" class="form-control" name="keyword" onkeyup="search2()"
										style="margin-top: 10px;"
										value="<%if (request.getParameter("keyword") != null) {out.print(request.getParameter("keyword"));}%>" />
									<input name="command" type="hidden" value="ds-products">
									<span class="input-group-btn"> <input type="submit"
										class="btn btn-default" value="Tìm" style="margin-top: 10px;" />
									</span>
								</div>
								
								<span id="valueSearch2" style="position: absolute; right: 0; 
									background: #FFF; z-index: 9999; top: 40px; 
									box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);" > </span>
							</form>
	
							<!-- /tìm kiếm -->

                            <ul class="nav navbar-nav">
                                <s:if test="#session.cart != null && #session.cart.countItem() > 0">
                                    <li><a href="${pageContext.request.contextPath}/checkout"><i class="fa fa-crosshairs"></i> Thanh toán</a></li>
                                    <li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Giỏ hàng(<s:text name="#session.cart.countItem()"></s:text>)</a></li>
                                </s:if>
                                
                                <s:if test="#session.user != null">
                                    <li><a href="${pageContext.request.contextPath}/profile"> 
                                    	<i class="fa fa-user"></i><s:text name="session.user.name"></s:text></a>
                                    </li>
                                </s:if>
                                <s:else>
                                    <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i>Đăng nhập</a></li>
                           		</s:else>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    
        <div class="header-bottom hidden-xs"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><a href="${pageContext.request.contextPath}/#sanpham" class="active">Sản phẩm</a></li>
                                
                                <s:iterator var="loai" value="dsloaisp">
                                <li class="dropdown">
                                	<a href="${pageContext.request.contextPath}/product-list?keyword=<s:property value="#loai.ten" />">
                                		<s:property value="#loai.ten" /><i class="fa fa-angle-down"></i>
                                	</a>
                                    <ul role="menu" class="sub-menu">
                                    	<s:iterator var="hang" value="dshangsx">
                                    	<s:if test="#hang.parent == #loai.id">
										<li>
											<a href="${pageContext.request.contextPath}/product-list?keyword=<s:property value="#loai.ten + ' ' + #hang.ten" />">
												<s:property value="#hang.ten" />
											</a>
										</li>				
										</s:if>
										</s:iterator>
									</ul>
								</li>
								</s:iterator>
                                
                                <li class="dropdown"><a href="${pageContext.request.contextPath}/#tintuc">Tin tức<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="${pageContext.request.contextPath}/bai-viet-list">Bài viết</a></li>
                                        <li><a href="${pageContext.request.contextPath}/video-list">Video</a></li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div><!--/header-bottom-->
        
        
        		<div class="clearfix"></div>
				<%if(session.getAttribute("success")!=null) { %>
					<div class="alert alert-success" align="center">
						<%=session.getAttribute("success") %>
						<% session.removeAttribute("success"); %>
					</div>
				<%} %>
				
				<%if(session.getAttribute("error")!=null) { %>
					<div class="alert alert-danger" align="center">
						<%=session.getAttribute("error") %>
						<% session.removeAttribute("error"); %>
					</div>
				<%} %>
				<div class="clearfix"></div>
        
    </header><!--/header-->
    
    
    <jsp:include page="header-fixed.jsp"></jsp:include>
