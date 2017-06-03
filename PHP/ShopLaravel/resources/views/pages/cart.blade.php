
	@extends('layout.index')

	@section('title', 'Giỏ hàng')
	@section('breadcrumb', 'Giỏ hàng')
    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    <section id="cart_items">
						<div class="container">
							<div class="breadcrumbs">
								<ol class="breadcrumb">
								  <li><a href="#">Home</a></li>
								  <li class="active">@yield('breadcrumb')</li>
								</ol>
							</div>
							
							                    
							<div class="table-responsive cart_info">

								<table class="table table-condensed">
									<thead>
										<tr class="cart_menu">
											<td class="image">Item</td>
											<td class="description"></td>
											<td class="price">Price</td>
											<td class="quantity">Quantity</td>
											<td class="total">Total</td>
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
									</tbody>
								</table>
							</div>
						</div>
					</section> <!--/#cart_items-->


                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection