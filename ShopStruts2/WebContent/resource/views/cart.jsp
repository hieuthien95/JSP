<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	

<!DOCTYPE html>
<html lang="en">
<head>



    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>

<body>
	
	
	
	<jsp:include page="layout/header.jsp"/>
	
	
	
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
						<s:iterator var="sp" value="#session.cart.getDsItem().entrySet()">
							
							<s:set var="i" value="#sp.getValue().getProduct()"></s:set>
							
							<tr>
								<td class="cart_product">
									<a href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#i.id" />"><img src="upload/sanpham/<s:text name="#i.hinhanh"/>" alt="" width="50"></a>
								</td>
								<td class="cart_description">
									<h4><a href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#i.id" />"><s:text name="#i.ten"/></a></h4>
									<p>Web ID: <s:text name="#i.id"/></p>
								</td>
								<td class="cart_price">
									<p><s:text name="getText('{0,number,#,##0}',{#i.gia})" />đ</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" href="${pageContext.request.contextPath}/add-to-cart?sanpham.id=<s:text name="#i.id"/>"> + </a>
										<input class="cart_quantity_input" type="text" name="quantity" value="<s:text name="#sp.getValue().qty"/>" autocomplete="off" size="2">
										<a class="cart_quantity_down" href="${pageContext.request.contextPath}/sub-in-cart?sanpham.id=<s:text name="#i.id"/>"> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price"><s:text name="getText('{0,number,#,##0}',{#i.gia})" />đ</p>
								</td>
								<td class="cart_delete">
									<a class="cart_quantity_delete" 
										href="${pageContext.request.contextPath}/remove-in-cart?sanpham.id=<s:text name="#i.id"/>">
											<i class="fa fa-times"></i>
									</a>
								</td>
							</tr>
						
						</s:iterator>

					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
	
	
	
	<jsp:include page="layout/footer.jsp"/>
	
	
</body>
</html>