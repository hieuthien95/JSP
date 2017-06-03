<%@page import="java.util.ArrayList"%>
<%@page import="dao.BaiVietDAO"%>
<%@page import="model.BaiViet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ArrayList<BaiViet> getAllBaiViet  = new BaiVietDAO().getAllBaiViet();
%>

	<section id="form" style="margin-top: 20px">
		<!--form-->
		<div class="container">
			<div class="row">
			
				<div class="col-md-9 col-sm-8" >
				<%
					for (BaiViet i : getAllBaiViet) {
				%>
				<div style="padding-bottom: 20px">
					<a href="./?command=tt-bai-viet&stt=<%=i.getStt()%>"
						style="color: #000">
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"
							style="padding: 0px; padding-bottom: 10px">
							<img src="<%=i.getHinhanh()%>"
								style="width: 100%; overflow: hidden" />
						</div>
						<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12"
							style="text-align: justify; overflow: hidden">
							<b style="font-size: 20px; line-height: 25px"> <%=i.getTieude()%>
							</b> <br />
							<%=i.getTomtat()%>
						</div>

						<div style="clear: both"></div>
					</a>
				</div>

				<%
					}
				%>
				</div>
			
				<jsp:include page="/website/menu.jsp"></jsp:include>
				
			</div>
		</div>
	</section>
	<!--/form-->

