<?
	include("view/editor/editor1.php");
?>

<form class="col-lg-4 col-md-4 col-sm-4 col-xs-4" action="view/modules/hangsx/xuly.php" method="post" enctype="multipart/form-data"> 
        <table style="width:100%"  border="0">
          <tr>
            <td colspan="3"><div align="center"><strong>THÊM HÃNG SX</strong></div></td>
          </tr>
          
          <tr height="40px">
            <td colspan="2"><input placeholder="Tên hãng" type="text" name="tenhang" id="tenhang" style="width:100%"></td>
          </tr>
          
          <tr height="20px">
            <td colspan="2"><input placeholder="Mã hãng" type="text" name="mahang" id="mahang" style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td><input type="submit" name="themhangsx" id="themhangsx" value="  Thêm  "></td>
            <td><input type="reset" name="reset" id="Reset" value="  Xoá  " style="float:right" ></td>
          </tr>
          
          <tr height="15px"></tr>
          
        </table>
        
        <table width="100%" border="1" id="customers">
          <tr class="doimaunen">
            <td width="38" height="46">Mã hàng</td>
            <td width="91">Tên hàng</td>
            <td><strong></strong></td>
          </tr>
          <?
            foreach($brandList as $dong){
          ?>
          <tr> 
            <td><? echo $dong["mahang"] ?></td>
            <td><? echo $dong["tenhang"] ?></td>
            
            <td width="31">
                <a href="view/modules/hangsx/xuly.php?xoa=hangsx&stthangsx=<? echo $dong["mahang"] ?>">
                    <img src="view/img/b_drop.png" />		
                </a>
            </td>   
          </tr>
          <? } ?>
        </table>
</form>


<form class="col-lg-3 col-md-3 col-sm-3 col-xs-3" action="view/modules/hangsx/xuly.php" method="post" enctype="multipart/form-data"> 

        <table style="width:100%" border="0">
          <tr>
            <td colspan="2"><div align="center"><strong>THÊM HDH</strong></div></td>
          </tr>
          
          <tr height="40px">
            <td colspan="2"><input placeholder="Tên HĐH" type="text" name="tenhdh" id="tenhdh" style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td><input type="submit" name="themhdh" id="themhdh" value="  Thêm  "></td>
            <td><input type="reset" name="reset" id="Reset" value="  Xoá  " style="float:right" ></td>
          </tr>
          
          <tr height="40px"></tr>
        </table>
        
        <table style="width:100%" border="1" id="customers">
          <tr class="doimaunen">
            <td width="91">Tên HDH</td>
            <td><strong></strong></td>
          </tr>
          <?
            foreach($hdhList as $hdh){
          ?>
          <tr> 
            <td><? echo $hdh["tenhdh"] ?></td>
            
            <td width="31" align="center">
                <a href="view/modules/hangsx/xuly.php?xoa=hangsx&stthdh=<? echo $hdh["tenhdh"] ?>">
                    <img src="view/img/b_drop.png" />		
                </a>
            </td>   
          </tr>
          <? } ?>
        </table>
</form>


<form class="col-lg-3 col-md-3 col-sm-3 col-xs-3" action="view/modules/hangsx/xuly.php" method="post" enctype="multipart/form-data"> 
        <table style="width:100%" border="0">
          <tr>
            <td colspan="2"><div align="center"><strong>THÊM MÀN HÌNH</strong></div></td>
          </tr>
          
          <tr height="40px">
            <td colspan="2"><input placeholder="Màn hình" type="text" name="manhinh" id="manhinh" style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td><input type="submit" name="themmanhinh" id="themmanhinh" value="  Thêm  "></td>
            <td><input type="reset" name="reset" id="Reset" value="  Xoá  " style="float:right" ></td>
          </tr>
          <tr height="40px"></tr>
        </table>
        
        <table style="width:100%" border="1" id="customers">
          <tr class="doimaunen">
            <td width="91">Màn hình</td>
            <td><strong></strong></td>
          </tr>
          <?
            foreach($manHinhList as $hdh){
          ?>
          <tr> 
            <td><? echo $hdh["manhinh"] ?></td>
            
            <td width="31" align="center">
                <a href="view/modules/hangsx/xuly.php?xoa=hangsx&sttmanhinh=<? echo $hdh["manhinh"] ?>">
                    <img src="view/img/b_drop.png" />		
                </a>
            </td>   
          </tr>
          <? } ?>
        </table>
</form>


<form class="col-lg-2 col-md-2 col-sm-2 col-xs-2" action="view/modules/hangsx/xuly.php" method="post" enctype="multipart/form-data" style="padding-right:5px"> 
        <table style="width:100%" border="0">
          <tr>
            <td colspan="2"><div align="center"><strong>THÊM CAMERA</strong></div></td>
          </tr>
          
          <tr height="40px">
            <td colspan="2"><input placeholder="Phân giải" type="text" name="phangiai" id="phangiai" style="width:100%"></td>
          </tr>
          
          <tr height="40px">
            <td><input type="submit" name="themcamera" id="themcamera" value="  Thêm  "></td>
            <td><input type="reset" name="reset" id="Reset" value="  Xoá  " style="float:right" ></td>
          </tr>
          
          <tr height="40px"></tr>
        </table>
        
        <table style="width:100%" border="1" id="customers">
          <tr class="doimaunen">
            <td width="91">Phân giải</td>
            <td><strong></strong></td>
          </tr>
          <?
            foreach($cameraList as $hdh){
          ?>
          <tr> 
            <td><? echo $hdh["phangiai"] ?></td>
            
            <td width="31" align="center">
                <a href="view/modules/hangsx/xuly.php?xoa=hangsx&sttcamera=<? echo $hdh["phangiai"] ?>">
                    <img src="view/img/b_drop.png" />		
                </a>
            </td>   
          </tr>
          <? } ?>
        </table>
</form>
