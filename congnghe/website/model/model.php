<?php

	define('NUM',12);

	class Model {
		public function __construct() { }
		
		public function connectDatabase() {	
			
			include("config.php");
			
			$con=mysqli_connect($tenmaychu, $taikhoan, $matkhau, $csdl);
			
			if(!$con)
			{
				echo"khong the ket noi CSDL";
				exit;	
			}
			mysqli_query($con,"SET NAMES 'UTF8'");
			
			return $con;
		}
		
		//lấy ra danh sách quảng cáo
		public function getAdList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM raovat");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$adList[] = $row;
				return $adList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy ra danh sách tin tức
		public function getNewsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM baiviet ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$newsList[] = $row;
				return $newsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang tin tức
		public function getNumNews() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM baiviet");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy ra danh sách KM
		public function getKMsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM baiviet WHERE loaitin = 'Khuyến mãi' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$newsList[] = $row;
				return $newsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang KM
		public function getNumKMs() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM baiviet WHERE loaitin = 'Khuyến mãi'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy ra danh sách giới thiệu
		public function getIntroList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM gioithieu");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$introList[] = $row;
				return $introList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy ra danh sách hỗ trợ khách hàng
		public function getSupList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM hotrokhachhang");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$supList[] = $row;
				return $supList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy ra danh sách tổng đài bán hàng
		public function getPhoneList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM tongdai");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$phoneList[] = $row;
				return $phoneList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy danh sách thanh toán
		public function getPayList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM thanhtoan LIMIT 10");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$payList[] = $row;
				return $payList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy danh sách tin khuyến mãi
		public function getProList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM khuyenmai");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$proList[] = $row;
				return $proList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy danh sách thông tin quảng cáo
		public function getBanList() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM quangcao ORDER BY stt DESC LIMIT 5");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$banList[] = $row;
				return $banList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//-------------------------lấy ra danh sách hình ảnh-------------------------
		public function getImgList($loaihinh, $sttloaihinh) {			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM hinhanh WHERE loaihinh='$loaihinh' AND sttloaihinh='$sttloaihinh'");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$imgList[] = $row;
				return $imgList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy danh sách hàng hoá
		public function getGoodsList() {			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham ORDER BY stt DESC LIMIT 72");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//tìm sản phẩm
		public function getSearchGooodsList($keyword) {			
			$con = $this->connectDatabase();
			
			if(strtoupper($keyword)==strtoupper("máy củ")) 
				header('Location: ./?ac=chonmenu&stt=maycu');
			
			if(strtoupper($keyword)==strtoupper("tin tức"))
				header('Location: ./?ac=chonmenu&stt=tintuc');
			if(strtoupper($keyword)==strtoupper("video"))
				header('Location: ./?ac=chonmenu&stt=video');
			if(strtoupper($keyword)==strtoupper("khuyến mãi"))
				header('Location: ./?ac=chonmenu&stt=km');
			
			$keyword = "REPLACE('%$keyword%', ' ', '')";
			
			$data = "REPLACE(CONCAT(loaisp, hangsx, ten), ' ', '')";
			$sql = mysqli_query($con,"SELECT * FROM sanpham WHERE $data LIKE $keyword");
		  	while($row = mysqli_fetch_array($sql))
				$goodsList[] = $row;
			if(sizeof($goodsList)!=0)
				return $goodsList;
				
			$data = "REPLACE(CONCAT(loaisp, ten), ' ', '')";
			$sql = mysqli_query($con,"SELECT * FROM sanpham WHERE $data LIKE $keyword");
		  	while($row = mysqli_fetch_array($sql))
				$goodsList[] = $row;
			if(sizeof($goodsList)!=0)
				return $goodsList;
		}
		
		//lấy danh sách điện thoại
		public function getPhonesList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Điện thoại' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang điện thoại
		public function getNumPhones() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Điện thoại'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy danh sách MTB
		public function getMTBsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Máy tính bảng' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang MTB
		public function getNumMTBs() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Máy tính bảng'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy danh sách máy ảnh
		public function getMayAnhsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Máy ảnh' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang máy ảnh
		public function getNumMayAnhs() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Máy ảnh'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy danh sách laptop
		public function getLaptopsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Laptop' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang laptop
		public function getNumLaptops() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Laptop'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//lấy danh sách phụ kiện
		public function getPKsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Phụ kiện' ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang phụ kiện
		public function getNumPKs() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham WHERE loaisp = 'Phụ kiện'");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//-------------------------lấy danh sách video-------------------------
		public function getVideoList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM video ORDER BY stt DESC LIMIT $bd, $num");
			if ($result) {
				while($row = mysqli_fetch_assoc($result))
					$videotList[] = $row;
				return $videotList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}	
		//lấy số trang video
		public function getNumVideos() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM video");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//-------------------------lấy danh sách đơn hàng-------------------------
		public function getDonHangList() {
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM donhang ORDER BY stt DESC");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$donHangList[] = $row;
				return $donHangList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//thêm đơn hàng
		public function addDonHang($gia, $sdt, $ghichu) {
			$con = $this->connectDatabase();
			
			$gia = base64_decode($gia);
			$ghichu = base64_decode($ghichu);
			
			$sql = mysqli_query($con, "SELECT * FROM donhang ORDER BY stt DESC");
			$donHangList[] = mysqli_fetch_assoc($sql);
			$madonhang = $donHangList[0]["stt"] + 1;
			
			date_default_timezone_set("Asia/Bangkok");
			$time = date("h:i:s d/m/Y");
			
			
			mysqli_query($con, 
				"INSERT INTO donhang(stt, gia, sdt, ghichu, thoigian) VALUES ('$madonhang', '$gia', '$sdt', '$ghichu', '$time')");
			
			
			$chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			$size = strlen( $chars );
			for( $i = 0; $i < 10; $i++ )
				$str .= $chars[ rand( 0, $size - 1 ) ];
				
			session_start();
			$_SESSION["accapnhat"] = $str;
			
			$link = "https://www.nganluong.vn/button_payment.php?receiver=hieuthien95@gmail.com&product_name=".$madonhang."&price=".$gia."&return_url=http://thientdt.esy.es/congnghe/?accapnhat=".$str."&comments=".$ghichu;
			header('Location: '.$link);
		}	
		//cập nhật đơn hàng
		public function updateDonHang($madonhang, $magiaodich) {
			$con = $this->connectDatabase();
			
			//kiểm tra đơn hàng đã thanh toán
			$result = mysqli_query($con, "SELECT * FROM donhang WHERE stt='$madonhang' AND magiaodich <>''");
			$num = mysqli_num_rows($result);
			if($num > 0 )
				header('Location: ./');
			else {
				date_default_timezone_set("Asia/Bangkok");
				$time = date("h:i:s d/m/Y");
				
				$sql="UPDATE donhang SET magiaodich='$magiaodich', thoigian='$time' WHERE stt=".$madonhang;
				
				mysqli_query($con, $sql);
				
				header('Location: ./?ac=thongtindonhang');
			}
		}
		//lấy danh sách hãng
		public function getBrandList() {
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM hangsx");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$brandList[] = $row;
				return $brandList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}	
		
		//thêm tài khoản
		public function addTaiKhoan($id, $sdt, $email, $ten, $quyen, $tenanh, $pass) {
			$con = $this->connectDatabase();
			
			$pass = md5($pass);
			
			//if(preg_match('/^[a-zA-Z_ÀÁÂÃÈÉÊẾỆÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$/', $ten))
			{
				$rows = mysqli_query($con, "SELECT * FROM login WHERE id = '$id' OR email = '$email' OR sdt = '$sdt'");
				
				if(mysqli_num_rows($rows) == 0)
					if($tenanh!=""){
						$time = date("Ymdhis");
						$tenanh = $time . $tenanh;
						$dich = "../../website/view/dangnhap/".$tenanh;
						
						copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
						$dich=substr($dich,6);
						
						mysqli_query($con, "INSERT INTO login(id, sdt, email, ten, quyen, avatar, pass) VALUES ('$id', '$sdt','$email', '$ten', '$quyen','$dich','$pass')");
					}
					
					else
						mysqli_query($con, "INSERT INTO login(id, sdt, email, ten, quyen, pass) VALUES ('$id', '$sdt','$email', '$ten', '$quyen', '$pass')");
				else {
					echo $error = "Your info has users";
					return;
				}
			}
			header("location: ../../");
		}
		
		//login
		public function login($username, $password, $return_url) {
			$con = $this->connectDatabase();
			
			if(preg_match('/^[a-zA-Z0-9]*$/', $username))
			{
				$password = md5($password);
				
				// For Security 
				$result= mysqli_query($con, "SELECT * From login where id ='$username' and pass ='$password'");
				$rows = mysqli_num_rows($result);	
				if($rows == 1)
				{
					session_start();
					$quyen = mysqli_fetch_assoc($result);
					
					$_SESSION['quyen']=$quyen["quyen"];
					$_SESSION['ten']=$quyen["ten"];
					$_SESSION['username']=$quyen["id"];
					$_SESSION['sdt']=$quyen["sdt"];
					$_SESSION['email']=$quyen["email"];
					$_SESSION['pass']=$quyen["pass"];
					$_SESSION['avatar']=$quyen["avatar"];
					
					setcookie('username', $quyen["id"], time() + (86400 * 30), "/"); // 86400 = 1 day
					setcookie('pass', $password, time() + (86400 * 30), "/"); // 86400 = 1 day
					
					echo $_COOKIE["username"]." ".$_COOKIE["pass"];
					
					header('Location:'.$return_url);
				}
				else
				{
					echo $error = "Your Login Name or Password is invalid";
				}
			}
		}
		
		public function quenMK($email) {
			$con = $this->connectDatabase();
			
			$chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			$size = strlen( $chars );
			for( $i = 0; $i < 6; $i++ )
				$pass .= $chars[ rand( 0, $size - 1 ) ];
				
			$newpass = md5($pass);
			
			$sql="UPDATE login SET pass='$newpass' WHERE email='$email'";
			mysqli_query($con,$sql);
			
			return $pass;			
		}
		
		
		public function updateAccount($id, $sdt, $email, $ten, $quyen, $tenanh, $newpass) {
			$con = $this->connectDatabase();
			
			//if(preg_match('/^[a-zA-Z_ÀÁÂÃÈÉÊẾỆÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$/', $ten))
			{
			
				$rows = mysqli_query($con, "SELECT * FROM login WHERE id = '$id' OR email = '$email' OR sdt = '$sdt'");
				if(mysqli_num_rows($rows) == 1)
					if($newpass != "")
					{
						$newpass = md5($newpass);
						if($tenanh!="")
						{					
							date_default_timezone_set("Asia/Bangkok");
							$time = date("Ymdhis");
							$tenanh = $time . $tenanh;
							$dich = "../../website/view/dangnhap/".$tenanh;
								
							copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
							$dich=substr($dich,6);
								
							//---------xoa anh co roi
							if($_SESSION["avatar"]!="")
								unlink("../../".$_SESSION["avatar"]);
							//----------
								
							$sql="UPDATE login SET avatar='$dich', ten='$ten', email='$email', sdt='$sdt', pass='$newpass' WHERE id='".$_SESSION["username"]."'";
						}
						else
							$sql="UPDATE login SET ten='$ten', email='$email', sdt='$sdt', pass='$newpass' WHERE id='".$_SESSION["username"]."'";
								
						if(mysqli_query($con,$sql)){
							session_destroy();
							header('location:../../');
						}
					}
					else
					{
						if($tenanh!="")
						{
								
							date_default_timezone_set("Asia/Bangkok");
							$time = date("Ymdhis");
							$tenanh = $time . $tenanh;
							$dich = "../../website/view/dangnhap/".$tenanh;
								
							copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
							$dich=substr($dich,6);
								
							//---------xoa anh co roi
							if($_SESSION["avatar"]!="")
								unlink("../../".$_SESSION["avatar"]);
							//----------
								
							$sql="UPDATE login SET avatar='$dich', ten='$ten', email='$email', sdt='$sdt' WHERE id='".$_SESSION["username"]."'";
						}
						else
							$sql="UPDATE login SET ten='$ten', email='$email', sdt='$sdt' WHERE id='".$_SESSION["username"]."'";
								
						if(mysqli_query($con,$sql)){
							session_destroy();
							header('location:../../');
						}
					}
				else 
					echo $error = "Your info has users";
			}
		}
	}
?>