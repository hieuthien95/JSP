﻿<style>
	td, table{
		border:0
	}
	tr{
		height:5px
	}
</style>

<?php
$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
session_start();

$model = new Model();
$con  = $model->connectDatabase();
?>

<? 
if($_SESSION["quyen"] == null)
{ ?>
    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" style="padding: 10px; margin-bottom:10px">      
    
    	<h4 align="center">Đăng nhập để nhận các ưu đãi về sau </h4>
        <form action="website/controller/controller_account.php" id="form-login" method="post">                          
			<input type="text" placeholder="Username" name="username" style="margin-bottom:5px; width:100%">
			<input type="password" name="password" placeholder="Password" style="margin-bottom:5px; width:100%">
			
			<br /><a href="./?ac=register" style="color:#09F">Đăng ký ngay</a>
			<input style="background:#09F; color:#FFF; float:right; width:50%" 
            	 name="dangnhap" type="submit" value="ĐĂNG NHẬP">
            <input type="hidden" name="return_url" value="<? echo $current_url ?>" />
		</form>          
        <div class="clearfix"></div>
    </div>
<? } ?>




<div class="view-cart <? if(isset($_SESSION["quyen"])){echo 'col-lg-12 col-md-12';} else{ echo 'col-lg-8 col-md-8';} ?> col-sm-12 col-xs-12">
  <?php
	if(isset($_SESSION["products"]))
    {
	    $total = 0; 
  		static $ghichu="";
	?>
		<form method="post" action="./?ac=tinhtien<? echo $ghichu; ?>">
            <ul style="margin: 0; padding: 0; list-style: none;">
				<li class="cart-itm">
					<div class="product-info">
						<div style="float:left; width:50%"><b>Tên</b></div>
                        <div style="float:left; width:10%" class="p-sl"><b>SL</b></div>
                        <span class="hidden-xs">
                            <div style="float:left; width:15%" class="p-sl"><b>Mã</b></div>
                            <div style="float:left; width:20%" class="p-gia"><b>Giá</b></div>
                            <div style="float:right; width:5%; text-align:right" class="p-sl"><b>Xóa</b></div>
                        </span>
                        
                        <div class="clearfix"></div>
					</div>
				</li>
				<? $cart_items = 0;
                foreach ($_SESSION["products"] as $cart_itm)
                {
                   $stt = $cart_itm["code"];
                   $results = mysqli_query($con, "SELECT ten,cpu, gia FROM sanpham WHERE stt='$stt' LIMIT 1");
                   $obj = mysqli_fetch_object($results);
                   ?>
                    <li class="cart-itm">
                        <span class="remove-itm">
                            <a href="website/model/cart_update.php?removep=<? echo $cart_itm["code"] ?>&return_url=<? echo $current_url?>">&times;</a>
                        </span>
                        <div class="product-info">
                            <div style="float:left; width:50%; overflow:hidden"><? echo $obj->ten ?></div>
                            <div style="float:left; width:10%" class="p-sl"><? echo $cart_itm["sl"] ?></div>
                            <span class="hidden-xs">
                                <div style="float:left; width:15%" class="p-sl"><? echo $stt ?></div>
                                <div style="float:left; width:20%" class="p-gia">
                                    <?php echo number_format($currency.$obj->gia) ?>
                                </div>
                            </span>
                        	<div class="clearfix"></div>
                        </div>
                    </li>
                    <? 
                    $subtotal = ($cart_itm["gia"]*$cart_itm["sl"]);
                    $total = ($total + $subtotal);
					$ghichu=$ghichu.$obj->ten.'('.$stt.')x'.$cart_itm["sl"].'; ';
                    ?>
                    
                    <input type="hidden" name="item_name[<? echo $cart_items ?>]" value="<? echo $obj->ten ?>" />
                    <input type="hidden" name="item_code[<? echo $cart_items ?>]" value="<? echo $stt ?>" />
                    <input type="hidden" name="item_desc[<? echo $cart_items ?>]" value="<? echo $obj->cpu ?>" />
                    <input type="hidden" name="item_sl[<? echo $cart_items ?>]" value="<? echo $cart_itm["sl"] ?>" />
                    <?
                    
                    $cart_items ++;
                }?>
                </ul>
                <span class="check-out-txt">
                    <strong style="float:left; font-size:20px; padding-top:15px; margin-bottom:15px">
                    	Tổng tiền : <?php echo number_format($currency.$total) ?>₫
                    </strong>
                    
                    
                    
                    <a style="float:right" target="_blank" 
                    	href="./?ac=donhang&price=<?php echo base64_encode($currency.$total) ?>&comments=<? echo base64_encode($ghichu) ?>">
                    	<img src="website/view/images/sites/thanhtoan.png" />
                    </a>
                    
                </span>
                
                
                
            </form>
		<?
    }else
	{
		echo 'Your Cart is empty';
	}
	
    ?>
</div>

<div class="clearfix"></div>