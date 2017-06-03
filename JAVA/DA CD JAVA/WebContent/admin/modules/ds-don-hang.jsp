<%@page import="java.util.ArrayList"%>
<%@page import="tool.StringAction"%>
<%@page import="hibernate.dao.DonHangDAO"%>
<%@page import="hibernate.model.DonHang"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<DonHang> getAllDonHang = new DonHangDAO().getAllDonHang();
%>

<div class="workplace">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-grid"></div>
				<h1>Sản phẩm</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid table-sorting">
				<table class="table" id="tSortable">
					<thead>
						<tr>
							<th>Mã đơn hàng</th>
							<th width="15%">Tổng tiền</th>
							<th>Sđt</th>
							<th width="25%">Mã giao dịch</th>
							<th width="25%">Ghi chú</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (DonHang i : getAllDonHang) {
						%>
						<tr>
							<td><%=i.getStt()%><br></td>
							<td><%=StringAction.numberFormat(i.getGia()) %>đ</td>
							<td><%=i.getSdt()%></td>
							<td>
								<%=i.getMaGiaoDich() %>
								<%
									if (i.getMaGiaoDich() == null || i.getMaGiaoDich().equals("")) {
								%>
								<a href="/DonHangServlet?command=remove&stt=<%=i.getStt()%>" onclick="return confirm('Do you want...?')"> <img
									src="modules/img/b_drop.png" width="18" /></a>
								<%
								}
								%>
							</td>
							<td>
								<%=i.getThoiGian()%>
								<br>
								<%=i.getGhiChu()%>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<div class="clear"></div>
			</div>
		</div>

	</div>

	<div class="dr">
		<span></span>
	</div>

</div>

