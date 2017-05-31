<?php
include("website/model/model.php");
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
		if(mysqli_affected_rows($con)!=0) {
			echo '<ul style="padding:0; list-style: none; background: #fff; position: absolute; width:96%; top: 44px; z-index:9; border-radius:4px">';
			while($row = mysqli_fetch_array($result,MYSQLI_ASSOC)) {
				echo '<li style="padding:5px; float:left"><a href="?ac=thongtin&stt='.$row["stt"].'">'.'<img width="40" src="'.$row['hinhanh'].'" /> '.$row["hangsx"].' '.$row['ten'].' - <i style="color:red">'.number_format($row['gia']).'₫</i></a></li>';
				echo '<div class="clearfix"></div>';
			}
			echo '</ul>';
		}
		else {
			echo '<ul style="list-style:none">';
				echo '<li></li>';
			echo '</ul>';	
		}
	}
?>
