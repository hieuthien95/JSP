<script>
		// facebook fanpage
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.8&appId=161789597663541";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
		
		// facebook chat fangage
		(function($) {
			$(document).ready(function() {
				$('#hisella-minimize').click(function() {
					if ($('#hisella-facebook').css('opacity') == 0) {
						$('#hisella-facebook').css('opacity', 1);
						$('.hisella-messages').animate({
							right : '0'
						}).animate({
							bottom : '0'
						});
					} else {
						$('.hisella-messages').animate({
							bottom : '-300px'
						}).animate({
							right : '-135px'
						}, 400, function() {
							$('#hisella-facebook').css('opacity', 0)
						});
					}
				})
			});
		})(jQuery);
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
</script>

<div id="fb-root"></div>
						<!--<style type="text/css">
                            .fb-page
                            {
                                margin-top: 30px; padding: 0
                            }
                        </style>
                        
<div class="fb-page col-lg-12 col-md-12 col-sm-12 col-xs-12 wow fadeInLeft" data-href="https://www.facebook.com/facebook/" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-tabs='messages' ></div>-->
						<style type="text/css">
                            .hisella-messages 
                            { 
                                position: fixed; bottom: 0; left: 0; z-index: 999999; 
                            }
                            .hisella-messages-outer 
                            { 
                                position: relative; 
                            }
                            #hisella-minimize 
                            { 
                                background: #3b5998; font-size: 14px; color: #fff; 
								padding: 3px 10px; position: absolute; top: -27px; left: 0; 
								border: 1px solid #E9EAED; cursor: pointer; 
                            }
                            @media screen and (max-width:768px)
                            { 
                                #hisella-facebook { opacity:0; } 
                                .hisella-messages { bottom: -300px; right: -135px; } 
                            }
                        </style>
<div class="hisella-messages hidden-xs">
  <div class="hisella-messages-outer">
    <div id="hisella-minimize">Facebook chat</div>
    <div id="hisella-facebook" class='fb-page' data-adapt-container-width='true' data-height='300' data-hide-cover='false' data-href='https://www.facebook.com/IconClubTDT/' data-show-facepile='true' data-show-posts='false' data-small-header='false' data-tabs='messages' data-width='250'></div>
  </div>
</div>
