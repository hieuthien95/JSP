<div>
	<table width="100%" border="1" id="customers">
      <tr class="doimaunen">
      	<td>Avatar</td>
        <td>ID</td>
        <td>Tên</td>
        <td>Quyền</td>
        <td>SDT</td>
        <td>Email</td>
        <td></td>
      </tr>
      <?
	  include_once("model/model.php"); 
	  $model = new Model();
	  foreach($model->getTaiKhoanList() as $dong){
	  ?>
      <tr> 
      	<td><img src="../<? echo $dong["avatar"] ?>" width="50px"/></td>
      	<td><? echo $dong["id"] ?></td>
        <td><? echo $dong["ten"] ?></td>
        <td><? echo $dong["quyen"] ?></td>
        <td><? echo $dong["sdt"] ?></td>
        <td><? echo $dong["email"] ?></td>
       
        <td width="31" align="center">
            <a href="view/modules/taikhoan/xuly.php?ac=xoa&id=<? echo $dong["id"] ?> ">
                <img src="view/img/b_drop.png" />		
            </a>
         </td>    
      </tr>
      <? } ?>
    </table>
    
    <!--	phân trang	-->
    <div class="clearfix"> </div>
    <? 
	$sotrang = $model->getNumTaiKhoan(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=taikhoan&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
   
</div>

