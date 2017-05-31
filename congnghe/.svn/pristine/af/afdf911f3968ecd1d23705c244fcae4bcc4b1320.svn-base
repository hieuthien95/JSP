<?
session_start();

if($_SESSION["quyen"]=="admin" || $_SESSION["quyen"]=="nhanvien")
{
	include_once("../../../model/model.php");
	$model = new Model();	
	
	$stt=$_GET["stt"];
	$tieude=$_POST["tieude"];
	$noidung=$_POST["noidung"];
	$tomtat=$_POST["ttat"];
	$loaitin=$_POST["loaitin"];
	
	$tenanh = $_FILES["anhminhhoa"]["name"];
	
	$trangthai=0;
	if($_SESSION["quyen"]=="admin")
		$trangthai = $_POST["trangthai"];
			
	if(isset($_POST["them"]))
		$model->addNews($loaitin, $tieude, $tomtat, $tenanh, $noidung, $trangthai);
	
	else if(isset($_POST["sua"]) && $_SESSION["quyen"]=="admin"){
		$model->updateNews($stt, $loaitin, $tieude, $tomtat, $tenanh, $noidung, $trangthai);
		header("location: ../../../index.php?quanly=baiviet&ac=sua&stt=".$stt."&trang=".$_GET["trang"]);
	}
	
	else
		if($_GET["ac"]=="xoa" && $_SESSION["quyen"]=="admin")
			$model->deleteNews($stt);
}
?>