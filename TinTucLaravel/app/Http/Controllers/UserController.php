<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\Auth; // cho đăng nhập

use Illuminate\Http\Request;
use App\User;

class UserController extends Controller
{
    public function getDanhSach(){
    	$user = User::orderBy('id', 'DESC')->get();
    	return view('admin.user.danhsach', ['user'=>$user]);
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getSua($id){
        $user = User::find($id);
    	return view('admin.user.sua', ['user'=>$user]);
    }

    public function postSua(Request $request, $id){
        $user = User::find($id);

        $this->validate($request, 
            ['Name'=>'required|min:3'],
            ['Name.required'=>'Bạn chưa nhập đầy đủ', 'Name.min'=>'Phải dài từ 3 ký tự']
        );

        $user->name = $request->Name;
        $user->email = $request->Email;
        $user->quyen = $request->Quyen;
        $user->password = $request->Password;

        if($request->hasFile("Hinh")) {
            if(file_exists("upload/user/".$user->Hinh) && $user->Hinh != null && $user->Hinh != "")
                unlink("upload/user/".$user->Hinh);

            $file = $request->file("Hinh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('admin/user/them')->with('loi', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $Hinh = date("Ymdhis")."_".$name;

            $user->Hinh = $Hinh;
            
            $file->move("upload/user/",$Hinh);
            // copy($file, "upload/user/".$Hinh);
        }

        $user->save();

        return redirect('admin/user/sua/'.$user->id)->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getThem(){
    	return view('admin.user.them');
    }

    public function postThem(Request $request){
        $this->validate($request, 
            ['Name'=>'required|min:3'],
            ['Name.required'=>'Bạn chưa nhập đầy đủ', 'Name.min'=>'Phải dài từ 3 ký tự']
        );


        $user = new User;
    	$user->name = $request->Name;
        $user->email = $request->Email;
        $user->quyen = $request->Quyen;
        $user->password = bcrypt($request->Password);

        $user->save();

        return redirect('admin/user/them')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getXoa($id){
        $user = User::find($id);


        if(file_exists("upload/user/".$user->Hinh) && $user->Hinh != null && $user->Hinh != "")
            unlink("upload/user/".$user->Hinh);

        $user->delete();

        return redirect('admin/user/danhsach')->with('thongbao', 'Thành công');
    }

// -------------------------------------------------------------------------------------------------------------------

    public function getDangNhapAdmin(){
       	return view('admin.login');
    }

    public function postDangNhapAdmin(Request $request){
    	$email = $request->Email;
    	$password = $request->Password;

    	if(Auth::attempt(['email'=>$email, 'password'=>$password])) {
            // $_SESSION["name"]=User::where('email', $email)->get()[0]->name;
            // echo $_SESSION["name"];
    		return redirect('admin/user/danhsach')->with('thongbao', 'Đăng nhập thành công');;
    	}
    	else 
    		return redirect('admin/dangnhap')->with('loi', 'Đăng nhập không thành công');;
    }

    public function getDangXuatAdmin(){
        Auth::logout();
        return redirect('/')->with('loi', 'Đã đăng xuất');
    }

}
