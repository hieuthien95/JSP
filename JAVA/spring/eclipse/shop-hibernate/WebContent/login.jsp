<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<%
		String username_err = "", password_err = "", username = "", err = "";
		if (request.getAttribute("username_err") != null) {
			username_err = (String) request.getAttribute("username_err");
		}
		if (request.getAttribute("password_err") != null) {
			password_err = (String) request.getAttribute("password_err");
		}
		if (request.getAttribute("username") != null) {
			username = (String) request.getAttribute("username");
		}
		if (request.getAttribute("err") != null) {
			err = (String) request.getAttribute("err");
		}
	%>

	<jsp:include page="header.jsp"></jsp:include>

	<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>Đăng nhập</h2>
					<form action="UserLoginServlet" method="POST">
						<%=err%>
						<input type="text" placeholder="Username" name="username" /> <input
							type="password" placeholder="Password" name="password" />
						<button type="submit" class="btn btn-default">Đăng nhập</button>
					</form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>Tạo tài khoản</h2>
					<form action="UserRegisterServlet" method="POST">
						<p><%=username_err%></p>
						<input type="text" placeholder="Name" name="username" />
						<p><%=password_err%></p>
						<input type="password" placeholder="Password" name="password" />
						<button type="submit" class="btn btn-default">Đăng ký</button>
					</form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>
	</section>
	<!--/form-->


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>