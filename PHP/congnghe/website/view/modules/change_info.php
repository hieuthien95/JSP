<script type="text/javascript">
function validateForm() {
	//Tên phải được điền
	var ten = document.forms["myForm"]["ten"].value;
	var reg_ten = /^[a-zA-Z_ÀÁÂÃÈÉÊẾỆÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$/;
	if (ten == "") {
		alert("Tên không được để trống");
		return false;
	}
	else if (/*reg_ten.test(ten) == false*/false) {
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
	//Xác nhận password chính xác
	var pass=document.forms["myForm"]["pass"].value;
	var conformpass=document.forms["myForm"]["conformpass"].value;
	if (pass == "") {
		alert("Mật khẩu không được để trống");
		return false;
	}
	//Xác nhận password chính xác
	var newpass=document.forms["myForm"]["newpass"].value;
	var conformpass=document.forms["myForm"]["conformpass"].value;
	if (newpass != "")
		if (newpass != conformpass) {
			alert("Mật khẩu xác nhận không hợp lệ");
			return false;
		}
}
</script>

<div class="clearfix"></div>
<div class="col-lg-6 col-md-6">
    <form class="taikhoan" action="website/controller/controller_account.php" 
    	method="post" enctype="multipart/form-data" name="myForm" onsubmit="return validateForm()">
        <h2>Thông tin </h2>
        <img src="<? echo $_SESSION["avatar"]?>" style="width:50%; margin-bottom:10px; border-radius: 1000%" />
        <input type="text" name="ten" value="<? echo $_SESSION["ten"]?>" />
        <input type="text" placeholder="Tên đăng nhập" name="id" value="<? echo $_SESSION["username"]?>" 
        	disabled="disabled" style="background:#E6E6E6" />
        <input type="text" placeholder="Điện thoại" name="sdt" value="<? echo $_SESSION["sdt"]?>" />
        <input type="text" placeholder="Email" name="email" value="<? echo $_SESSION["email"]?>"/>
        <input type="file" name="anhminhhoa"/>
        <input type="password" placeholder="Mật khẩu củ" name="pass" />
        <input type="password" placeholder="Mật khẩu mới" name="newpass" />
        <input type="password" placeholder="Nhập lại mật khẩu mới" name="conformpass" />
                
        <input style="background:#06F; border:none; color:#fff" name="capnhat" type="submit" value="CẬP NHẬT">
    </form>
</div>
<div class="clearfix"></div>