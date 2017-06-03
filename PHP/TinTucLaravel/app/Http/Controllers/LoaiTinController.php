<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\LoaiTin;
use App\TheLoai;

class LoaiTinController extends Controller
{
    public function getDanhSach(){
    	$loaitin = LoaiTin::all();
    	$theloai = TheLoai::all();
    	return view('admin.loaitin.danhsach', ['loaitin'=>$loaitin, 'theloai'=>$theloai]);
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getSua($id){
        $loaitin = LoaiTin::find($id);
        $theloai = TheLoai::all();
    	return view('admin.loaitin.sua', ['loaitin'=>$loaitin, 'theloai'=>$theloai]);
    }

    public function postSua(Request $request, $id){
        $loaitin = LoaiTin::find($id);

        $this->validate($request, 
            ['Ten'=>'required|unique:loaitin,Ten|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Đã tồn tại', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );

        $loaitin->Ten = $request->Ten;
        $loaitin->idTheLoai = $request->TheLoai;
        $loaitin->TenKhongDau = changeTitle($request->Ten);
        $loaitin->save();

        return redirect('admin/loaitin/sua/'.$loaitin->id)->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getThem(){
    	$theloai = TheLoai::all();
    	return view('admin.loaitin.them',['theloai'=>$theloai]);
    }

    public function postThem(Request $request){
        $this->validate($request, 
            ['Ten'=>'required|unique:loaitin,Ten|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Đã tồn tại', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );

        $loaitin = new LoaiTin;
        $loaitin->Ten = $request->Ten;
        $loaitin->idTheLoai = $request->TheLoai;
        $loaitin->TenKhongDau = changeTitle($request->Ten);
        $loaitin->save();
        
        return redirect('admin/loaitin/them')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getXoa($id){
        $loaitin = LoaiTin::find($id);
        $loaitin->delete();

        return redirect('admin/loaitin/danhsach')->with('thongbao', 'Thành công');
    }
}
