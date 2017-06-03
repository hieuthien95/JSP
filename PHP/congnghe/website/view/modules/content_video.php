<style>
	p{
		font-size:18px !important;
		line-height:30px
	}
	.tintuc img {
		width:100%
	}
	.tintuc a{
		color: #009 !important
	}
</style>
<div class="tintuc row" style="padding:0px 0px 10px 0px">
    		
	<?php 
	foreach($videoList as $video)
			if($video["stt"]==$_GET["stt"])
			{ ?>
				<img style="padding:0px; padding-bottom:5px" 
                	class="col-lg-12 col-md-12 col-sm-12 col-xs-12" src="<? echo $video["hinhanh"] ?>" />
				<h2 class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  style="text-align: center"> 
					<? echo $video["ten"] ?> 
                </h2>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center" style="padding:5px">
                    <iframe frameborder="0" allowfullscreen="1" style="width:100%; height:200px"
                        title="YouTube video player" src="<?php echo $video["duongdan"] ?>"> 
                    </iframe>
                </div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: justify; padding:5px">  
					<? echo $video["noidung"] ?> 
                </div>
				<? 
			}?>
	
	<?php 	
	if($_GET["stt"]!=0)
	{ ?>
            <hr />
            <h3 class="col-xs-12" align="center"> Video khác </h3>
            <?php 
            foreach($videoList as $video) 
            { ?>
                <a style="line-height:30px; color:#009; padding: 0px 15px; text-align:justify; display:block" 
                	href="./?ac=video&stt=<? echo $video["stt"] ?>"> <? echo $video["ten"] ?><br/>
                </a> 
         <? } 
     } ?>
</div>



<!--<div class="fb-like" data-share="true" data-show-faces="true"></div>-->
<div class="fb-comments" data-href="http://www.thiensu.com/WebDemo/?ac=thongtin&stt=<? echo $_GET["stt"] ?>" 
	data-colorscheme="light" data-numposts="5" data-width="100%">
</div>