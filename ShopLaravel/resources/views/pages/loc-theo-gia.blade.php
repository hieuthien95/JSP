
	@extends('layout.index')

	@section('title', 'Lọc theo giá')

    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    @include('layout.menu')

                    <div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">
                        <div class="features_items"><!--features_items-->

							@foreach($dssanpham as $sp)
	                            @include('layout.product-big')
	                        @endforeach
							
							<div class="clearfix"></div>
                            
                            <div align="center"> {{$dssanpham->links()}} </div>
							
							<div align="center"> <?php //{{$dssanpham->links()}}  ?></div>
							
						</div><!--features_items-->
                	</div><!--/category-tab-->
                        
                    @include('layout.recommend')
                        
                </div>
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection