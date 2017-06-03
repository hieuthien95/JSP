<?
	include_once("website/model/model.php");
	
	$model = new Model();	
			
	if($_GET["ac"]=="donhang") {
		$gia=$_GET["price"];
		$ghichu=$_GET["comments"];
		$model->addDonHang($gia, $_SESSION["sdt"], $ghichu);
	} 
	else if($_GET["ac"]=="capnhatdonhang") {
		$madonhang=$_GET["order_code"];
		$magiaodich=$_GET["payment_id"];
		$model->updateDonHang($madonhang, $magiaodich);
	}
?>