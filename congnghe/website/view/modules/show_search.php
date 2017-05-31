<? include_once("./website/model/model.php"); 
$model = new Model();
$keyword = $_GET['search-keyword'];

$con = $model->connectDatabase();
$keyword = mysqli_real_escape_string($con, $keyword);
$goodsSearchList=$model->getSearchGooodsList($keyword);
?>

<div class="menu row" style="padding:0px 0px 10px 0px">
	<div class="site-body">
		<section class="content-block-wrapper product-news clearfix">
			<div class="product-list-wrapper" style="width:100%">   
                <ul class="product-list nolist clearfix" style="width:100%">
                   <?php 
                    if($goodsSearchList == null)
                        echo "<div style='width:100%; text-align:center'>Không tìm thấy nội dung của bạn</div>";
                    else 
                        foreach($goodsSearchList as $goods)
                        { ?>
                            <li data-webstatus="4" class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
                                <? include("website/view/modules/product.php");?>
                            </li>
                    <? 	} ?>
                </ul>
        	</div>
		</section>
	</div>
</div>