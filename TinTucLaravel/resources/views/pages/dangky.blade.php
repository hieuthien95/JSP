	
	<?php 
		use App\TinTuc;
	?>

	@extends('layout.index')

	@section('title', 'Đăng ký')

	@section('content')
	
	<!-- Page Content -->
    <div class="container">

    	<!-- slider -->
    	<div class="row carousel-holder">
    		<div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="panel panel-default">
				  	<div class="panel-heading">Đăng Ký</div>
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

				    	<form action="dangky" method="POST">
 							<input type="hidden" name="_token" value="{{csrf_token()}}">

 							<div>
				    			<label>Tên</label>
							  	<input type="text" class="form-control" placeholder="Hãy nhập tên" name="Name" >
							</div>

							<div>
				    			<label>Email</label>
							  	<input type="email" class="form-control" placeholder="Email" name="Email">
							</div>
							<br>	
							<div>
				    			<label>Mật khẩu</label>
							  	<input type="password" class="form-control" placeholder="Password" name="Password">
							</div>
							<br>
							<button type="submit" class="btn btn-default">Đăng ký
							</button>
				    	</form>
				  	</div>
				</div>
            </div>
            <div class="col-md-4"></div>
        </div>
        <!-- end slide -->
    </div>
    <!-- end Page Content -->
    
    @endsection