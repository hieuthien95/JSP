<? 
// first thing is to start session 
session_start();

if(!$_SESSION['quyen'] || $_SESSION['quyen']=="nguoidung" )
{
	header('location:../');
}
else if($_SESSION['quyen']=="admin" || $_SESSION['quyen']=="nhanvien")
{ ?>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Trang quản trị nội dung</title>
    <link rel="stylesheet" type="text/css" href="view/css/style.css"/>
    <!-- 	bootstrap	 -->
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../bootstrap/js/jquery-1.11.3.min.js"></script>
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    

<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.watermark.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$("#search-keyword").watermark("Nhập từ cần tìm kiếm");					// Watermart cho khung nhập
$("#search-keyword").keyup(function()
{
	var search_keyword = $(this).val();   						// Lấy giá trị search của người dùng
	var dataString = 'keyword='+ search_keyword;						// Lấy giá trị làm tham số đầu vào cho file ajax-search.php
	if(search_keyword.length>0)								// Kiểm tra giá trị người nhập có > 3 ký tự hay ko
	{
		$.ajax({
			type: "GET",      							// Phương thức gọi là GET
			url: "ajax-search.php",  						// File xử lý
			data: dataString,							// Dữ liệu truyền vào
			beforeSend:  function() {						// add class "loading" cho khung nhập
				$('input#search-keyword').addClass('loading');
			},
			success: function(server_response)					// Khi xử lý thành công sẽ chạy hàm này
			{
				$('#searchresultdata').html(server_response).show();  		// Hiển thị dữ liệu vào thẻ div #searchresultdata
				$('span#faq_category_title').html(search_keyword);		// Hiển thị giá trị search của người dùng
				
				if ($('input#search-keyword').hasClass("loading"))		// Kiểm tra class "loading"
					$("input#search-keyword").removeClass("loading");	// Remove class "loading"
			}
		});
	}
	else {
		$.ajax({
			type: "GET",      							// Phương thức gọi là GET
			url: "ajax-search.php",  						// File xử lý
			data: 00000000000000,							// Dữ liệu truyền vào
			beforeSend:  function() {						// add class "loading" cho khung nhập
				$('input#search-keyword').addClass('loading');
			},
			success: function(server_response)					// Khi xử lý thành công sẽ chạy hàm này
			{
				$('#searchresultdata').html(server_response).show();  		// Hiển thị dữ liệu vào thẻ div #searchresultdata
				$('span#faq_category_title').html(search_keyword);		// Hiển thị giá trị search của người dùng
				
				if ($('input#search-keyword').hasClass("loading"))		// Kiểm tra class "loading"
					$("input#search-keyword").removeClass("loading");	// Remove class "loading"
			}
		});
	}
	return false;										// Không chuyển trang
});
});
</script>
    
    
    <script>
	  $(window).scroll(function(){
		if ($(this).scrollTop() > 100) {
			/*$('#task_flyout').addClass('fixed');*/
			$('#menu').css("top","0");
		} else {
			//$('#task_flyout').removeClass('fixed');
			$('#menu').css("top","110px");
		}
	  });
	</script>
    </head>
    
    <body>    
        <div id="banner">
            <p align="center">Trang quản trị nội dung</p>
        </div> 
            
            
            
        <?
                
        	include("view/modules/menu.php");
                
        	include_once("controller/controller.php");
          	$controller = new Controller();
           	$controller->invoke();
        ?>
        
        
        
        
    </body>
    </html>
<? } ?>