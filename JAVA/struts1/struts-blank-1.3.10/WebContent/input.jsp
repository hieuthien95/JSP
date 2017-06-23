<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HTML Select Tag Example</title>
    </head>
    <body>
        <html:form action="/inputAction" >
            <table>
                <tr>
                    <td>
                        Select Country :
                    </td>
                    <td>
                        <html:select property="country" >
                            <html:option value="0">Select Country</html:option>
                            <html:optionsCollection name="InputForm" property="countryList" label="countryName" value="countryId" />
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Select State :
                    </td>
                    <td>
                        <html:select property="state" >
                            <html:option value="0">Select State</html:option>
                            <html:optionsCollection name="InputForm" property="stateList" label="label" value="value" />
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <html:submit property="method" value="save" />
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html>

