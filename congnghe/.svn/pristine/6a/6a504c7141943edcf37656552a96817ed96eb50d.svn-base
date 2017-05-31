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
<? 
if($_GET["stt"]=="dtdd" || $_GET["stt"]=="mtb" || $_GET["stt"]=="laptop" || $_GET["stt"]=="mayanh" 
|| $_GET["stt"]=="phukien" || $_GET["stt"]=="maycu")
{ ?>
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
<? } ?>
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
							   foreach($PhonesList as $goods) 
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            
					  </div>
                      <div class="clearfix"> </div>
					  		<!--	phân trang	-->
                            <? $sotrang = $NumPhones; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                                	href="?ac=chonmenu&stt=dtdd&trang=<? echo $i ?>">
                                   <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
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
							   foreach($MTBsList as $goods) 
							   { ?>
                                    <li data-webstatus="4"  class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            <!--	phân trang	-->
                            <? $sotrang = $NumMTBs ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=mtb&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
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
							   foreach($LaptopsList as $goods) 
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            <!--	phân trang	-->
                            <? $sotrang = $NumLaptops; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=laptop&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
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
							   foreach($MayAnhsList as $goods) 
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            <!--	phân trang	-->
                            <? $sotrang = $NumMayAnhs; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=mayanh&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
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
							   foreach($PKsList as $goods) 
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            <!--	phân trang	-->
                            <? $sotrang = $NumPKs; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=phukien&trang=<? echo $i ?>">
                                     <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
					  </div>
					  
				</section>
			</div>
	<?	}?>
    <!--	loadding danh sách máy củ	-->
    <?php 
		if($_GET["stt"]=="maycu")
		{ ?>
			<div class="site-body">
				<section class="content-block-wrapper product-news clearfix">
				  
					  <div class="product-list-wrapper" style="width:100%">   
                       		<input type='hidden' id='current_page' /> <!--2 input và id='content' của phân trang-->
							<input type='hidden' id='show_per_page' />  
							<ul id='content' class="product-list nolist clearfix" style="width:100%">
							   <?php 
							   foreach($goodsList as $goods)
							   if($goods["sl"]=="Máy củ") 
							   { ?>
                                    <li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
                                        <? include("website/view/modules/product.php");?>
                                    </li>
                            <? } ?>
							</ul>
                            <div style="text-align:center; margin:10px" id="page_navigation">
                			</div><!--id="page_navigation của phân trang-->
					  </div>
					  
				</section>
			</div>
	<?	}?>

    <!--	loadding danh sách tin tức	-->
    
    <?php 
		if($_GET["stt"]=="tintuc")
		{ 	
			foreach($NewsList as $news) 
				{ ?>
					<a href="./?ac=tintuc&stt=<? echo $news["stt"] ?>">
                      <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12" style="padding:0px; padding-bottom:10px"> 
                          <img src="<?php echo $news['hinhanh'] ?>" style="width:100%; overflow:hidden" /> 
                      </div>
                      <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" style="text-align:justify; overflow: hidden">
                            <b style="font-size:20px; line-height:25px"><?php echo $news['tieude'] ?></b> <br />
                            <?php echo $news['tomtat'] ?>
                      </div>
                      
                      <div style="clear:both"></div>
					</a>
			<? 	}  ?>
		 					<!--	phân trang	-->
                            <? $sotrang = $NumNews; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=tintuc&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
	 <? }?>
	


    <!--	loadding danh sách khuyến mại	-->
    
    <?php 
		if($_GET["stt"]=="km")
		{ 	
			foreach($KMsList as $news) 
				{ ?>
					<a href="./?ac=tintuc&stt=<? echo $news["stt"] ?>">
                      <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12" style="padding:0px; padding-bottom:10px"> 
                          <img src="<?php echo $news['hinhanh'] ?>" style="width:100%; overflow:hidden" /> 
                      </div>
                      <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" style="text-align:justify; overflow: hidden">
                            <b style="font-size:20px; line-height:25px"><?php echo $news['tieude'] ?></b> <br />
                            <?php echo $news['tomtat'] ?>
                      </div>
                      
                      <div style="clear:both"></div>
					</a>
			<? 	}  ?>
		 					<!--	phân trang	-->
                            <? $sotrang = $NumKMs; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=tintuc&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
	 <? }?>
        
    <!--	loadding danh sách video	-->
    
    <?php 
		if($_GET["stt"]=="video")
		{
			$count = sizeof($videoList);
			for($i=0; $i < $count ; $i=$i+2)
			{ ?>
					<a style="display:block; padding:0px 0px 10px 0px" class="col-lg-6 col-md-6 col-sm-6 col-xs-12" href="./?ac=video&stt=<? echo $videoList[$i]["stt"] ?>">
                            <div class="img-video col-lg-4 col-md-4 col-sm-4 col-xs-12" style="padding:0px"> 
                                <img src="<?php echo $videoList[$i]['hinhanh'] ?>" 
                                	style="width:100%; overflow:hidden" /> 
                            </div>
                            
                            <div class="tit-video col-lg-8 col-md-8 col-sm-8 col-xs-12" 
                                style="text-align:justify; overflow: hidden; padding-top:5px">
                                <b style="font-size:20px; line-height:25px"><?php echo $videoList[$i]['ten'] ?></b> <br />
                            </div>
					</a>
                    <? if($i+1 < $count){ ?>
                    <a style="display:block; padding:0px 0px 10px 0px" class="col-lg-6 col-md-6 col-sm-6 col-xs-12" href="./?ac=video&stt=<? echo $videoList[$i+1]["stt"] ?>">
                            <div class="img-video col-lg-4 col-md-4 col-sm-4 col-xs-12" style="padding:0px"> 
                                <img src="<?php echo $videoList[$i+1]['hinhanh'] ?>" 
                                	style="width:100%; overflow:hidden" /> 
                            </div>
                            
                            <div class="tit-video col-lg-8 col-md-8 col-sm-8 col-xs-12" 
                                style="text-align:justify; overflow: hidden; padding-top:5px">
                                <b style="font-size:20px; line-height:25px"><?php echo $videoList[$i+1]['ten'] ?></b> <br />
                            </div>
					</a>
                    <? } ?>
                    <div class="clearfix" ></div>         
			<? } ?>
             				<!--	phân trang	-->
                            <? $sotrang = $NumVideos; ?>
                            <div  style="text-align:center; margin:10px" class="trang">
								<? 	$i=1;
                                    while($i <= $sotrang){
                                ?>	
                                <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> "
                                	href="?ac=chonmenu&stt=video&trang=<? echo $i ?>">
                                    <? echo $i; ?>
                                </a>
                                <? 	$i++;
                                    } ?>
                			</div>
		<? }?>


</div>

<!--	begin so sánh	-->
<?php
//current URL of the Page. cart_update.php redirects back to this URL
	$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
if(isset($_SESSION["ss"]))
{ 
	$link="";
?>
	<div style="position:fixed; bottom:0; right:0; z-index:9999">      	
		<ul style="list-style:none; padding:0; margin:0">
		<?  $i = 1;
            foreach ($_SESSION["ss"] as $cart_itm)
            {?>
                <li style="box-shadow: -1px 3px 10px rgba(0,0,0,0.1); background:#fff; padding:5px; min-width:250px">
                    
                    <a  style="float: right; padding: 4px; line-height: 8px;" href="website/model/cart_update.php?removess=<? echo $cart_itm["code"]?>&return_url=<? echo $current_url?>">&times; </a>
                    
                    
                    <img style="float:left; height:40px; padding-right:5px" src="<? echo $cart_itm["hinhanh"]?>" />
                    <div style="float:left">
                        <b style="font-size:15px"><? echo $cart_itm["name"]?></b><br />
                        <i style="color:#F63"><?php echo number_format($currency.$cart_itm["gia"])?> VNĐ</i>
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