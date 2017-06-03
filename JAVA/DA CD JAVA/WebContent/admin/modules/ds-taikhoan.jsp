<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.dao.UserDAO"%>
<%@page import="hibernate.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<User> getAllUser = new UserDAO().getAllUser();
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
							<th></th>
							<th width="15%">Tên/ Username</th>
							<th>Thông tin</th>
							<th width="25%">Quyền</th>
							<th class="hidden"></th>
						</tr>
					</thead>
					<tbody>
						<%
							for (User i : getAllUser) {
						%>
						<tr>
							<td width="55"><a href="#"><img src="/<%=i.getAvatar()%>"
									class="img-polaroid" width="40" /></a>
								<p class="actions">
									<a href="#"><span class="icon-envelope"></span> </a> <a href="#"><span
										class="icon-lock"></span></a>
								</p>
							</td>
							<td><a href="#" class="user"><%=i.getTen()%></a>
								<p class="about">
									<span class="icon-user"></span>
									<%=i.getUsername()%>
								</p>
							</td>
							<td><span class="icon-home"></span> <%=i.getEmail()%> <br />
	
								<span class="icon-envelope"></span> <%=i.getSdt()%>
							</td>
							<td><span class="icon-hdd"></span> <%=i.getQuyen()%><br />
								<span class="icon-tasks"></span> <%=i.getDiemTichTuy()%>
							</td>
							<td class="hidden"></td>
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