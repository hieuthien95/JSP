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
	margin: 0px 30px
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
		<div style="color: red">
			<html:errors />
		</div>
		
		<hr style="border: 1px solid #ddd; width: 550px;"/>
		<h1 align="center">Form</h1>

		<html:form action="/Na18">

			<table>
				<tr>
					<td class="label">User Name:</td>
					<td><html:text readonly="true" property="userName" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><html:password property="password" /></td>
				</tr>
				<tr>
					<td class="label">Country:</td>
					<td><html:password property="country" /> <span
						class="pad-left-90"><html:button styleClass="btn-default"
								property="fresh">Fresh</html:button> </span></td>
				</tr>

				<tr>
					<td class="label">Choice:</td>
					<td><html:select property="sex">
							<html:option value="male">Male</html:option>
							<html:option value="female">Female</html:option>
						</html:select> <span class="pad-right">Sex</span> <html:select property="age">
							<html:option value="male">18--</html:option>
							<html:option value="female">20++</html:option>
						</html:select> <span class="pad-right">Age</span> <html:select
							property="contact">
							<html:option value="email">Email</html:option>
							<html:option value="phone">phone</html:option>
						</html:select> <span> Contact</span></td>
				</tr>
				<tr>
					<td class="label">Work:</td>
					<td><html:select property="work">
							<html:option value="sutdent">Student</html:option>
							<html:option value="engineer">Engineer</html:option>
						</html:select></td>
				</tr>
				<tr>
					<td class="label">User Name1:</td>
					<td><html:text styleClass="input-text-small" property="userName1" /></td>
				</tr>
				<tr>
					<td class="label">Password1:</td>
					<td><html:password styleClass="input-text-small"
							property="password1" /></td>
				</tr>
				<tr>
					<td class="label">Country1:</td>
					<td><html:password styleClass="input-text-small"
							property="country1" /></td>
				</tr>
				<tr>
					<td class="label">Country2:</td>
					<td><html:password styleClass="input-text-small"
							property="country2" /></td>
				</tr>

				<tr>
					<td colspan="2" class="label-center" align="center">
						<html:submit styleClass="btn-default margin-them-side">OK - Na-19</html:submit>
						<html:cancel styleClass="btn-default margin-them-side">Cancel - Na-15</html:cancel>
					</td>
				</tr>
			</table>
		</html:form>

	</div>

</body>
</html>
