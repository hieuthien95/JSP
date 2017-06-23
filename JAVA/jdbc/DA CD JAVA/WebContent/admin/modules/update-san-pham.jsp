<%@page import="hibernate.dao.LoaiSanPhamDAO"%>
<%@page import="hibernate.model.LoaiSanPham"%>
<%@page import="hibernate.dao.HangSanXuatDAO"%>
<%@page import="hibernate.model.HangSanXuat"%>
<%@page import="hibernate.dao.SanPhamDAO"%>
<%@page import="hibernate.model.SanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	SanPham i = new SanPhamDAO().getSanPhamByStt(Integer.parseInt(request.getParameter("stt")));
	if(i!=null) {
%>

<form action="/SanPhamServlet?command=update&stt=<%=i.getStt() %>"   method="POST" class="workplace"
	enctype="multipart/form-data">

	<div class="row-fluid">

		<div class="span12">
			<div class="head">
				<div class="isw-documents"></div>
				<h1>Cập nhật sản phẩm</h1>
				<div class="clear"></div>
			</div>
			<div class="block-fluid">

				<div class="row-form">
					<div class="span3">Hình ảnh:</div>
					<div class="span7">
						<img width="150" src="/<%= i.getHinhanh() %>"><br>
						<input type="file" name="hinhanh" value="<%=i.getHinhanh()%>" />
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Tên:</div>
					<div class="span9">
						<input type="text" placeholder="Tên sản phẩm" name="ten" value="<%=i.getTen()%>" />
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Giá:</div>
					<div class="span9">
						<input type="text" placeholder="Giá sản phẩm" name="gia" value="<%=i.getGia()%>" />
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Màn hình:</div>
					<div class="span9">
						<select name="manhinh">
							<option  value="<%=i.getManhinh()%>" ><%=i.getManhinh()%></option>
							<option value="2.3 inch">2.3 inch</option>
							<option value="3.2 inch">3.2 inch</option>
							<option value="4 inch">4 inch</option>
							<option value="4.5 inch">4.5 inch</option>
							<option value="5 inch">5 inch</option>
							<option value="5.2 inch">5.2 inch</option>
							<option value="5.5 inch">5.5 inch</option>
							<option value="5.7 inch">5.7 inch</option>
							<option value="6 inch">6 inch</option>
							<option value="6.2 inch">6.2 inch</option>
							<option value="7 inch">7 inch</option>
							<option value="8 inch">8 inch</option>
							<option value="9.7 inch">9.7 inch</option>
							<option value="10 inch">10 inch</option>
							<option value="11 inch">11 inch</option>
							<option value="14 inch">14 inch</option>
							<option value="15.6 inch">15.6 inch</option>
							<option value="17 inch">17 inch</option>

						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Hệ điều hành:</div>
					<div class="span9">
						<select name="hdh">
							<option value="<%=i.getHdh()%>" > <%=i.getHdh()%> </option>
							<option value="Android">Android</option>
							<option value="iOS">iOS</option>
							<option value="Window">Window</option>
							<option value="Symbian">Symbian</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">CPU:</div>
					<div class="span9">
						<input type="text" placeholder="CPU-Chipset" name="cpu" value="<%=i.getCpu()%>" />
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Camera:</div>
					<div class="span9">
						<select name="camera">
							<option value="<%=i.getCamera()%>" > <%=i.getCamera()%> </option>
							<option value="2MP">2MP</option>
							<option value="5MP">5MP</option>
							<option value="12MP">12MP</option>
							<option value="16MP">16MP</option>
							<option value="20MP">20MP</option>
							<option value="23MP	">23MP</option>
							<option value="40MP">40MP</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Pin:</div>
					<div class="span9">
						<input type="text" placeholder="Pin" name="pin" value="<%=i.getPin()%>" />
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-fluid">
					<div class="span3"></div>
					<div class="span9" style="padding: 15px">
						<div class="head">
							<h1>Nhiều hơn</h1>
							<div class="clear"></div>
						</div>
						<div class="block-fluid" id="wysiwyg_container">

							<textarea id="wysiwyg" name="nhieuhon" style="height: 300px;"><%=i.getNhieuhon()%></textarea>

						</div>
					</div>

				</div>

				<div class="row-form">
					<div class="span3">Hãng sản xuất:</div>
					<div class="span9">
						<select name="hangsx">
							<option value="<%=i.getHangsx()%>" > <%=i.getHangsx()%> </option>
							<%
							for(HangSanXuat j: new HangSanXuatDAO().getAllHangSX()) {
							%>
								<option value="<%=j.getTenHang() %>"><%=j.getTenHang() %></option>
							<%} %>
						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Loại sản phẩm:</div>
					<div class="span9">
						<select name="loaisp">
							<option value="<%=i.getLoaisp()%>" > <%=i.getLoaisp()%> </option>
							<%
							for(LoaiSanPham j: new LoaiSanPhamDAO().getAllLoaiSanPham()) {
							%>
								<option value="<%=j.getTenloai() %>"><%=j.getTenloai() %></option>
							<%} %>
						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Khuyến mãi:</div>
					<div class="span9">
						<textarea name="km" placeholder="Khuyến mãi..."><%=i.getKm()%></textarea>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Trạng thái:</div>
					<div class="span9">
						<select name="trangthai">
							<option value="<%=i.getTrangthai()%>" > <%=i.getTrangthai()%> </option>
							<option value="0">Không hiển thị</option>
							<option value="1">Hiển thị</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>

				<div class="row-form">
					<div class="span3">Số lượng:</div>
					<div class="span9">
						<select name="sl">
							<option value="<%=i.getSl()%>" > <%=i.getSl()%> </option>
							<option value="Còn hàng">Còn hàng</option>
							<option value="Hết hàng">Hết hàng</option>
							<option value="Máy củ">Máy củ</option>
							<option value="Không kinh doanh">Không kinh doanh</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>


				<div class="row-form">
					<div class="span3"></div>
					<div class="span9">
						<input class="btn" type="submit" value="Cập nhật sản phẩm">
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

<% }%>