$(window).scroll(function(){
		if ($(this).scrollTop() > 115) {
			/*$('#task_flyout').addClass('fixed');*/
			$('#task_flyout').css("position","fixed");
			$('#task_flyout').css("top","0");
			$('#task_flyout').css("z-index","99999");
			$('#task_flyout').css("display","block");
			$('#task_flyout').css("width",$(".site-body").width());
		} else {
			//$('#task_flyout').removeClass('fixed');
			$('#task_flyout').css("display","none");
		}
		
		var width = $("body").width();
		if( width <= 991){
			if ($(this).scrollTop() > 50) {
				$('.shopping-cart').css("position","fixed");
				$('.shopping-cart').css("z-index","99999");
				$('.shopping-cart').css("top","0");
				$('.shopping-cart').css("right","0");
				$('.shopping-cart').css("border-top-right-radius","0");
				$('.shopping-cart').css("border-top-left-radius","0");
				$('.shopping-cart').css("box-shadow","-1px 3px 10px rgba(0,0,0,0.1)");
			} else {
				$('.shopping-cart').css("position","absolute");
				$('.shopping-cart').css("top","6px");
				$('.shopping-cart').css("right","50px");
				$('.shopping-cart').css("border-radius","3px");
				$('.shopping-cart').css("box-shadow","none");
			}
		}
	  });