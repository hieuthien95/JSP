<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>



    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>

<body>
	
	
	
	<jsp:include page="layout/header.jsp"/>
	
	
	
	<section>
		<div class="container">
			<div class="row">
			
			
			
			<jsp:include page="layout/menu.jsp"/>
			
			
			
				<style>
						.baiviet img {
							width: 100%;
							padding-bottom: 5px
						}
					</style>

		            <div class="col-md-9 col-sm-8 padding-left baiviet">

						<img src="upload/video/<s:text name="video.hinhanh" />" />
						<h2 style="text-align: center; margin-top: 5px">
							<s:text name="video.ten" />
						</h2>
						<div style="text-align: justify; padding: 0px 5px">
							<s:text name="video.noidung" />
						</div>

						<div class="fb-comments"
							data-href="http://www.thiensu.com/Shop_laravel/bai-viet/<s:text name="video.id" />"
							data-colorscheme="light" data-numposts="5" data-width="100%"></div>

					</div>

			</div>
		</div>
	</section>
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
	
</body>
</html>