<%@page import="java.util.ArrayList"%>
<%@page import="tool.StringAction"%>
<%@page import="dao.HinhAnhDAO"%>
<%@page import="model.HinhAnh"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (request.getParameter("stt1") != null && request.getParameter("stt2") != null) {

		SanPham sp = new SanPhamDAO().getSanPhamByStt(Integer.parseInt(request.getParameter("stt1")));
		SanPham sp2 = new SanPhamDAO().getSanPhamByStt(Integer.parseInt(request.getParameter("stt2")));

		// cap nhat luot xem
		sp.setLuotxem(sp.getLuotxem() + 1);
		sp2.setLuotxem(sp2.getLuotxem() + 1);
		new SanPhamDAO().update(sp);
		new SanPhamDAO().update(sp2);
%>

<!DOCTYPE html>
<html>
<head>
<title><%=sp.getTen()%></title>
<link rel="icon" href="/website/view/images/sites/ICON1.png"/>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<jsp:include page="/website/header.jsp"></jsp:include>
	
	
	<section style="margin-top: 30px">
		<div class="container">
		
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="/">Home</a></li>
					<li class="active">So sánh</li>
				</ol>
			</div><!--/breadcrums-->
		
			<div class="row">

				<div class="col-sm-6 padding-right">
					<img src="<%=sp.getHinhanh()%>" style="width: 60%" />
					
					<div class="product-details">
						<div class="col-sm-12">
							<div class="product-information">
							
								<h2><%=sp.getTen()%></h2>
								<p>
									<b>ID:</b>
									<%=sp.getStt()%>
								</p>
								<p>
									<b>Tinh Trang:</b>
									<%=sp.getSl()%>
								</p>
								<p>
									<b>HSX:</b>
									<%=sp.getHangsx()%>
								</p>
								<p>
									<b>KM:</b>
									<%=sp.getKm()%>
								</p>

								<span> <span><%=StringAction.numberFormat(sp.getGia()) %>đ</span>
								</span>  <br>
								<a target="_blank" href="./CheckoutServlet"> <img
									style="margin-bottom: 10px"
									src="website/view/images/sites/thanhtoan.png" />
								</a> <a href="CartServlet?command=plus&productID=<%=sp.getStt()%>"
									type="button" class="btn btn-fefault cart" style="color: #fff">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>
							</div>
						</div>

					</div>
					<!--/product-details-->

					<div class="category-tab shop-details-tab">
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details">
								<div class="col-sm-12" style="padding: 5px">
									<p>
										<b>Display: </b><%=sp.getManhinh()%></p>
									<p>
										<b>OS: </b><%=sp.getHdh()%></p>
									<p>
										<b>CPU: </b><%=sp.getCpu()%></p>
									<p>
										<b>Camera: </b><%=sp.getCamera()%></p>
									<p>
										<b>Pin: </b><%=sp.getPin()%></p>
									<p>
										<b>KM: </b><%=sp.getKm()%></p>
									<p>
										<b>Other: </b><%=sp.getNhieuhon()%></p>
								</div>
							</div>

						</div>

						<div class="col-sm-12">
									<%
										ArrayList<HinhAnh> getAllHinhAnhBySttSP = new HinhAnhDAO().getAllHinhAnhBySttSP(sp.getStt());
										if (getAllHinhAnhBySttSP!=null)
										for(HinhAnh i: getAllHinhAnhBySttSP) {
											out.print("<img src='"+ i.getHinhAnh() + "' width='100%' style='margin-top: 5px'>"); 
										}
									%>
						</div>
					</div>

				</div>

	
	
	
				<%sp=sp2; %>

				<div class="col-sm-6 padding-right">
					
					<img src="<%=sp.getHinhanh()%>" style="width: 60%" />
					
					<div class="product-details">
						<div class="col-sm-12">
							<div class="product-information">
							
								<h2><%=sp.getTen()%></h2>
								<p>
									<b>ID:</b>
									<%=sp.getStt()%>
								</p>
								<p>
									<b>Tinh Trang:</b>
									<%=sp.getSl()%>
								</p>
								<p>
									<b>HSX:</b>
									<%=sp.getHangsx()%>
								</p>
								<p>
									<b>KM:</b>
									<%=sp.getKm()%>
								</p>

								<span> <span><%=StringAction.numberFormat(sp.getGia()) %>đ</span>
								</span><br>
								<a target="_blank" href="./CheckoutServlet"> <img
									style="margin-bottom: 10px"
									src="website/view/images/sites/thanhtoan.png" />
								</a> <a href="CartServlet?command=plus&productID=<%=sp.getStt()%>"
									type="button" class="btn btn-fefault cart" style="color: #fff">
									<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
								</a>
							</div>
						</div>

					</div>
					<!--/product-details-->

					<div class="category-tab shop-details-tab">
						<div class="tab-content">
							<div class="tab-pane fade active in" id="details">
								<div class="col-sm-12" style="padding: 5px">
									<p>
										<b>Display: </b><%=sp.getManhinh()%></p>
									<p>
										<b>OS: </b><%=sp.getHdh()%></p>
									<p>
										<b>CPU: </b><%=sp.getCpu()%></p>
									<p>
										<b>Camera: </b><%=sp.getCamera()%></p>
									<p>
										<b>Pin: </b><%=sp.getPin()%></p>
									<p>
										<b>KM: </b><%=sp.getKm()%></p>
									<p>
										<b>Other: </b><%=sp.getNhieuhon()%></p>
								</div>
							</div>

						</div>

						<div class="col-sm-12">
									<%
									getAllHinhAnhBySttSP = new HinhAnhDAO().getAllHinhAnhBySttSP(sp.getStt());
									if (getAllHinhAnhBySttSP!=null)
									for(HinhAnh i: getAllHinhAnhBySttSP) {
										out.print("<img src='"+ i.getHinhAnh() + "' width='100%' style='margin-top: 5px'>"); 
									}
									%>
						</div>
					</div>

				</div>

			</div>
		</div>
	</section>

	<jsp:include page="/website/footer.jsp"></jsp:include>

</body>
</html>
<%
	}
%>