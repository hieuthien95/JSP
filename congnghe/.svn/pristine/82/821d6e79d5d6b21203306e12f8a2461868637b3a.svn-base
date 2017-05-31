<?
	include("view/editor/editor1.php");
	
	include_once("model/model.php");
	$model = new Model();
	foreach($model->getVideoList() as $video){
		if($video['stt']==$_GET['stt']){
?>
<form action="view/modules/video/xuly.php?stt=<? echo $video["stt"] ?>&trang=<? echo $_GET["trang"] ?>" method="post" enctype="multipart/form-data" class="col-lg-5 col-md-12 col-sm-12 col-xs-12"> 
    <div>
        <table width="100%" border="0">
          <tr height="40px">
            <td colspan="3"><div align="center"><strong>SỬA VIDEO</strong></div></td>
          </tr>
           <tr height="40px">
            <td></td>
            <td colspan="2">
            	<?
				if($video["trangthai"]==1){
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
            <td colspan="2"><input placeholder="Tên video" type="text" name="ten" id="ten" value="<? echo $video["ten"] ?>" style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td></td>
            <td colspan="2">
            	<textarea style="width:100%" rows="10" name="noidung"><? echo $video["noidung"] ?></textarea></td>
          </tr>
          
          <tr height="40px">
            <td></td>
            <td colspan="2"><input placeholder="Đường dẫn" type="text" name="duongdan" id="duongdan" value="<? echo $video["duongdan"] ?>"  style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td></td>
            <td colspan="2">
            	<img src="../<? echo $video["hinhanh"] ?>" width="90"/>
            	<input type="file" name="anhminhhoa" />                
            </td>
          </tr>          
          <tr height="40px">
          	<td></td>
            <td colspan="2">
            	<input type="submit" name="sua" id="sua" value="  Sửa  ">
            	<input type="reset" name="reset" id="Reset" value="  Xoá  ">
            </td>
          </tr>
          
        </table>
    </div>
</form>

<?php		
		}
	}
?>