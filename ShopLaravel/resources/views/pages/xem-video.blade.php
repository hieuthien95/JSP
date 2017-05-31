
@extends('layout.index')


                    
@if($video != null)


	@section('title', $video->ten)
    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    <span class="hidden-xs">
                    
                    @include('layout.menu')

                    </span>

					<style>
						.video img {
							width: 100%;
							padding-bottom: 5px
						}
					</style>


					<div class="col-md-9 col-sm-8 padding-left video">

						<img class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							src="upload/video/{{$video->hinhanh}}" />
						<h2 class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							style="text-align: center">
							{{$video->ten}}
						</h2>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" align="center"
							style="padding: 5px">
							<iframe style="width: 100%; height: 400px"
								title="YouTube video player" src="{{$video->duongdan}}">
							</iframe>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
							style="text-align: justify; padding: 5px">
							{!!$video->noidung!!}
						</div>

						<div class="fb-comments"
							data-href="http://www.thiensu.com/Shop_laravel/xem-video/{{$video->id}}"
							data-colorscheme="light" data-numposts="5" data-width="100%"></div>

					</div>
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection

@endif