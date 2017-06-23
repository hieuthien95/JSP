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
				
				
				

				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						
						<s:iterator var="sp" value="dssanpham">
								<div class="col-sm-4">
									<jsp:include page="layout/product-big.jsp"/>
								</div>
						</s:iterator>
						
					</div><!--features_items-->
					
				</div>

			</div>
		</div>
	</section>
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
	
</body>
</html>




<jsp:include page="layout/so-sanh-fixed.jsp"/>


