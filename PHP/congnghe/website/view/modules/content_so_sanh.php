<?
	include_once("./website/model/model.php");
	$model = new Model();
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
    <?php 
	foreach($goodsList as $goods)
    if($goods["stt"]==$_GET["stt1"])
	{ ?>
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" align="center">
    	<div style="width:100%" align="center">
            <img src="<?php echo $goods['hinhanh'] ?>" style="width:60%">  
            <div class="clearfix"></div>
            <h2><?php echo $goods['hangsx']." ".$goods['ten'] ?></h2>
            <h3 style="color:red"> <?php echo number_format($goods['gia']) ?> VNĐ</h3>
            <h4><?php echo $goods['sl'] ?></h4>
            
            <h4>
            	<a target="_blank" href="./?ac=donhang&price=<?php echo $goods['gia'] ?>&comments=<? echo $goods['loaisp']." ".$goods['hangsx']." ".$goods['ten'] ?>">
								<img src="website/view/images/sites/thanhtoan.png" />
							</a>
                <br /><br />
                <form method="post" action="website/model/cart_update.php" 
                    style="text-align:center; padding-top:10px; position:relative">
					<input type="text" name="sl" value="1" style="height:30px; width:50px; padding:0; 
                		text-align:center; position:absolute; top:0; margin-left: -85px"/>
                	<button  name="type" value="add"  class="add_to_cart" style="background: #06F; 
						color: #FFF; height:30px; border-radius: 4px; position:absolute; top:0; margin-left: -8px">
                    	Thêm vào giỏ
                	</button>
                    <input type="hidden" name="stt" value="<?php echo $goods["stt"] ?>" />
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
                <tr>
                	<td colspan="2">
                	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding:0">
						<?  
                        $imgList = $model->getImgList("hanghoa", $_GET["stt1"]);
						if($imgList != null)
							foreach($imgList as $good) { ?>
                             <img src="<?php echo $good['anhminhhoa'] ?>" style="width:100%" />
                        <? } ?>
                    </div>
                	</td>
                </tr>
        </table>					
    </div>
         <? }?>
    
    <?php 
	foreach($goodsList as $goods)
    if($goods["stt"]==$_GET["stt2"])
	{ ?>
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" align="center">
    	<div style="width:100%" align="center">
            <img src="<?php echo $goods['hinhanh'] ?>" style="width:60%"> 
            <div class="clearfix"></div>
            <h2><?php echo $goods['hangsx']." ".$goods['ten'] ?></h2>
            <h3 style="color:red"> <?php echo number_format($goods['gia']) ?> VNĐ</h3>
            <h4><?php echo $goods['sl'] ?></h4>
            
            <h4>
            	<a target="_blank" href="./?ac=donhang&price=<?php echo $goods['gia'] ?>&comments=<? echo $goods['loaisp']." ".$goods['hangsx']." ".$goods['ten'] ?>">
								<img src="website/view/images/sites/thanhtoan.png" />
							</a>
                <br /><br />
                <form method="post" action="website/model/cart_update.php" 
                	style="text-align:center; padding-top:10px; position:relative">
					<input type="text" name="sl" value="1" style="height:30px; width:50px; padding:0; 
                		text-align:center; position:absolute; top:0; margin-left: -85px"/>
                	<button  name="type" value="add"  class="add_to_cart" style="background: #06F; 
						color: #FFF; height:30px; border-radius: 4px; position:absolute; top:0; margin-left: -8px">
                    	Thêm vào giỏ
                	</button>
                    <input type="hidden" name="stt" value="<?php echo $goods['stt'] ?>" />
                    <input type="hidden" name="return_url" value="<? echo $current_url ?>" />
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
                <tr>
                	<td colspan="2">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding:0">
						<?  
                        $imgList = $model->getImgList("hanghoa", $_GET["stt2"]);
						if($imgList != null)
							foreach($imgList as $good) { ?>
                             <img src="<?php echo $good['anhminhhoa'] ?>" style="width:100%" />
                        <? } ?>
                    </div>
                    </td>
                </tr>
		</table>					
	</div>
    <? } ?>
        
     
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
						<div> 
                        <a href="./?ac=thongtin&stt=<? echo $goods["stt"] ?>"> 
							<img style="padding:0px 15px" data-u="image" src="<?php echo $goods['hinhanh'] ?>" /> 
                        </a>             
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