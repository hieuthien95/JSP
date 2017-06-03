<?php
	include_once("model/model.php");
	$model = new Model();
	$loaihinh = $_GET["quanly"];
	$sttloaihinh = $_GET["stt"];
?>
<form action="view/modules/hanghoa/xuly.php?stt=<? echo $_GET["stt"] ?>&quanly=<? echo $_GET["quanly"] ?>&trang=<? echo $_GET["trang"] ?>" method="post" enctype="multipart/form-data" class="col-lg-5 col-md-12 col-sm-12 col-xs-12">  
	<div>
    	<input type="file" name="anhminhhoa" style="margin:10px 0px"/> 
        <input type="submit" name="themanhkhac" id="themanhkhac" value="Thêm ảnh"  style="margin-bottom:10px">
        <table width="100%" border="1" id="customers">
          <? 
		  $imgList = $model->getImgList($loaihinh, $sttloaihinh);
		  if($imgList != null)
			  foreach($imgList as $goods) { ?>
                  <tr>
                    <td style="padding:2px">
                        <img src="../<? echo $goods["anhminhhoa"] ?>" width="100%"/>
                    </td>
                    <td>
                        <a href="view/modules/hanghoa/xuly.php?xoa=hinhanh&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>&sttsp=<? echo $_GET["stt"] ?>">
                            <img src="view/img/b_drop.png" width="25"/>		
                        </a>
                    </td>
                  </tr>
			  <? } ?>
        </table>
	</div>
</form>