
	@extends('layout.index')

	@section('title', 'Danh sách bài viết')

    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    <span class="hidden-xs">
                    
                    @include('layout.menu')

                    </span>

                    <div class="col-md-9 col-sm-8" >

						@foreach($dsbaiviet as $bv)

						<div style="padding-bottom: 20px">
							<a href="bai-viet/{{$bv->id}}/{{changeTitle($bv->tieude)}}.html"
								style="color: #000">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"
									style="padding: 0px; padding-bottom: 10px">
									<img src="upload/baiviet/{{$bv->hinhanh}}" style="width: 100%; overflow: hidden" />
								</div>
								<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12"
									style="text-align: justify; overflow: hidden">
									<b style="font-size: 20px; line-height: 25px"> {{$bv->tieude}}
									</b> <br />
									{!!$bv->tomtat!!}
								</div>

								<div style="clear: both"></div>
							</a>
						</div>

						@endforeach

						<div class="clearfix"></div>

						<div align="center"> {{$dsbaiviet->links()}} </div>

					</div>
                        
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection