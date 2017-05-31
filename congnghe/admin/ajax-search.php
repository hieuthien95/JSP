<?php
session_start();
include("model/model.php");
$model = new Model();
$con = $model->connectDatabase();

// Kiểm tra dữ liệu đầu vào có tồn tại hay không
if(isset($_GET['keyword'])){		
	$keyword = trim($_GET['keyword']);
	if($keyword=='') 
		return false;
	$keyword = "REPLACE('%$keyword%', ' ', '')";
	
	$data = "REPLACE(CONCAT(loaisp, hangsx, ten), ' ', '')";
	$result = mysqli_query($con,"select * from sanpham where REPLACE(CONCAT(loaisp, hangsx, ten), ' ', '') like $keyword");
	$data = "REPLACE(CONCAT(loaisp,ten), ' ', '')";
	if(mysqli_num_rows($result)==0)
		$result = mysqli_query($con,"select * from sanpham where $data like $keyword");
	$data = "REPLACE(CONCAT(hangsx,ten), ' ', '')";
	if(mysqli_num_rows($result)==0)
		$result = mysqli_query($con,"select * from sanpham where $data like $keyword");
		
	if($result)
		// Kiểm tra có dòng record nào hay không?
		if(mysqli_affected_rows($con)!=0)
			// Hiển thị dữ liệu
			while($row = mysqli_fetch_array($result,MYSQLI_ASSOC)) { 
				echo '<h4>'.$row['ten'].'</h4><br>';
			?>
            	<img src="../<? echo $row["hinhanh"] ?>" style="width:80px"/>
            	<?
				if($_SESSION["quyen"]=="admin")
				{ ?>                 
					  <a href="index.php?quanly=hanghoa&ac=sua_no_page&stt=<? echo $row["stt"] ?>">
						  <img src="view/img/b_edit.png" width="25px"/>
					  </a>
									 
									 
					  <a href="view/modules/hanghoa/xuly.php?ac=xoa&stt=<? echo $row["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
						  <img src="view/img/b_drop.png" width="25px"/>		
					  </a>
					  
					  <a href="./index.php?quanly=hanghoa&ac=themanhkhac&stt=<? echo $row["stt"] ?>&trang=<? echo $_GET["trang"] ?>">
						  <img src="view/img/b_img.png" width="25px"/>
					  </a><br />
                      <hr style="border-color:#6FF" />
						 
				<? } ?>
            
            	<?
			}
	}
?>