<%@page import="dao.BaiVietDAO"%>
<%@page import="model.BaiViet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String stt = request.getParameter("stt");

	if (stt != null) {
		BaiViet i = new BaiVietDAO().getBaiVietByStt(Integer.parseInt(stt));

		if (i != null) {
%>

<style>
.baiviet img {
	width: 100%;
	padding-bottom: 5px
}
</style>

	<section style="margin-top: 30px">
		<div class="container">
			<div class="row">

				<div class="col-md-9 col-sm-8 padding-left baiviet">

					<img src="<%=i.getHinhanh()%>" />
					<h2 style="text-align: center; margin-top: 5px">
						<%=i.getTieude()%>
					</h2>
					<h3 style="text-align: justify; padding: 0px 5px">
						<%=i.getTomtat()%>
					</h3>
					<div style="text-align: justify; padding: 0px 5px">
						<%=i.getNoidung()%>
					</div>

					<div class="fb-comments"
						data-href="http://www.thiensu.com/DAJAVA/?ac=baiviet&stt=<%=i.getStt()%>"
						data-colorscheme="light" data-numposts="5" data-width="100%"></div>

				</div>
				
				<jsp:include page="/website/menu.jsp"></jsp:include>

			</div>
		</div>
	</section>

<%
	} else {
			response.sendRedirect("/");
		}
	} else {
		response.sendRedirect("/");
	}
%>
