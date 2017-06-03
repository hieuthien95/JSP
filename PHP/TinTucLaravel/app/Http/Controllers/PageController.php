<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\TheLoai;
use App\LoaiTin;
use App\TinTuc;
use App\Slide;

use App\User;

use App\Comment;

use Illuminate\Support\Facades\Auth; // cho đăng nhập

class PageController extends Controller
{

	// chia sẽ cho các page
	function __construct() {
		$theloai = TheLoai::all();
		view()->share('theloai', $theloai);

        $tinnoibat = TinTuc::where('NoiBat', 1)->take(6)->get();
        view()->share('tinnoibat', $tinnoibat);

		// $slide = Slide::all();
		// view()->share('slide', $slide);
	}

    // --------------------------------------------------------------------------------

    public function trangchu() {
        // $theloai = TheLoai::all();
        // return view('pages.trangchu',['theloai'=>$theloai]);
        $slide = Slide::all();
        return view('pages.trangchu', ['slide'=>$slide]);
    }

    public function lienhe() {
        return view('pages.lienhe');
    }

    public function loaitin($id, $TenKhongDau = 'null') {
        $loaitin = LoaiTin::find($id);
        $tintuc = TinTuc::where('idLoaiTin', $id)->paginate(5);

        return view('pages.loaitin', ['loaitin'=>$loaitin, 'tintuc'=>$tintuc]);
    }

    public function tintuc($id, $TieuDeKhongDau = 'null') {
        $tintuc = TinTuc::find($id);
        $tinnoibat = TinTuc::where('NoiBat', 1)->take(4)->get();
        $tinlienquan = TinTuc::where('idLoaiTin', $tintuc->idLoaiTin)->take(4)->get();

        return view('pages.tintuc', ['tintuc'=>$tintuc, 'tinnoibat'=>$tinnoibat, 'tinlienquan'=>$tinlienquan]);
    }

    // --------------------------------------------------------------------------------

    public function getDangKy() {
        return view('pages.dangKy');
    }

    public function postDangKy(Request $request) {
        $user = new User;
        $user->name = $request->Name;
        $user->email = $request->Email;
        $user->password = bcrypt($request->Password);

        $user->save();

        return redirect('dangnhap')->with('thongbao', 'Đã đăng ký thành công');
    }

    public function getDangNhap() {
        return view('pages.dangnhap');
    }

    public function postDangNhap(Request $request) {
        $email = $request->Email;
        $password = $request->Password;

        if(Auth::attempt(['email'=>$email, 'password'=>$password])) {
            return redirect('/')->with('thongbao', 'Đã đăng nhập thành công');;
        } else {
            return redirect('dangnhap')->with('loi', 'Đăng nhập không thành công');;
        }
    }

    public function getDangXuat() {
        Auth::logout();
        return redirect('/')->with('loi', 'Đã đăng xuất');
    }

    public function getNguoiDung() {
        return view('pages.nguoidung');
    }

    public function postNguoiDung(Request $request) {
        $name = $request->Name;
        $email = $request->Email;

        $password = $request->Password;
        $repassword = $request->Repassword;

        $user = Auth::user();

        if($request->changepassword == "on") {
            //echo $name." ".$email." ".$password." ".$repassword." check";
            $user->name = $name;
            $user->password = bcrypt($password);

            $user->save();
            return redirect('nguoidung')->with('thongbao', 'Sửa thành công');
        }
        else {
            //echo $name." ".$email;
            $user->name = $name;

            $user->save();
            return redirect('nguoidung')->with('thongbao', 'Sửa thành công');
        }

        return redirect('nguoidung')->with('loi', 'Sửa không thành công');
    }

    // --------------------------------------------------------------------------------

    public function postComment(Request $request, $idTinTuc) {
        $comment = new Comment;
        $comment->NoiDung = $request->NoiDung;
        $comment->idTinTuc = $idTinTuc;
        $comment->idUser = Auth::user()->id;

        $comment->save();

        return redirect('tintuc/'.$idTinTuc)->with('thongbao', 'Đã bình luận');
    }

    // --------------------------------------------------------------------------------

    public function TimKiem(Request $request) {
        $tukhoa = $request->TuKhoa;
        
        return redirect('timkiem/'.$tukhoa);
    }

    public function getTimKiem($tukhoa) {
        $tintuc = TinTuc::where('TieuDe', 'like', '%'.$tukhoa.'%')
        ->orWhere('TomTat', 'like', '%'.$tukhoa.'%')
        ->orWhere('NoiDung', 'like', '%'.$tukhoa.'%')
        ->paginate(5);
        
        return view('pages.timkiem', ['tintuc'=>$tintuc,'tukhoa'=>$tukhoa]);
    }
}

