<?
	session_start();
	
	include_once("../../../model/model.php");
	$model = new Model();
	
	$stt=$_GET["stt"];
	
	
	if($_SESSION["quyen"]=="admin")
		if($_GET['ac']=="xoa_DH_all")
			$model->deleteAllDonHang();
		else
			$model->deleteDonHang($stt);
?>