<?php

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

Route::get('/', function () {
    return redirect('trangchu');
});

//---------------------------------------

Route::get('trangchu', 'PageController@trangchu');

Route::get('product/{id}/{tenkhongdau?}', 'PageController@getProduct');

Route::get('product-list', 'PageController@getProductList');

//---------------------------------------

Route::get('bai-viet-list', 'PageController@getBaiVietList');

Route::get('bai-viet/{id}/{tieudekhongdau?}', 'PageController@getBaiViet');

Route::get('video-list', 'PageController@getVideoList');

Route::get('video/{id}/{tenkhongdau?}', 'PageController@getVideo');

//---------------------------------------

Route::get('cart', 'PageController@getCart');

Route::get('checkout', 'PageController@getCheckout');

Route::get('so-sanh/{id1}/{id2}/{nothing?}', 'PageController@getSoSanh');

//---------------------------------------

Route::get('add-to-cart/{id}/{url?}', 'PageController@addToCart');

Route::get('sub-in-cart/{rowId}/{url?}', 'PageController@subInCart');

Route::get('remove-in-cart/{rowId}/{url?}', 'PageController@removeInCart');


Route::get('add-to-so-sanh/{id}/{url?}', 'PageController@addToSoSanh');

Route::get('remove-in-so-sanh/{rowId}/{url?}', 'PageController@removeInSoSanh');

//---------------------------------------

Route::get('thanh-toan', 'PageController@thanhtoan');

Route::get('update-thanh-toan/{abc?}', 'PageController@updateThanhToan');

//---------------------------------------

Route::get('tim-kiem/{tukhoa}', 'PageController@getTimKiem');

Route::post('postTimKiem', 'PageController@postTimKiem');

Route::get('ajaxTimKiem/{tukhoa?}', 'PageController@ajaxTimKiem');

Route::get('loc-theo-gia/{url?}', 'PageController@locTheoGia');

Route::get('loc-theo-gia/{url?}', 'PageController@locTheoGia');

//---------------------------------------

Route::get('profile', 'PageController@getProfile')->name('route-profile');


Route::get('login', 'PageController@getLogin');

Route::post('postLogin/{url?}', 'PageController@postLogin');


Route::get('logout', 'PageController@logout');

Route::post('postRegister', 'PageController@postRegister');

Route::post('postChangeInfo', 'PageController@postChangeInfo');


Route::get('forgot', 'PageController@getForgot');

Route::post('postForgot', 'PageController@postForgot');

// Android -----------------------------------------------------------------

Route::get('danhmuc1', 'PageController@danhmuc1');

Route::get('danhmuc2/{parent}', 'PageController@danhmuc2');


Route::get('send-mail', 'PageController@sendMail');






Route::get('all-san-pham', function(){
	echo App\SanPham::orderBy('id', 'DESC')->get();
});


Route::get('all-bai-viet', function(){
	echo App\BaiViet::orderBy('id', 'DESC')->get();
});


Route::get('all-video', function(){
	echo App\Video::orderBy('id', 'DESC')->get();
});

Route::get('all-san-pham/{tukhoa?}', function($tukhoa = null){
	$dssanpham = App\SanPham::timkiem($tukhoa)->orderBy('id', 'DESC')->get();
	echo $dssanpham;
});

Route::get('all-hinh-anh', function(){
	$dshinhanh = App\HinhAnh::all();
	echo $dshinhanh;
});


// Route::get('add-to-cart-android/{id}', function($id = null){
// 	$sanpham = DB::table('sanpham')->where('id', $id)->first();

//     Cart::instance('shopping')->add(['id'=>$sanpham->id, 'name'=>$sanpham->hangsx.' '.$sanpham->ten, 'qty'=>1, 'price'=>$sanpham->gia, 'options' => ['hinhanh'=>$sanpham->hinhanh]]);

// 	$dssanpham = Cart::instance('shopping')->content();
//     echo "[".$dssanpham->tojSon()."]";
// });

// Route::get('cart-android', function($tukhoa = null){
// 	$dssanpham = Cart::instance('shopping')->content();
//     echo "[".$dssanpham->tojSon()."]";
// });
