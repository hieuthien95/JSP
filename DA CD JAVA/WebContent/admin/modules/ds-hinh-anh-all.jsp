<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.dao.HinhAnhDAO"%>
<%@page import="hibernate.model.HinhAnh"%>
<%@page import="hibernate.dao.SanPhamDAO"%>
<%@page import="hibernate.model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<HinhAnh> getAllHinhAnh = new HinhAnhDAO().getAllHinhAnh();
%>

<div class="workplace">

	<div class="row-fluid">

		<div class="span12">

			<div class="head">
				<div class="isw-picture"></div>
				<h1>Hình ảnh</h1>
				<div class="clear"></div>
			</div>


			<div class="block thumbs">
				<%
					if (getAllHinhAnh != null)
						for (HinhAnh i : getAllHinhAnh) {
				%>

				<div class="thumbnail">
					<a class="fancybox" rel="group" href="/<%=i.getHinhAnh()%>"> <img
						src="/<%=i.getHinhAnh()%>" class="img-polaroid" width="95%" />
					</a>
					<p style="margin: 5px; text-align: center;">
						STT Sản phẩm:
						<%=i.getSttSp()%></p>
				</div>

				<%
					}
				%>

			</div>
		</div>

	</div>

	<div class="dr">
		<span></span>
	</div>

</div>