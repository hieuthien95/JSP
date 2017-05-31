<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class DanhMuc extends Model
{
    protected $table = 'danhmuc';

    public static function getAllLoaisp(){
		return DanhMuc::where('parent', 0)
		->get();
	}

	public static function getAllHangsxByIdparent($idparent){
		return DanhMuc::where('parent',$idparent)
		->get();
	}
}
