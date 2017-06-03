<div id="content">
	<?
	session_start();
		if(isset($_GET['quanly']))
			$tam=$_GET['quanly'];
		else
			$tam="";
		
		if($tam=="baiviet")
			include("view/modules/baiviet/main.php");
			
		else if($tam=="hanghoa" || isset($_GET['search-product']))
			include("view/modules/hanghoa/main.php");
		
		else if($tam=="quangcao")
			include("view/modules/quangcao/main.php");
			
		else if($tam=="video")
			include("view/modules/video/main.php");
			
		else if($tam=="donhang")
			include("view/modules/donhang/main.php");
		
		else if($tam=="taikhoan")
			include("view/modules/taikhoan/main.php");

	
		else if($tam=="hangsx")
			if($_SESSION["quyen"]=="admin")	
				include("view/modules/hangsx/main.php");
		
	?>
</div>