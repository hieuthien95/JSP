<?
	session_start();
	
	include_once("../../../model/model.php");
	$model = new Model();
	
	$id=$_GET["id"];
	
	
	if($_SESSION["quyen"]=="admin") {
		if($_GET['ac']=="sua") {}
		else
			$model->deleteTaiKhoan($id);
	}
?>