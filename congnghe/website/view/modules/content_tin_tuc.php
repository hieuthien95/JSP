<style>
	p{
		font-size:18px !important;
		line-height:30px
	}
	.tintuc img{
		width:100%
	}
	.tintuc a{
		color: #009 !important
	}
</style>
<div class="tintuc row" style="overflow:hidden">
    		
	<?php 
		foreach($newsList as $news)
			if($news["stt"]==$_GET["stt"])
			{ ?>
				<img src="<? echo $news["hinhanh"] ?>" />
				<h2 style="text-align: center; margin-top:5px"> <? echo $news["tieude"] ?> </h2>
				<h3 style="text-align: justify; padding:0px 5px"> <? echo $news["tomtat"] ?> </h3>
				<div style="text-align: justify; padding:0px 5px">  <? echo $news["noidung"] ?> </div>
				<? 
			}?>
	
	 <?php 
	 if($_GET["stt"]!=0)
	 { ?>
            <hr />
            <h3 align="center"> Tin khác </h3>
            <?php 
            foreach($newsList as $news) 
            { ?>
                <a style="line-height:30px; color:#009; padding: 0px 15px; text-align:justify; display:block" 
                	href="./?ac=tintuc&stt=<? echo $news["stt"] ?>"> <? echo $news["tieude"] ?><br/>
                </a> 
         <? } 
     } ?>
</div>



<!--<div class="fb-like" data-share="true" data-show-faces="true"></div>-->
<div class="fb-comments" data-href="http://www.thiensu.com/WebDemo/?ac=thongtin&stt=<? echo $_GET["stt"] ?>" 
	data-colorscheme="light" data-numposts="5" data-width="100%">
</div>