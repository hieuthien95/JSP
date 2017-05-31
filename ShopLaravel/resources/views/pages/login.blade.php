
	@extends('layout.index')

	@section('title', 'Đăng nhập')
	@section('breadcrumb', 'Đăng nhập')

    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
	            <div class="breadcrumbs">
					<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li class="active">@yield('breadcrumb')</li>
					</ol>
				</div><!--/breadcrums-->
                <div class="row">				
                    
                    <section style="margin: 0"><!--form-->
						<div class="container">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">

									<div class="login-form"><!--login form-->
										<h2>Đăng nhập</h2>
										<form action="postLogin/{{base64_encode(url()->current())}}" method="POST">
                            				<input type="hidden" name="_token" value="{{ csrf_token() }}">
                            				
											<input type="email" placeholder="Địa chỉ Email" name="email" />
											<input type="password" placeholder="Mật khẩu" name="password" />
											<span>
												<input type="checkbox" checked="checked" class="checkbox"> 
												Giử đăng nhập
											</span>
											<a href="forgot">Quên mật khẩu</a>
											<button type="submit" class="btn btn-default">Đăng nhập</button>
										</form>
									</div><!--/login form-->
								</div>
								<div class="col-sm-1">
									<h2 class="or">Hoặc</h2>
								</div>
								<div class="col-sm-4">
									<div class="signup-form"><!--sign up form-->
										<h2>Đăng ký</h2>
										<form action="postRegister" method="POST" enctype="multipart/form-data">
                            				<input type="hidden" name="_token" value="{{ csrf_token() }}">

											<input type="text" placeholder="Tên" name="name" />
											<input type="email" placeholder="Địa chỉ Email" name="email" />
											<input type="tel" placeholder="Số điện thoại" name="sdt" />
											<input type="file" name="hinhanh" />

											<input type="password" placeholder="Mật khẩu" name="password" />
											<input type="password" placeholder="Nhập lại mật khẩu" name="repassword" />

											<button type="submit" class="btn btn-default">Đăng ký</button>
										</form>
									</div><!--/sign up form-->
								</div>
							</div>
						</div>
					</section><!--/form-->


                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection