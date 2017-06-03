<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class SanPham extends Model
{
    protected $table = "sanpham";

	public static function timkiem($tukhoa){
		return SanPham::whereRaw("(CONCAT(loaisp, ' ', hangsx, ' ', ten) like '%$tukhoa%')")
		->orWhereRaw("(CONCAT(loaisp, ' ', ten) like '%$tukhoa%')")
		->orWhereRaw("(CONCAT(ten, ' ') like '%$tukhoa%')");
	}

	public static function loctheogia($min, $max){
		return SanPham::where('gia','>=', $min)->where('gia','<=', $max);
	}
}
