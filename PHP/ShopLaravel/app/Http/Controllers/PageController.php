<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Illuminate\Support\Facades\Auth; // cho đăng nhập

use App\SanPham;
use App\DanhMuc;
use App\HinhAnh;
use App\Video;
use App\BaiViet;
use App\User;
use App\DonHang;

use Cart, DB, Mail;

class PageController extends Controller
{

	// chia sẽ cho các page
	function __construct() {

    	$dsloaisp = DanhMuc::getAllLoaisp();
		view()->share('dsloaisp', $dsloaisp);

        $dsvideo = Video::all();
        view()->share('dsvideo', $dsvideo);

        $dsbaiviet = BaiViet::all();
        view()->share('dsbaiviet', $dsbaiviet);

        if(Auth::check()) {
            view()->share('nguoidung', Auth::user());
        }
	}

    // --------------------------------------------------------------------------------

    public function trangchu() {
    	// $dssanpham = SanPham::paginate(12);
        $dstopsanpham = SanPham::orderBy('luotxem', 'DESC')->take(5)->get();
        $dssanpham = SanPham::where('loaisp', '<>', 'Phụ kiện')->orderBy('id', 'DESC')->paginate(12);
        return view('pages.trangchu',['dssanpham'=>$dssanpham,'dstopsanpham'=>$dstopsanpham]);
    }

    public function getProduct($id, $tenkhongdau = null) {
    	$dssanpham = SanPham::all();
    	$sanpham = SanPham::find($id);
        $sanpham->luotxem++;
        $sanpham->save();
        $dshinhanh = HinhAnh::getHinhAnhByIdsp($id);
        return view('pages.product-detail',['dssanpham'=>$dssanpham,'sanpham'=>$sanpham, 'dshinhanh'=>$dshinhanh]);
    }

    public function getProductList() {      
        $dssanpham = SanPham::paginate(12);
        return view('pages.product-list',['dssanpham'=>$dssanpham]);
    }

    // --------------------------------------------------------------------------------
    public function getBaiVietList() {      
        $dsbaiviet = BaiViet::paginate(10);
        return view('pages.bai-viet-list',['dsbaiviet'=>$dsbaiviet]);
    }

    public function getBaiViet($id, $tenkhongdau = null) {
        $baiviet = BaiViet::find($id);
        return view('pages.xem-bai-viet',['baiviet'=>$baiviet]);
    }


    public function getVideoList() {      
        $dsvideo = Video::paginate(10);
        return view('pages.video-list',['dsvideo'=>$dsvideo]);
    }

    public function getVideo($id, $tieudekhongdau = null) {
        $video = Video::find($id);
        return view('pages.xem-video',['video'=>$video]);
    }

    //---------------------------------------

	public function getCart() {
        $dssanpham = Cart::instance('shopping')->content();
        return view('pages.cart',['dssanpham'=>$dssanpham]);
    }

    public function getCheckout() {
        $dssanpham = Cart::instance('shopping')->content();
        return view('pages.checkout',['dssanpham'=>$dssanpham]);
    }

    public function getSoSanh($id1, $id2, $nothing = null) {
        $sanpham1 = DB::table('sanpham')->where('id', $id1)->first();
        $sanpham2 = DB::table('sanpham')->where('id', $id2)->first();

        $dshinhanh1 = HinhAnh::getHinhAnhByIdsp($id1);
        $dshinhanh2 = HinhAnh::getHinhAnhByIdsp($id2);

        return view('pages.so-sanh',['sanpham1'=>$sanpham1, 'sanpham2'=>$sanpham2, 'dshinhanh1'=>$dshinhanh1, 'dshinhanh2'=>$dshinhanh2]);
    }

    //---------------------------------------

    public function addToCart($id, $url = 'null') {
        $sanpham = DB::table('sanpham')->where('id', $id)->first();

        Cart::instance('shopping')->add(['id'=>$sanpham->id, 'name'=>$sanpham->hangsx.' '.$sanpham->ten, 'qty'=>1, 'price'=>$sanpham->gia, 'options' => ['hinhanh'=>$sanpham->hinhanh]]);
        
        return redirect(base64_decode($url))->with('success', 'Thêm thành công');;
    }

    public function subInCart($rowId, $url = 'null') {
        $row = Cart::instance('shopping')->get($rowId);

        Cart::instance('shopping')->update($rowId, $row->qty - 1); 

        return redirect(base64_decode($url))->with('error', 'Xóa thành công');;
    }

    public function removeInCart($rowId, $url = 'null') {
        Cart::instance('shopping')->remove($rowId);
        return redirect(base64_decode($url))->with('error', 'Đã xóa sản phẩm');;
    }


     public function addToSoSanh($id, $url = 'null') {
        $sanpham = DB::table('sanpham')->where('id', $id)->first();

        Cart::instance('sosanh')->add(['id'=>$sanpham->id, 'name'=>$sanpham->hangsx.' '.$sanpham->ten, 'qty'=>1, 'price'=>$sanpham->gia, 'options' => ['hinhanh'=>$sanpham->hinhanh]]);
        
        return redirect(base64_decode($url))->with('success', 'Thêm thành công');;
    }

    
    public function removeInSoSanh($rowId, $url = 'null') {
        Cart::instance('sosanh')->remove($rowId);
        return redirect(base64_decode($url))->with('error', 'Đã xóa sản phẩm');;
    }


    //---------------------------------------

    public function thanhtoan() {

        $id = date("Ymdhis");
        $gia = 0;
        $sdt = '';
        $ghichu = '';

        if(Auth::user()) {
            $sdt = Auth::user()->sdt;
        }

        foreach(Cart::instance('shopping')->content() as $sp){
            $ghichu .= $sp->name.'('.$sp->qty.');';
            $gia += $sp->price * $sp->qty;
        }

        $donhang = new DonHang;
        $donhang->id = $id;
        $donhang->gia = $gia;
        $donhang->sdt = $sdt;
        $donhang->ghichu = $ghichu;

        $donhang->save();



        $url = "https://www.nganluong.vn/button_payment.php?receiver=hieuthien95@gmail.com&product_name=".$id.
        "&price=".$gia."&comments=".$ghichu."&return_url=http://localhost:8080/ShopLaravel/public/update-thanh-toan";

        // $url = "https://www.nganluong.vn/button_payment.php?receiver=hieuthien95@gmail.com&product_name=".$id.
        // "&price=".$gia."&comments=".$ghichu."&return_url=http://nuocuongbaovinh.com/laravel/public/update-thanh-toan";
        
        // echo Cart::content();
        return redirect($url);
    }

    public function updateThanhToan(Request $request, $abc = null) {
        //http://localhost:8080/ShopLaravel/public/update-thanh-toan/Galaxy%20Note%205(1);?transaction_info=&order_code=20170406074730&price=2000&payment_id=28115274&payment_type=2&error_text=&secure_code=548385bfb86408b935109dd7c4a330bd&token_nl=9207039-98507814fa28a02755255e184e8bb632
        //http://localhost:8080/ShopLaravel/public/update-thanh-toan/Galaxy%20Note%205(1);?transaction_info=&order_code=20170406075324&price=2000&payment_id=28115336&payment_type=2&error_text=&secure_code=83b253d1bb105b1f794f57b2717f5bb9&token_nl=9207089-0d2d9cdaa4a2f36799f386fd6c90c097
        //http://localhost:8080/ShopLaravel/public/update-thanh-toan/Galaxy%20Note%205(1);?transaction_info=&order_code=20170406075445&price=2000&payment_id=28115365&payment_type=2&error_text=&secure_code=a23bab526a143ac2e4e69e141c8a0a89&token_nl=9207110-65f68e89b857eb1262484cf432f9571f
        $id = $request->order_code;
        $donhang = DonHang::find($id);
        $donhang->magiaodich = $request->payment_id;

        $donhang->save();

        return redirect('checkout')->with('success', 'Thanh toán thành công');;
    }

    //---------------------------------------

    public function postTimKiem(Request $request) {
        $tukhoa = $request->tukhoa;
        
        return redirect('tim-kiem/'.$tukhoa);
    }

    public function getTimKiem($tukhoa) {
        $dssanpham = SanPham::timkiem($tukhoa)->paginate(24);

        return view('pages.tim-kiem',['dssanpham'=>$dssanpham]);
    }

    public function ajaxTimKiem($tukhoa = null) {
        if($tukhoa != '') {
            $dssanpham = SanPham::timkiem($tukhoa)->take(8)->get();

            echo "<table style='background: #FFF; z-index: 9999; margin: 0'>";

            foreach ($dssanpham as $sp) {

                echo "
                <tr>
                    <td style='padding: 10px; '>
                        <a href='product/$sp->id'><img src='upload/sanpham/$sp->hinhanh' width='50' /></a>
                    </td>
                    <td style='padding: 10px; '>
                        <a href='product/$sp->id'>$sp->ten</a>
                    </td>
                    <td style='color: red; padding: 10px'>".number_format($sp->gia)."đ</td>
                </tr>";
            }
            echo "</table>";
        }
        
    }

    public function locTheoGia(Request $request) {
        $minmax = $request->minmax;

        $arr = explode( ',', $minmax );
        $min = $arr[0];
        $max = $arr[1];

        $dssanpham = SanPham::loctheogia($minmax, $max)->paginate(24);

        return view('pages.loc-theo-gia',['dssanpham'=>$dssanpham]);

    }
   
   //---------------------------------------

    public function getProfile() {
        $dsdonhang = DonHang::where('sdt', '=', Auth::user()->sdt)->get();
        return view('pages.profile',['dsdonhang'=>$dsdonhang]);
    }

    public function getLogin() {
        if(Auth::user())
            return redirect()->route('route-profile');
        return view('pages.login');
    }

    public function postLogin(Request $request, $url=null) {
        //$urlcurr = $request->urlcurr;
        $email = $request->email;
        $password = $request->password;

        if(Auth::attempt(['email'=>$email, 'password'=>$password])) {
            return redirect(base64_decode($url))->with('success', 'Đăng nhập thành công');;
        } else {
            return redirect('login')->with('error', 'Đăng nhập không thành công');
        }
    }

    public function logout() {
        Auth::logout();
        return redirect('/')->with('error', 'Đã đăng xuất');
    }

    public function postRegister(Request $request) {

        $user = new User;
        $user->name = $request->name;
        $user->email = $request->email;
        $user->sdt = $request->sdt;
        $user->password = bcrypt($request->password);

        if($request->hasFile("hinhanh")) {
            $file = $request->file("hinhanh");

            $duoi = $file->getClientOriginalExtension();
            if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                return redirect('login')->with('error', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
            }

            $name = $file->getClientOriginalName();
            $hinhanh = date("Ymdhis")."_".$name;

            $user->hinhanh = $hinhanh;
            
            $file->move("upload/taikhoan/",$hinhanh);
            // copy($file, "upload/tintuc/".$Hinh);
        }


        $user->save();

        return redirect('login')->with('success', 'Đăng ký thành công');        
    }

    public function postChangeInfo(Request $request) {

        if(Auth::attempt(['email'=>Auth::user()->email, 'password'=>$request->password])) {
            
            $id = Auth::user()->id;
            $user = User::find($id);

            $user->name = $request->name;
            $user->sdt = $request->sdt;

            if($request->hasFile("hinhanh")) {
                if($user->hinhanh  != null && $user->hinhanh  != '' && file_exists("upload/taikhoan/".$user->hinhanh))
                    unlink("upload/taikhoan/".$user->hinhanh);

                $file = $request->file("hinhanh");

                $duoi = $file->getClientOriginalExtension();
                if($duoi != 'jpg' && $duoi != 'png' && $duoi != 'jpeg') {
                    return redirect('admin/taikhoan/them')->with('error', 'Bạn chỉ được chọn file có duôi jpg, png, jpeg');
                }

                $name = $file->getClientOriginalName();
                $hinhanh = date("Ymdhis")."_".$name;

                $user->hinhanh = $hinhanh;
                
                $file->move("upload/taikhoan/",$hinhanh);
                // copy($file, "upload/taikhoan/".$hinhanh);
            }

            $user->save();

            return redirect('profile')->with('success', 'Cập nhật thành công');    
        }

        return redirect('profile')->with('error', 'Cập nhật không thành công');   
    
    }


    public function getForgot() {
        if(Auth::user())
            return redirect()->route('route-profile');
        return view('pages.forgot');
    }

    public function postForgot(Request $request) {

        $email_client = $request->email;
        $user = User::where('email', $email_client)->first();

        if($user != null) {
            $password = '';
            for($i = 0; $i<8; $i++) {
                $password .= rand(0,99);
            }
            $user->password = bcrypt($password);
            $user->save();

            $this->sendMail($email_client, 'Quên mật khẩu', 'Mật khẩu mới của bạn là: '.$password);
            
            return redirect('login')->with('success', 'Mật khẩu đã gửi đến email của bạn');
        } 
        else {
            return redirect('forgot')->with('error', 'Không tìm thấy email');
        }

    }

    //------------------------------------------------------------------------------------------------------

    public function sendMail($email_client, $subject, $content) {
        $email_server = 'myfamilyTG2015@gmail.com';

        $data = array('email'=>$email_client, 'content'=>$content);
   
        Mail::send('pages.blanks', $data, function($message) use ($email_client, $email_server, $subject){
            $message->to($email_client);
            $message->from($email_server);
            $message->subject($subject);
        });


        echo "Mật khẩu đã được gửi đến Email của bạn <br>";
        echo "<a href='login'>Đăng nhập</a> | <a href='http://mail.google.com'>Kiểm tra mail</a>";

    }

    //------------------------------------------------------------------------------------------------------




    public function danhmuc1() {
        // $danhmuc1 = new DanhMuc;
        // return $danhmuc1->getAllLoaisp();

        return DanhMuc::getAllLoaisp();
    }

    public function danhmuc2($idparent) {

        return DanhMuc::getAllHangsxByIdparent($idparent);
    }

}

