﻿<?php

	define('NUM',12);
	
	class Model {
	
		public function __construct() {	}	
		
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
		
		//-------------------------lấy danh sách hàng hoá-------------------------
		public function getGoodsList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM sanpham ORDER BY stt DESC LIMIT $bd, $num");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy sản phẩm
		public function getGoodsSearchList($stt) {
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM sanpham Where stt=$stt ORDER BY stt DESC");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$goodsList[] = $row;
				return $goodsList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang điện thoại
		public function getNumGoods() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM sanpham");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//thêm hàng hóa
		public function addGood($tenanh, $ten, $gia, $manhinh, $hdh, $cpu, $camera, $pin, $nhieuhon, $hangsx, $loaisp, $km, $trangthai, $sl) {
			$con = $this->connectDatabase();
			
			
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/hanghoa/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
				$dich=substr($dich,12);
				$sql="INSERT INTO sanpham (hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx, loaisp, km, trangthai, sl) VALUES('$dich', '$ten', '$gia', '$manhinh', '$hdh', '$cpu', '$camera', '$pin', '$nhieuhon', '$hangsx', '$loaisp', '$km', '$trangthai', '$sl')";
			}
			else
				$sql="INSERT INTO sanpham (hinhanh, ten, gia, manhinh, hdh, cpu, camera, pin, nhieuhon, hangsx, loaisp, km, trangthai, sl) VALUES('', '$ten', '$gia', '$manhinh', '$hdh', '$cpu', '$camera', '$pin', '$nhieuhon', '$hangsx', '$loaisp', '$km', '$trangthai', '$sl')";
			
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=hanghoa&ac=them");
		}
		//thêm ảnh hàng hóa
		public function addGoodImg($stt, $tenanh2, $tenanh3, $tenanh4, $tenanh5) {
			$con = $this->connectDatabase();
			
			if($tenanh2!=""){
				$time = date("Ymdhis");
				$tenanh2 = $time . $tenanh2;
				$dich2 = "../../../../website/view/hanghoa/".$tenanh2;
				
				copy($_FILES["anhminhhoa2"]["tmp_name"], $dich2);
				$dich2=substr($dich2,12);
				
				$sql="UPDATE sanpham SET hinhanh2='$dich2' WHERE stt=".$stt;
				mysqli_query($con,$sql);
			}
			if($tenanh3!=""){
				$time = date("Ymdhis");
				$tenanh3 = $time . $tenanh3;
				$dich3 = "../../../../website/view/hanghoa/".$tenanh3;
				
				copy($_FILES["anhminhhoa3"]["tmp_name"], $dich3);
				$dich3=substr($dich3,12);
				
				$sql="UPDATE sanpham SET hinhanh3='$dich3' WHERE stt=".$stt;
				mysqli_query($con,$sql);
			}
			if($tenanh4!=""){
				$time = date("Ymdhis");
				$tenanh4 = $time . $tenanh4;
				$dich4 = "../../../../website/view/hanghoa/".$tenanh4;
				
				copy($_FILES["anhminhhoa4"]["tmp_name"], $dich4);
				$dich4=substr($dich4,12);
				
				$sql="UPDATE sanpham SET hinhanh4='$dich4' WHERE stt=".$stt;
				mysqli_query($con,$sql);
			}
			if($tenanh5!=""){
				$time = date("Ymdhis");
				$tenanh5 = $time . $tenanh5;
				$dich5 = "../../../../website/view/hanghoa/".$tenanh5;
				
				copy($_FILES["anhminhhoa5"]["tmp_name"], $dich5);
				$dich5=substr($dich5,12);
				
				$sql="UPDATE sanpham SET hinhanh5='$dich5' WHERE stt=".$stt;
				mysqli_query($con,$sql);
			}
			
			header("location: ../../../index.php?quanly=hanghoa&ac=themanhkhac&stt=".$stt);
		}
		
		//thêm ảnh
		public function addImg($loaihinh, $sttloaihinh, $tenanh) {
			$con = $this->connectDatabase();
			
			if($tenanh!=""){
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/hinhanh/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
				$dich=substr($dich,12);
				
				$sql="INSERT INTO hinhanh(loaihinh, sttloaihinh, anhminhhoa) VALUES ('$loaihinh', '$sttloaihinh',  '$dich')";
				mysqli_query($con,$sql);
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
		
		//xóa hình ảnh
		public function deleteImg($stt) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$sql="SELECT * FROM hinhanh WHERE stt=".$stt;
			$hinhanh=mysqli_query($con,$sql);
			$dong=mysqli_fetch_array($hinhanh);
			if($dong["anhminhhoa"]!="")
				unlink("../../../../".$dong["anhminhhoa"]);
			//----------	
			
			mysqli_query($con,"DELETE FROM hinhanh WHERE stt=".$stt);
		}
		
		//xóa hàng hóa
		public function deleteGood($stt) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$sql="SELECT hinhanh FROM sanpham WHERE stt=".$stt;
			$baiviet=mysqli_query($con,$sql);
			$dong=mysqli_fetch_array($baiviet);
			if($dong["hinhanh"]!="")
				unlink("../../../../".$dong["hinhanh"]);
			//----------	
			
			mysqli_query($con,"DELETE FROM sanpham WHERE stt=".$stt);
			header("location: ../../../index.php?quanly=hanghoa&ac=them");
		}
		
		//cập nhật hàng hóa
		public function updateGood($stt, $tenanh, $ten, $gia, $manhinh, $hdh, $cpu, $camera, $pin, $nhieuhon, $hangsx, $loaisp, $km, $trangthai, $sl) {
			$con = $this->connectDatabase();
			
			if($tenanh!=""){
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/hanghoa/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);			
				$dich=substr($dich,12);
				
				//---------xoa anh co roi
				$sql="SELECT hinhanh FROM sanpham WHERE stt=".$stt;
				$sp=mysqli_query($con,$sql);
				$dong=mysqli_fetch_array($sp);
				if($dong["hinhanh"]!="")
					unlink("../../../../".$dong["hinhanh"]);
				//----------
				
				$sql="UPDATE sanpham SET hinhanh='$dich', ten='$ten', gia='$gia', manhinh='$manhinh', hdh='$hdh', cpu='$cpu', camera='$camera', pin='$pin', nhieuhon='$nhieuhon', hangsx='$hangsx', loaisp='$loaisp', km='$km', trangthai='$trangthai', sl='$sl'  WHERE stt=".$stt;
				
			}
			else
				$sql="UPDATE sanpham SET ten='$ten', gia='$gia', manhinh='$manhinh', hdh='$hdh', cpu='$cpu', camera='$camera', pin='$pin', nhieuhon='$nhieuhon', hangsx='$hangsx', loaisp='$loaisp', km='$km', trangthai='$trangthai', sl='$sl' WHERE stt=".$stt;
		
			mysqli_query($con,$sql);
		}		
		
		//-------------------------lấy ra danh sách tin tức-------------------------
		public function getNewsList() {			
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM baiviet ORDER BY stt DESC LIMIT $bd, $num");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
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
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//thêm tin tức
		public function addNews($loaitin, $tieude, $tomtat, $tenanh, $noidung, $trangthai) {
			$con = $this->connectDatabase();
				
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/tintuc/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
				$dich=substr($dich,12);
				$sql = mysqli_query($con, "INSERT INTO baiviet(loaitin, tieude, tomtat, hinhanh, noidung, trangthai) VALUES ('$loaitin', '$tieude', '$tomtat', '$dich', '$noidung', '$trangthai')");
			}
			else
				$sql = mysqli_query($con, "INSERT INTO baiviet(loaitin, tieude, tomtat, hinhanh, noidung, trangthai) VALUES ('$loaitin', '$tieude', '$tomtat', '', '$noidung', '$trangthai')");
			
			
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=baiviet&ac=them");	
		}
		
		//xóa tin tức
		public function deleteNews($stt) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$sql="SELECT hinhanh FROM baiviet WHERE stt=".$stt;
			$baiviet=mysqli_query($con,$sql);
			$dong=mysqli_fetch_array($baiviet);
			if($dong["hinhanh"]!="")
				unlink("../../../../".$dong["hinhanh"]);
			//----------	
		
			$sql="DELETE FROM baiviet WHERE stt=".$stt;
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=baiviet&ac=them");
		}
		
		//cập nhật tin tức
		public function updateNews($stt, $loaitin, $tieude, $tomtat, $tenanh, $noidung, $trangthai) {
			$con = $this->connectDatabase();
			
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/tintuc/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);			
				$dich=substr($dich,12);
				
				//---------xoa anh co roi
				$sql="SELECT hinhanh FROM baiviet WHERE stt=".$stt;
				$baiviet=mysqli_query($con,$sql);
				$dong=mysqli_fetch_array($baiviet);
				if($dong["hinhanh"]!="")
					unlink("../../../../".$dong["hinhanh"]);
				//----------
				
				$sql="UPDATE baiviet SET loaitin='$loaitin', tieude='$tieude', tomtat='$tomtat', hinhanh='$dich', noidung='$noidung', trangthai='$trangthai' WHERE stt=".$stt;
				
			}
			else
				$sql="UPDATE baiviet SET loaitin='$loaitin', tieude='$tieude', tomtat='$tomtat', noidung='$noidung', trangthai='$trangthai' WHERE stt=".$stt;
		
			mysqli_query($con,$sql);
		}
		
		//-------------------------lấy danh sách video-------------------------
		public function getVideoList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM video ORDER BY stt DESC LIMIT $bd, $num");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$videoList[] = $row;
				return $videoList;
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
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//thêm video
		public function addVideo($ten, $tenanh, $duongdan, $noidung, $trangthai) {
			$con = $this->connectDatabase();
				
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/video/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
				$dich=substr($dich,12);
				$sql = mysqli_query($con, "INSERT INTO video(ten, duongdan, hinhanh, noidung, trangthai) VALUES ('$ten', '$duongdan', '$dich', '$noidung', '$trangthai')");
			}
			else
				$sql = mysqli_query($con, "INSERT INTO video(ten, duongdan, hinhanh, noidung, trangthai) VALUES ('$ten', '$duongdan', '', '$noidung', '$trangthai')");
			
			
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=video&ac=them");	
		}
		
		//xóa tin tức
		public function deleteVideo($stt) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$sql="SELECT hinhanh FROM video WHERE stt=".$stt;
			$baiviet=mysqli_query($con,$sql);
			$dong=mysqli_fetch_array($baiviet);
			if($dong["hinhanh"]!="")
				unlink("../../../../".$dong["hinhanh"]);
			//----------	
		
			$sql="DELETE FROM video WHERE stt=".$stt;
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=video&ac=them");
		}
		
		//cập nhật video
		public function updateVideo($stt, $ten, $tenanh, $duongdan, $noidung, $trangthai) {
			$con = $this->connectDatabase();
			
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/video/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);			
				$dich=substr($dich,12);
				
				//---------xoa anh co roi
				$sql="SELECT hinhanh FROM video WHERE stt=".$stt;
				$video=mysqli_query($con,$sql);
				$dong=mysqli_fetch_array($video);
				if($dong["hinhanh"]!="")
					unlink("../../../../".$dong["hinhanh"]);
				//----------
				
				$sql="UPDATE video SET ten='$ten', duongdan='$duongdan', hinhanh='$dich', noidung='$noidung', trangthai='$trangthai' WHERE stt=".$stt;
				
			}
			else
				$sql="UPDATE video SET ten='$ten', duongdan='$duongdan', noidung='$noidung', trangthai='$trangthai' WHERE stt=".$stt;
		
			mysqli_query($con,$sql);
		}
		
		//-------------------------lấy danh sách quảng cáo-------------------------
		public function getBanList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM quangcao ORDER BY stt DESC LIMIT $bd, $num");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$banList[] = $row;
				return $banList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//lấy số trang quảng cáo
		public function getNumBans() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM quangcao");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//thêm quảng cáo
		public function addBan($tenanh, $tieude, $link, $trangthai) {
			$con = $this->connectDatabase();
				
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/quangcao/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);
				$dich=substr($dich,12);
				$sql = mysqli_query($con,"INSERT INTO quangcao(hinhanh, tieude, link, trangthai) VALUES ('$dich', '$tieude','$link', '$trangthai')");
			}
			else
				$sql = mysqli_query($con,"INSERT INTO quangcao(hinhanh, tieude, link, trangthai) VALUES ('', '$tieude','$link', '$trangthai')");
			
			
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=quangcao&ac=them");	
		}
		
		//xóa quảng cáo
		public function deleteBan($stt) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$sql="SELECT hinhanh FROM quangcao WHERE stt=".$stt;
			$qc=mysqli_query($con,$sql);
			$dong=mysqli_fetch_array($qc);
			if($dong["hinhanh"]!="")
				unlink("../../../../".$dong["hinhanh"]);
			//----------	
			
			$sql="DELETE FROM quangcao WHERE stt=".$stt;
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=quangcao&ac=them");
		}
		
		//cập nhật quảng cáo
		public function updateBan($stt, $tenanh, $tieude, $link, $trangthai) {
			$con = $this->connectDatabase();
			
			if($tenanh!=""){
				
				$time = date("Ymdhis");
				$tenanh = $time . $tenanh;
				$dich = "../../../../website/view/quangcao/".$tenanh;
				
				copy($_FILES["anhminhhoa"]["tmp_name"], $dich);			
				$dich=substr($dich,12);
				
				//---------xoa anh co roi
				$sql="SELECT hinhanh FROM quangcao WHERE stt=".$stt;
				$qc=mysqli_query($con,$sql);
				$dong=mysqli_fetch_array($qc);
				if($dong["hinhanh"]!="")
					unlink("../../../../".$dong["hinhanh"]);
				//----------
				
				$sql="UPDATE quangcao SET hinhanh='$dich', tieude='$tieude', link='$link', trangthai='$trangthai' WHERE stt=".$stt;
			}
			else
				$sql="UPDATE quangcao SET link='$link', tieude='$tieude', trangthai='$trangthai' WHERE stt=".$stt;
		
			mysqli_query($con,$sql);
		}
		
		//-------------------------lấy danh sách hãng sx-------------------------
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
		
		//thêm hang sx
		public function addBrand($mahang, $tenhang) {
			$con = $this->connectDatabase();
			
			mysqli_query($con, 
				"INSERT INTO hangsx(mahang, tenhang) VALUES ('$mahang', '$tenhang')");
			
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}	
		
		//xóa hang sx
		public function deleteBrand($stt) {
			$con = $this->connectDatabase();
			
			$sql="DELETE FROM hangsx WHERE mahang='$stt'";
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		//-------------------------lấy danh sách HDH-------------------------
		public function getHDHList() {
			$con = $this->connectDatabase();
			
			$sql = mysqli_query($con, "SELECT * FROM hdh");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$hdhList[] = $row;
				return $hdhList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//thêm HDH
		public function addHDH($tenhdh) {
			$con = $this->connectDatabase();
			
			mysqli_query($con, 
				"INSERT INTO hdh(tenhdh) VALUES ('$tenhdh')");
				
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		//xóa HDH
		public function deleteHDH($stt) {
			$con = $this->connectDatabase();
			
			$sql="DELETE FROM hdh WHERE tenhdh='$stt'";
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		//-------------------------lấy danh sách đơn hàng-------------------------
		public function getDonHangList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM donhang ORDER BY stt DESC LIMIT $bd, $num");
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
		
		//lấy số trang đơn hàng
		public function getNumDonHangs() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM donhang");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		
		//xóa đơn hàng
		public function deleteDonHang($stt) {
			$con = $this->connectDatabase();
		
			$sql="DELETE FROM donhang WHERE stt=".$stt;
			mysqli_query($con,$sql);
			
			header("location: ../../../index.php?quanly=donhang");
		}
		//xóa đơn hàng
		public function deleteAllDonHang() {
			$con = $this->connectDatabase();
		
			$sql="DELETE FROM donhang WHERE magiaodich=''";
			mysqli_query($con,$sql);
			
			header("location: ../../../index.php?quanly=donhang");
		}
		
		
		//-------------------------lấy danh sách phan giai camera-------------------------
		public function getCameraList() {
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM camera ORDER BY phangiai DESC");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$cameraList[] = $row;
				return $cameraList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//thêm camera
		public function addCamera($phangiai) {
			$con = $this->connectDatabase();
			
			mysqli_query($con, "INSERT INTO camera(phangiai) VALUES ('$phangiai')");
				
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		//xóa HDH
		public function deleteCamera($stt) {
			$con = $this->connectDatabase();
			
			$sql="DELETE FROM camera WHERE phangiai='$stt'";
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		
		//-------------------------lấy danh sách man hinh-------------------------
		public function getManHinhList() {
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM manhinh ORDER BY manhinh DESC");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$manHinhList[] = $row;
				return $manHinhList;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		
		//thêm man hinh
		public function addManHinh($manhinh) {
			$con = $this->connectDatabase();
			
			mysqli_query($con, "INSERT INTO manhinh(manhinh) VALUES ('$manhinh')");
				
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		
		//xóa man hinh
		public function deleteManHinh($stt) {
			$con = $this->connectDatabase();
			
			$sql="DELETE FROM manhinh WHERE manhinh='$stt'";
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=hangsx&ac=them");
		}
		//-------------------------lấy danh sách tài khoản-------------------------
		public function getTaiKhoanList() {
			$trang = $_GET["trang"];
			if ($trang == null)
				$trang = 1;
			$num = NUM;
			$bd = ($trang-1)*NUM;
			
			$con = $this->connectDatabase();
			$sql = mysqli_query($con, "SELECT * FROM login LIMIT $bd, $num");
			if ($sql) {
				while($row = mysqli_fetch_assoc($sql))
					$taikhoans[] = $row;
				return $taikhoans;
			}
			else {
				echo "<strong>Database access failed.</strong><br/>";
				return NULL;
			}
		}
		//lấy số trang điện thoại
		public function getNumTaiKhoan() {
			$con = $this->connectDatabase();
			$result = mysqli_query($con, "SELECT * FROM login");
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			if(mysqli_num_rows($result)%12==0)
				return mysqli_num_rows($result)/12;
			return mysqli_num_rows($result)/12+1;
			
		}
		//xóa tài khoản
		public function deleteTaiKhoan($id) {
			$con = $this->connectDatabase();
			
			//---------xoa anh co roi
			$taikhoan=mysqli_query($con,"SELECT avatar FROM login WHERE id='$id'");
			$dong=mysqli_fetch_array($taikhoan);
			if($dong["avatar"]!="")
				unlink("../../../../".$dong["avatar"]);
			
			$sql="DELETE FROM login WHERE id='$id'";
			mysqli_query($con,$sql);
			header("location: ../../../index.php?quanly=taikhoan&ac=them");
		}
		//tìm sản phẩm
		public function getSearchGooodsList($keyword) {			
			$con = $this->connectDatabase();
			
			if(strtoupper($keyword)==strtoupper("máy củ")) 
				header('Location: ./?ac=chonmenu&stt=maycu');
			if(strtoupper($keyword)==strtoupper("điện thoại"))
				header('Location: ./?ac=chonmenu&stt=dtdd');
			if(strtoupper($keyword)==strtoupper("máy tính bảng"))
				header('Location: ./?ac=chonmenu&stt=mtb');
			if(strtoupper($keyword)==strtoupper("laptop"))
				header('Location: ./?ac=chonmenu&stt=laptop');
			if(strtoupper($keyword)==strtoupper("phụ kiện"))
				header('Location: ./?ac=chonmenu&stt=phukien');
			if(strtoupper($keyword)==strtoupper("máy ảnh"))
				header('Location: ./?ac=chonmenu&stt=mayanh');
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
				
			$data = "REPLACE(CONCAT(hangsx, ten), ' ', '')";
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
	}
?>