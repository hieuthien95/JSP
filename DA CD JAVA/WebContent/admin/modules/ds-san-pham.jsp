<%@page import="java.util.ArrayList"%>
<%@page import="tool.StringAction"%>
<%@page import="hibernate.dao.SanPhamDAO"%>
<%@page import="hibernate.model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<SanPham> getAllSanPham = new SanPhamDAO().getAllSanPham();
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
				<table class="table"
					id="tSortable">
					<thead>
						<tr>
							<th></th>
							<th width="15%">Hình ảnh</th>
							<th>Tên</th>
							<th width="25%">Cấu hình</th>
							<th width="25%">Chi tiết</th>
						</tr>
					</thead>
					<tbody>
						<%
						for(SanPham i: getAllSanPham) { 
						%>
						<tr>
							<td>
								<input type="checkbox" name="checkbox" 
									<%if(i.getTrangthai()==1){out.print("checked='checked'");} %>/>
									
								<a href="?ac=dshinhanh&stt=<%=i.getStt()%>">
									<img src="modules/img/b_img.png" width="20" style="margin-top: 10px"/></a><br />
								<a href="?ac=updatesanpham&stt=<%=i.getStt()%>">
									<img src="modules/img/b_edit.png" width="20" style="margin-top: 10px"/></a><br />
								<a href="/SanPhamServlet?command=remove&stt=<%=i.getStt()%>" onclick="return confirm('Do you want...?')">
									<img src="modules/img/b_drop.png" width="20" style="margin-top: 10px"/></a><br />
							</td>
							<td>
								<img src="<%="/" + i.getHinhanh() %>">
							</td>
							<td>
								<h4><%=i.getLoaisp()+" "+i.getHangsx()+" "+i.getTen() %></h4>
								<h4 style="color: red"><%=StringAction.numberFormat(i.getGia()) %>đ</h4>
								<b>Mã: </b><%=i.getStt() %><br>
							</td>
							<td>
								<b>Màn hình: </b><%=" "+i.getManhinh() %><br>
								<b>HĐH: </b><%=i.getHdh() %>
								<b>CPU: </b><%=i.getCpu() %><br>
								<b>Camera: </b><%=i.getCamera() %><br>
								<b>Pin: </b><%=i.getPin() %><br>
								<b>Lượt xem: </b><%="Lượt xem: " + i.getLuotxem() %><br>
								
								<b>Tình trạng: </b> <b style="color: red" ><%=i.getSl() %></b><br>
							</td>
							<td>
								<%=i.getNhieuhon() %>
								<b>KM: </b><%="\n" + i.getKm() %>
							</td>
						</tr>
						<%} %>
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

