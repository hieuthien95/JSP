<?php 

	include_once("model/model.php");



	class Controller {

		

		private $model;

		

		public function __construct() {

			$this->model = new Model();

		}

		

		public function invoke() {

			$goodsList = $this->model->getGoodsList();

			$banList = $this->model->getBanList();

			$newsList = $this->model->getNewsList();

			$videoList = $this->model->getVideoList();

			$donHangList = $this->model->getDonHangList();

			$brandList = $this->model->getBrandList();

			$hdhList = $this->model->getHDHList();

			$cameraList = $this->model->getCameraList();

			$manHinhList = $this->model->getManHinhList();

			include 'view/modules/content.php';

		}

		

	}

?>