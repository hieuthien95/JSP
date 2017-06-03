<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class HinhAnh extends Model
{
    protected $table = 'hinhanh';

	public static function getHinhAnhByIdsp($idsp){
		return HinhAnh::where('idsp',$idsp)
		->get();
	}
}
