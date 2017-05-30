<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.model.BaiViet"%>
<%@page import="hibernate.dao.BaiVietDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<BaiViet> getAllBaiViet = new BaiVietDAO().getAllBaiViet();
%>

<div class="workplace">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-grid"></div>
				<h1>Bài viết</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid table-sorting">
				<table class="table" id="tSortable">
					<thead>
						<tr>
							<th></th>
							<th width="30%">Tên</th>
							<th>Nội dung</th>
							<th class="hidden"></th>
							<th class="hidden"></th>
						</tr>
					</thead>
					<tbody>
						<%
						for(BaiViet i: getAllBaiViet) { 
						%>
						<tr>
							<td>
								<input type="checkbox" name="checkbox" 
									<%if(i.getTrangthai()==1){out.print("checked='checked'");} %> />
									
								<a href="?ac=updatebaiviet&stt=<%=i.getStt()%>">
									<img src="modules/img/b_edit.png" width="20" style="margin-top: 10px"/></a><br />
								<a href="/BaiVietServlet?command=remove&stt=<%=i.getStt()%>" onclick="return confirm('Do you want...?')">
									<img src="modules/img/b_drop.png" width="20" style="margin-top: 10px"/></a><br />
								</td>
							<td>
								<img src="<%="/" + i.getHinhanh() %>">
								<h5><%="\n" + i.getLoaitin() %>
								<%="\n" + i.getStt() %></h5>
								
								<h4><%=i.getTieude() %></h4>
								<b>Tóm tắt: </b><%=i.getTomtat() %>
							</td>
							<td>
								<%=i.getNoidung() %>
							</td>
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
