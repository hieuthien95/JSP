<%@page import="hibernate.dao.VideoDAO"%>
<%@page import="hibernate.model.Video"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Video i = new VideoDAO().getVideoByStt(Integer.parseInt(request.getParameter("stt")));
	if(i!=null) {
%>
<form action="/VideoServlet?command=update&stt=<%=i.getStt()%>" method="POST" class="workplace"
	enctype="multipart/form-data">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-documents"></div>
				<h1>Cập nhật video</h1>
				<div class="clear"></div>
			</div>

			<div class="block-fluid">

				<div class="row-form">
					<div class="span3">Tên:</div>
					<div class="span9">
						<input type="text" name="ten" value="<%=i.getTen()%>"/>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Hình ảnh:</div>
					<div class="span7">
						<img width="150" src="/<%= i.getHinhanh() %>"><br>
						<input type="file" name="hinhanh" />
					</div>
					<div class="clear"></div>
				</div>
				
				<div class="row-form">
					<div class="span3">Trạng thái:</div>
					<div class="span9">
						<select name="trangthai">
							<option value="<%=i.getTrangthai()%>"><%=i.getTrangthai()%></option>
							<option value="0">Không hiển thị</option>
							<option value="1">Hiển thị</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
				
				<div class="row-form">
					<div class="span3">Đường dẫn:</div>
					<div class="span9">
						<input type="text" name="duongdan" value="<%=i.getDuongdan()%>" />
					</div>
					<div class="clear"></div>
				</div>



				<div class="row-fluid">
					<div class="span3"></div>
					<div class="span9" style="padding: 15px">
						<div class="head">
							<h1>Nội dung</h1>
							<div class="clear"></div>
						</div>
						<div class="block-fluid" id="wysiwyg_container">

							<textarea id="wysiwyg" name=noidung style="height: 300px;"><%=i.getNoidung()%></textarea>

						</div>
					</div>
				</div>



				<div class="row-form">
					<div class="span3"></div>
					<div class="span9">
						<input class="btn" type="submit" value="Cập nhật Video">
					</div>
					<div class="clear"></div>
				</div>

			</div>
		</div>

	</div>

	<div class="dr">
		<span></span>
	</div>

</form>

<%}%>