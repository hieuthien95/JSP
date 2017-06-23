<%@page import="java.util.ArrayList"%>
<%@page import="dao.VideoDAO"%>
<%@page import="model.Video"%>
<%@page import="dao.BaiVietDAO"%>
<%@page import="model.BaiViet"%>
<%@page import="model.HangSanXuat"%>
<%@page import="dao.HangSanXuatDAO"%>
<%@page import="dao.LoaiSanPhamDAO"%>
<%@page import="model.LoaiSanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<LoaiSanPham> getAllLoaiSanPham = new LoaiSanPhamDAO().getAllLoaiSanPham();
	
	ArrayList<HangSanXuat> getAllHangSX = new HangSanXuatDAO().getAllHangSX();
	
	ArrayList<BaiViet> getAllBaiViet = new BaiVietDAO().getAllBaiViet();
	
	ArrayList<Video> getAllVideo = new VideoDAO().getAllVideo();
%>

<div class="col-md-3 col-sm-4">
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
	
		<h2 style="margin-top: 30px">Danh mục</h2>
		<div class="panel-group category-products wow fadeInLeft" id="accordian">
			<!--category-productsr-->
			
			<%
				for(LoaiSanPham i: getAllLoaiSanPham) {
			%>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#L<%=i.getStt()%>"> <span class="badge pull-right"><i
								class="fa fa-plus"></i></span> <%=i.getTenloai() %>
						</a>
					</h4>
				</div>
				<div id="L<%=i.getStt()%>" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
						<%
							for (HangSanXuat j : getAllHangSX) {
								String []arr = j.getSttloaisp().split(",");
								for(int k = 0; k < arr.length; k++){
									if(arr[k].equalsIgnoreCase(i.getStt()+"")) {
							%>
										<li><a href="./?command=ds-products&tenhang=<%=j.getTenHang()%>&loaisp=<%=i.getTenloai()%>"><%=j.getTenHang()%> </a></li>
						<%
									}
								}
							}
						%>
						</ul>
					</div>
				</div>
			</div>
			<% }%>
			
			<div class="panel panel-default">
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
							<li><a href="./?command=ds-news">Bài viết</a></li>
							<li><a href="./?command=ds-videos">Video</a></li>
						</ul>
					</div>
				</div>
			</div>
			
		</div>
		<!--/category-products-->

		<div class="left-sidebar hidden-xs" id="tintuc">
			<!--brands_products-->
			<h2><a href="/?command=ds-news">Bài viết</a></h2>
			<div class="brands-name wow fadeInLeft" style="padding: 0">
				<ul style="padding: 0; margin: 0">
					<%
						int count = 0;
						for(BaiViet i: getAllBaiViet){
							 if(++count == 8)
								 break;
					%>
					<li style="padding: 5px">
						<img src="<%=i.getHinhanh()%>" width="20%"/>
						<a href="/?command=tt-bai-viet&stt=<%=i.getStt() %>" style="color: #000; padding-left: 5px">
							<%=i.getTieude()%>
						</a>
					</li>
					
					<%} %>
				</ul>
			</div>
		</div>
		<!--/brands_products-->
		
		<div class="left-sidebar hidden-xs">
			<!--brands_products-->
			<h2 style="margin-top: 30px"><a href="/?command=ds-videos">Video</a></h2>
			<div class="brands-name wow fadeInLeft" style="padding: 0">
				<ul style="padding: 0; margin: 0">
					<%
						count = 0;
						for(Video i: getAllVideo){
							 if(++count == 8)
								 break;
					%>
					<li style="padding: 5px">
						<img src="<%=i.getHinhanh()%>" width="20%"/>
						<a href="/?command=tt-video&stt=<%=i.getStt() %>" style="color: #000; padding-left: 5px">
							<%=i.getTen()%>
						</a>
					</li>
					
					<%} %>
				</ul>
			</div>
		</div>
		<!--/brands_products-->

		

		<div class="shipping text-center hidden-xs wow fadeInLeft">
			<!--shipping-->
			<img src="website/images/home/shipping.jpg" alt="" />
		</div>
		<!--/shipping-->
		
		
		
		<jsp:include page="facebook-fanpage.jsp"></jsp:include>
                        
                        

	</div>
</div>