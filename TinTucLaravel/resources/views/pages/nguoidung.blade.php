	
	<?php 
		use App\TinTuc;
	?>

	@extends('layout.index')

	@section('title', 'Người dùng')

	@section('content')
	
	<!-- Page Content -->
    <div class="container">

    	<!-- slider -->
    	<div class="row carousel-holder">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <div class="panel panel-default">
				  	<div class="panel-heading">
                        Thông tin tài khoản
                        {!! (Auth::user()->quyen==1 || Auth::user()->quyen==2)?"<a href='admin'> | Trang quản lý</a>":""!!}
                    </div>
				  	<div class="panel-body">

				  		@if(count($errors) > 0)
                            <div class="col-lg-12 alert alert-danger">
                                @foreach ($errors->all() as $err)
                                        {{$err}}<br>
                                @endforeach
                            </div>
                        @endif

                        @if(session('thongbao'))
                            <div class="col-lg-12 alert alert-success">
                                {{session('thongbao')}}
                            </div>
                        @endif

                        @if(session('loi'))
                            <div class="col-lg-12 alert alert-danger">
                                {{session('loi')}}
                            </div>
                        @endif

				    	<form action="nguoidung" method="post">

				    		<input type="hidden" name="_token" value="{{csrf_token()}}">

				    		<div>
				    			<label>Họ tên</label>
							  	<input type="text" class="form-control" placeholder="Username" name="Name" aria-describedby="basic-addon1" value="{{Auth::user()->name}}">
							</div>
							<br>
							<div>
				    			<label>Email</label>
							  	<input type="email" class="form-control" placeholder="Email" name="Email" value="{{Auth::user()->email}}" 
							  	readonly >
							</div>
							<br>	
							<div>
								<input type="checkbox" name="changepassword" id="changepassword">

				    			<label>Đổi mật khẩu</label>
							  	<input type="password" class="form-control password" name="Password" aria-describedby="basic-addon1" disabled>
							</div>
							<br>
							<div>
				    			<label>Nhập lại mật khẩu</label>
							  	<input type="password" class="form-control repassword" name="Repassword" aria-describedby="basic-addon1" disabled>
							</div>
							<br>
							<button type="submit" class="btn btn-default">Sửa
							</button>

				    	</form>
				  	</div>
				</div>
            </div>
            <div class="col-md-2">
            </div>
        </div>
        <!-- end slide -->
    </div>
    <!-- end Page Content -->
    
    @endsection

    @section('script')
    	<script type="text/javascript">
    		$(document).ready(function(){
    		$('#changepassword').change(function(){
    			if($(this).is(':checked')) {
    				$('.password').removeAttr('disabled');
    				$('.repassword').removeAttr('disabled');
    			} else {
    				$('.password').attr('disabled', '');
    				$('.repassword').attr('disabled','');
    			}
    		});
    	});

    	</script>
    @endsection