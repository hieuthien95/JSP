<?
	include("view/editor/editor1.php");
	
	include_once("model/model.php");
	$model = new Model();
	foreach($model->getVideoList() as $video){
		if($video['stt']==$_GET['stt']){
?>
<form action="view/modules/video/xuly.php?stt=<? echo $video["stt"] ?>" method="post" enctype="multipart/form-data"> 
    <div class="left" style="padding-left:0%; width:49%">
        <table width="100%" border="0">
        
          <tr>
            <td colspan="3"><div align="left"><strong>CHỨC NĂNG SỬA VIDEO</strong></div></td>
          </tr>
          
          <tr height="40px">
            <td width="20%">Tên video:</td>
            <td colspan="2"><input type="text" name="ten" id="ten" value="<? echo $video["ten"] ?>" size="58"></td>
          </tr>
          
          <tr>
            <td>Nội dung:</td>
            <td colspan="2">
            	<textarea cols="45" rows="10" name="noidung"><? echo $video["noidung"] ?></textarea></td>
          </tr>
          
          <tr height="40px">
            <td width="20%">Đường dẫn:</td>
            <td colspan="2"><input type="text" name="duongdan" id="duongdan" value="<? echo $video["duongdan"] ?>" size="58"></td>
          </tr>
          
          <tr height="40px">
            <td>Ảnh minh họa:</td>
            <td colspan="2">
            	<img src="../<? echo $video["hinhanh"] ?>" width="90"/>
            	<input type="file" name="anhminhhoa" />                
            </td>
          </tr>
          
          <tr height="40px">
            <td>Trạng thái:</td>
            <td colspan="2">
            	<?
				if($video["trangthai"]=="Hiển thị"){
				?>
                    <select name="trangthai">
                        <option value="1" selected="selected">Hiển thị</option>
                        <option value="0">Không hiển thị</option>
                    </select>
                <?
				}else{
				?>
                    <select name="trangthai">
                        <option value="1">Hiển thị</option>
                        <option value="0" selected="selected">Không hiển thị</option>
                    </select>
				<?
				}
				?>
			</td>
          </tr>
          
          <tr height="40px">
            <td height="34"></td>
            <td width="65"><input type="submit" name="sua" id="sua" value="  Cập nhật  "></td>
            <td width="441"><input type="reset" name="reset" id="Reset" value="  Xoá  "></td>
          </tr>
          
        </table>
    </div>
</form>

<?php		
		}
	}
?>