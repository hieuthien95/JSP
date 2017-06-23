<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	

<s:if test="#session.compare !=null && #session.compare.countItem() > 0">

<div class="hidden-xs" style="position: fixed; z-index: 999999; bottom: 0; left: 0; background: #fff; box-shadow: 4px -2px 10px rgba(0, 0, 0, 0.1); padding: 5px; padding-right: 10px">
	
	<s:iterator var="sp" value="#session.compare.getDsItem().entrySet()">
		<s:set var="i" value="#sp.getValue().getProduct()"></s:set>
			
			<div style="float: left; margin: 10px 15px 5px 10px">
				<img style="float: left; margin-right: 5px; height: 50px"
					src="upload/sanpham/<s:text name="#i.hinhanh"/>">
				<div style="float: left; height: 50px">
					<h5 style="float: left; margin-top: 10; margin-bottom: 5px;">
						<a href="${pageContext.request.contextPath}/product?sanpham.id=<s:property value="#i.id" />"
							style="color: black"> 
							<s:text name="#i.hangsx + ' ' + #i.ten"/>
						</a>
					</h5>
					<h5 style="float: left; margin-top: 10; margin-bottom: 5px; 
						margin-left: 5px">
						<a style="color: red; padding-left: 10px"
							href="${pageContext.request.contextPath}/remove-in-so-sanh?sanpham.id=<s:text name="#i.id"/>">o
						</a>
					</h5>
					<p><s:text name="getText('{0,number,#,##0}',{#i.gia})" />đ</p>
				</div>
			</div>
			
	</s:iterator>
	
	<div class="clearfix"></div>
	
	<s:if test="#session.compare.countItem() == 2">
		<a style="position: absolute; top: 0; right: 5px" href="${pageContext.request.contextPath}/so-sanh">
			o o o
		</a>
	</s:if>
	<s:if test="#session.compare.countItem() > 2">
		<a style="position: absolute; top: 0; right: 5px; color: red;">
			x x x
		</a>
	</s:if>
	
</div>

</s:if>
	