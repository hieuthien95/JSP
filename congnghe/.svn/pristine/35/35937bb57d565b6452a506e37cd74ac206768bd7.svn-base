<style type="text/css">
.right #customers {
	font-weight: bold;
}
</style>

<div class="col-lg-8 col-md-12 col-sm-12 col-xs-12" style="padding-right:0px">
  <table width="100%" border="1" id="customers">
      <tr class="doimaunen">
        <td>STT</td>
        <td>Hình ảnh</td>
        <td>Link</td>
        <? 
		session_start();
		if($_SESSION["quyen"]=="admin")
		{
		?>
        	<td colspan="2"><strong>Quản lý</strong></td>
        <? }?>
      </tr>
      <?
	  	foreach($banList as $ban){
	  ?>
      		  <tr <? if($_GET["stt"]== $ban["stt"]) { echo "class='doimaunen'"; } ?> >
                <td><? echo $ban["stt"] ?></td>
                <td>
					<img src="../<? echo $ban["hinhanh"] ?>" width="60" />
                </td>
                <td style="max-width:300px; overflow:hidden">
                	<b><? echo $ban["tieude"] ?></b><br />
					<? echo $ban["trangthai"] ?>-<? echo $ban["link"] ?>
                </td>
                
                <? 
				session_start();
				if($_SESSION["quyen"]=="admin")
				{
				?>
                	<td width="31">
                        <a href="index.php?quanly=quangcao&ac=sua&stt=<? echo $ban["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                            <img src="view/img/b_edit.png" />
                        </a>
                    </td>
                    <td width="31">
                        <a href="view/modules/quangcao/xuly.php?ac=xoa&stt=<? echo $ban["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
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
	$sotrang = $model->getNumBans(); 
	?>
    <div  style="text-align:center; margin:10px" class="trang">
		<? 
		$i=1;
        while($i <= $sotrang){
        ?>	
            <a class=" <? if($i==$_GET["trang"]){ echo 'active'; }?> " 
                href="index.php?quanly=quangcao&ac=them&trang=<? echo $i ?>">
                <? echo $i; ?>
            </a>
            <? 	$i++;
        } ?>
    </div>
    
</div>

