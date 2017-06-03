
	@extends('layout.index')

	@section('title', 'Cá nhân')
	@section('breadcrumb', 'Cá nhân')

    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
				<div class="breadcrumbs">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li class="active">@yield('breadcrumb')</li>
					</ol>
				</div>

                <div class="row">
                    
                    


                    <div class="col-sm-12">
						<div class="category-tab shop-details-tab" style="margin: 0">
							<!--category-tab-->
							<div class="col-sm-12">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#change" data-toggle="tab">Thay đổi thông tin</a></li>
									<li><a href="#profile" data-toggle="tab">Cá nhân</a></li>
									<li><a href="#checkedout" data-toggle="tab">Đã thanh toán</a> </li>
									
									@if(Auth::user())
										@if(Auth::user()->quyen == 1 || Auth::user()->quyen == 2)
									<li><a href="/TinTucLaravel/public/admin">Trang quản lý</a></li>
										@endif
									@endif
									<li><a href="logout">Đăng xuất</a></li>
								</ul>
							</div>
							<div class="tab-content">

								<div class="tab-pane fade active in" id="change"
									style="padding: 20px; text-align: center;">
									<div class="col-sm-8 col-sm-offset-2">
										<section id="form">
											<div class="signup-form">


												<!--update up form-->
												<form action="postChangeInfo" method="POST" enctype="multipart/form-data">
                            						<input type="hidden" name="_token" value="{{ csrf_token() }}">

													<img src="upload/taikhoan/{{Auth::user()->hinhanh}}" style="width: 30%; border-radius: 500px; margin-bottom: 30px">
													<input name="email" type="email" value="{{Auth::user()->email}}" readonly="readonly" />

													<input name="name" type="text" value="{{Auth::user()->name}}" /> 
													<input name="sdt" type="tell" value="{{Auth::user()->sdt}}" />
													<input name="hinhanh" type="file" /> 

													<input name="password" type="password" placeholder="Password" /> <br> 

													<input name="newpassword" type="password" placeholder="New password" /> 
													<input name="repassword" type="password" placeholder="Conform password" />

													<button type="submit" class="btn btn-default">Xác nhận</button>

												</form>
											</div>
										</section>
									</div>
								</div>

								<div class="tab-pane fade" id="profile"
									style="padding: 20px; text-align: center;">
									<div class="col-sm-12">

										@if(Auth::user())

										<img src="upload/taikhoan/{{Auth::user()->hinhanh}}"
											style="width: 50%; border-radius: 5000px; margin-bottom: 30px">
										<h1>
											<b>Tên: </b>{{Auth::user()->name}}
										</h1>

										<h4>
											<b>Email: </b>{{Auth::user()->email}}
										</h4>
										<h4>
											<b>Sdt: </b>{{Auth::user()->sdt}}
										</h4>
										<h4>
											<b>Quyền: </b>{{Auth::user()->quyen}}
										</h4>
										<h4>
											<b>Điểm tích lũy: </b>{{Auth::user()->diem}}
										</h4>

										@endif
									</div>
								</div>

								<div class="tab-pane fade" id="checkedout">
									<div style="padding: 20px">
										<table class="table table-condensed">
											<thead>
												<tr class="cart_menu">
													<td><h5>Stt</h5></td>
													<td><h5>Giá</h5></td>
													<td><h5>Sđt</h5></td>
													<td><h5>Ghi chú</h5></td>
													<td><h5>Mã giao dịch</h5></td>
													<td><h5>Thời gian</h5></td>
												</tr>
											</thead>
											<tbody>

												@foreach($dsdonhang as $dh)
												<tr>
													<td><h5>{{$dh->id}}</h5></td>
													<td><h5 style="color: #06F">{{number_format($dh->gia)}}đ</h5></td>
													<td><h5 style="color: #06F">{{$dh->sdt}}</h5></td>
													<td><h5>{{$dh->ghichu}}</h5></td>
													<td><h5>{{$dh->magiaodich}}</h5></td>
													<td><h5>{{$dh->updated_at}}</h5></td>
												</tr>

												@endforeach

											</tbody>
										</table>
									</div>

								</div>

							</div>
						</div>
						<!--/category-tab-->

					</div>



                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection