<div>
	<table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td>ID</td>
        <td>Giá</td>
        <td>Thời gian</td>
        <td>Mã giao dịch</td>
        <td>Ghi chú</td>
         <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        <td></td>
        <? } ?>
      </tr>
      <?
	  foreach($donHangList as $dong){
	  ?>
      <tr> 
      	<td><? echo $dong["stt"] ?></td>
        <td><? echo number_format($dong["gia"]) ?></td>
        <td><? echo $dong["thoigian"] ?></td>
        <td><? echo $dong["magiaodich"] ?></td>
        <td><? echo "SĐT: ".$dong["sdt"]."<br>Thông tin: ".$dong["ghichu"] ?></td>
        
		 <? 
		if($_SESSION["quyen"]=="admin")
		{
		?> 
        <td width="30" align="center">
            <a href="view/modules/donhang/xuly.php?xoa=donhang&stt=<? echo $dong["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                <img src="view/img/b_drop.png" />		
            </a>
         </td> 
         <? } ?>   
      </tr>
      <? } ?>
    </table>
    
    
    <!--	phân trang	-->
    <div class="clearfix"> </div>
    <? 
	include_once("model/model.php"); 
	$model = new Model();
	$sotrang = $model->getNumDonHangs(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=donhang&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
</div>

