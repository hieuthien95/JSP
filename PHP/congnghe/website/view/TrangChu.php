<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<?php 
	$controller = new Controller();
	include("modules/head.php") ?>
    
    <body>
        <div id="site-wrapper" class="container align-center clearfix" style="box-shadow:rgba(0, 0, 0, 0.08) -1px 3px 10px">
            <?php include("modules/header.php") ?>
    	
            <?php 
				/*	chọn link san pham	*/
				if($_GET['ac']=="sosanh")
					include("modules/content_so_sanh.php");
				/*	chọn link san pham	*/
				else if($_GET['ac']=="thongtin") {
					$controller->getThongTinSP("hanghoa", $_GET["stt"]);
				}
				/*	chọn link tin tức	*/
				else if($_GET['ac']=="tintuc")
					include("modules/content_tin_tuc.php");
				/*	chọn link tin tức	*/
				else if($_GET['ac']=="video")
					include("modules/content_video.php");
				/*	chọn mục trong navigation	*/
				else if($_GET['ac']=="chonmenu")
					$controller->getPageChonMenu($_GET["stt"], $_GET["hangsx"]);					
				/*	chọn button thanh toán	*/
				else if($_GET['ac']=="thanhtoan")
					include("modules/view_cart.php");
				/*	thêm đơn hàng	*/
				else if($_GET['ac']=="donhang" || isset($_GET['accapnhat']))
					include("./website/controller/controller_don_hang.php");
				/*	cập nhật đơn hàng	*/
				else if($_GET['ac']=="thongtindonhang")
					include("modules/thongtin_donhang.php");
				/*	tìm kiếm sản phẩm	*/
				else if($_GET['ac']=="Tìm kiếm" || $_GET['ac']=="Tìm")
					include("modules/show_search.php");
				/*	đăng ký tài khoản	*/
				else if($_GET['ac']=="register")
					include("modules/register.php");
				/*	đăng ký tài khoản	*/
				else if($_GET['ac']=="forget")
					include("modules/forget.php");
				/*	thay đổi tài khoản	*/
				else if($_GET['ac']=="change_info")
					include("modules/change_info.php");
				/*	đăng nhập	*/
				else if($_GET['ac']=="logout")
					include("./website/controller/controller_account.php");
				/*	mặc định đưa về trang chủ	*/
				else
					include("modules/content.php");
			?>
            
            <?php include("modules/footer.php") ?>
             <div id="jssor_1" style="height:0"> 
                <div class="slides" data-u="slides"></div>
             </div>
        
        </div>
	</body>

</html>