
@extends('layout.index')


                    
@if($baiviet != null)


	@section('title', $baiviet->tieude)
    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">

                	<span class="hidden-xs">
                    
                    @include('layout.menu')

                    </span>

					<style>
						.baiviet img {
							width: 100%;
							padding-bottom: 5px
						}
					</style>

		            <div class="col-md-9 col-sm-8 padding-left baiviet">

						<img src="upload/baiviet/{{$baiviet->hinhanh}}" />
						<h2 style="text-align: center; margin-top: 5px">
							{{$baiviet->tieude}}
						</h2>
						<h3 style="text-align: justify; padding: 0px 5px">
							{!!$baiviet->tomtat!!}
						</h3>
						<div style="text-align: justify; padding: 0px 5px">
							{!!$baiviet->noidung!!}
						</div>

						<div class="fb-comments"
							data-href="http://www.thiensu.com/Shop_laravel/bai-viet/{{$baiviet->id}}"
							data-colorscheme="light" data-numposts="5" data-width="100%"></div>

					</div>
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection

@endif