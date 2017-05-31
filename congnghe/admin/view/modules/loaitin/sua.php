<? 
	$loaitin = mysqli_query($con,"SELECT * FROM loaitin WHERE idloaitin= '$_GET[id]'");
	$dong = mysqli_fetch_array($loaitin);
?>

<form action="modules/loaitin/xuly.php?id=<? echo $dong["idloaitin"] ?>" method="post">
    <div class="left">
        <table width="100%" height="165" border="0">
          <tr>
            <td colspan="3"><div align="left"><strong>CHỨC NĂNG SỬA LOẠI TIN</strong></div></td>
          </tr>
          <tr>
            <td width="86">Tên loại tin:</td>
            <td colspan="2"><input type="text" name="tenloaitin" id="tenloaitin" value="<? echo($dong["tenloaitin"]) ?>"></td>
          </tr>
          <tr>
            <td>Trạng thái</td>
            <td colspan="2">
            
            <? 
                if($dong["trangthai"]=="Hiển thị"){
            ?>
                <select name="trangthai" id="trangthai" >
                    <option value="Hiển thị" selected="selected">Hiển thị</option>
                    <option value="Không hiển thị">Không hiển thị</option>
                </select>
            <? }else{ ?>
                <select name="trangthai" id="trangthai" >
                    <option value="Không hiển thị" selected="selected">Không hiển thị</option>
                    <option value="Hiển thị">Hiển thị</option>
                </select>
            <? } ?>   
            
            </td>
          </tr>
          <tr>
            <td height="34"></td>
            <td width="72"><input type="submit" name="sua" id="sua" value="  Sửa  "></td>
            <td width="175"><input type="reset" name="reset" id="Reset" value="  Xoá  "></td>
          </tr>
        </table>
    </div>
</form>