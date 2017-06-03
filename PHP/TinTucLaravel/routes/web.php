<?php
use Illuminate\Http\Request;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

/*
thêm vào composer.json chổ autoload chuỗi sau
"files": [
	"app/function/function.php"
]

cmd: composer dumpautoload
*/

Route::get('/', function () {
    //return view('welcome');
    return redirect('trangchu');
});

// ---------------------------------------------------------------------------------------

Route::get('admin/dangnhap', 'UserController@getDangNhapAdmin');
Route::post('admin/dangnhap', 'UserController@postDangNhapAdmin');
Route::get('admin/logout', 'UserController@getDangXuatAdmin');

// App\Http\Middleware\AdminLoginMiddleware.php
// App\Http\Kernel.php
Route::group(['prefix'=>'admin', 'middleware'=>'adminLogin'], function(){

	Route::get('/', function () {
		return redirect('admin/user/danhsach');
	});

	// admin/loaitin/danhsach
	Route::group(['prefix'=>'loaitin'], function(){
		Route::get('danhsach', 'LoaiTinController@getDanhSach');

		Route::get('sua/{id}', 'LoaiTinController@getSua');
		Route::post('sua/{id}', 'LoaiTinController@postSua');

		Route::get('them', 'LoaiTinController@getThem');
		Route::post('them', 'LoaiTinController@postThem');

		Route::get('xoa/{id}', 'LoaiTinController@getXoa');
	});

	// admin/slide/danhsach
	Route::group(['prefix'=>'slide'], function(){
		Route::get('danhsach', 'SlideController@getDanhSach');

		Route::get('sua/{id}', 'SlideController@getSua');
		Route::post('sua/{id}', 'SlideController@postSua');

		Route::get('them', 'SlideController@getThem');
		Route::post('them', 'SlideController@postThem');

		Route::get('xoa/{id}', 'SlideController@getXoa');
	});

	// admin/theloai/danhsach
	Route::group(['prefix'=>'theloai'], function(){
		Route::get('danhsach', 'TheLoaiController@getDanhSach');

		Route::get('sua/{id}', 'TheLoaiController@getSua');
		Route::post('sua/{id}', 'TheLoaiController@postSua');

		Route::get('them', 'TheLoaiController@getThem');
		Route::post('them', 'TheLoaiController@postThem');

		Route::get('xoa/{id}', 'TheLoaiController@getXoa');
	});

	// admin/tintuc/danhsach
	Route::group(['prefix'=>'tintuc'], function(){
		Route::get('danhsach', 'TinTucController@getDanhSach');

		Route::get('sua/{id}', 'TinTucController@getSua');
		Route::post('sua/{id}', 'TinTucController@postSua');

		Route::get('them', 'TinTucController@getThem');
		Route::post('them', 'TinTucController@postThem');

		Route::get('xoa/{id}', 'TinTucController@getXoa');
	});

	// admin/user/danhsach
	Route::group(['prefix'=>'user'], function(){
		Route::get('danhsach', 'UserController@getDanhSach');

		Route::get('sua/{id}', 'UserController@getSua');
		Route::post('sua/{id}', 'UserController@postSua');

		Route::get('them', 'UserController@getThem');
		Route::post('them', 'UserController@postThem');

		Route::get('xoa/{id}', 'UserController@getXoa');
	});

	// admin/comment/xoa/1/2
	Route::group(['prefix'=>'comment'], function(){
		Route::get('xoa/{id}/{idTinTuc}', 'CommentController@getXoa');
	});

	// admin/ajax/loaitin/1
	Route::group(['prefix'=>'ajax'], function(){
		Route::get('loaitin/{idTheLoai}', 'AjaxController@getLoaiTin');
	});

});

// ---------------------------------------------------------------------------------------

Route::get('trangchu', 'PageController@trangchu');
Route::get('lienhe', 'PageController@lienhe');
Route::get('loaitin/{id}/{TenKhongDau?}', 'PageController@loaitin');
Route::get('tintuc/{id}/{TieuDeKhongDau?}', 'PageController@tintuc');

Route::get('dangky', 'PageController@getDangKy');
Route::post('dangky', 'PageController@postDangKy');
Route::get('dangnhap', 'PageController@getDangNhap');
Route::post('dangnhap', 'PageController@postDangNhap');
Route::get('dangxuat', 'PageController@getDangXuat');
Route::get('nguoidung', 'PageController@getNguoiDung');
Route::post('nguoidung', 'PageController@postNguoiDung');

Route::post('comment/{idTinTuc}', 'PageController@postComment');

Route::get('timkiem/{tukhoa}', 'PageController@getTimKiem');
Route::post('timkiem', 'PageController@TimKiem');



// DEMO-----------------------------------------------------------------------------------

Route::get('route1', ['as'=>'layPath', function(Request $request){
	// trả về tên route đã yêu cầu
	return $request->path();
}]);
Route::get('route2', function(Request $request){
	return $request->url();
})->name('layUrl');

Route::get('BuiHieuThien/', function(Request $request){
	echo $request->isMethod('get')?"Phuong thuc get <br>":"phuong thuc post<br>";
	echo $request->is('Bui*')?"Co Bui":"khong co Bui";
});

Route::get('test', function(){
	return redirect()->route('layUrl');
});



Route::get('qb/get', function () {
	$data = DB::table('users')
	->select('id','name','email')
	->where('id','>=',1)
	->orderBy('id','ASC')
	->skip(3) // bỏ qua phần tử thứ 1 đến thứ 3
	->take(5) // lấy 5 phần tử đầu tiên (từ 4 đế 9)
	->get();
	
	// echo $data; // JSON
	foreach($data as $row) {
		foreach ($row as $tencot => $giatri) {
			echo $tencot." : ".$giatri."<br>";
		}

		echo '<hr>';
	}

	echo count($data);

	// var_dump($data);
	// echo $data->count();

	//-------------------------------------------------------------------

	// echo "<hr>";

	// $tintuc = DB::table('tintuc')
	// ->where('TieuDe', 'like', '%iphone%')
	// ->orWhere('TomTat', 'like', '%iphone%')
	// ->orWhere('NoiDung', 'like', '%iphone%')
	// ->take(5)
	// ->get();

	// echo $tintuc;

	//-------------------------------------------------------------------
	echo "<hr>";

	$user = new App\User();
	$user= $user::all(); 

	//echo $user; // JSON
	foreach($user as $us) {
		echo $us->name.'<br>';
	}
});



Route::get('qb/update', function () {
	DB::table('users')
	->where('name', 'Thiện Hiếu Bùi')
	->update(['name'=>'Bùi Hiếu Thiện']);

	echo 'đã update';
});
