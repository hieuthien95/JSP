<?php
    //current URL of the Page. cart_update.php redirects back to this URL
	$current_url = base64_encode($url="http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI']);
?>

<style>
	td, table{
		border:0
	}
	tr{
		height:45px
	}
</style>
    <div style="padding:10px 0 25px; overflow:hidden">
        <?php foreach($goodsList as $goods)
		{
                if($goods["stt"]==$_GET["stt"])
				{ ?>    
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12" style="float:left">
                        <div style="width:100%" align="center">
                            <img style="width: 80%" src="<?php echo $goods['hinhanh'] ?>" />                          	<h2 style="margin-top:5px">
								<?php echo '<span class="hidden-xs">'.$goods['loaisp']." ".'</span>'.$goods['hangsx']." ".$goods['ten'] ?> 
                            </h2> 
                            <h3 style="color:red"> <?php echo number_format($goods['gia']) ?> VNĐ</h3>
                            <h4> <?php echo $goods['sl'] ?></h4>
                                    
                            <h4>
                                <a target="_blank" href="./?ac=donhang&price=<?php echo base64_encode($goods['gia']) ?>&comments=<? echo base64_encode($goods['loaisp']." ".$goods['hangsx']." ".$goods['ten']) ?>">
                                    <img src="website/view/images/sites/thanhtoan.png" />
                                </a>
                                <br /><br />
                                <form method="post" action="website/model/cart_update.php" 
                                        style="text-align:center; padding-top:10px; position:relative">
                                    <input type="text" name="sl" value="1" 
                                    	style="height:30px; width:60px; padding:0; text-align:center;
                                       	position:absolute; top:0; margin-left: -85px"/>
                                    <button  name="type" value="add"  class="add_to_cart" 
                                    	style="background: #06F; color: #FFF; height:30px; border-radius: 4px;  
                                        position:absolute; top:0; margin-left: -8px">
                                        Thêm vào giỏ
                                    </button>
                                    <input type="hidden" name="stt" value="<?php echo $goods['stt'] ?>" />
                                    <input type="hidden" name="return_url" 
                                        value="<? echo $current_url ?>" />
                                </form>
                            </h4>
                        </div>
                        <table width="100%" style="font-size:16px; line-height:25px; margin-top:30px">
                            <tr>
                                <td width="35%">Màn hình</td>
                                <td ><?php echo $goods['manhinh'] ?></td>
                            </tr>
                            <tr>
                                <td>Hãng sản xuất</td>
                                <td><?php echo $goods['hangsx'] ?></td>
                            </tr>
                            <tr>
                                <td>HĐH</td>
                                <td><?php echo $goods['hdh'] ?></td>
                            </tr>
                            <tr>
                                <td>CPU</td>
                                <td><?php echo $goods['cpu'] ?></td>
                            </tr>
                            <tr>
                                <td>Camera</td>
                                <td><?php echo $goods['camera'] ?></td>
                            </tr>
                            <tr>
                                <td>Pin</td>
                                <td><?php echo $goods['pin'] ?></td>
                            </tr>
                            <tr>
                                <td>Nhiều hơn</td>
                                <td><?php echo $goods['nhieuhon'] ?></td>
                            </tr>
                            <tr>
                                <td>Khuyến mại</td>
                                <td><a href="#" style="color:blue"><?php echo $goods['km'] ?> </a></td>
                            </tr>
                        </table>					
                    </div>
                    
                    <div id="img_show" class="col-lg-5 col-md-5 col-sm-5 col-xs-12" style="padding:0" align="center">
                    <h3 class="hinhanhsp"> Hình ảnh sản phẩm </h3>
                    <? 
					if($imgList == null)
						echo "không có hình ảnh";
					else 
					{ ?>
                        <div id="carousel-example-generic" class="carousel slide" 
                        	style="background:#FFF" align="center">
                              <div class="carousel-inner" style="background:#FFF" align="center">
                                    <div class="item active" style="background:#FFF">
                                      <img class="itm" src="<?php echo $imgList[0]['anhminhhoa'] ?>" style="width:100%" />
                                    </div>
									<?  
								  	if(sizeof($imgList) > 1)
										for($i=1; $i<sizeof($imgList); $i++) { ?>
                                            <div class="item" style="background:#FFF" align="center">
                                              <img class="itm" src="<?php echo $imgList[$i]['anhminhhoa'] ?>" 
                                              	style="width:100%" />
                                            </div>
                                    	<? } ?>
                              </div>              
                              
                              <a class="left carousel-control" href="#carousel-example-generic" 
                              	data-slide="prev" style="background:none">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                              </a>
                              <a class="right carousel-control" href="#carousel-example-generic" 
                              	data-slide="next" style="background:none">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                              </a>
                        </div>   
                    <? } ?>   	               
                    </div>
             <? } 
		} ?>
        
        <div class="clearfix"></div>
        
        <!--	loading sản phẩm liên quan	-->       
        <div style="font-size:20px; margin:30px 0px 20px 0px" align="center"> Sản phẩm liên quan</div>
        <!--	Carousel slider	-->
        <div id="jssor_1" style="position: relative; height: 210px"> 
			<!-- Loading Screen -->
			<div class="slides" data-u="slides">
            	<?php foreach($goodsList as $goods)
					if($goods["loaisp"]!="Phụ kiện")
					{ ?>
						<div> <a href="./?ac=thongtin&stt=<? echo $goods["stt"] ?>"> 
							<img style="padding:0px 15px" data-u="image" src="<?php echo $goods['hinhanh'] ?>" /> </a>                     
						</div>                
				 <? } ?>
			</div>
			<!-- Arrow Navigator --> 
			<span data-u="arrowleft" class="jssora03l" style="top:0px;left:8px;width:55px;height:55px;" 
			data-autocenter="2"></span> 
			<span data-u="arrowright" class="jssora03r" style="top:0px;right:8px;width:55px;height:55px;" 
            data-autocenter="2"></span> 
        </div>
        
        
        <div class="clearfix"></div>
        
    </div>

<!--	facebook	--> 
<!--<div class="fb-like" data-share="true" data-show-faces="true"></div>-->
<div class="fb-comments" data-href="http://www.thiensu.com/WebDemo/?ac=thongtin&stt=<? echo $_GET["stt"] ?>" 
	data-colorscheme="light" data-numposts="5" data-width="100%">
</div>