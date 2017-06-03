<?
session_start();
	
if($_SESSION["quyen"]=="admin" || $_SESSION["quyen"]=="nhanvien")
{
	include_once("../../../model/model.php");
	$model = new Model();
	
	$stt=$_GET["stt"];
	$ten=$_POST["ten"];
	$sl=$_POST["sl"];
	$gia=$_POST["gia"];
	$manhinh=$_POST["manhinh"];
	$hdh=$_POST["hdh"];
	$cpu=$_POST["cpu"];
	$camera=$_POST["camera"];
	$pin=$_POST["pin"];
	$nhieuhon=$_POST["nhieuhon"];
	$hangsx=$_POST["hangsx"];
	$loaisp=$_POST["loaisp"];
	$km=$_POST["km"];
	
	$tenanh = $_FILES["anhminhhoa"]["name"];
	
	$trangthai=0;
	if($_SESSION["quyen"]=="admin")
		$trangthai = $_POST["trangthai"];
	
	if(isset($_POST["them"]))
		$model->addGood($tenanh, $ten, $gia, $manhinh, $hdh, $cpu, $camera, $pin, $nhieuhon, $hangsx, $loaisp, $km, $trangthai, $sl);
		
	else if(isset($_POST["sua"]) && $_SESSION["quyen"]=="admin") {
		$model->updateGood($stt, $tenanh, $ten, $gia, $manhinh, $hdh, $cpu, $camera, $pin, $nhieuhon, $hangsx, $loaisp, $km, $trangthai, $sl);
		header("location: ../../../index.php?quanly=hanghoa&ac=sua&stt=".$stt."&trang=".$_GET["trang"]);
	}
		
	else if(isset($_POST["themanhkhac"]))
	{
		//$model->addGoodImg($stt, $tenanh2, $tenanh3, $tenanh4, $tenanh5);
		$loaihinh = $_GET["quanly"];
		$sttloaihinh = $_GET["stt"];
		$model->addImg($loaihinh, $sttloaihinh, $tenanh);
		
		header("location: ../../../index.php?quanly=hanghoa&ac=themanhkhac&stt=".$stt."&trang=".$_GET["trang"]);
	}
	else if($_GET["xoa"] == "hinhanh") {
		$stt = $_GET["stt"];
		$model->deleteImg($stt);
		header("location: ../../../index.php?quanly=hanghoa&ac=themanhkhac&stt=".$_GET["sttsp"]."&trang=".$_GET["trang"]);
	}
	
	else if($_GET["ac"]=="xoa" && $_SESSION["quyen"]=="admin")
		$model->deleteGood($stt);
}
?>