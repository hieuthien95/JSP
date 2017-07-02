<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
	<h1>List Customer</h1> 
	<logic:present name="SearchForm" property="customers">
		<logic:iterate id="item" name="SearchForm" property="customers">
			<bean:write name="item" property="customerId"/>
			 ---- 
			<bean:write name="item" property="name"/>
			 ---- 
			<bean:write name="item" property="address"/>
			<br/>
		</logic:iterate>
	</logic:present>
	
</body>
</html>