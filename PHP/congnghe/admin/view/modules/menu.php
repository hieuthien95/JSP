<? session_start();
?>

<div id="menu">

    <a href="index.php?quanly=hanghoa&ac=them">
        <div id="box-chucnang" <? if($_GET["quanly"]=="hanghoa") echo "style='box-shadow:rgba(0, 0, 0, 0.1) 0px 0px 10px'"; ?>>
            <p><img class="visible-lg" src="view/img/icon1.png"/> Hàng hóa</p>
        </div>
	</a>
    
	<a href="index.php?quanly=baiviet&ac=them">
        <div id="box-chucnang" <? if($_GET["quanly"]=="baiviet") echo "style='box-shadow:rgba(0, 0, 0, 0.1) -1px 0px 10px'"; ?>>
            <p> <img class="visible-lg" src="view/img/icon1.png"/>Bài viết</p>
        </div>
	</a>
    
    <a href="index.php?quanly=quangcao&ac=them">
        <div id="box-chucnang" <? if($_GET["quanly"]=="quangcao") echo "style='box-shadow:rgba(0, 0, 0, 0.1) -1px 0px 10px'"; ?>>
            <p><img class="visible-lg" src="view/img/icon1.png"/>Quảng cáo</p>
        </div>
	</a>  
    
    <a href="index.php?quanly=video&ac=them">
        <div id="box-chucnang" <? if($_GET["quanly"]=="video") echo "style='box-shadow:rgba(0, 0, 0, 0.1) -1px 0px 10px'"; ?>>
            <p><img class="visible-lg" src="view/img/icon1.png"/>Video</p>
        </div>
	</a>  
    
    <? 
	if($_SESSION["quyen"]=="admin")
	{
	?>	
    <a href="index.php?quanly=hangsx&ac=them">
        <div id="box-chucnang" <? if($_GET["quanly"]=="hangsx") echo "style='box-shadow:rgba(0, 0, 0, 0.1) -1px 0px 10px'"; ?>>
            <p><img class="visible-lg" src="view/img/icon1.png"/>Hãng SX</p>
        </div>
	</a>
    
    <a href="index.php?quanly=taikhoan">
        <div id="box-chucnang" <? if($_GET["quanly"]=="taikhoan") echo "style='box-shadow:rgba(0, 0, 0, 0.1) -1px 0px 10px'"; ?>>
            <p><img class="visible-lg" src="view/img/icon1.png"/>Tài khoản</p>
        </div>
    </a>
    
    <? } ?>

    <a href="index.php?quanly=donhang">
        <div id="box-chucnang">
            <p><img class="visible-lg" src="view/img/icon1.png"/>Đơn hàng</p>
        </div>
    </a>
    
    <a href="../">
        <div id="box-chucnang">
            <p><img class="visible-lg" src="view/img/icon1.png"/>Thoát</p>
        </div>
	</a>
</div>