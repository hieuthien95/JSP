<?
session_start();

if($_SESSION["quyen"]=="admin")
{
	include_once("../../../model/model.php");
	$model = new Model();	
	
	$mahang=$_POST["mahang"];
	$tenhang=$_POST["tenhang"];
	
	$tenhdh=$_POST["tenhdh"];
	
	$manhinh=$_POST["manhinh"];
	
	$phangiai=$_POST["phangiai"];
	
	
	
	if(isset($_POST["themhangsx"]))
		$model->addBrand($mahang, $tenhang);
	
	else if(isset($_POST["themhdh"]))
		$model->addHDH($tenhdh);
	
	else if(isset($_POST["themmanhinh"]))
		$model->addManHinh($manhinh);
	
	else if(isset($_POST["themcamera"]))
		$model->addCamera($phangiai);
	
	else 
	{
		$stt=$_GET["stthangsx"];
		$model->deleteBrand($stt);
		
		$stt=$_GET["stthdh"];
		$model->deleteHDH($stt);
		
		$stt=$_GET["sttcamera"];
		$model->deleteCamera($stt);
		
		$stt=$_GET["sttmanhinh"];
		$model->deleteManHinh($stt);
	}
}
?>