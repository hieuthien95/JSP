<?php
    //current URL of the Page. cart_update.php redirects back to this URL
	$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
?>

<a style="text-align:center"
	href="./?ac=thongtin&stt=<? echo $goods["stt"] ?>">
	<div class="img clearfix wow fadeInLeft" style="">
		<img style="height:100% !important,max-height:100% !important" 
        	src="<?php echo $goods['hinhanh'] ?>">
	</div>
	<div class="name clearfix wow fadeInLeft">
		<h3><span><?php echo $goods["hangsx"] ?> </span> <? echo $goods["ten"] ?></h3>
		<div class="price-list clearfix">
            <cite class="price"><?php echo number_format($goods['gia']) ?>₫</cite><br />
            <del class="old-price"></del>
		</div>
	</div>
</a>
<form method="post" action="website/model/cart_update.php" style="text-align:center; padding-top:5px" 
    	class="visible-sm visible-xs wow fadeInLeft">
    	<input type="text" name="sl" value="1" size="2"
        	style="height:20px; width:20px; font-size:9px; padding:0; text-align:center"/>
		<button  name="type" value="add"  class="add_to_cart" 
        	style="background: #06F; color: #FFF; height: 20px; border-radius: 4px; font-size:9px; 	
            line-height:0px">Thêm vào giỏ
        </button>
        <button  name="type" value="addss"  class="add_to_cart hidden-xs" 
        	style="background: #06F; color: #FFF; height: 20px; border-radius: 4px; font-size:9px; 	
            line-height:0px">So sánh
        </button>
		<input type="hidden" name="stt" value="<?php echo $goods['stt'] ?>" />
		<input type="hidden" name="return_url" 
				value="<? echo $current_url ?>" />
</form>
<div class="more-detail clearfix hidden-sm hidden-xs" href="#" style="opacity: 0.95; width:100%; height:220px">
<? if($_SESSION["quyen"]=="admin")
    { ?>
    <span style="position:absolute; right:0">
        <a href="admin/index.php?quanly=hanghoa&ac=themanhkhac&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
            <img src="./admin/view/img/b_img.png" width="27px"/><br />
        </a>
        <a href="admin/index.php?quanly=hanghoa&ac=sua_no_page&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
            <img src="./admin/view/img/b_edit.png" width="25px"/><br />
        </a>
        <a href="admin/view/modules/hanghoa/xuly.php?ac=xoa&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
            <img src="./admin/view/img/b_drop.png" width="25px"/>		
        </a>
    </span>
<? } ?>
	<a href="./?ac=thongtin&stt=<? echo $goods["stt"] ?>">
		<div style="min-height:160px">
			<h3 class="clearfix"><?php echo $goods["hangsx"]." ".$goods["ten"] ?></h3>
			<div class="price-list clearfix">
				<cite class="price"><?php echo number_format($goods['gia']) ?>₫</cite> (<? echo $goods["sl"] ?>)
			</div>
			<ul class="nolist clearfix">
						<li>Màn hình: <?php echo $goods['manhinh'] ?></li>
						<li>HĐH: <?php echo $goods['hdh'] ?></li>
						<li style="max-height:30px; overflow:hidden">
			        	CPU: <?php echo $goods['cpu'] ?>
			        </li>
						<li>Camera: <?php echo $goods['camera'] ?></li>
						<li>Pin: <?php echo $goods['pin'] ?></li>
			</ul>
			<div class="promotion clearfix"><?php echo $goods['km'] ?></div>
		</div>
	</a>
	<form method="post" action="website/model/cart_update.php" style="float:left; text-align:center">
				<input type="text" name="sl" value="1" size="2"  
                	style="height:2fpx; width:30px; padding:0; text-align:center; float:left"/>
				<button  name="type" value="add"  class="add_to_cart" style="background: #06F; margin-left:5px;
                            color: #FFF; height: 25px; border-radius: 4px;">Thêm vào giỏ
                </button>
                <button  name="type" value="addss"  class="add_to_cart" style="background: #06F; 
                            color: #FFF; height: 25px; border-radius: 4px;">so sánh
                </button>
				<input type="hidden" name="stt" value="<?php echo $goods['stt'] ?>" />
				<input type="hidden" name="return_url" 
								value="<? echo $current_url ?>" />
	</form>
</div>