<?php
	include("view/editor/editor1.php");

	include_once("model/model.php");
	$model = new Model();
	foreach($model->getBanList() as $ban){
		if($ban['stt']==$_GET['stt']){
?>
<form action="view/modules/quangcao/xuly.php?stt=<? echo $ban["stt"] ?>&trang=<? echo $_GET["trang"] ?>" method="post" enctype="multipart/form-data" class="col-lg-4 col-md-12 col-sm-12 col-xs-12"> 
    <div>
        <table width="100%" border="0">
          <tr>
            <td><div align="center"><strong>SỬA QUẢNG CÁO</strong></div></td>
          </tr>
          <tr height="40px">
            <td>
            	<?
				if($ban["trangthai"]==1){
				?>
                    <select name="trangthai" style="float:right">
                        <option value="1" selected="selected">Hiển thị</option>
                        <option value="0">Không hiển thị</option>
                    </select>
                <?
				}else{
				?>
                    <select name="trangthai" style="float:right">
                        <option value="1">Hiển thị</option>
                        <option value="0" selected="selected">Không hiển thị</option>
                    </select>
				<?
				}
				?>
			</td>
          </tr>
          <tr height="40px">
            <td><input placeholder="Tiêu đề" type="text" name="tieude" id="tieude" style="width:100%" value="<? echo $ban['tieude'] ?> ">
            </td>
          </tr>
          <tr height="40px">
            <td><input placeholder="Link" type="text" name="link" id="link" style="width:100%" value="<? echo $ban['link'] ?> "> </td>
          </tr>
          <tr height="40px">
            <td>
            	<img src="../<? echo $ban["hinhanh"] ?>" width="90"/> <br />
            	<input type="file" name="anhminhhoa" />
            </td>
          </tr>
          <tr height="40px">
            <td>
            	<input type="submit" name="sua" id="sua" value="  Sửa  ">
            	<input type="reset" name="reset" id="Reset" value="  Xoá  ">
            </td>
          </tr>
        </table>
    </div>
</form>

<? } } ?>