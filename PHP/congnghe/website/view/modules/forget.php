<script type="text/javascript">
function validateForm() {
	//Tên phải được điền
	var ten = document.forms["myForm"]["ten"].value;
	var reg_ten = /^[a-zA-Z_ÀÁÂÃÈÉÊẾỆÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$/;
	if (ten == "") {
		alert("Tên không được để trống");
		return false;
	}
	else if (reg_ten.test(ten) == false) {
		alert("Tên không hợp lệ");
		return false;
	}
	//Tên đăng nhập phải được điền
	var id = document.forms["myForm"]["id"].value;
	var reg_id = /^[a-zA-Z0-9]+([a-zA-Z0-9](_|-| )[a-zA-Z0-9])*[a-zA-Z0-9]*$/;
	if (id == "") {
		alert("Tên đăng nhập không được để trống");
		return false;
	}
	else if (reg_id.test(id) == false) {
		alert("Tên đăng nhập không hợp lệ");
		return false;
	}
	//Nhập số điện thoại
	var dienThoai = document.forms["myForm"]["sdt"].value;
	var kiemTraDT = isNaN(dienThoai);
	if (dienThoai == "") {
		alert("Điện thoại không được để trống");
		return false;
	}
	if (kiemTraDT == true) {
		alert("Điện thoại không hợp lệ");
		return false;
	}
	//Email phải được điền chính xác
	var email=document.forms["myForm"]["email"].value;
	var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
	if (email == "") {
		alert("Email không được để trống");
		return false;
	}
	else if (reg_mail.test(email) == false) {
		alert("Email không hợp lệ");
		return false;
	}
}
</script>

<? $site_key    = '6LdYGwsUAAAAALjiOh6jVtQ1403qqU8SxVsw6FYI'; ?>
<script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>
<div class="clearfix"></div>
<div class="col-lg-6 col-md-6" style="padding:5px">
    <form action="website/controller/controller_account.php" class="taikhoan" method="post" enctype="multipart/form-data" name="myForm" onsubmit="return validateForm()">
        <h2 style="padding-top:20px">Quên mật khẩu</h2> 
        <input type="text" placeholder="Email" name="email"/>                
        <input style="background:#06F; border:none; color:#fff" name="quenmk" type="submit" value="XÁC NHẬN">
    </form>
</div>
<div class="clearfix"></div>