<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\TheLoai;

class TheLoaiController extends Controller
{
    public function getDanhSach(){
    	$theloai = TheLoai::all();
    	return view('admin.theloai.danhsach', ['theloai'=>$theloai]);
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getSua($id){
        $theloai = TheLoai::find($id);
    	return view('admin.theloai.sua', ['theloai'=>$theloai]);
    }

    public function postSua(Request $request, $id){
        $theloai = TheLoai::find($id);

        $this->validate($request, 
            ['Ten'=>'required|unique:TheLoai,Ten|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Đã tồn tại', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );

        $theloai->Ten = $request->Ten;
        $theloai->TenKhongDau = changeTitle($request->Ten);
        $theloai->save();

        return redirect('admin/theloai/sua/'.$theloai->id)->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getThem(){
    	return view('admin.theloai.them');
    }

    public function postThem(Request $request){
        $this->validate($request, 
            ['Ten'=>'required|unique:TheLoai,Ten|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Đã tồn tại', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );

        $theloai = new TheLoai;
        $theloai->Ten = $request->Ten;
        $theloai->TenKhongDau = changeTitle($request->Ten);
        $theloai->save();
        
        return redirect('admin/theloai/them')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getXoa($id){
        $theloai = TheLoai::find($id);
        $theloai->delete();

        return redirect('admin/theloai/danhsach')->with('thongbao', 'Thành công');
    }
}
