<%-- 
    Document   : menu
    Created on : Jan 20, 2017, 11:46:34 PM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>

        <script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>

    </head>
    <body>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Category</h2>
                <div class="panel-group category-products" id="accordian"><!--category-productsr-->

                    <c:forEach var="item" items="${listCategory}" >
                        <c:if test="${item.categoryParent==0}">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian" href="#${item.categoryID}">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                            <a href="${pageContext.request.contextPath}/category/list/?categoryID=${item.categoryID}" > ${item.categoryName} </a>
                                        </a>
                                    </h4>
                                </div>
                                <div id="${item.categoryID}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                            <c:forEach var="itemChild" items="${listCategory}" >
                                                <c:if test="${itemChild.categoryParent==item.categoryID}">
                                                    <li><a href="${pageContext.request.contextPath}/category/list/?categoryID=${itemChild.categoryID}">${itemChild.categoryName} </a></li>
                                                    </c:if>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title"><a href="#">Shoes</a></h4>
                        </div>
                    </div>
                </div><!--/category-products-->

                <div class="brands_products"><!--brands_products-->
                    <h2>Brands</h2>
                    <div class="brands-name">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#"> <span class="pull-right">(50)</span>Acne</a></li>
                            <li><a href="#"> <span class="pull-right">(56)</span>Grüne Erde</a></li>
                        </ul>
                    </div>
                </div><!--/brands_products-->
            </div>
        </div>
    </body>
</html>
