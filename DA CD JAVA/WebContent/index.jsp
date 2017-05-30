<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="/website/view/images/sites/ICON1.png"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="website/header.jsp"></jsp:include>
	
	<%
	String title="";
	String command = request.getParameter("command");
	if(command!=null) {
%>

<%		
		switch(command){
		case "tt-bai-viet":
			title ="Xem bài viết";
			%><jsp:include page="website/tt-bai-viet.jsp"/><%
			break;
		case "tt-video":
			title ="Xem video";
			%><jsp:include page="website/tt-video.jsp"/><%
			break;
		case "tt-san-pham":
			title ="Chi tiết sản phẩm";
			%><jsp:include page="website/tt-san-pham.jsp"/><%
			break;
			
		case "ds-news":
			title ="Danh sách bài viết";
			%><jsp:include page="website/ds-news.jsp"/><%
			break;
		case "ds-videos":
			title ="Danh sách video";
			%><jsp:include page="website/ds-videos.jsp"/><%
			break;
		case "ds-products":
			title ="Danh sách sản phẩm";
			%><jsp:include page="website/ds-products.jsp"/><%
			break;
		
		}
		
	} else {
		title ="Icon Club";
	%>
	
		<jsp:include page="website/banner.jsp"></jsp:include>
		
		<jsp:include page="website/content.jsp"></jsp:include>
	
	<%
	}
	%>
	
	
	
	<script type="text/javascript">
		document.title = '<%=title%>';
	</script>
	
	<jsp:include page="website/footer.jsp"></jsp:include>
	
</body>
</html>
