<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.model.HangSanXuat"%>
<%@page import="hibernate.dao.HangSanXuatDAO"%>
<%@page import="hibernate.dao.LoaiSanPhamDAO"%>
<%@page import="hibernate.model.LoaiSanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	ArrayList<LoaiSanPham> getAllLoaiSanPham = new LoaiSanPhamDAO().getAllLoaiSanPham();
	ArrayList<HangSanXuat> getAllHangSX = new HangSanXuatDAO().getAllHangSX();
%>

<div class="clearfix"></div>


<div class="workplace">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-grid"></div>
				<h1>Hãng sãn xuất</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid table-sorting">
				<table class="table" id="tSortable">
					<thead>
						<tr>
							<th>Stt</th>
							<th>Mã hãng</th>
							<th>Tên hãng</th>
							<th>STT loại SP</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						for(HangSanXuat i: getAllHangSX) { 
						%>
						<tr>
							<form action="/AdminServlet" method="get">
							<input name="command" type="hidden" value="update-hsx">
								<td>
									<%=i.getStt() %>
								</td>
								<td>
									<%=i.getMaHang()%>
								</td>
								<td>
									<%=i.getTenHang() %>
								</td>
								<td>
									<input name="stt" type="hidden" value="<%=i.getStt()%>">
									<input name="sttloaisp" type="text" value="<%=i.getSttloaisp()%>">
								</td>
								<td>
									<input class="btn btn-default" type="submit" value="Submit">
									<a class="btn btn-danger" onclick="return confirm('Do you want...?')"
										href="/AdminServlet?command=delete-hsx&stt=<%=i.getStt()%>">
										Delete
									</a>
								</td>
								
							</form>
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



	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-grid"></div>
				<h1>Loại Sản phẩm</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid table-sorting">
				<table class="table" id="tSortable">
					<thead>
						<tr>
							<th>Stt</th>
							<th>Tên loại</th>
							<th class="hidden"></th>
							<th class="hidden"></th>
							<th class="hidden"></th>
						</tr>
					</thead>
					<tbody>
						<%
						for(LoaiSanPham i: getAllLoaiSanPham) { 
						%>
						<tr>
							<td>
								<%=i.getStt() %>
							</td>
							<td>
								<%=i.getTenloai() %>
							</td>
							<td class="hidden"></td>
							<td class="hidden"></td>
							<td class="hidden"></td>
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
