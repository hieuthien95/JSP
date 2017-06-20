<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div id="contact-page" class="container">
		<form action="SendMailServlet" method="POST">
			<div class="form-group col-md-12">
				<input type="email" name="email" class="form-control"
					placeholder="Email">
			</div>
			<div class="form-group col-md-12">
				<input type="text" name="subject" class="form-control"
					placeholder="Subject">
			</div>
			<div class="form-group col-md-12">
				<textarea name="message" id="message" class="form-control" rows="8"
					placeholder="Your Message Here"></textarea>
			</div>
			<div class="form-group col-md-12">
				<input type="submit" class="btn btn-primary">
			</div>
		</form>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>