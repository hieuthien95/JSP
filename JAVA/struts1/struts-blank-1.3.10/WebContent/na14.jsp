<%@page import="form.Na14Form"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UserRegisterDAO"%>
<%@page import="bean.User"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.struts.action.ActionErrors"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
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
	background: #5784cc;
	padding: 5px;
	color: #fff;
	border: solid 1px #fff;
}

tbody td {
	padding: 5px;
	border: solid 1px #fff;
}

tbody tr {
	background: #fcfcfc;
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

.input-num {
	width: 25px;
	height: 12px;
	background: #FFF !important;
	margin-left: 5px
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
	margin: 0px 30px
}

.this-margin {
	margin: 0px 15px;
	margin-top: 30px
}

.pad-right {
	padding-right: 15px
}

.pad-left-90 {
	padding-left: 90px
}

.abc:first-child>td>input {
	background: #000
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>

<script type="text/javascript">
$(".hihi").attr("checked", "true");
</script>

<body>
	<div class="container">

		<div style="color: red">
			<html:errors />
		</div>

		<hr style="border: 1px solid #ddd; width: 550px;" />
		<h1 align="center">Form14</h1>
		<div align="right" style="margin-top: -30px">
			<html:button styleClass="btn-default" property="to01">Logout - To-01</html:button>
		</div>

		<html:form method="get" action="/Na14" styleId="myForm">

			<div class="label-center" align="center">
				<html:button styleClass="btn-default margin-them-side"
					property="na15">Na-15</html:button>
				<html:reset styleClass="btn-default margin-them-side">OK - Na-18</html:reset>
			</div>

			<table>
				<thead>
					<tr>
						<td colspan="5" align="right" style="padding: 10px 0px"><span
							style="float: left; margin-left: 40px">ABCDEFG</span> <span>ABC
						</span><span> 1/20 </span><span> EFG</span> <html:submit
								styleClass="btn-default">Page</html:submit> <html:text
								styleClass="input-num" property="num" />
						<td>
					</tr>
					<tr>
						<th width="30px"></th>
						<th width="150px">Month</th>
						<th width="150px">Savings</th>
						<th width="150px">Month</th>
						<th width="150px">Savings</th>
					</tr>
				</thead>
			</table>
			<table>
				<tbody id = "MyDiv">

					<%
						if (request.getAttribute("list_user") != null) {
								int count = 0;
					%>
					<logic:iterate id="l" collection="${list_user}">
						<tr class="abc" style="<%=count++ % 2 != 0 ? "background: #f4f4f4" : ""%>">
							<td width="30px" align="center">
								<html:checkbox property="check" value="${l.firstName }"></html:checkbox>
							</td>
							<td width="150px"><bean:write name="l" property="firstName"/></td>
							<td width="150px">${l.userName}</td>
							<td width="150px" align="right">${l.email}</td>
							<td width="150px" align="right">${l.password}</td>
						</tr>
					</logic:iterate>
					<%
						}
					%>
				</tbody>
			</table>

			<div align="right">
				<html:submit styleClass="btn-default" style="margin-top: 20px"
					property="na11">Choice - Na-11</html:submit>
			</div>
			
			<script type="text/javascript">
				function clickBtn() {

					var aArray = [];
					$('#MyDiv input:checked').each(function() {
						aArray.push(this.value);
			        });
					alert(aArray);
				}
			</script>
			
			<button type="button" id="mybtn" name="btn" value="submit-form" onclick="clickBtn()">Button</button>
		</html:form>
	</div>
</body>
</html>
