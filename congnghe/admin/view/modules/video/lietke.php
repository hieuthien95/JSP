<div class="col-lg-7 col-md-12 col-sm-12 col-xs-12" style="padding-right:0px">
	<table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td width="38" height="46"><strong>ID</strong></td>
        <td width="91"><strong>Tên video</strong></td>
        <td width="83">Ảnh minh họa</td>
        <td width="83">Nội dung</td>
        <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        <td colspan="2"><strong>Quản lý</strong></td>
        <? } ?>
      </tr>
      <?
	  	foreach($videoList as $dong){
	  ?>
      <tr <? if($_GET["stt"]== $dong["stt"]) { echo "class='doimaunen'"; } ?> >
      	<td><? echo $dong["stt"] ?></td>
        <td><? echo $dong["trangthai"] ?> - <? echo $dong["ten"] ?>
        </td>
        <td>
			<img src="../<? echo $dong["hinhanh"] ?>" width="60" />
        </td>
        <td><? echo $dong["duongdan"] ?></td>
        
         <? 
		if($_SESSION["quyen"]=="admin")
		{
		?>
		<td width="31">
        	<a href="index.php?quanly=video&ac=sua&stt=<? echo $dong["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
            	<img src="view/img/b_edit.png" />
            </a>
        </td>
                
        <td width="31">
            <a href="view/modules/video/xuly.php?ac=xoa&stt=<? echo $dong["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
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
	$sotrang = $model->getNumVideos(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=video&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
</div>

