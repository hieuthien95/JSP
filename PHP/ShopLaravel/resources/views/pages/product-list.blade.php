
	@extends('layout.index')

	@section('title', 'Danh sách sản phẩm')

    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    @include('layout.menu')

                    <div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">
                        <div class="features_items"><!--features_items-->
							<h2 class="title text-center">Features Items</h2>
							
							@foreach($dssanpham as $sp)
	                            @include('layout.product-big')
	                        @endforeach
							
							<div class="clearfix"></div>
							
							<div align="center"> {{$dssanpham->links()}} </div>
							
						</div><!--features_items-->
                	</div><!--/category-tab-->
                        
                    @include('layout.recommend')
                        
                </div>
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection