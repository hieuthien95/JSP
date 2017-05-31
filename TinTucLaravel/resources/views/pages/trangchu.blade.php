	
	<?php 
		use App\TinTuc;
	?>

	@extends('layout.index')

	@section('title', 'Trang chủ')

	@section('content')
	<!-- Page Content -->
    <div class="container">

    	@include('layout.slide')


        <div class="row main-left">

            <div class="col-lg-9 col-md-8 col-sm-8">
	            <div class="panel panel-default">         

	            	<div class="panel-body">

	            	@foreach($theloai as $tl)
	            	@if(count($tl->loaitin) > 0)

		                <!-- item -->
					    <div class="row-item row wow fadeInLeft" style="margin-bottom: 30px !important" id="{{$tl->TenKhongDau}}">
					    	<div style="margin-bottom: 20px">
					    		<h3 style="display: inline;"><a>{{$tl->Ten}}</a></h3>	
			                	@foreach($tl->loaitin as $lt)
			                		<h4 style="display: inline"><a href="loaitin/{{$lt->id}}/{{$lt->TenKhongDau}}"><i>{{$lt->Ten}}</i></a> |</h4>
			                	@endforeach 
			                </div>
		                	
		                	

		                	<?php 
		                		$tintuc = $tl->tintuc->where('NoiBat', 1)->sortByDesc('created_at')->take(5); 
		                		// cắt 1 tin từ danh sách $tintuc
		                		$tin1 = $tintuc->shift();
		                	?>
		                	<div class="row wow fadeInLeft">
		                		<div class="col-md-7">
			                        <a href="tintuc/{{$tin1['id']}}/{{$tin1['TieuDeKhongDau']}}">
			                            <img width="100%" src="upload/tintuc/{{$tin1['Hinh']}}" alt="">
			                        </a>
			                    </div>
			                    <div class="col-md-5">
			                        <h3 style="margin-top:0">{{$tin1['TieuDe']}}</h3>
			                        <h4>{{$tin1['TomTat']}}</h4>
			                        <a class="btn btn-default" href="tintuc/{{$tin1['id']}}/{{$tin1['TieuDeKhongDau']}}">Xem <span class="glyphicon glyphicon-chevron-right"></span></a>
								

									<div style="margin-top: 30px">
									@foreach($tintuc as $tt)

										<a href="tintuc/{{$tt->id}}/{{$tt->TieuDeKhongDau}}">
											<h4 class=" wow fadeInRight">
												<span class="glyphicon glyphicon-list-alt"></span> {{$tt->TieuDe}}
											</h4>
										</a>

									@endforeach
									</div>

								</div>
		                	</div>

		                </div>
		                <!-- end item -->
		            @endif
		            @endforeach

					</div>
	            </div>
        	</div>


        
            @include('layout.menu')

        </div>
        <!-- /.row -->
    </div>
    <!-- end Page Content -->
    @endsection