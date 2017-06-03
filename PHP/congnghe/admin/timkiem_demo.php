<head>
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.watermark.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$("#search-keyword").watermark("Nhập Từ Cần Tìm Kiếm");					// Watermart cho khung nhập
$("#search-keyword").keyup(function()
{
	var faq_search_input = $(this).val();   						// Lấy giá trị search của người dùng
	var dataString = 'keyword='+ faq_search_input;						// Lấy giá trị làm tham số đầu vào cho file ajax-search.php
	if(faq_search_input.length>3)								// Kiểm tra giá trị người nhập có > 3 ký tự hay ko
	{
		$.ajax({
			type: "GET",      							// Phương thức gọi là GET
			url: "ajax-search.php",  						// File xử lý
			data: dataString,							// Dữ liệu truyền vào
			beforeSend:  function() {						// add class "loading" cho khung nhập
				$('input#search-keyword').addClass('loading');
			},
			success: function(server_response)					// Khi xử lý thành công sẽ chạy hàm này
			{
				$('#searchresultdata').html(server_response).show();  		// Hiển thị dữ liệu vào thẻ div #searchresultdata
				$('span#faq_category_title').html(faq_search_input);		// Hiển thị giá trị search của người dùng
				
				if ($('input#search-keyword').hasClass("loading"))		// Kiểm tra class "loading"
					$("input#search-keyword").removeClass("loading");	// Remove class "loading"
			}
		});
	}
	return false;										// Không chuyển trang
});
});
</script>
</head>
<input type="text" id="search-keyword" />
<div id="searchresultdata" > </div>