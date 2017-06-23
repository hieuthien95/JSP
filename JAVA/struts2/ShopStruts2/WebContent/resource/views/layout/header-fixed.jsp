<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
<!-- thêm jquery.min.js -->
<script type="text/javascript">
    $(window).scroll(function() {
        if ($(this).scrollTop() > 132) {
            $('#task_flyout').css("top", "0");
            $('#task_flyout').css("position", "fixed");
            $('#task_flyout').css("z-index", "99999");
            $('#task_flyout').css("display", "block");
            $('#task_flyout').css("width", $("#header").width());
            $('.header-bottom').css("padding-top", "8px");
            $('.header-bottom').css("padding-bottom", "0");
        } else {
            $('#task_flyout').css("display", "none");
            $('.header-bottom').css("padding-top", "30px");
            $('.header-bottom').css("padding-bottom", "20px");
        }
        

        if ($("#header").width() < 768) {
            $('#task_flyout').css("display", "none");
            $('.header-bottom').css("display", "none");
        }

    });
    

    
    // sự kiện chút chơi
    // $(window).scroll(function() {
    //  var st = $(window).scrollTop();
    //  var sb = $(document).height() - $(window).height() - $(window).scrollTop();
    //  $('#scroll-status').replaceWith('<span id="scroll-status" style="position: fixed; right:0; bottom: 40px;">Top: ' + st + '<br>Bottom: ' + sb + '</span>');
    // });
    
    $(window).mousemove(function(event) {
        $('#mousemove-status').replaceWith("<span id='mousemove-status' style='position: fixed; right:0; bottom: 80px;'>X: " + event.pageX + "<br>Y: " + event.pageY + "</span>");;
        // $("#mousemove-status").text(event.pageX + ", " + event.pageY);
        
        var st = $(window).scrollTop();
        var sb = $(document).height() - $(window).height() - $(window).scrollTop();
        $('#scroll-status').replaceWith("<span id='scroll-status' style='position: fixed; right:0; bottom: 40px;'>T: " + st + "<br>B: " + sb + "</span>");
    });
    
</script>
<style>
/*.fixed {position:fixed; top:0}*/
#task_flyout {
    display: none
}
</style>




<header id="task_flyout">
    <div class="header-bottom hidden-xs wow fadeInDown"
        style="background: #FBFBFB; box-shadow: 4px 3px 10px rgba(0, 0, 0, 0.1)">
        <!--header-bottom-->
        <div class="container">
            <div class="row" >
                <div class="mainmenu">
                    <ul class="nav navbar-nav collapse navbar-collapse">
                        <li><a href="${pageContext.request.contextPath}/#sanpham" class="active">Sản phẩm</a></li>
                        
							<s:iterator var="loai" value="dsloaisp">
                                <li class="dropdown">
                                	<a href="${pageContext.request.contextPath}/product-list?keyword=<s:property value="#loai.ten" />">
                                		<s:property value="#loai.ten" /><i class="fa fa-angle-down"></i>
                                	</a>
                                    <ul role="menu" class="sub-menu">
                                    	<s:iterator var="hang" value="dshangsx">
                                    	<s:if test="#hang.parent == #loai.id">
										<li><a href="${pageContext.request.contextPath}/product-list?keyword=<s:property value="#loai.ten + ' ' + #hang.ten" />">
											<s:property value="#hang.ten" /></a>
										</li>				
										</s:if>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>

                        <li class="dropdown"><a href="${pageContext.request.contextPath}/#tintuc">Tin tức<i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                                <li><a href="${pageContext.request.contextPath}/bai-viet-list">Bài viết</a></li>
                                <li><a href="${pageContext.request.contextPath}/video-list">Video</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</header>
<!--/header-->
