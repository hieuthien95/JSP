<?php
	include("view/editor/editor1.php");

	include_once("model/model.php");
	$model = new Model();
	foreach($model->getNewsList() as $news){
		if($news['stt']==$_GET['stt']){
?>
	<form action="view/modules/baiviet/xuly.php?stt=<? echo $news["stt"] ?>&trang=<? echo $_GET["trang"] ?>" 
    	method="post" enctype="multipart/form-data" class="col-lg-5 col-md-12 col-sm-12 col-xs-12"> 
    <div>
        <table width="100%" border="0">
          <tr>
            <td colspan="3"><div align="center"><strong>SỬA BÀI VIẾT</strong></div></td>
          </tr>
          <tr height="40px">
            <td></td>
            <td colspan="2">
            	<select name="loaitin">
                	<option value="<? echo $news["loaitin"]; ?>" selected="selected"><? echo $news["loaitin"]; ?></option>
                	<option value="Tin tức">Tin tức</option>
                    <option value="Khuyến mãi">Khuyến mãi</option>
                </select>
            	<?
				if($news["trangthai"]==1){
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
            <td></td>
            <td colspan="2"><input type="text" name="tieude" id="tieude" value="<? echo $news["tieude"] ?>" style="width:100%"></td>
          </tr>
          <tr height="40px">
            <td></td>
            <td colspan="2">
            	<img src="../<? echo $news["hinhanh"] ?>" width="90"/> <br />
            	<input type="file" name="anhminhhoa" />                
            </td>
          </tr> 
          <tr height="40px">
            <td></td>
            <td colspan="2">Tóm tắt
            	<textarea style="width:100%" name="ttat"><? echo $news["tomtat"] ?></textarea>
            </td>
          </tr>
          <tr>
            <td></td>
            <td colspan="2">Nội dung
            	<textarea style="width:100%" name="noidung">
                	<? echo $news["noidung"] ?>
                </textarea>
			</td>
          </tr>         
          <tr height="40px">
          	<td></td>
            <td><input type="submit" name="sua" id="sua" value="  Cập nhật  "></td>
            <td><input type="reset" name="reset" id="Reset" value="  Xoá  "></td>
          </tr>
        </table>
    </div>
</form>
<?php		
		}
	}
?>
