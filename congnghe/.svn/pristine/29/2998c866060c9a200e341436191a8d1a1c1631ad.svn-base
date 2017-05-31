<?php
include_once("model.php");
session_start();

$model = new Model();
$con  = $model->connectDatabase();



//											phần danh sách so sanh



//add item in so sánh
if(isset($_POST["type"]) && $_POST["type"]=='addss')
{
	$stt 	= filter_var($_POST["stt"], FILTER_SANITIZE_STRING); //product code
	$sl 	= filter_var($_POST["sl"], FILTER_SANITIZE_NUMBER_INT); //product code
	$return_url 	= base64_decode($_POST["return_url"]); //return url

	//MySqli query - get details of item from db using product code
	$results = mysqli_query($con, "SELECT ten,gia,hinhanh FROM sanpham WHERE stt='$stt' LIMIT 1");
	$obj = mysqli_fetch_object($results);
	
	if ($results) { //we have the product info 
		
		//prepare array for the session variable
		$new_product = array(array('name'=>$obj->ten, 'code'=>$stt, 'sl'=>$sl, 'gia'=>$obj->gia, 'hinhanh'=>$obj->hinhanh));
		
		if(isset($_SESSION["ss"])) //if we have the session
		{
			$found = false; //set found item to false
			
			foreach ($_SESSION["ss"] as $cart_itm) //loop through session array
			{
				if($cart_itm["code"] == $stt){ //the item exist in array

					$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$sl, 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
					$found = true;
				}else{
					//item doesn't exist in the list, just retrive old info and prepare array for session var
					$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$cart_itm["sl"], 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
				}
			}
			
			if(sizeof($product) < 2){
				if($found == false) //we didn't find item in array
				{
					//add new user item in array
					$_SESSION["ss"] = array_merge($product, $new_product);
				}else{
					//found user item in array list, and increased the quantity
					$_SESSION["ss"] = $product;
				}
			}
			
		}else{
			//create a new session var if does not exist
			$_SESSION["ss"] = $new_product;
		}
		
	}
	
	//redirect back to original page
	header('Location:'.$return_url);
}

//remove item from so sanh
if(isset($_GET["removess"]) && isset($_GET["return_url"]) && isset($_SESSION["ss"]))
{
	$stt 	= $_GET["removess"]; //get the product code to remove
	$return_url 	= base64_decode($_GET["return_url"]); //get return url

	
	foreach ($_SESSION["ss"] as $cart_itm) //loop through session array var
	{
		if($cart_itm["code"]!=$stt){ //item does,t exist in the list
			$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$cart_itm["sl"], 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
		}
		
		//create a new product list for cart
		$_SESSION["ss"] = $product;
	}
	
	//redirect back to original page
	header('Location:'.$return_url);
}





//											phần danh sách sản phẩm




//add item in shopping cart
if(isset($_POST["type"]) && $_POST["type"]=='add')
{
	$stt 	= filter_var($_POST["stt"], FILTER_SANITIZE_STRING); //product code
	$sl 	= filter_var($_POST["sl"], FILTER_SANITIZE_NUMBER_INT); //product code
	$return_url 	= base64_decode($_POST["return_url"]); //return url

	//MySqli query - get details of item from db using product code
	$results = mysqli_query($con, "SELECT ten,gia,hinhanh FROM sanpham WHERE stt='$stt' LIMIT 1");
	$obj = mysqli_fetch_object($results);
	
	if ($results) { //we have the product info 
		
		//prepare array for the session variable
		$new_product = array(array('name'=>$obj->ten, 'code'=>$stt, 'sl'=>$sl, 'gia'=>$obj->gia, 'hinhanh'=>$obj->hinhanh));
		
		if(isset($_SESSION["products"])) //if we have the session
		{
			$found = false; //set found item to false
			
			foreach ($_SESSION["products"] as $cart_itm) //loop through session array
			{
				if($cart_itm["code"] == $stt){ //the item exist in array

					$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$sl, 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
					$found = true;
				}else{
					//item doesn't exist in the list, just retrive old info and prepare array for session var
					$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$cart_itm["sl"], 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
				}
			}
			
			if($found == false) //we didn't find item in array
			{
				//add new user item in array
				$_SESSION["products"] = array_merge($product, $new_product);
			}else{
				//found user item in array list, and increased the quantity
				$_SESSION["products"] = $product;
			}
			
		}else{
			//create a new session var if does not exist
			$_SESSION["products"] = $new_product;
		}
		
	}
	
	//redirect back to original page
	header('Location:'.$return_url);
}





//remove item from shopping cart
if(isset($_GET["removep"]) && isset($_GET["return_url"]) && isset($_SESSION["products"]))
{
	$stt 	= $_GET["removep"]; //get the product code to remove
	$return_url 	= base64_decode($_GET["return_url"]); //get return url

	
	foreach ($_SESSION["products"] as $cart_itm) //loop through session array var
	{
		if($cart_itm["code"]!=$stt){ //item does,t exist in the list
			$product[] = array('name'=>$cart_itm["name"], 'code'=>$cart_itm["code"], 'sl'=>$cart_itm["sl"], 'gia'=>$cart_itm["gia"], 'hinhanh'=>$cart_itm["hinhanh"]);
		}
		
		//create a new product list for cart
		$_SESSION["products"] = $product;
	}
	
	//redirect back to original page
	header('Location:'.$return_url);
}
?>