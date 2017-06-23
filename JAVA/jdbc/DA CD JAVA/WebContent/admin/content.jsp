<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="content" style="padding-top: 0">
	<div class="breadLine">

		<ul class="breadcrumb">
			<li><a href="/admin">Home</a> <span class="divider">></span></li>
			<li class="active"><%=request.getParameter("ac") %></li>
		</ul>

		<ul class="buttons" style="margin: 0">
			<li>
				<a href="#" class="link_bcPopupSearch"><span
					class="icon-search"></span><span class="text">Search</span>
				</a>
				<div id="bcPopupSearch" class="popup">
					<div class="head">
						<div class="arrow"></div>
						<span class="isw-zoom"></span> <span class="name">Search</span>
						<div class="clear"></div>
					</div>
									
										
					<script type="text/javascript">
						var request = new XMLHttpRequest();
	
						function search() {
							var keywrd = document.frmSearch.keyword.value;
							var url = "/admin/modules/search-admin.jsp?key=" + keywrd;
	
							try {
								request.onreadystatechange = function() {
									if (request.readyState == 4) {
										var val = request.responseText;
										document.getElementById('valueSearch').innerHTML = val;
									}
								}
	
								request.open("GET", url, true);
								request.send();
	
							} catch (e) {
							}
						}
					</script>
					
					<form class="body search" action="/ds-products.jsp" method="get" name="frmSearch"
						style="position: relative;" class="hidden-xs">
						<input type="text" name="keyword" autocomplete="off"
							placeholder="Tìm kiếm" onkeyup="search()"/>
						<span style="width:100%; position: absolute; right: 0; background: #FFF; z-index: 9999; top: 95px; box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);"
							id="valueSearch"> 
						</span>
					</form>
										
					<div class="footer">
						<button class="btn btn-danger link_bcPopupSearch" type="button">Đóng</button>
					</div>
					
				</div>
			</li>

			<li><a href="/UserServlet?command=logout"> <span
					class="icon-share-alt"></span>Logout
			</a></li>
			<li><a href="/"> <span class="icon-home"></span>Home
			</a></li>
		</ul>
	</div>

	<%
		String ac = request.getParameter("ac");
	
		if (ac != null && !ac.equals("")) {
			switch(ac) {
			case "dssanpham":
				%> <jsp:include page="modules/ds-san-pham.jsp"/> <%
				break;
			case "dsbaiviet":
				%> <jsp:include page="modules/ds-bai-viet.jsp"/> <%
				break;
			case "dshinhanh":
				%> <jsp:include page="modules/ds-hinh-anh.jsp"/> <%
				break;
			case "dsvideo":
				%> <jsp:include page="modules/ds-video.jsp"/> <%
				break;
			case "dstaikhoan":
				%> <jsp:include page="modules/ds-taikhoan.jsp"/> <%
				break;
			case "dsdonhang":
				%> <jsp:include page="modules/ds-don-hang.jsp"/> <%
				break;
			case "dshinhanhall":
				%> <jsp:include page="modules/ds-hinh-anh-all.jsp"/> <%
				break;
			case "dshangsx":
				%> <jsp:include page="modules/ds-hangsx.jsp"/> <%
				break;
			}
			
			
			switch(ac) {
			case "insertsanpham":
				%>
				<jsp:include page="modules/insert-san-pham.jsp"/>
				<jsp:include page="modules/ds-san-pham.jsp"/>
				<%
				break;
			case "insertbaiviet":
				%> 
				<jsp:include page="modules/insert-bai-viet.jsp"/>
				<jsp:include page="modules/ds-bai-viet.jsp"/> 
				<%
				break;
			case "insertvideo":
				%>
				<jsp:include page="modules/insert-video.jsp"/>
				<jsp:include page="modules/ds-video.jsp"/>
				<%
				break;
			}
			
			
			switch(ac) {
			case "updatesanpham":
				%>
				<jsp:include page="modules/update-san-pham.jsp"/>
				<jsp:include page="modules/ds-san-pham.jsp"/>
				<%
				break;
			case "updatebaiviet":
				%>
				<jsp:include page="modules/update-bai-viet.jsp"/>
				<jsp:include page="modules/ds-bai-viet.jsp"/>
				<%
				break;
			case "updatevideo":
				%>
				<jsp:include page="modules/update-video.jsp"/>
				<jsp:include page="modules/ds-video.jsp"/>
				<%
				break;
			}
			
		} else {
			%> <jsp:include page="modules/ds-hinh-anh-all.jsp"/> <%
		}
	%>


</div>
