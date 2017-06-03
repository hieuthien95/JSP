
	@extends('layout.index')

	@section('title', 'Thanh toán')
	@section('breadcrumb', 'Thanh toán')

    

	@section('content')
        
    <section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">@yield('breadcrumb')</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="step-one">
				<h2 class="heading">Bước 1</h2>
			</div>
			
			@if(!Auth::user())
			
			<section id="form">
				<!--form-->
				<div class="container">
					<div class="row">
						<div class="col-sm-4 col-sm-offset-1">
							<div class="login-form">
								<!--login form-->
								
								<form action="postLogin/{{base64_encode(url()->current())}}" method="POST">
                            		<input type="hidden" name="_token" value="{{ csrf_token() }}">
                            				
									<input type="email" placeholder="Địa chỉ Email" name="email" />
									<input type="password" placeholder="Mật khẩu" name="password" />
									
									<button type="submit" class="btn btn-default">Đăng nhập</button>
								</form>
								
							</div>
							<!--/login form-->
						</div>
						
					</div>
				</div>
			</section>
			
			<div class="register-req">
				<p>Hãy đăng nhập hoặc <a href="./login.jsp"> đăng ký </a> để được tích lũy điểm và lịch sử giao dịch</p>
			</div>
			
			@else
				<div class="col-lg-12 alert alert-success"> Đã đăng nhập </div>
				<div class="clearfix"></div>
			@endif
			
			
			<div class="step-one">
				<h2 class="heading">Bước 2 (*)</h2>
			</div>
			

			<div class="table-responsive cart_info">
				<table class="table table-condensed">

					<thead>
						<tr class="cart_menu">
							<td class="image">Sản phẩm</td>
							<td class="description"></td>
							<td class="price">Giá</td>
							<td class="quantity">Số lượng</td>
							<td class="total">Tổng</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					@foreach($dssanpham as $sp)
						<tr>
							<td class="cart_product">
								<a href=""><img src="upload/sanpham/{!! $sp->options['hinhanh'] !!}" alt="" width="50"></a>
							</td>
							<td class="cart_description">
								<h5><a href="">{{$sp->name}}</a></h5>
								<p>ID: {{$sp->id}}</p>
							</td>
							<td class="cart_price">
								<p>{{number_format($sp->price)}}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href="{!! url('add-to-cart', [$sp->id, base64_encode(url()->current())]) !!}"> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="{{$sp->qty}}" autocomplete="off" size="2">
									<a class="cart_quantity_down" href="{!! url('sub-in-cart', [$sp->rowId, base64_encode(url()->current())]) !!}"> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">{{number_format($sp->subtotal)}}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="{!! url('remove-in-cart', [$sp->rowId, base64_encode(url()->current())]) !!}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
					@endforeach

						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr class="shipping-cost">
										<td>Phí giao hàng</td>
										<td>Miển phí</td>										
									</tr>
									<tr class="shipping-cost">
										<td>Tax</td>
										<td>{{Cart::instance('shopping')->tax()}}đ</td>										
									</tr>
									<tr>
										<td>Tổng tiền</td>
										<td><span>{{Cart::instance('shopping')->total()}}đ</span></td>
									</tr>
									<tr>
										<td>
											<a href="thanh-toan">
												<img src="images/thanhtoan.png" />
											</a>
										<td>
									</tr>
								</table>
							</td>
						</tr>

					</tbody>

				</table>
			</div>
			
		</div>
	</section> <!--/#cart_items-->
	
    @endsection