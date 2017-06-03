<%@page import="java.util.ArrayList"%>
<%@page import="connect.DBConnect"%>
<%@ page import="java.sql.*"%>
<%@page import="tool.StringAction"%>
<%@page import="hibernate.dao.SanPhamDAO"%>
<%@page import="hibernate.model.SanPham"%>
<%@page import="model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String kw = request.getParameter("key");
if (kw != null && !kw.trim().equals("")) 
{
	ArrayList<SanPham> dsSP = new SanPhamDAO().searchSanPham(kw);
		%>
		
<table style="background: #FFF; z-index: 9999; margin: 0; width: 100%">
<%
	for (SanPham i : dsSP) {
%>
	<tr >
		<td style="padding: 10px; ">
			<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><img src="/<%=i.getHinhanh()%> " width="50" /></a>
		</td>
		<td style="padding: 10px; ">
			<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><%=i.getHangsx() + " " + i.getTen()%></a>
		</td>
		
		<%
			User user = (User)session.getAttribute("user");
			if(user!=null && user.getQuyen().equals("admin")) {
		%>
		<td style="color: red; padding: 10px; float: right">
			<a href="?ac=updatesanpham&stt=<%=i.getStt()%>"><img width="25" src="/admin/modules/img/b_edit.png"></a>
			<a href="?ac=dshinhanh&stt=<%=i.getStt()%>"><img width="25" src="/admin/modules/img/b_img.png"></a>
			<a href="/SanPhamServlet?command=remove&stt=<%=i.getStt()%>"><img width="25" src="/admin/modules/img/b_drop.png"></a>
		</td>
		<%} %>
		
	</tr>
<%
	}
%>
</table>
<%
}
%>