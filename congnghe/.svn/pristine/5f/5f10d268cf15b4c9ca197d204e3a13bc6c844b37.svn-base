<?
	session_start();
	include_once("website/model/model.php");
	
	$model = new Model();	
			
	if(isset($_GET["ac"])) {
		$gia=$_GET["price"];
		$ghichu=$_GET["comments"];
		$model->addDonHang($gia, $_SESSION["sdt"], $ghichu);
	} 
	else if(isset($_GET["accapnhat"]))
		if($_GET["accapnhat"]==$_SESSION["accapnhat"]){
			$madonhang=$_GET["order_code"];
			$magiaodich=$_GET["payment_id"];
			$model->updateDonHang($madonhang, $magiaodich);
		}
?>