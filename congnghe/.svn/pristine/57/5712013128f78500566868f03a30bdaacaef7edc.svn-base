<?php 
	include_once("website/model/model.php"); 
	
	class Controller {
		
		private $model;
		
		public function __construct() {
			$this->model = new Model();
		}
		
		public function getTrangChu() {
			$goodsList = $this->model->getGoodsList();
			$banList = $this->model->getBanList();
			$proList = $this->model->getProList();
			$payList = $this->model->getPayList();
			$phoneList = $this->model->getPhoneList();
			$supList = $this->model->getSupList();
			$introList = $this->model->getIntroList();
			$newsList = $this->model->getNewsList();
			$videoList = $this->model->getVideoList();
			$donHangList = $this->model->getDonHangList();
			$donHangList = $this->model->getDonHangList();
			
			$brandList = $this->model->getBrandList();
			include 'website/view/TrangChu.php';
		}
		
		public function getThongTinSP($loaihang, $stt) {
			$imgList = $this->model->getImgList($loaihang, $stt);
			$goodsList = $this->model->getGoodsList();
			include "./website/view/modules/content_thong_tin_sp.php" ;
		}
		
		public function getPageChonMenu($stt, $hangsx) {				
			$brandList = $this->model->getBrandList();
			
			if($stt == "dtdd")	{	
				$PhonesList = $this->model->getPhonesList();
				$NumPhones = $this->model->getNumPhones();
			} else if($stt == "mtb") {
				$MTBsList = $this->model->getMTBsList();
				$NumMTBs = $this->model->getNumMTBs();
			} else if($stt == "laptop") {
				$LaptopsList = $this->model->getLaptopsList();
				$NumLaptops = $this->model->getNumLaptops();
			} else if($stt == "mayanh") {
				$MayAnhsList = $this->model->getMayAnhsList();
				$NumMayAnhs = $this->model->getNumMayAnhs();
			} else if($stt == "phukien") {
				$PKsList = $this->model->getPKsList();
				$NumPKs = $this->model->getNumPKs();
			} else if($stt == "tintuc") {
				$NewsList = $this->model->getNewsList();
				$NumNews = $this->model->getNumNews();
			} else if($stt == "km") {
				$KMsList = $this->model->getKMsList();
				$NumKMs = $this->model->getNumKMs();
			} else if($stt == "video") {
				$videoList = $this->model->getVideoList();
				$NumVideos = $this->model->getNumVideos();
			} else if($stt == "maycu") {
				$goodsList = $this->model->getGoodsList();
			}
			
			if($hangsx != "") {
				$goodsList = $this->model->getGoodsList();
				include './website/view/modules/content_chon_menu2.php';
			}
			else 
				include './website/view/modules/content_chon_menu.php';
		}
		
	}
?>
