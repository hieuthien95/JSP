<?
	$loaitin = mysqli_query($con,"SELECT * FROM loaitin ORDER BY idloaitin ASC");
?>

<div class="right">
  <table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td width="38" height="46"><strong>ID</strong></td>
        <td width="91"><strong>Tên loại tin</strong></td>
        <td width="83"><strong>Trạng thái</strong></td>
        <td colspan="2"><strong>Quản lý</strong></td>
      </tr>
      <?
	  	$i=1;
	  	while($dong = mysqli_fetch_array($loaitin)){
			if($dong["idloaitin"]==$_GET["id"]){
	  ?>
              <tr class="doimaunen">
      <? }else{ ?>
      		  <tr>
      <? }?>
                <td><? echo $dong["idloaitin"] ?></td>
                <td><? echo $dong["tenloaitin"] ?></td>
                <td><? echo $dong["trangthai"] ?></td>
                
                <td width="31">
                    <a href="index.php?quanly=loaitin&ac=sua&id=<? echo $dong["idloaitin"] ?>">
                        <img src="img/b_edit.png" />
                    </a>
                </td>
                
                <td width="31">
                    <a href="modules/loaitin/xuly.php?xoa=loaitin&id=<? echo $dong["idloaitin"] ?>">
                        <img src="img/b_drop.png" />		
                    </a>
                </td>
              </tr>
     
      <? $i++;
		}
	  ?>
    </table>
</div>

