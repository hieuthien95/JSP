<div class="site-body row">



    <section class="content-block-wrapper product-news clearfix">
      
          	<div class="product-list-wrapper col-lg-9 col-md-9 col-sm-12 col-sx-12">
          		<!--	begin slider	-->
              	<div class="slider-wrapper theme-default">
                    <div id="slider" class="nivoSlider"> 
						<?php 
						foreach($banList as $ban){ ?>
							<a href="<? echo $ban['link'] ?>"> 
						    	<img src="<? echo $ban['hinhanh'] ?>" title="<? echo $ban['tieude'] ?>"/>
						  	</a>
					<?	}?>     
                    </div>
                </div>
                <!--	end slider	-->
                           
                <ul id='content' class="product-list nolist clearfix">
				    <?php 
						foreach($goodsList as $goods)
						{
							if($goods["loaisp"]!="Phụ kiện" && $goods["sl"]!="Máy củ" 
							&& $goods["sl"]!="Sản phẩm không còn kinh doanh" )
							{
							 ?>
								<li data-webstatus="4" class="col-lg-3 col-md-4 col-sm-4 col-xs-6">
									<? include("website/view/modules/product.php");?>
								</li>
						 <? } 
						}?>
                </ul>
                <div class="clearfix"></div>
                
                <input type='hidden' id='current_page' /> 
                <input type='hidden' id='show_per_page' />
                <div style="text-align: center; margin-bottom: 20px" id="page_navigation"></div>
                <!--2 <input>, <ul> id='content', <li>, id='page_navigation' của phân trang-->
                
			</div>
          	
          
          
          
			<div class="news-wrapper col-lg-3 col-md-3 col-sm-12 col-sx-12" style="position:relative">
                
                <!--	begin tin tức	-->
                <div class="banner sidebar-banner wow fadeInRight">
                      <h2><a href="./?ac=chonmenu&stt=tintuc" title="Tin công nghệ">Tin tức</a></h2>
                      <a href="./?ac=tintuc&stt=<? echo $newsList[0]["stt"] ?>"> 
						<img src="<?php echo $newsList[0]['hinhanh'] ?>" width="100%">
						<div class="tit"><b><?php echo $newsList[0]['tieude'] ?></b></div>
                      </a> 
                </div>
                
                <div class="news-list-wrapper more-wrapper clearfix" style="border-bottom:1px solid rgba(0, 94, 253, 0.62)">
                	  <div class="title-wrapper clearfix">
                          <span class="view-all">
                              <a href="./?ac=chonmenu&stt=tintuc" title="Xem tất cả"> 
                                Xem tất cả <span style="font-size:15px">»</span>
                              </a> 
                          </span>
                      </div>
                      
                      <ul class="news-list nolist clearfix">
						  <?php 
						  for ($i = 1; $i <= 6; $i++) if($newsList[$i]!=null)
						  { ?>
						       <li class="clearfix wow fadeInRight" style="overflow:hidden">
						       	<a href="./?ac=tintuc&stt=<? echo $newsList[$i]["stt"] ?>"> 
						             <div class="news-avatar-wrapper"> 
						                   <img src="<?php echo $newsList[$i]['hinhanh'] ?>"> 
						             </div>
						             <div class="news-teaser-wrapper">
											<?php echo $newsList[$i]['tieude'] ?> 
						             </div>
						       	</a>
						       </li>
					<?php } ?>
                      </ul>
                </div>
                <!--	end tin tức	-->
                
                
                <!--	begin video	-->                
                <div class="news-list-wrapper more-wrapper clearfix" style="border-bottom:1px solid rgba(0, 94, 253, 0.62)">
                      <div class="title-wrapper clearfix">
						  <h2><a href="./?ac=chonmenu&stt=video" title="Video nổi bật"> Video nổi bật </a> </h2>
						  <span class="view-all">
                              <a href="./?ac=chonmenu&stt=tintuc" title="Xem tất cả"> 
                                Xem tất cả <span style="font-size:15px">»</span>
                              </a> 
                          </span>
                      </div>
                      
                      <ul class="news-list nolist clearfix">
						  <?php 
						  for ($i = 0; $i <= 3; $i++) if($videoList[$i]!=null)
						  { ?>
								   <li class="clearfix wow fadeInRight" style="overflow:hidden">
									<a href="./?ac=video&stt=<? echo $videoList[$i]["stt"] ?>"> 
										 <div class="news-avatar-wrapper"> 
											   <img src="<? echo $videoList[$i]['hinhanh'] ?>"> 
										 </div>
										 <div class="news-teaser-wrapper">
												<?php echo $videoList[$i]['ten'] ?> 
										 </div>
									</a>
								   </li>
						<?php } ?>
                      </ul>
                </div>
                <!--	end video	-->                
          		
                <!--	begin rao vặt	-->
                <div class="more-wrapper clearfix wow fadeInRight">
                      <div class="title-wrapper clearfix">
						  <h2><a href="./?ac=chonmenu&stt=maycu" title="Rao vặt, máy cũ"> Rao vặt, máy cũ</a> </h2>
						  <span class="view-all">
     							<a href="./?ac=chonmenu&stt=maycu" title="Xem tất cả"> Xem tất cả <span style="font-size: 15px">»</span></a>
						  </span> 
                      </div>
                      
                      <ul class="ads-list nolist clearfix" style="padding:0px 5px">
						 <?php $i = 0;
						 foreach($goodsList as $ad)
							 if($i == 8)
							 	break;
							 else if($ad['sl'] == "Máy củ")
							 { ?>
								  <li style="overflow:hidden" class=" wow fadeInRight">
									<a href="./?ac=thongtin&stt=<? echo $ad["stt"] ?>">
										<h3><?php echo $ad['hangsx']." ".$ad['ten'] ?></h3> 
										<cite class="price"><?php echo number_format($ad['gia']) ?>₫</cite>
									</a>
								  </li>
						  	 <? $i++;
						  	 }
						 ?>
                      </ul>
                </div>
                <!--	end rao vặt	-->
                
                
			</div>
      
      
    </section>
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
                <li style="box-shadow: -2px -2px 10px rgba(0,0,0,0.1); background:#fff; padding:5px; 
                margin-top:8px; min-width:250px">
                    
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