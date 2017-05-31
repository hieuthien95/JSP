<style>
	p {
		font-size:18px !important;
		line-height:30px
	}
	.active {
		background:#0066ff;
		color:#fff !important;
		border:none
	}
	div.trang a{
			padding:3px;
			border:1px solid #0066ff;
			margin:3px;
			text-decoration:none;
			border-radius:2px; 
			text-align:center
	}
</style>

<div class="site-body" style="padding:0px 0px 10px 0px">
	<input type="button" data-toggle="modal" data-target="#myModal" 
    	style="float:right; margin-top:10px" value="Chọn hãng"/>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
    	aria-hidden="true">
      	<div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Chọn hãng</h4>
              </div>
              <div class="modal-body">
                <form class="form clearfix" method="get" >
                    <ul class="nolist">
                        <li>
                            <input type="hidden" name="ac" value="<? echo $_GET["ac"] ?>" />
                            <input type="hidden" name="stt" value="<? echo $_GET["stt"] ?>" />
                            <? 
							foreach($brandList as $brand)
							{ ?>
                            <input type="submit" class="btn btn-default" name="hangsx" style="margin:5px;width:100px"
                            	value="<? echo $brand["tenhang"] ?>" />
                            <? } ?>
                        </li>
                    </ul>
                </form>
              </div>
            </div>
      	</div>
    </div>
</div>

<div class="menu row" style="padding:0px 0px 10px 0px">

	<!--	loadding danh sách điện thoại	-->
	<?php 
		if($_GET["stt"]=="dtdd")
		{ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">   
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["loaisp"]=="Điện thoại")
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            
					  </div>
                      
				</section>
			</div>

	<?	}?>


    <!--	loadding danh sách MTB	-->
    <?php 
		if($_GET["stt"]=="mtb"){ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">    
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["loaisp"]=="Máy tính bảng")
							   { ?>
                                    <li data-webstatus="4"  class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                           
					  </div>
					  
				</section>
			</div>
		<? }?>


    <!--	loadding danh sách laptop	-->
    <?php 
		if($_GET["stt"]=="laptop"){ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">    
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["loaisp"]=="Laptop")
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                           
					  </div>
					  
				</section>
			</div>
		<? }?>
        
    <!--	loadding danh sách phụ kiện	-->
    <?php 
		if($_GET["stt"]=="phukien")
		{ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">    
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["loaisp"]=="Phụ kiện")
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            
					  </div>
					  
				</section>
			</div>
		<? }?>


    <!--	loadding danh sách máy ảnh	-->
    <?php 
		if($_GET["stt"]=="mayanh")
		{ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">    
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["loaisp"]=="Máy ảnh")
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            
					  </div>
					  
				</section>
			</div>
		<? }?>
        
        
        <!--	loadding danh sách máy ảnh	-->
    <?php 
		if($_GET["stt"]=="maycu")
		{ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">    
							<ul class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods) 
							   if($goods["hangsx"]==$_GET["hangsx"] && $goods["sl"]=="Máy củ")
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            
					  </div>
					  
				</section>
			</div>
		<? }?>

</div>

<!--	begin so sánh	-->
<?php
if(isset($_SESSION["ss"]))
{ 
	$link="";
?>
	<div class="hidden-xs" style="position:fixed; bottom:0; right:0; z-index:9999">      	
		<ul style="list-style:none; padding:0; margin:0">
		<?  $i = 1;
            foreach ($_SESSION["ss"] as $cart_itm)
            {?>
                <li style="box-shadow: -2px -2px 10px rgba(0,0,0,0.1); background:#fff; padding:5px; min-width:250px">
                    
                    <a  style="float: right; padding: 4px; line-height: 8px;" href="website/model/cart_update.php?removess=<? echo $cart_itm["code"]?>&return_url=<? echo $current_url?>">&times; </a>
                    
                    
                    <img style="float:left; height:40px; padding-right:5px" src="<? echo $cart_itm["hinhanh"]?>" />
                    <div style="float:left">
                        <b style="font-size:15px"><? echo $cart_itm["name"]?></b><br />
                        <i style="color:#F63"><?php echo number_format($currency.$cart_itm["gia"])?>₫</i>
                    </div>
                    <div class="clearfix"></div>
                </li>
            <?  $link=$link.'&stt'.$i.'='.$cart_itm["code"];
            $i++;
            }?>
		</ul>
                
		<a href="./?ac=sosanh<? echo $link ?>" style="position: absolute; bottom: 8px; right: 2px; color:#39F"> So sánh
		</a>  
	</div> 
<? }?>
<!--	end so sánh	-->