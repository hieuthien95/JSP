<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<sql:setDataSource var="snapshot" user="root" password="123456789"
		driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/qlsv"/>
	<sql:query dataSource="${snapshot}" sql="select * from STUDENT" var="sinhvienlist"/>
	
	<h1>Sinh vien list - Length: ${fn:length("Sinh vien list")} -  LowerCase: ${fn:toLowerCase("Sinh vien list")}</h1>
	<table border=1 width=600px style="border-collapse: collapse"
		align="center">
		<tr>
			<td>STT</td>
			<td>Name</td>
			<td>Age</td>
			<td>Ngoại quốc</td>
			<td>Email</td>
			<td>Action</td>
		</tr>

		<c:forEach var="row" items="${sinhvienlist.rows}">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.name}"/></td>
				<td><c:out value="${row.age}"/></td>
				<td>
					<input type="checkbox" 
					<c:if test="${row.foreigner}">checked</c:if> >
				</td>
				<td><c:out value="${row.email}"/></td>
				<td>	
					<c:url value="StudentServlet" var="myURL">
						<c:param name="command" value="delete"></c:param>
						<c:param name="id" value="${row.id}"></c:param>
					</c:url>
					<a href="${myURL}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>