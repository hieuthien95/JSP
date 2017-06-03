
	@extends('layout.index')

	@section('title', 'Quên mật khẩu')
	@section('breadcrumb', 'Quên mật khẩu')

    

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
                    
                    <section style="margin: 10px 0px"><!--form-->
						<div class="container">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">

									<div class="login-form">
										<!--login form-->
										<h2>Quên mật khẩu</h2>

										<form action="postForgot" method="POST">
											<input type="hidden" name="_token" value="{{ csrf_token() }}">
											
											<input type="text" placeholder="Email" name="email" /> 
											<button type="submit" value="forgot" class="btn btn-default">Gửi</button>
										</form>

									</div>
									<!--/login form-->
								</div>
								
							</div>
						</div>
					</section><!--/form-->


                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection