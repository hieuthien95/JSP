<?
	$ac=$_GET['ac'];
	if($ac=="them"){
		include("view/modules/quangcao/them.php");
	}else if($ac=="sua"){
		include("view/modules/quangcao/sua.php");
	}
	include("view/modules/quangcao/lietke.php");
?>