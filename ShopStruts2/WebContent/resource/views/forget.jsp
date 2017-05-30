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
	
	
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
			
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Quên mật khẩu</h2>
						<form action="${pageContext.request.contextPath}/forget-process">
							<input type="email" placeholder="Email Address" name="user.email" />

							<button type="submit" class="btn btn-default">Gửi</button>
						</form>
					</div><!--/login form-->
				</div>

			</div>
		</div>
	</section><!--/form-->
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
</body>
</html>