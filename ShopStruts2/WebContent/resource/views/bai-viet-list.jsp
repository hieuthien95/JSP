<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>



    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>

<body>
	
	
	
	<jsp:include page="layout/header.jsp"/>
	
	
	
	<section>
		<div class="container">
			<div class="row">
			
			
			
			
				<jsp:include page="layout/menu.jsp"/>
				
				<div class="col-md-9 col-sm-8" >

					<s:iterator var="bv" value="dsbaiviet">
					
					<div style="padding-bottom: 20px">
						<a href="${pageContext.request.contextPath}/xem-bai-viet?baiviet.id=<s:property value='#bv.id'/>" style="color: #000">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"
								style="padding: 0px; padding-bottom: 10px">
								<img src="upload/baiviet/<s:property value="#bv.hinhanh"/>" style="width: 100%; overflow: hidden" />
							</div>
							<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12"
								style="text-align: justify; overflow: hidden">
								<b style="font-size: 20px; line-height: 25px"> <s:property value="#bv.tieude"/>
								</b> <br />
								
								<s:text name="#bv.tomtat"/>
							</div>

							<div style="clear: both"></div>
						</a>
					</div>

					</s:iterator>

				</div>

			</div>
		</div>
	</section>
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
	
</body>
</html>