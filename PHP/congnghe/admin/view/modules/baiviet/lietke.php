<div class="col-lg-7 col-md-12 col-sm-12 col-xs-12" style="padding-right:0px">
  <table border="1" id="customers">
      <tr class="doimaunen">
        <td><strong>STT</strong></td>
        <td><strong>Hình ảnh</strong></td>
        <td><strong>Tiêu đề</strong></td>
        <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        	<td colspan="2"><strong>Quản lý</strong></td>
        <? }?>
      </tr>
      <?
	  	foreach($newsList as $news){
	  ?>
      		  <tr <? if($_GET["stt"]== $news["stt"]) { echo "class='doimaunen'"; } ?> >
                <td><? echo $news["stt"] ?></td>
                <td>
					<img src="../<? echo $news["hinhanh"] ?>" width="60" />
                </td>
                <td>
					<b>Tiêu đề:</b> <? echo $news["tieude"] ?><br />
                	<b>Tóm tắt: <? echo $news["trangthai"] ?> - <? echo $news["loaitin"] ?></b> <? echo $news["tomtat"] ?>
                </td>
                
                <? 
				session_start();
				if($_SESSION["quyen"]=="admin")
				{
				?>
                	<td width="31">
                        <a href="index.php?quanly=baiviet&ac=sua&stt=<? echo $news["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                            <img src="view/img/b_edit.png" />
                        </a>
                    </td>
                    <td width="31">
                        <a href="view/modules/baiviet/xuly.php?ac=xoa&stt=<? echo $news["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                            <img src="view/img/b_drop.png" />		
                        </a>
                    </td>
             <? } ?>
              </tr>
      
      <?
		}
	  ?>
    </table>
    
    
    <!--	phân trang	-->
    <div class="clearfix"> </div>
    <? 
	include_once("model/model.php"); 
	$model = new Model();
	$sotrang = $model->getNumNews(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=baiviet&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
    
</div>

