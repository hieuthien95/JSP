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
						<h2>Đăng nhập</h2>
						<form action="${pageContext.request.contextPath}/login-process">
							<input type="email" placeholder="Email Address" name="user.email" />
							<input type="password" placeholder="Password" name="user.password"/>
							<span>
								<input type="checkbox" class="checkbox">Lưu đăng nhập
							</span>
							<a href="${pageContext.request.contextPath}/forget">Quên mật khẩu</a>
							<button type="submit" class="btn btn-default">Đăng nhập</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">Hoặc</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Đăng ký</h2>
						<s:actionerror/>
						<s:form action="register-process" method="post" enctype="multipart/form-data">
							
							<s:textfield name="user.name" placeholder="Name"/>
							<s:textfield name="user.email" placeholder="Email" />
							<s:textfield name="user.sdt" placeholder="Phone"/>
							
							<s:file name="myFile" ></s:file>
							
							<s:password name="user.password" placeholder="Password" />
							<s:submit value="Register" />
						</s:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
</body>
</html>