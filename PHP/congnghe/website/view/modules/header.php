<? 
	session_start();
	$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
?>


<header class="row clearfix" style="position:relative; background: #5fe0eb; border-bottom: 1px solid #fff;">
    <div class="logo-xs visible-sm visible-xs">
    	<a href="/congnghe"> <img style="height:45px" src="website/view/images/sites/ICON.png" /></a>
	</div>
    
    <div class="clearfix"></div>

    <nav class="navbar navbar-default visible-sm visible-xs" role="navigation" style="border-radius: 0px;">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" style="margin-right:10px; margin-left:10px"
          	data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <form method="get" action="./" style="padding:0 10px; margin-top:8px">
            <div class="input-group">
              <input type="text" class="form-control" name="search-keyword" 
              	value="<? echo $_GET["search-keyword"] ?>" />
              <span class="input-group-btn">
                <input type="submit" class="btn btn-default" name="ac" value="Tìm" />
              </span>
            </div><!-- /input-group -->
          </form>
        </div>
    
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            		<li class="mobile" >
                        <a href="./?ac=chonmenu&stt=dtdd" rel="Điện thoại Di Động">Điện thoại</a>
                    </li>
                    <li class="tablet"><a href="./?ac=chonmenu&stt=mtb" rel="Máy tính bảng">Máy tính bảng</a></li>
                    <li class="laptop last"><a href="./?ac=chonmenu&stt=laptop" rel="Laptop" class="">Laptop</a></li>
                
                    <li class="accessories"><a href="./?ac=chonmenu&stt=phukien" rel="Phụ kiện">Phụ kiện</a></li>
                    <li class="digital last"><a href="./?ac=chonmenu&stt=mayanh" rel="Camera" class="">Máy ảnh</a></li>
                
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Khác <span class="caret"></span></a>
              <ul class="dropdown-menu">
                	<li class="news"><a href="./?ac=chonmenu&stt=tintuc" rel="Tin công nghệ">Tin tức</a></li>
                    <li class="ads"><a href="./?ac=chonmenu&stt=video" rel="Video">Video</a></li>
                    <li class="promotion"><a href="./?ac=chonmenu&stt=km" rel="Khuyến mãi">Khuyến mãi</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    
	<div class="logo col-lg-3 col-md-3 hidden-sm hidden-xs" style="padding:0; padding-left: 3px;">
    	<a href="/congnghe"> <img class="img-logo" style="height:57px" src="website/view/images/sites/logo.png" /></a>
	</div>
   
    <div id="site-search" class="form-wrapper col-lg-6 col-md-6 hidden-sm hidden-xs" style="margin-top: 2px;">
        <form id="frmMainSearchForm" class="form clearfix" method="get" action="./" autocomplete="off">
            <div class="input-group">
              <input type="text" class="form-control" id="search-keyword" name="search-keyword" 
                	class="input search-keyword" placeholder="" value="<? echo $_GET["search-keyword"] ?>" />
              <span class="input-group-btn">
                <input type="submit" class="btn btn-default" name="ac" value="Tìm kiếm" />
              </span>
            </div><!-- /input-group -->
        </form>
        
    	<div id="searchresultdata"> </div>
    </div>
    
    
                
          		<!--	begin shoping cart	-->
                <?php
				$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
                if(isset($_SESSION["products"]))
                { ?>
                    <div class="shopping-cart">
						<ul class="aaa" style="margin:0; padding:0">
							<? $total = 0; $count=0;
                            foreach ($_SESSION["products"] as $cart_itm)
                            {?>
                              <li class="cart-itm">
                                  <span class="remove-itm">
                                      <a href="website/model/cart_update.php?removep=<? echo $cart_itm["code"]?>&return_url=<? echo $current_url?>">&times; </a>
                                  </span>
                                 
                                  <b style="font-size:15px"><? echo $cart_itm["name"]?>
                                  <span class="hidden-xs">(Mã SP: <? echo $cart_itm["code"]?>)</span>
                                  </b> <br />
                                   <a href="./?ac=thongtin&stt=<? echo $cart_itm["code"] ?>">
                                   	  <img src="<? echo $currency.$cart_itm["hinhanh"]?>" 
                                      style="height:40px; float:left" />
                                   </a>
                                   <div style="float:left; padding-left:10px">
                                       <div class="p-price">Giá: <?php echo number_format($currency.$cart_itm["gia"])?>₫</div>
                                       <div class="p-qty">Số lượng: <? echo $cart_itm["sl"]?></div>
                                   </div>
                                  
                                   <div class="clearfix"></div>
                              </li>
                            <?
                              $subtotal = ($cart_itm["gia"]*$cart_itm["sl"]);
                              $total = ($total + $subtotal);
							  $count=$count+$cart_itm["sl"];
                            }?>
                        </ul>
                        <span class="check-out-txt">
						  <a style="color:#F63; " class="thanhtoan" href="./?ac=thanhtoan">
                          	<img src="website/view/images/sites/cart.png" style="height:20px; float:left"/> 
                            <i style="line-height:25px; padding:0px 5px; float:left">
                                <span class=""><?php echo number_format($currency.$total)?>₫ </span>
                                
                            </i> 
                          </a>
						  <div class="clearfix" ></div>
                        </span>
                    </div>  
             <? } ?>
                <!--	end shoping cart	-->
    
    
    <div id="user-zone">
    
        <div class="user-account-wrapper">
            <div class="user-avatar">
                
                <img src="<? if($_SESSION["avatar"]!=""){echo $_SESSION["avatar"]; } else{echo "website/view/dangnhap/default_avatar.png";}?>" alt="Tài khoản của bạn" width="40" height="40"style="border-radius:20px">
                
                <div class="user-menu-wrapper">
                    <div class="user-menu" style="right:0">
                        <form action="website/controller/controller_account.php" id="form-login" method="post"> 
                        	<?
							if($_SESSION["quyen"]==null)
							{ ?>                           
                                <input type="text" placeholder="Username" id="username" name="username" style="margin-bottom:5px">
                                <input type="password" id="password" name="password" placeholder="Password">
                                <div class="note-wrapper clearfix">
                                    <div class="lost-password-wrapper">
                                    	<a href="./?ac=forget" class="forgetpass" style="padding:0">Quên mật khẩu</a>
                                        <a href="./?ac=register" rel="nofollow" style="float:right">Đăng ký</a>
                                    </div>
<!--                                    <div class="remember-password-wrapper hidden">
                                        <input class="checkbox lost-password" type="checkbox" id="lost-password" 
                                            name="lost-password" checked="checked" style="float:left">
                                        <label style="float:left; padding-top:4px">ghi nhớ</label>
                                    </div>-->
                                </div>
                                  
                                <input type="hidden" name="return_url" value="<? echo $current_url ?>" />
                                <input style="background:#09F; color:#FFF; float:right" name="dangnhap" 
                                	type="submit" value="ĐĂNG NHẬP">
                                
                                
                                
                            <? }
							else
							{ ?>
                            
                                <ul class="user-links nolist clearfix">
                                	<li style="border-bottom:1px solid #ddd"><a href="./?ac=change_info"><? echo $_SESSION["ten"] ?></a> </li>
                                    <li> <a href="./?ac=change_info"> Hồ sơ cá nhân</a> </li>
                                    <li> <a href="./?ac=thongtindonhang"> Thông tin đơn hàng</a> </li>
                                    <? 
									if($_SESSION["quyen"]=="admin" || $_SESSION["quyen"] == "nhanvien")
									{
										echo "<li><a href='./admin'> Quản lý nội dung</a></li>";
										echo "<li><a href='./?ac=register' rel='nofollow'>Thêm thành viên</a></li>";
									} 
									?>
            						<li> <a href="./?ac=logout">Đăng xuất</a> </li>
                                </ul>
                            <? } ?>
                        </form>                   
                   </div>
                </div>

            </div>

        </div>
        
    </div>
</header>




<div class="site-body row hidden-sm hidden-xs">
	<section class="content-block-wrapper navigation-banner clearfix">
        
        <!--	begin navigation	-->
        <div class="navigation">
            <ul class="col1 nolist" style="width:100%">
                <li class="mobile">
                	<a href="./?ac=chonmenu&stt=dtdd" rel="Điện thoại Di Động">Điện thoại</a>
                </li>
                <li class="tablet"><a href="./?ac=chonmenu&stt=mtb" rel="Máy tính bảng">Máy tính bảng</a></li>
                <li class="laptop last"><a href="./?ac=chonmenu&stt=laptop" rel="Laptop" class="">Laptop</a></li>
            
                <li class="accessories"><a href="./?ac=chonmenu&stt=phukien" rel="Phụ kiện">Phụ kiện</a></li>
                <li class="digital last"><a href="./?ac=chonmenu&stt=mayanh" rel="Camera" class="">Máy ảnh</a></li>
            
                <li class="news">
                	<a style="padding-top: 40px;" href="./?ac=chonmenu&stt=tintuc" rel="Tin công nghệ">Tin tức</a>
                </li>
                <li class="ads">
                	<a style="padding-top: 40px;" href="./?ac=chonmenu&stt=video" rel="Video">Video</a>
                </li>
                <li class="promotion">
                	<a style="padding-top: 40px;" href="./?ac=chonmenu&stt=km" rel="Khuyến mãi">Khuyến mãi</a>
                </li>
            </ul>
        </div>
        <!--	end navigation	-->
        
	</section>
</div>


<div class="site-body row">
    <!--	begin menu top fixed	-->    
    <div id="task_flyout" class="hidden-sm hidden-xs">
        <section class="content-block-wrapper navigation-banner clearfix">
            <!--	begin navigation	-->
            <div class="navigation">
                <ul class="col11 nolist" style="width:100%">
                    <li class="mobile" >
                        <a href="./?ac=chonmenu&stt=dtdd" rel="Điện thoại Di Động">Điện thoại</a>
                    </li>
                    <li class="tablet"><a href="./?ac=chonmenu&stt=mtb" rel="Máy tính bảng">Máy tính bảng</a></li>
                    <li class="laptop last"><a href="./?ac=chonmenu&stt=laptop" rel="Laptop" class="">Laptop</a></li>
                
                    <li class="accessories"><a href="./?ac=chonmenu&stt=phukien" rel="Phụ kiện">Phụ kiện</a></li>
                    <li class="digital last"><a href="./?ac=chonmenu&stt=mayanh" rel="Camera" class="">Máy ảnh</a></li>
                
                    <li class="news"><a href="./?ac=chonmenu&stt=tintuc" rel="Tin công nghệ">Tin tức</a></li>
                    <li class="ads"><a href="./?ac=chonmenu&stt=video" rel="Video">Video</a></li>
                    <li class="promotion"><a href="./?ac=chonmenu&stt=km" rel="Khuyến mãi">Khuyến mãi</a></li>
                </ul>
            </div>
            <!--	end navigation	-->
        </section>
    </div>
    <!--	end menu top fixed	-->
    
</div>


<?
	include("facebook-fanpage.php");
?>