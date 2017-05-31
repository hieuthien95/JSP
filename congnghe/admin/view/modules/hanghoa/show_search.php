
<? include_once("model/model.php"); 
$model = new Model();

$keyword = $_GET['search-product'];
$goodsSearchList=$model->getSearchGooodsList($keyword);
?>

<div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
    <form method="get" style="margin-top:15px"  autocomplete="off">
        <div class="input-group">
            <input type="text" class="form-control" name="search-product" id="search-keyword"/>
            <span class="input-group-btn">
                <input type="submit" class="btn btn-default" name="ac" value="Tìm" />
            </span>
        </div><!-- /input-group -->
        <div id="searchresultdata" class="faq-articles"> </div>
    </form>


<?php 
if($goodsSearchList == null)
     echo "<div style='width:100%; text-align:center'>Không tìm thấy nội dung của bạn</div>";
else 
     foreach($goodsSearchList as $goods)
     { ?>
     <div style="border-bottom: 1px solid #0CF; width:100%; padding-bottom:20px" align="center">
		<h3><? echo $goods["stt"]." ".$goods["ten"] ?></h3><br />
		<img src="../<? echo $goods["hinhanh"] ?>" style="width:40%"/><br />
		
		<? 
 		session_start();
		if($_SESSION["quyen"]=="admin")
		{ ?>                 
              <a href="index.php?quanly=hanghoa&ac=sua_no_page&stt=<? echo $goods["stt"] ?>">
                  <img src="view/img/b_edit.png" width="25px"/>
              </a>
                             
                             
              <a href="view/modules/hanghoa/xuly.php?ac=xoa&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                  <img src="view/img/b_drop.png" width="25px"/>		
              </a>
              
              <a href="./index.php?quanly=hanghoa&ac=themanhkhac&stt=<? echo $goods["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
                  <img src="view/img/b_img.png" width="25px"/>
              </a> <br />
                 
		<? } ?>
        </div>     
     <? } ?>
</div>