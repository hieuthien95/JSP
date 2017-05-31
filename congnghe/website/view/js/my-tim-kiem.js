    $(document).ready(function() {				// Watermart cho khung nhập
    $("#search-keyword").keyup(function()
    {
        var search_keyword = $(this).val();   					// Lấy giá trị search của người dùng
        var dataString = 'keyword='+ search_keyword;				// Lấy giá trị làm tham số đầu vào cho file ajax-search.php
        if(search_keyword.length>0)								// Kiểm tra giá trị người nhập có > 3 ký tự hay ko
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
                    $('span#faq_category_title').html(search_keyword);		// Hiển thị giá trị search của người dùng
                    
                    if ($('input#search-keyword').hasClass("loading"))		// Kiểm tra class "loading"
                        $("input#search-keyword").removeClass("loading");	// Remove class "loading"
                }
            });
        }
		else {
			$.ajax({
                type: "GET",      							// Phương thức gọi là GET
                url: "ajax-search.php",  						// File xử lý
                data: 0000000000,							// Dữ liệu truyền vào
                beforeSend:  function() {						// add class "loading" cho khung nhập
                    $('input#search-keyword').addClass('loading');
                },
                success: function(server_response)					// Khi xử lý thành công sẽ chạy hàm này
                {
                    $('#searchresultdata').html(server_response).show();  		// Hiển thị dữ liệu vào thẻ div #searchresultdata
                    $('span#faq_category_title').html(search_keyword);		// Hiển thị giá trị search của người dùng
                    
                    if ($('input#search-keyword').hasClass("loading"))		// Kiểm tra class "loading"
                        $("input#search-keyword").removeClass("loading");	// Remove class "loading"
                }
            });
		}
        return false;										// Không chuyển trang
    });
    });