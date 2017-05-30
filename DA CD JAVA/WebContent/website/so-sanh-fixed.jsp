<%@page import="tool.StringAction"%>
<%@page import="java.util.Map"%>
<%@page import="model.Cart"%>
<%@page import="model.Item"%>

<%
	int count = 0;
	String link = "";
	Cart compare = (Cart) session.getAttribute("compare");
	
	if (compare != null && compare.countItem()>0) { %>
		<div class="hidden-xs"
			style="position: fixed; z-index: 999999; bottom: 0; left: 0; 
			background: #fff; box-shadow: 4px -2px 10px rgba(0, 0, 0, 0.1); 
			padding: 5px; padding-right: 10px">
	<%
		for (Map.Entry<Long, Item> i : compare.getCartItems().entrySet()) {
			link += "stt" + ++count + "=" + i.getValue().getProduct().getStt() + "&";
	%>
			<div style="float: left; margin: 10px 15px 5px 10px">
				<img style="float: left; margin-right: 5px; height: 50px"
					src="<%=i.getValue().getProduct().getHinhanh()%>">
				<div style="float: left; height: 50px">
					<h5 style="float: left; margin-top: 10; margin-bottom: 5px;">
						<a href="/?command=tt-san-pham&ac=thongtinsp&&stt=<%=i.getValue().getProduct().getStt()%>"
							style="color: black"> 
							<%=i.getValue().getProduct().getLoaisp() + " " 
							+ i.getValue().getProduct().getHangsx() + " "
							+ i.getValue().getProduct().getTen()%>
						</a>
					</h5>
					<h5 style="float: left; margin-top: 10; margin-bottom: 5px; 
						margin-left: 5px">
						<a style="color: red; padding-left: 10px"
							href="CompareServlet?command=remove&productID=<%=i.getValue().getProduct().getStt()%>">o
						</a>
					</h5>
					<p><%=StringAction.numberFormat(i.getValue().getProduct().getGia()) %>đ</p>
				</div>
			</div>
	<% 		
		}
	%>
		<div class="clearfix"></div>
	
		<a style="position: absolute; top: 0; right: 5px" href="so-sanh.jsp?<%=link%>">
	<%
		if (compare!=null && ((Cart) session.getAttribute("compare")).getCartItems().size() >= 2) {
			out.print("o o o");
		}
	%>
		</a>
	</div>
	
	<%
} 
%>