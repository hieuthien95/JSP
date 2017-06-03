<link rel="stylesheet" href="./admin/view/css/style.css">
<div class="row">
	<table width="100%" border="1" id="customers" style="margin-bottom:10px">
      <tr class="doimaunen">
        <td class="hidden-xs">ID</td>
        <td>Giá</td>
        <td class="hidden-xs hidden-sm">Thời gian</td>
        <td>Mã giao dịch</td>
        <td>Ghi chú</td>
      </tr>
      <?
	  	foreach($donHangList as $dong)
		if($dong["sdt"]==$_SESSION["sdt"]){
	  ?>
      <tr> 
      	<td class="hidden-xs"><? echo $dong["stt"] ?></td>
        <td><span class="visible-xs">(<? echo $dong["stt"] ?>)</span><? echo number_format($dong["gia"]) ?></td>
        <td class="hidden-xs hidden-sm"><? echo $dong["thoigian"] ?></td>
        <td><b><? echo $dong["magiaodich"] ?></b><span class="visible-xs visible-sm">(<? echo $dong["thoigian"] ?>)</span></td>
        <td><? echo "SĐT: ".$dong["sdt"]."<br>Thông tin: ".$dong["ghichu"] ?></td>
      </tr>
      <? } ?>
    </table>
</div>   

<div class="clearfix"></div>

