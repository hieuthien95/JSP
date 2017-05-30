<%@page import="java.util.ArrayList"%>
<%@page import="hibernate.dao.HinhAnhDAO"%>
<%@page import="hibernate.model.HinhAnh"%>
<%@page import="hibernate.dao.SanPhamDAO"%>
<%@page import="hibernate.model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String stt = request.getParameter("stt");
	if (stt != null) {
		SanPham sp = new SanPhamDAO().getSanPhamByStt(Integer.parseInt(stt));
		if (sp != null) {
			ArrayList<HinhAnh> getAllHinhAnhBySttSP = new HinhAnhDAO().getAllHinhAnhBySttSP(Integer.parseInt(stt));
%>


<form action="/HinhAnhServlet?command=insert" method="POST"
	class="workplace" style="padding-bottom: 0"
	enctype="multipart/form-data">

	<div class="row-fluid">
		<div class="span12">
			<div class="head">
				<div class="isw-documents"></div>
				<h1>Thêm danh sách hình ảnh</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid">
				<div class="row-form">
					<div class="span6">
						<input type="file" name="hinhanh" /> <input type="hidden"
							name="stt" value="<%=request.getParameter("stt")%>">
					</div>
					<div class="span6">
						<input class="btn" type="submit" value="Thêm hình ảnh">
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
</form>

<div class="workplace" style="padding-top: 0">

	<div class="row-fluid">

		<div class="span12">

			<div class="head">
				<div class="isw-picture"></div>
				<h1>Hình ảnh</h1>
				<div class="clear"></div>
			</div>


			<div class="block thumbs">
				<div class="thumbnail">
					<a class="fancybox" rel="group" href="/<%=sp.getHinhanh()%>"> <img
						src="/<%=sp.getHinhanh()%>" class="img-polaroid" width="95%" />
					</a>
					<p
						style="width: 100%; text-align: center; margin: 0; font-weight: bold;">
						<a href="/tt-san-pham.jsp?ac=thongtinsp&&stt=<%=sp.getStt()%>">
							<%=sp.getLoaisp() + " " + sp.getHangsx() + " " + sp.getTen()%>
						</a>
					</p>

					<form
						action="/SanPhamServlet?command=updatehinhanh&stt=<%=sp.getStt()%>"
						method="POST" enctype="multipart/form-data">
						<div class="row-form" align="center">
							<input type="file" name="hinhanh" /> <br /> <input
								type="hidden" name="dechayduoc" value="dechayduoc"> <input
								class="btn" type="submit" value="Thay đổi">
						</div>
					</form>

				</div>

				<%
							if (getAllHinhAnhBySttSP != null)
								for (HinhAnh i : getAllHinhAnhBySttSP) {
				%>
				<div class="thumbnail">
					<a class="fancybox" rel="group" href="/<%=i.getHinhAnh()%>"> <img
						src="/<%=i.getHinhAnh()%>" class="img-polaroid" width="95%" />
					</a>
					<div class="caption">
						<a class="btn btn-danger" style="float: right" onclick="return confirm('Delete entry?')"
							href="/HinhAnhServlet?command=remove&stt=<%=i.getStt()%>">Xóa</a>
					</div>
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
<%
	}
	}
%>