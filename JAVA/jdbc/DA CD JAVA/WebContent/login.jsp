<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập</title>
<link rel="icon" href="/website/view/images/sites/ICON1.png"/>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<jsp:include page="website/header.jsp"></jsp:include>

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="/">Home</a></li>
					<li class="active">Đăng nhập</li>
				</ol>
			</div><!--/breadcrums-->
		
			<%
				if (session.getAttribute("user") == null) {
			%>
			<div class="row">
			
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Đăng nhập</h2>

						<form action="UserServlet" method="POST">
							<input type="text" placeholder="Username" name="username" /> <input
								type="password" placeholder="Password" name="password" />
							<%
								String error = (String) session.getAttribute("error");
								session.removeAttribute("error");
								if (error != null)
									out.print(error + "<br>");
							%>
							<span>
							<input checked="checked" type="checkbox" name="remember">
							Giữ đăng nhập</span>
							<a style="float: right" href="/forgot.jsp">Quên mật khẩu</a> <br>
							<button name="command" type="submit" value="login"
								class="btn btn-default">Đăng nhập</button>
						</form>

					</div>
					<!--/login form-->
					
				</div>

				<div class="col-sm-1">
					<h2 class="or">Hoặc</h2>
				</div>

				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>Đăng ký</h2>

						<form action="UserServlet?command=register" method="POST"
							class="workplace" enctype="multipart/form-data">
							<input name="username" type="text" placeholder="Username" /> <input
								name="email" type="email" placeholder="Email Address" /> <input
								name="ten" type="text" placeholder="Name" /> <input name="sdt"
								type="tel" placeholder="Phone" /> <input name="avatar"
								type="file"> <input name="password" type="password"
								placeholder="Password" /> <input name="repassword"
								type="password" placeholder="Comform password" />
							<%
								String errorRegister = (String) session.getAttribute("errorRegister");
								session.removeAttribute("errorRegister");
								if (errorRegister != null)
									out.print(errorRegister + "<br>");
							%>
							<button type="submit" class="btn btn-default">Đăng ký</button>
						</form>

					</div>
					<!--/sign up form-->
				</div>
			</div>
			<%
				} else { 
					out.print("<div class='wow fadeInLeft' align='center'><h4>Bạn đã đăng nhập</h4></div>");
				} 
			%>
		</div>
	</section>
	<!--/form-->


	<jsp:include page="website/footer.jsp"></jsp:include>

</body>
</html>