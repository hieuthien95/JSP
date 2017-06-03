<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String ac = request.getParameter("ac");
%>

<div class="menu" style="margin-top: 0; position: fixed;">
	<ul class="navigation">
		<li class="<%=(ac == null)?"active":"" %>">
			<a href="/admin"> 
				<span class="isw-grid"></span><span class="text">Home</span>
			</a>
		</li>
		
		<li class="openable <%=(ac != null && ac.equals("insertsanpham"))?"active":"" %>">
			<a> <span class="isw-zoom"></span> <span class="text">Sản phẩm</span></a>
			<ul>
				<li>
					<a href="?ac=insertsanpham"> 
						<span class="icon-shopping-cart"></span><span class="text">Thêm sản phẩm</span>
					</a>
				</li>
				<li>
					<a href="?ac=dssanpham"> 
						<span class="icon-list"></span><span class="text">Danh sách sản phẩm</span>
					</a>
				</li>
			</ul>
		</li>
		
		<li class="openable <%=(ac != null && ac.equals("insertbaiviet"))?"active":"" %>">
			<a> <span class="isw-zoom"></span> <span class="text">Bài viết</span></a>
			<ul>
				<li>
					<a href="?ac=insertbaiviet"> 
						<span class="icon-list-alt"></span><span class="text">Thêm bài viết</span>
					</a>
				</li>
				<li>
					<a href="?ac=dsbaiviet"> 
						<span class="icon-list"></span><span class="text">Danh sách bài viết</span>
					</a>
				</li>
			</ul>
		</li>
		
		<li class="openable <%=(ac != null && ac.equals("insertvideo"))?"active":"" %>">
			<a> <span class="isw-zoom"></span> <span class="text">Video</span></a>
			<ul>
				<li>
					<a href="?ac=insertvideo"> 
						<span class="icon-facetime-video"></span><span class="text">Thêm Video</span>
					</a>
				</li>
				<li>
					<a href="?ac=dsvideo"> 
						<span class="icon-list"></span><span class="text">Danh sách Video</span>
					</a>
				</li>
			</ul>
		</li>

		

		
		<li class="<%=(ac != null && ac.equals("dsdonhang"))?"active":"" %>">
			<a href="?ac=dsdonhang"> <span class="icon-list">
				</span><span class="text">Đơn hàng</span>
			</a>
		</li>
		
		<li class="<%=(ac != null && ac.equals("dstaikhoan"))?"active":"" %>">
			<a href="?ac=dstaikhoan"> <span class="icon-list">
				</span><span class="text">Tài khoản</span>
			</a>
		</li>
		
		<li class="openable"> <a href="#"> <span class="isw-zoom"></span><span class="text">Danh sách</span></a>
			<ul>
				<li>
					<a href="?ac=dshangsx">
						<span class="icon-shopping-cart"></span>
						<span class="text">Loại - Hãng</span>
					</a>
				</li>
				<li class=" <%=(ac != null && ac.equals("dshinhanhall"))?"active":"" %>">
					<a href="?ac=dshinhanhall"> <span class="icon-list">
						</span><span class="text">Hình ảnh</span>
					</a>
				</li>
			</ul>
		</li>
		
	</ul>

	<div class="dr">
		<span></span>
	</div>

	<div class="widget-fluid">
		<div id="menuDatepicker"></div>
	</div>

</div>