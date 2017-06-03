<%@page import="java.util.ArrayList"%>
<%@page import="connect.DBConnect"%>
<%@ page import="java.sql.*"%>
<%@page import="tool.StringAction"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String kw = request.getParameter("key");
	if (kw != null && !kw.trim().equals("")) 
	{
		ArrayList<SanPham> dsSP = new SanPhamDAO().searchSanPham(kw);
%>
		
<table style="background: #FFF; z-index: 9999; margin: 0">
<%
	for (SanPham i : dsSP) {
%>
	<tr >
		<td style="padding: 10px; ">
			<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><img src="/<%=i.getHinhanh()%> " width="50" /></a>
		</td>
		<td style="padding: 10px; ">
			<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><%=i.getLoaisp() + " " + i.getHangsx() + " " + i.getTen()%></a>
		</td>
		<td style="color: red; padding: 10px">
			<%=StringAction.numberFormat(i.getGia()) %>đ
		</td>
	</tr>
<%
	}
%>
</table>
<%
}
%>