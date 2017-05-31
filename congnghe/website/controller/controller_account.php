<?php
include_once("../model/model.php"); 
session_start();
$model = new Model();
$con  = $model->connectDatabase();

//cấu hình thông tin do google cung cấp
$api_url     = 'https://www.google.com/recaptcha/api/siteverify';
$site_key    = '6LdYGwsUAAAAALjiOh6jVtQ1403qqU8SxVsw6FYI';
$secret_key  = '6LdYGwsUAAAAAHjGNY09YnkIAHiT8G65G3irDCcW';

$id = $_POST['id'];
$sdt = $_POST['sdt'];
$email = $_POST['email'];
$ten = $_POST['ten'];
$tenanh = $_FILES["anhminhhoa"]["name"];
$pass = $_POST['pass'];
$newpass = $_POST['newpass'];
$conformpass = $_POST['conformpass'];

if(isset($_POST['them']) || isset($_POST['capnhat'])) {
	$errors= array();
	if($tenanh != ""){
		$file_name = $tenanh;
		$file_size = $_FILES['anhminhhoa']['size'];
		$file_tmp = $_FILES['anhminhhoa']['tmp_name'];
		$file_type = $_FILES['anhminhhoa']['type'];
		$file_ext=strtolower(end(explode('.',$_FILES['anhminhhoa']['name'])));
		   
		$expensions= array("jpeg","jpg","png");
		   
		if(in_array($file_ext,$expensions)== false){
			$errors[]="Chỉ hỗ trợ upload file JPEG hoặc PNG.";
		}
		   
		if($file_size > 2097152) {
			$errors[]='Kích thước file không được lớn hơn 2MB';
		}
	}
	if(empty($errors)==true) {
		if(isset($_POST['them'])) {
			//lấy dữ liệu được post lên
			$site_key_post    = $_POST['g-recaptcha-response'];
				  
			//lấy IP của khach
			if (!empty($_SERVER['HTTP_CLIENT_IP'])) 
				$remoteip = $_SERVER['HTTP_CLIENT_IP'];
			elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR']))
				$remoteip = $_SERVER['HTTP_X_FORWARDED_FOR'];
			else
				$remoteip = $_SERVER['REMOTE_ADDR'];
			
				 
			//tạo link kết nối
			$api_url = $api_url.'?secret='.$secret_key.'&response='.$site_key_post.'&remoteip='.$remoteip;
			//lấy kết quả trả về từ google
			$response = file_get_contents($api_url);
			//dữ liệu trả về dạng json
			$response = json_decode($response);
			if(!isset($response->success))
				echo 'Captcha khong dung';
			if($response->success == true)
			{
				$quyen = "nguoidung";
					
				if($_SESSION["quyen"]=="admin")
					$quyen = $_POST["quyen"];
					
				if (empty($_POST['id']) || empty($_POST['pass'])) 
					echo $error = "Username or Password is invalid";
				else				
					$model->addTaiKhoan($id, $sdt, $email, $ten, $quyen, $tenanh, $pass);				
			}
			else
				echo 'Captcha khong dung';
		}
			
		else if(isset($_POST['capnhat']))
		{
			if (md5($pass) == $_SESSION["pass"]) 
				$model->updateAccount($_SESSION['username'], $sdt, $email, $ten, $quyen, $tenanh, $newpass);
			else 
				echo $error = "Password is invalid";
		}
	} else{ 
		print_r($errors);
	}
	
}


else if(isset($_POST['dangnhap'])) 
{
	$return_url = base64_decode($_POST["return_url"]);
	$username=$_POST['username'];
	$password=$_POST['password'];
	
	if (empty($_POST['username']) || empty($_POST['password'])) 
		echo $error = "Your Login Name or Password is invalid111";
	else
		$model->login($username, $password, $return_url);
}


else if(isset($_POST['quenmk'])) 
{
	$email=$_POST['email'];
	
	$value = $model->quenMK($email);
	
	$to = $email;  //khai báo địa chỉ mail người nhận
	$subject = 'Forgot password'; // chủ đề của mail
	// Đây là nội dung mail cần gửi. Để xuống dòng , chèn \n vào cuối dòng
	$message = "Your password is ".$value;
	// Khai báo thông tin mail người gửi. Cách dòng bằng \r\n
	$headers = "From: hieuthien95@gmail.com\r\nReply-To: '$to'";
	 //Gửi mail
	$mail_sent = mail( $to, $subject, $message, $headers );
	// Nếu thành công thì xuất dòng thông báo "Mail sent", ngược lại thì xuất  "Mail failed"
	$error = $mail_sent ? "Mail sent" : "Mail failed";
	?>
    
    <script> alert("Đã gửi mail cho bạn"); </script>
    
    <?
}


else {
	session_unset();
	$_SESSION['quyen']="";
	session_destroy();
	header('location:./');
}

?>

<a href="http://www.thientdt.esy.es" class="btn">Trở về trang chủ</a>