$(document).ready
		(
		
			function()
			{
				var width = window.screen.availWidth;
				var height=window.screen.availHeight;
				
				if(width>=768)
					$('#img_show').css("width","40%");
				$('.item').mouseover
				(
					function()
					{
						$(this).css("cursor","pointer");
					}
				);
				
				$(".item").toggle
				(
					function()
					{ 
						 $('#img_show').css("position","fixed");
						 $('#img_show').css("z-index","99999");
						 $('#img_show').css("top","0");
						 $('#img_show').css("left","0");
						 $('#img_show').css("width","100%");
						 $('#img_show').css("height","100%");
						 $('#img_show').css("background","rgba(0,0,0,0.8)");
						 $('.hinhanhsp').css("display","none");
						 
						 if(height>=width)
						 	$('.itm').css("width","100%");
						 else {
							$('.itm').css("width","auto");
							if(width>=768)
								$('.itm').css("height",height-150);
							else 
								$('.itm').css("height",height-20);
						 }
						 
						 $('#carousel-example-generic').css("top","50%");
						 $('#carousel-example-generic').css("transform","translateY(-50%)");
					},
					function()
					{
						 if( width < 768){
							$('#img_show').css("width","inherit");
						 } 
						 else 
						 	$('#img_show').css("width","40%");
						 $('#img_show').css("background","inherit");
						 $('#img_show').css("position","inherit");
						 $('#img_show').css("top","inherit");
						 $('#img_show').css("left","inherit")
						 $('.hinhanhsp').css("display","inherit");
						 $('.itm').css("height","inherit");
						 $('#carousel-example-generic').css("top","inherit");
						 $('#carousel-example-generic').css("transform","inherit");
					}
				);
			}
		);
		
	
    	$(document).ready
		(
			function()
			{
				$('#img2').width(100);
				$('#img2').mouseover
				(
					function()
					{
						$(this).css("cursor","pointer");
					}
				);
				$("#img2").toggle
				(
					function()
					{
						$(this).animate({width: "100%", paddingLeft: "0", paddingRight: "0"}, 'medium')
					},
					function()
					{
						$(this).animate({width: "100px"}, 'medium');
					}
				);
			}
		);