<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HTML Select Tag Example</title>
</head>
<body>
<h3>Selected Values are</h3>
<html:form action="/inputAction">
	<bean:write name="InputForm" property="country" />
	<br />
	<bean:write name="InputForm" property="state" />
</html:form>
</body>
</html>