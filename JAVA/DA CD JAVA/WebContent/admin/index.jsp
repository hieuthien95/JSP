<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="model.User"%>
<%@page import="dao.UserDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	User user = (User) session.getAttribute("user");
	// cookie
	if(user == null) {
	    String username = null, password = null;
		Cookie []cookie = request.getCookies();
		for(int i = 0; i<cookie.length; i++) {
			if(cookie[i].getName().equals("username"))
				username = cookie[i].getValue();
			else if(cookie[i].getName().equals("password"))
				password = cookie[i].getValue();
		}
		if(username!=null && password !=null) {
			user = new UserDAO().login(username, password);
			session.setAttribute("user", user);
		}
	}	
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin <%=user!=null?"- " + user.getTen():"" %></title>
<jsp:include page="head.jsp"></jsp:include>
</head>

<body>


			
				<div class="clearfix"></div>
				<%if(session.getAttribute("success")!=null) { %>
					<div class="alert alert-success" align="center">
						<%=session.getAttribute("success") %>
						<% session.removeAttribute("success"); %>
					</div>
				<%} %>
				
				<%if(session.getAttribute("error")!=null) { %>
					<div class="alert alert-danger" align="center">
						<%=session.getAttribute("error") %>
						<% session.removeAttribute("error"); %>
					</div>
				<%} %>
				<div class="clearfix"></div>
				
				

	<%		
		if (user != null && user.getQuyen().equalsIgnoreCase("admin") 
				|| user != null && user.getQuyen().equals("nhân viên")) {
	%>
				<jsp:include page="menu.jsp"></jsp:include>
				<jsp:include page="content.jsp"></jsp:include>
	<%
			
		} else {
	%>
			<div class="container" style="margin: 100px">
				<div align="center" class="login-form">
					<form action="/UserServlet" method="POST">
						<input type="text" placeholder="Username" name="username" /> <br />
						<input type="password" placeholder="Password" name="password" /> <br />
						<button name="command" type="submit" value="login"
							class="btn btn-default">Đăng nhập</button>
					</form>
				</div>
			</div>
	<%
		}
	%>
</body>
</html>

