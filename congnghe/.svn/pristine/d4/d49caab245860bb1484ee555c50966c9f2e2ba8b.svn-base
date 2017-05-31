<div id="lietke" class="col-lg-7 col-md-12 col-sm-12 col-xs-12" style="padding-right:0px">
  <table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td width="30"><strong>STT</strong></td>
        <td width="70"><strong>Hình ảnh</strong></td>
        <td width="150"><strong>Tên, hãng máy</strong></td>
        <td width="100"><strong>Giá</strong></td>
        <td width="300"><strong>Thông tin</strong></td>
        <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        	<td colspan="2"><strong>Quản lý</strong></td>
        <? }?>
      </tr>
      <?
	  	foreach($goodsList as $goods){
	  ?>
      		  <tr <? if($_GET["stt"]== $goods["stt"]) { echo "class='doimaunen'"; } ?> >
                <td><? echo $goods["stt"] ?></td>
				<td align="center">
                	<a href="./index.php?quanly=hanghoa&ac=themanhkhac&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>"><img src="view/img/b_img.png" style="margin:10px"/></a><br />
                	<img src="../<? echo $goods["hinhanh"] ?>" style="width:60px"/><br />
                	<span style="font-size:12px"><? echo $goods["sl"] ?></span>
                    
                </td>
                <td><b><? echo $goods["loaisp"]." ". $goods["hangsx"]." ".$goods["ten"] ?></b> <br />
                	- <b>Khuyến mại:</b> <? echo $goods["km"] ?>
                </td>
                <td width="20%">- <b>Trạng thái:</b> <? echo $goods["trangthai"] ?><br />
                	- <b>CPU:</b> <? echo $goods["cpu"] ?><br />
                	- <b>HĐH:</b> <? echo $goods["hdh"] ?> <br />
                    - <b>Giá:</b> <? echo number_format($goods["gia"]) ?><br />
                </td>
                <td>
					- <b>Màn hình:</b> <? echo $goods["manhinh"] ?><br />
                    - <b>Camera:</b> <? echo $goods["camera"] ?> <br />
                	- <b>Pin:</b> <? echo $goods["pin"] ?><br />
                    - <b>Khác:</b> <? echo $goods["nhieuhon"] ?><br />                    
                </td>
                
                <? 
				session_start();
				if($_SESSION["quyen"]=="admin")
				{
				?>
                	<td width="31">
                        <a href="index.php?quanly=hanghoa&ac=sua&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                            <img src="view/img/b_edit.png" />
                        </a>
                    </td>
                    <td width="31">
                        <a href="view/modules/hanghoa/xuly.php?ac=xoa&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                            <img src="view/img/b_drop.png" />		
                        </a>
   		          	</td>
     		 <? } ?>
              </tr>
      <?
		}
	  ?>
    </table>
    
    <!--	phân trang	-->
    <div class="clearfix"> </div>
    <? 
	include_once("model/model.php"); 
	$model = new Model();
	$sotrang = $model->getNumGoods(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=hanghoa&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
</div>

