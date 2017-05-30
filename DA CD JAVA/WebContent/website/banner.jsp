<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	@SuppressWarnings("unchecked")
	ArrayList<SanPham> getTopSanPham = (ArrayList<SanPham>)request.getAttribute("getTopSanPham");
%>

<section id="slider">
	<!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#slider-carousel" data-slide-to="1"></li>
						<li data-target="#slider-carousel" data-slide-to="2"></li>
						<li data-target="#slider-carousel" data-slide-to="3"></li>
						<li data-target="#slider-carousel" data-slide-to="4"></li>
					</ol>

					<div class="carousel-inner">
						<%
							int count = 0;
							for (SanPham i : getTopSanPham) {
								if (++count > 5)
									break;
						%>

						<div
							class="item <%if (count == 1) {
					out.print("active");
				}%>">
							<%
								if (new Random().nextInt(2) % 2 == 0) {
							%>
							<div class="col-sm-6 wow fadeInUpBig">
								<h1>
									<span>ICON</span>CLUB
								</h1>
								<h2>
									<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><%=i.getHangsx() + " " + i.getTen()%></a>
								</h2>
								<p><%=i.getCpu() + "<br>Pin " + i.getPin() + "mAh <br>" + i.getKm()%></p>
								<a type="button" class="btn btn-default get" style="color: #FFF"
									href="/?command=tt-san-pham&stt=<%=i.getStt()%>">Mua	ngay</a>
							</div>
							<div class="col-sm-6 wow fadeInDownBig">
								<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><img
									src="<%=i.getHinhanh()%>" class="girl img-responsive" alt=""
									style="padding: 15px; width: 70%" /></a>
							</div>

							<%
								} else {
							%>

							<div class="col-sm-6 wow fadeInUpBig">
								<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><img
									src="<%=i.getHinhanh()%>" class="girl img-responsive" alt=""
									style="padding: 15px; width: 70%" /></a>
							</div>

							<div class="col-sm-6 wow fadeInDownBig">
								<h1>
									<span>ICON</span>CLUB
								</h1>
								<h2>
									<a href="/?command=tt-san-pham&stt=<%=i.getStt()%>"><%=i.getHangsx() + " " + i.getTen()%></a>
								</h2>
								<p><%=i.getCpu() + "<br>Pin " + i.getPin() + "mAh <br>" + i.getKm()%></p>
								<a type="button" class="btn btn-default get" style="color: #FFF"
									href="/?command=tt-san-pham&stt=<%=i.getStt()%>">Mua ngay</a>
							</div>

							<%
								}
							%>
						</div>
						<%
							}
						%>
					</div>

					<a href="#slider-carousel" class="left control-carousel hidden-xs"
						data-slide="prev"> <i class="fa fa-angle-left"></i>
					</a> <a href="#slider-carousel"
						class="right control-carousel hidden-xs" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>

			</div>
		</div>
	</div>
</section>
<!--/slider-->