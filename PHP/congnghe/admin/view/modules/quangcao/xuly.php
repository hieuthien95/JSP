<?
session_start();

if($_SESSION["quyen"]=="admin" || $_SESSION["quyen"]=="nhanvien")
{
	include_once("../../../model/model.php");
	$model = new Model();		
	
	$stt=$_GET["stt"];
	$tieude = $_POST["tieude"];
	$link=$_POST["link"];
	$tenanh = $_FILES["anhminhhoa"]["name"];
	
	
	$trangthai=0;
	if($_SESSION["quyen"]=="admin")
		$trangthai = $_POST["trangthai"];
			
	if(isset($_POST["them"]))
		$model->addBan($tenanh, $tieude, $link, $trangthai);	

	else if(isset($_POST["sua"]) && $_SESSION["quyen"]=="admin"){
		$model->updateBan($stt, $tenanh, $tieude, $link, $trangthai);
		header("location: ../../../index.php?quanly=quangcao&ac=sua&stt=".$stt."&trang=".$_GET["trang"]);
	}
	
	else
		if($_GET["ac"]=="xoa" && $_SESSION["quyen"]=="admin")
			$model->deleteBan($stt);		
}
?>