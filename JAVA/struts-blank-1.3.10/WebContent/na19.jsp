<%@page import="org.apache.struts.action.ActionErrors"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
body {
	background: #ddd;
}

thead th {
	background: #14d100;
	padding: 5px;
	color: #fff;
	border: solid 1px #fff;
}

tbody td {
	padding: 5px;
	border: solid 1px #fff;
}

tbody tr {
	background: #eeffed;
}

table {
	margin: auto;
	border-collapse: collapse;
}

.container {
	height: 550px;
	width: 920px;
	margin: auto;
	padding: 15px;
	background: #fff;
}

.input-text-big {
	width: 160px
}

.input-text-small {
	width: 80px
}

.label {
	text-align: right;
	padding: 10px 15px
}

.label-center {
	text-align: center;
	padding: 10px 15px
}

.btn-default {
	background: #eee;
	border: 1px solid #ddd;
	padding: 2px 10px;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1);
}

.margin-them-side {
	margin: 0px 15px
}

.this-margin {
	margin: 0px 15px;
	margin-top: 50px
}

.pad-right {
	padding-right: 15px
}

.pad-left-90 {
	padding-left: 90px
}
</style>
</head>
<body>
	<div class="container">

		<hr style="border: 1px solid #ddd; width: 550px;" />
		<h1 align="center">Form</h1>

		<html:form action="/Na19">
			<table>
				<thead>
					<tr>
						<th width="200px">Month</th>
						<th width="500px">Savings</th>
					</tr>
				</thead>
			</table>
			<table>
				<tbody>

					<%
						for (int i = 0; i < 10; i++) {
					%>
					<tr style="<%=i % 2 != 0 ? "background: #d4f9d1" : ""%>">
						<td align="right" width="200px">Month</td>
						<td width="500px">Savings</td>
					</tr>
					<%
						}
					%>

					<tr style="background: none">
						<td colspan="2" class="label-center" align="center"><html:submit
								styleClass="btn-default this-margin">OK - Na-14</html:submit> <html:cancel
								styleClass="btn-default this-margin">Edit - Na-18</html:cancel></td>
					</tr>
				</tbody>
			</table>
		</html:form>
	</div>
</body>
</html>
