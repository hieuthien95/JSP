<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Slide;

class SlideController extends Controller
{
    public function getDanhSach(){
    	$slide = Slide::orderBy('id', 'DESC')->get();
    	return view('admin.slide.danhsach', ['slide'=>$slide]);
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getSua($id){
        $slide = Slide::find($id);
    	return view('admin.slide.sua', ['slide'=>$slide]);
    }

    public function postSua(Request $request, $id){
        $slide = Slide::find($id);

        $this->validate($request, 
            ['Ten'=>'required|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );

        $slide->Ten = $request->Ten;
        $slide->NoiDung = $request->NoiDung;
        $slide->link = $request->Link;

        if($request->hasFile("Hinh")) {
            if(file_exists("upload/slide/".$slide->Hinh))
                unlink("upload/slide/".$slide->Hinh);

            $file = $request->file("Hinh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('admin/slide/them')->with('loi', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $Hinh = date("Ymdhis")."_".$name;

            $slide->Hinh = $Hinh;
            
            $file->move("upload/slide/",$Hinh);
            // copy($file, "upload/slide/".$Hinh);
        }

        $slide->save();

        return redirect('admin/slide/sua/'.$slide->id)->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getThem(){
    	return view('admin.slide.them');
    }

    public function postThem(Request $request){
        $this->validate($request, 
            ['Ten'=>'required|min:3'],
            ['Ten.required'=>'Bạn chưa nhập đầy đủ', 'Ten.min'=>'Phải dài từ 3 ký tự']
        );


        $slide = new Slide;
    	$slide->Ten = $request->Ten;
        $slide->Hinh = "";
        $slide->NoiDung = $request->NoiDung;
        $slide->link = $request->Link;

        if($request->hasFile("Hinh")) {
            $file = $request->file("Hinh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('admin/slide/them')->with('loi', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $Hinh = date("Ymdhis")."_".$name;

            $slide->Hinh = $Hinh;
            
            $file->move("upload/slide/",$Hinh);
            // copy($file, "upload/slide/".$Hinh);
        }


        $slide->save();

        return redirect('admin/slide/them')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getXoa($id){
        $slide = Slide::find($id);


        if(file_exists("upload/slide/".$slide->Hinh))
            unlink("upload/slide/".$slide->Hinh);

        $slide->delete();

        return redirect('admin/slide/danhsach')->with('thongbao', 'Thành công');
    }
}

