<footer id="site-footer" class="row align-center clearfix wow fadeInLeft">
    
    <div class="row footer-link-wrapper clearfix">
    
        <div class="col about-us col-lg-2 col-md-2 col-sm-6 col-xs-6" style="padding:10px 15px">
            <h3><b><a href="#" title="Giới Thiệu">Giới Thiệu</a></b></h3>
            <ul class="nolist">
				<?php foreach($introList as $intro) { ?>
               		<li><a href="<?php echo $intro['link'] ?>"><?php echo $intro['vande'] ?></a></li>
                <? }?>
            </ul>
        </div>
        
        <div class="col for-customer col-lg-2 col-md-2 col-sm-6 col-xs-6" style="padding:10px 15px">
            <h3><a href="#"><b>Hỗ Trợ Khách Hàng</b></a></h3>
            <ul class="nolist">
            	<?php foreach($supList as $sup) { ?>
                    <li><a href="<?php echo $sup['link'] ?>"><?php echo $sup['hotro'] ?></a></li>
				<? } ?>
            </ul>
        </div>
        
        <div class="col customer-support col-lg-4 col-md-4 col-sm-6 col-xs-12" style="padding:10px 15px">
            <h3><b><a href="#" title="Tổng đài bán hàng">Tổng đài bán hàng</a></b></h3>
            <div class="table-wrapper">
                <div class="row-wrapper title-wrapper clearfix">
                 <div class="col1">Miền Nam</div>
                 <div class="col2">Miền Trung</div>
                 <div class="col3">Miền Bắc</div>
                </div>
                <div class="row-wrapper content-wrapper clearfix">
                 <div class="col1"><?php echo $phoneList[0]['dt'] ?></div>
                 <div class="col2"><?php echo $phoneList[1]['dt'] ?></div>
                 <div class="col3"><?php echo $phoneList[2]['dt'] ?></div>
                </div>
            </div>
            <div class="note">
                Tư vấn, hỗ trợ <?php echo $phoneList[3]['dt'] ?>
            </div>
            <div class="note">
                Khiếu nại <?php echo $phoneList[4]['dt'] ?>
            </div>
        </div>

        <div class="col promotion col-lg-4 col-md-4 col-sm-6 col-xs-12" style="padding:10px 15px">
        	<b><a href="#"><span style="line-height:25px">Thanh toán an toàn với</span></a><br /></b>
            <?php foreach($payList as $pay) { ?>
                <a href="<?php echo $pay['link'] ?>">
                    <img width="75" height="30" src="<?php echo $pay['hinhthuc'] ?>">
                </a>
			<? } ?>            
        </div>
        
    </div>
    
    <div class="clearfix col-lg-12 col-md-12 col-sm-12 col-xs-12">
  		<div class="copyright">
        	© 2016. Công ty cổ phần Icon Club
        </div>
    </div>
    
    
    <!-- 	footer 	-->
	<script type="text/javascript"> 
		// tìm kiếm
		var homepage = 1;
		$('#search-keyword').attr('placeholder','');
		var categoryName = ' Bạn muốn tìm gì hôm nay?';
		var idx = 0;
		TypingPlaceHolder(categoryName, idx);
        
		function TypingPlaceHolder(categoryName, idx)
		{
		if(idx >= categoryName.length)
		 return;
		var cur = $('#search-keyword').attr('placeholder');
		$('#search-keyword').attr('placeholder',cur + categoryName[idx]);
		idx++;
		setTimeout(function(){
		 TypingPlaceHolder(categoryName, idx);
		}, 25);
		}
		var _cposi ='1';
		
		
		
		// facebook
		window.fbAsyncInit = function() {
			FB.init({
			appId      : '168660906912545',
			xfbml      : true,
			version    : 'v2.7'
			});
		};
		(function(d, s, id){
			 var js, fjs = d.getElementsByTagName(s)[0];
			 if (d.getElementById(id)) {return;}
			 js = d.createElement(s); js.id = id;
			 js.src = "//connect.facebook.net/en_US/sdk.js";
			 fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
		
		
		// chat trực tuyến
		(function() {
			var pname = ( (document.title !='')? document.title : document.querySelector('h1').innerHTML );
			var ga = document.createElement('script'); 
			ga.type = 'text/javascript'; ga.async=1; 
			ga.src = '//live.vnpgroup.net/js/web_client_box.php?hash=84fb9d21bc435cae91c71a977e21057f&data=eyJzc29faWQiOjE4MTExNzMsImhhc2giOiJkMWFjOTE2OTg0OGMzYzQxODhkYzdkZTU5OTQ5YTlhZiJ9&pname='+pname;
			var s = document.getElementsByTagName('script');
			s[0].parentNode.insertBefore(ga, s[0]);
		})();
	</script>
</footer>