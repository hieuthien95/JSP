<?php
	include("view/editor/editor1.php");
	include_once("model/model.php");
	$model = new Model();
	foreach($model->getGoodsSearchList($_GET['stt']) as $goods){
?>
<form action="view/modules/hanghoa/xuly.php?stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>" method="post" enctype="multipart/form-data" class="col-lg-5 col-md-12 col-sm-12 col-xs-12"> 
	<table width="100%" border="0">
		<tr>
            <td colspan="3"><div align="left"><strong>SỬA SẢN PHẨM</strong></div></td>
		</tr>
		<tr height="40px">
            <td width="80px"></td>
            <td><?
				if($goods["trangthai"]==1){
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
            <td>Tên máy</td>
            <td colspan="2">
            	<input type="text" name="ten" id="ten" value="<? echo $goods["ten"] ?>" style="width:100%">
            </td>
		</tr>
		<tr height="40px">
            <td>Giá</td>
            <td colspan="2">
            	<input type="text" name="gia" id="gia" value="<? echo $goods["gia"] ?>" style="width:100%">
            </td>
		</tr>
          
		<tr height="40px">
            <td>Số lượng</td>
            <td colspan="2">
                <select name="sl" style="width:100%">
                	<option value="<? echo $goods["sl"] ?>" selected="selected"><? echo $goods["sl"] ?></option>
                	<option value="Còn hàng">Còn hàng</option>
                    <option value="Hàng sắp về">Hàng sắp về</option>
                    <option value="Hết hàng">Hết hàng</option>
                    <option value="Sản phẩm không còn kinh doanh">Sản phẩm không còn kinh doanh</option>
                    <option value="Máy củ">Máy củ</option>
                </select>
            </td>
		</tr>
          
		<tr height="40px">
            <td>
                Loại sp
            </td>
            <td colspan="2">
            	<select name="loaisp">
                	<option value="<? echo $goods["loaisp"] ?>" selected="selected"><? echo $goods["loaisp"] ?></option>
                	<option value="Điện thoại">Điện thoại</option>
                    <option value="Máy tính bảng">Máy tính bảng</option>
                    <option value="Laptop">Laptop</option>
                    <option value="Máy ảnh">Máy ảnh</option>
                    <option value="Phụ kiện">Phụ kiện</option>
                </select>
                
                
                <select name="hangsx" style="float:right">
               		<option value="<? echo $goods["hangsx"] ?>" selected="selected"><? echo $goods["hangsx"] ?></option>
                	<?php
						foreach($brandList as $brands){
					?>
                		<option value="<? echo $brands["tenhang"] ?>"><? echo $brands["tenhang"] ?></option>
                	<? } ?>
                </select>
			</td>
		</tr>
          
		<tr height="40px">
            <td>Camera</td>
            <td colspan="2">
                
                <select name="camera">
               	 	<option value="<? echo $goods["camera"] ?>" selected="selected"><? echo $goods["camera"] ?></option>
                	<?php
						foreach($cameraList as $camera)
						{
					?>
               			<option value="<? echo $camera["phangiai"] ?>"><? echo $camera["phangiai"] ?></option>
                	<? } ?>
                </select>
                
            	<select name="manhinh">
                    <option value="<? echo $goods["manhinh"] ?>" selected="selected">
						<? echo $goods["manhinh"] ?>
                    </option>
                    <?php
						foreach($manHinhList as $manhinh)
						{
					?>
               			<option value="<? echo $manhinh["manhinh"] ?>"><? echo $manhinh["manhinh"] ?></option>
                	<? } ?>
                </select>
                
            	<select name="hdh" style="float:right">
                	<option value="<? echo $goods["hdh"] ?>" selected="selected"><? echo $goods["hdh"] ?></option>
                	<?php
						foreach($hdhList as $hdh)
						{
					?>
               			<option value="<? echo $hdh["tenhdh"] ?>"><? echo $hdh["tenhdh"] ?></option>
                	<? } ?>
                </select>
			</td>
			</td>
		</tr>
		<tr height="40px">
            <td>CPU</td>
            <td colspan="2"><input type="text" name="cpu" id="cpu" value="<? echo $goods["cpu"] ?>" style="width:100%"></td>
		</tr>
		<tr height="40px">
            <td>Pin</td>
            <td colspan="2"><input type="text" name="pin" id="pin" value="<? echo $goods["pin"] ?>" style="width:100%"></td>
		</tr>
		<tr height="40px">
            <td>T.Tin #</td>
            <td colspan="2">
            	<textarea name="nhieuhon" style="width:100%"><? echo $goods["nhieuhon"] ?></textarea>
            </td>
		</tr>
		<tr height="40px">
            <td>KM</td>
            <td colspan="2">
            	<textarea name="km" id="km" style="width:100%"><? echo $goods["km"] ?></textarea>
            </td>
		</tr>
		<tr height="40px">
            <td></td>
            <td colspan="2">
            	<img src="../<? echo $goods["hinhanh"] ?>" width="90"/> <br />
            	<input type="file" name="anhminhhoa"/>    
            </td>
		</tr>
		<tr height="40px">
            <td width="65"></td>
            <td width="441">
            	<input type="submit" name="sua" id="sua" value="  Cập nhật  ">
            	<input type="reset" name="reset" id="Reset" value="  Xoá  ">
            </td>
		</tr>
	</table>
</form>

<?php		
		}
?>