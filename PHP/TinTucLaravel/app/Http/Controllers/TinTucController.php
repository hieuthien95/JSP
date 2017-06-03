<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\TheLoai;
use App\LoaiTin;
use App\TinTuc;
use App\Comment;


class TinTucController extends Controller
{
    public function getDanhSach(){
    	$tintuc = TinTuc::orderBy('id', 'DESC')->get();
    	return view('admin.tintuc.danhsach', ['tintuc'=>$tintuc]);
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getSua($id){
        $tintuc = TinTuc::find($id);
        $theLoai = TheLoai::all();
        $loaitin = LoaiTin::all();
        // $comment = Comment::where('idTinTuc', '>', 1)->orderBy('id', 'DESC')->take(10)->get();
        $comment = Comment::where('idTinTuc', '=', $id)->get();
    	return view('admin.tintuc.sua', ['tintuc'=>$tintuc, 'theloai'=>$theLoai, 'loaitin'=>$loaitin, 'comment'=>$comment]);
    }

    public function postSua(Request $request, $id){
        $tintuc = TinTuc::find($id);

        $this->validate($request, 
            ['TieuDe'=>'required|min:3'],
            ['TieuDe.required'=>'Bạn chưa nhập đầy đủ', 'TieuDe.min'=>'Phải dài từ 3 ký tự']
        );

        $tintuc->TieuDe = $request->TieuDe;
        $tintuc->TieuDeKhongDau = changeTitle($request->TieuDe);
        $tintuc->TomTat = $request->TomTat;
        $tintuc->NoiDung = $request->NoiDung;
        $tintuc->NoiBat = $request->NoiBat;
        $tintuc->idLoaiTin = $request->LoaiTin;

        if($request->hasFile("Hinh")) {
            if(file_exists("upload/tintuc/".$tintuc->Hinh))
                unlink("upload/tintuc/".$tintuc->Hinh);

            $file = $request->file("Hinh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('admin/tintuc/them')->with('loi', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $Hinh = date("Ymdhis")."_".$name;

            $tintuc->Hinh = $Hinh;
            
            $file->move("upload/tintuc/",$Hinh);
            // copy($file, "upload/tintuc/".$Hinh);
        }

        $tintuc->save();

        return redirect('admin/tintuc/sua/'.$tintuc->id)->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getThem(){
        $theLoai = TheLoai::all();
        $loaitin = LoaiTin::all();
    	return view('admin.tintuc.them', ['theloai'=>$theLoai, 'loaitin'=>$loaitin]);
    }

    public function postThem(Request $request){
        $this->validate($request, 
            ['TieuDe'=>'required|min:3'],
            ['TieuDe.required'=>'Bạn chưa nhập đầy đủ', 'TieuDe.min'=>'Phải dài từ 3 ký tự']
        );


    	$tintuc = new TinTuc;
        $tintuc->TieuDe = $request->TieuDe;
        $tintuc->TieuDeKhongDau = changeTitle($request->TieuDe);
        $tintuc->TomTat = $request->TomTat;
        $tintuc->NoiDung = $request->NoiDung;
        $tintuc->Hinh = "";
        $tintuc->NoiBat = $request->NoiBat;
        $tintuc->idLoaiTin = $request->LoaiTin;
        $tintuc->SoLuotXem = 0;

        if($request->hasFile("Hinh")) {
            $file = $request->file("Hinh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('admin/tintuc/them')->with('loi', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $Hinh = date("Ymdhis")."_".$name;

            $tintuc->Hinh = $Hinh;
            
            $file->move("upload/tintuc/",$Hinh);
            // copy($file, "upload/tintuc/".$Hinh);
        }


        $tintuc->save();

        return redirect('admin/tintuc/them')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getXoa($id){
        $tintuc = TinTuc::find($id);

        if(file_exists("upload/tintuc/".$tintuc->Hinh))
            unlink("upload/tintuc/".$tintuc->Hinh);

        $tintuc->delete();

        return redirect('admin/tintuc/danhsach')->with('thongbao', 'Thành công');
    }
}

