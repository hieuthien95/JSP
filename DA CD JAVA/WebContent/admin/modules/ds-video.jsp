<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.dao.VideoDAO"%>
<%@page import="hibernate.model.Video"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<Video> getAllVideo = new VideoDAO().getAllVideo();
%>

<div class="workplace">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-grid"></div>
				<h1>Video</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid table-sorting">
				<table class="table"
					id="tSortable">
					<thead>
						<tr>
							<th></th>
							<th width="15%">Tên</th>
							<th>Nội dung</th>
							<th class="hidden"></th>
							<th class="hidden"></th>
						</tr>
					</thead>
					<tbody>
						<%
						for(Video i: getAllVideo) { 
						%>
						<tr>
							<td>
								<input type="checkbox" name="checkbox" 
									<%if(i.getTrangthai()==1){out.print("checked='checked'");} %> />
									
								<a href="?ac=updatevideo&stt=<%=i.getStt()%>">
									<img src="modules/img/b_edit.png" width="20" style="margin-top: 10px"/></a><br />
								<a href="/VideoServlet?command=remove&stt=<%=i.getStt()%>" onclick="return confirm('Do you want...?')">
									<img src="modules/img/b_drop.png" width="20" style="margin-top: 10px"/></a><br />
								</td>
							<td>
								<img src="<%="/" + i.getHinhanh() %>"> <br>
								<b>Mã: </b><%="\n" + i.getStt() %><br>
								<h5><%="\n" + i.getTen() %></h5>
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

