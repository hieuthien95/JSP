<div>
	<table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td>ID</td>
        <td>Giá</td>
        <td>Thời gian</td>
        <td>Ghi chú</td>
         <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        <td><a href="view/modules/donhang/xuly.php?ac=xoa_DH_all"><img src="view/img/b_drop.png" /></a></td>
        <? } ?>
      </tr>
      <?
	  foreach($donHangList as $dong)
		  if ($dong["magiaodich"]=="")
		  {
	  ?>
		  <tr> 
			<td><? echo $dong["stt"] ?></td>
			<td><? echo number_format($dong["gia"]) ?></td>
            <td><? echo $dong["thoigian"] ?></td>
			<td><? echo "SĐT: ".$dong["sdt"]."<br>Thông tin: ".$dong["ghichu"] ?></td>
			
			 <? 
			if($_SESSION["quyen"]=="admin")
			{
			?> 
			<td width="31" align="center">
				<a href="view/modules/donhang/xuly.php?xoa=donhang&stt=<? echo $dong["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
					<img src="view/img/b_drop.png" />		
				</a>
			 </td> 
			 <? } ?>   
		  </tr>
		  <? } ?>
    </table>
    
</div>

