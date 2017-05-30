<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("user") != null) {
		response.sendRedirect("./profile.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>Quên mật khẩu</title>
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
					<li class="active">Quên mật khẩu</li>
				</ol>
			</div><!--/breadcrums-->
			
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<div class="login-form">
						<!--login form-->
						<h2>Quên mật khẩu</h2>

						<form action="UserServlet" method="GET">
							<input type="text" placeholder="Email" name="email" />
							<%
								String message = (String)session.getAttribute("message");
								session.removeAttribute("message");
								if (message != null)
									out.print(message + "<a target='blank' href='https://mail.google.com'>Email </a> của bạn");
							%>
							<button name="command" type="submit" value="forgot" class="btn btn-default">Send</button>
						</form>

					</div>
					<!--/login form-->
				</div>

			</div>
		</div>
	</section>
	<!--/form-->


	<jsp:include page="website/footer.jsp"></jsp:include>

</body>
</html>