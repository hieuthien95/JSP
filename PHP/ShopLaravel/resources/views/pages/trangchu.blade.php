
	@extends('layout.index')

	@section('title', 'Trang chủ')

    

	@section('content')

        @include('layout.slider')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    @include('layout.menu')

                    <div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">





                        <div class="Sản phẩm mới"><!--features_items-->
                            <h2 class="title text-center wow fadeInUp">Sản phẩm mới</h2>
                            @foreach($dssanpham as $sp)
                                @include('layout.product-big')
                            @endforeach

                            <div class="clearfix"></div>

                            <div align="center" class=" wow fadeInUp"> {{$dssanpham->links()}} </div>
                        </div><!--features_items-->




                        
                        <div class="category-tab" id="sanpham"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs wow fadeInUp">

                                    <?php $count = 0; ?>
                                    @foreach($dsloaisp as $lsp)
                                        <li class="{{++$count==1?'active':''}}"><a href="#LSP{{$lsp->id}}" data-toggle="tab">{{$lsp->ten}}</a></li>
                                    @endforeach

                                </ul>
                            </div>
                            <div class="tab-content">
                                <?php 
                                    $count = 0; 
                                ?>
                                @foreach($dsloaisp as $lsp)
                                    <div class="tab-pane fade {{++$count==1?'active in':''}}" id="LSP{{$lsp->id}}" >
                                    
                                    <?php 
                                        $dssanpham = App\SanPham::timkiem($lsp->ten)->take(12)->get();
                                    ?>
                                    @foreach($dssanpham as $sp)
                                        <div class="col-sm-3 <?php if(++$count<=13){echo ' wow fadeInUp';} ?>">
                                            @include('layout.product-small')
                                        </div>
                                    @endforeach

                                    </div>
                                @endforeach
                                                            
                            </div>
                        </div><!--/category-tab-->



                        
                        @include('layout.recommend')



                        
                    </div>
                    
                </div>
            </div>
        </section>
        <!-- end Page Content -->





        @include('layout.so-sanh-fixed')





    @endsection