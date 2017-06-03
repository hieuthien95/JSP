<%@page import="dao.VideoDAO"%>
<%@page import="model.Video"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String stt = request.getParameter("stt");
	if (stt != null) {
		Video i = new VideoDAO().getVideoByStt(Integer.parseInt(stt));

		if (i != null) {
%>

<style>
	.video img {
		width: 100%;
		padding-bottom: 5px
	}
</style>

	<section style="margin-top: 30px">
		<div class="container">
			<div class="row">

				<div class="col-md-9 col-sm-8 padding-left video">

					<img class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
						src="<%=i.getHinhanh()%>" />
					<h2 class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
						style="text-align: center">
						<%=i.getTen()%>
					</h2>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center"
						style="padding: 5px">
						<iframe style="width: 100%; height: 400px"
							title="YouTube video player" src="<%=i.getDuongdan()%>">
						</iframe>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
						style="text-align: justify; padding: 5px">
						<%=i.getNoidung()%>">
					</div>

					<div class="fb-comments"
						data-href="http://www.thiensu.com/DAJAVA/?ac=video&stt=<%=i.getStt()%>"
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
