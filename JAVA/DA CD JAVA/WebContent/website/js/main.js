/*price range*/
$('#sl2').slider();
var RGBChange = function() {
	$('#RGB').css(
			'background',
			'rgb(' + r.getValue() + ',' + g.getValue() + ',' + b.getValue()
					+ ')')
};




// facebook
window.fbAsyncInit = function() {
	FB.init({
		appId : '168660906912545',
		xfbml : true,
		version : 'v2.7'
	});
};
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));






// chat trực tuyến
// window._sbzq || function(e) {
// e._sbzq = [];
// var t = e._sbzq;
// t.push([ "_setAccount", 56845 ]);
// var n = e.location.protocol == "https:" ? "https:" : "http:";
// var r = document.createElement("script");
// r.type = "text/javascript";
// r.async = true;
// r.src = n + "//static.subiz.com/public/js/loader.js";
// var i = document.getElementsByTagName("script")[0];
// i.parentNode.insertBefore(r, i)
// }(window);






//sự kiện scroll
$(function() {
	$('a[href*=#sanpham]:not([href=#])').click(
			function() {
				var target = $(this.hash);
				target = target.length ? target : $('[name='
						+ this.hash.substr(1) + ']');
				if (target.length) {
					$('html,body').animate({
						scrollTop : target.offset().top
					}, 2000);
					return false;
				}
			});
});

$(function() {
	$('a[href*=#tintuc]:not([href=#])').click(
			function() {
				var target = $(this.hash);
				target = target.length ? target : $('[name='
						+ this.hash.substr(1) + ']');
				if (target.length) {
					$('html,body').animate({
						scrollTop : target.offset().top
					}, 2000);
					return false;
				}
			});
});