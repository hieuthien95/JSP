<?
session_start();

if($_SESSION["quyen"]=="admin" || $_SESSION["quyen"]=="nhanvien")
{
	include_once("../../../model/model.php");
	$model = new Model();	
	
	$stt=$_GET["stt"];
	$ten=$_POST["ten"];
	$noidung=$_POST["noidung"];
	$duongdan=$_POST["duongdan"];
	$tenanh = $_FILES["anhminhhoa"]["name"];
	
	$trangthai=0;
	if($_SESSION["quyen"]=="admin")
		$trangthai = $_POST["trangthai"];
			
	if(isset($_POST["them"]))
		$model->addVideo($ten, $tenanh, $duongdan, $noidung, $trangthai);
	
	else if(isset($_POST["sua"]) && $_SESSION["quyen"]=="admin"){
		$model->updateVideo($stt, $ten, $tenanh, $duongdan, $noidung, $trangthai);
		header("location: ../../../index.php?quanly=video&ac=sua&stt=".$stt."&trang=".$_GET["trang"]);
	}
	
	else
		if($_GET["ac"]=="xoa" && $_SESSION["quyen"]=="admin")
			$model->deleteVideo($stt);			
}
?>