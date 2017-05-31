
@extends('layout.index')


                    
@if($sanpham2 != null)


	@section('title', $sanpham2->ten." | ".$sanpham2->ten)
    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 padding-right" style="padding-left: 0">
						<div class="product-details"><!--product-details-->
							<div class="col-sm-12">

								<div class="view-product" id="img" style="width: 60%">
									<img src="upload/sanpham/{{$sanpham1->hinhanh}}" alt="" id="img_kq"  style="height: auto; margin-top: 10px"/>
								</div>

									<div class="product-information"><!--/product-information-->
										<h2>{{$sanpham1->ten.' '.$sanpham1->ten}}</h2>
										<p><b>ID:</b> {{$sanpham1->id}}</p>

										<p><b>Tình trạng:</b> {{$sanpham1->sl}}</p>
										<p><b>Hãng:</b> {{$sanpham1->hangsx}}</p>
										<p><b>KM:</b>{!!$sanpham1->km!!}</p>

										<span><span> {{number_format($sanpham1->gia)}}đ</span> </span> <br>
										
										<a target="_blank" href="{!! url('add-to-cart', [$sanpham1->id, base64_encode('checkout')]) !!}"> 
											<img style="margin-bottom: 10px" src="images/thanhtoan.png" />
										</a> 
										<a href="{!! url('add-to-cart', [$sanpham1->id, base64_encode(url()->current())]) !!}"
											type="button" class="btn btn-fefault cart" style="color: #fff">
											<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
										</a>
									</div><!--/product-information-->
								
							</div><!--/product-details-->


							<div class="category-tab shop-details-tab">
								<div class="tab-content">
									<div class="tab-pane fade active in" id="details">
										<div class="col-sm-12" style="padding: 5px">
											<p>
												<b>Display: {{$sanpham1->manhinh}}</p>
											<p>
												<b>OS: </b>{{$sanpham1->hdh}}</p>
											<p>
												<b>CPU: </b>{{$sanpham1->cpu}}</p>
											<p>
												<b>Camera: </b>{{$sanpham1->camera}}</p>
											<p>
												<b>Pin: </b>{{$sanpham1->pin}}</p>
											<p>
												<b>KM: </b>{!!$sanpham1->km!!}</p>
											<p>
												<b>Other: </b>{!!$sanpham1->nhieuhon!!}</p>
										</div>
									</div>

								</div>

								<div class="col-sm-12">
									@foreach($dshinhanh1 as $hinh)
										<img src='upload/hinhanh/{{$hinh->hinhanh}}' width='100%' style='margin-top: 5px'>
									@endforeach
								</div>
							</div>


						</div>
							
					</div>



					

		            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 padding-right" style="padding-left: 0">
						<div class="product-details"><!--product-details-->
							<div class="col-sm-12">

								<div class="view-product" id="img" style="width: 60%">
									<img src="upload/sanpham/{{$sanpham2->hinhanh}}" alt="" id="img_kq"  style="height: auto; margin-top: 10px"/>
								</div>

									<div class="product-information"><!--/product-information-->
										<h2>{{$sanpham2->ten.' '.$sanpham2->ten}}</h2>
										<p><b>ID:</b> {{$sanpham2->id}}</p>

										<p><b>Tình trạng:</b> {{$sanpham2->sl}}</p>
										<p><b>Hãng:</b> {{$sanpham2->hangsx}}</p>
										<p><b>KM:</b>{!!$sanpham2->km!!}</p>

										<span><span> {{number_format($sanpham2->gia)}}đ</span> </span> <br>
										
										<a target="_blank" href="{!! url('add-to-cart', [$sanpham2->id, base64_encode('checkout')]) !!}"> 
											<img style="margin-bottom: 10px" src="images/thanhtoan.png" />
										</a> 
										<a href="{!! url('add-to-cart', [$sanpham2->id, base64_encode(url()->current())]) !!}"
											type="button" class="btn btn-fefault cart" style="color: #fff">
											<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
										</a>
									</div><!--/product-information-->
								
							</div><!--/product-details-->


							<div class="category-tab shop-details-tab">
								<div class="tab-content">
									<div class="tab-pane fade active in" id="details">
										<div class="col-sm-12" style="padding: 5px">
											<p>
												<b>Display: {{$sanpham2->manhinh}}</p>
											<p>
												<b>OS: </b>{{$sanpham2->hdh}}</p>
											<p>
												<b>CPU: </b>{{$sanpham2->cpu}}</p>
											<p>
												<b>Camera: </b>{{$sanpham2->camera}}</p>
											<p>
												<b>Pin: </b>{{$sanpham2->pin}}</p>
											<p>
												<b>KM: </b>{!!$sanpham2->km!!}</p>
											<p>
												<b>Other: </b>{!!$sanpham2->nhieuhon!!}</p>
										</div>
									</div>

								</div>

								<div class="col-sm-12">
									@foreach($dshinhanh2 as $hinh)
										<img src='upload/hinhanh/{{$hinh->hinhanh}}' width='100%' style='margin-top: 5px'>
									@endforeach
								</div>
							</div>


						</div>
							
					</div>




                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection

@endif