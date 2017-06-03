
@extends('layout.index')


                    
@if($sanpham != null)


	@section('title', $sanpham->ten)
    

	@section('content')
        
    	<!-- Page Content -->
        <section>
            <div class="container">
                <div class="row">
                    
                    @include('layout.menu')

                    <!-- script xử lý hình ảnh -->
					<script>
						$(document).ready(function() {
							
							// sự kiện zoom của id='img'
							$('#img').zoom({
								on : 'click'
							});
							
							// sự kiện bấm vô hình ảnh bất kỳ
							$('.item>img').on({
							    'click': function(){
							    	
							    	// thay doi hinh ảnh
							    	$('#img_kq').attr('src',$(this).attr('src'));
							    	
							    	// sự kiện zoom của id='img'
							    	$('#img').zoom({
										on : 'click'
									});
							    }
							});
							
						});
					</script>
					<!-- thêm jquery.zoom.js, jquery.min.js -->

		            <div class="col-md-9 col-sm-8 padding-right" style="padding-left: 0">
						<div class="product-details"><!--product-details-->
							<div class="col-sm-5">
								

								<div id="similar-product" class="carousel slide" data-ride="carousel">
									<?php $i=0; ?>
									<!-- Wrapper for slides -->
									<div class="carousel-inner">
										<div class="item active">
											<img src="upload/sanpham/{{$sanpham->hinhanh}}" width="27%">
											@if($i <= sizeof($dshinhanh)-1)
											<img src="upload/hinhanh/{{$dshinhanh[$i++]->hinhanh}}" width="27%">
											@endif
											@if($i <= sizeof($dshinhanh)-1)
											<img src="upload/hinhanh/{{$dshinhanh[$i++]->hinhanh}}" width="27%">
											@endif
										</div>
										@while($i <= sizeof($dshinhanh)-1)
										<div class="item">
											@if($i <= sizeof($dshinhanh)-1)
											<img src="upload/hinhanh/{{$dshinhanh[$i++]->hinhanh}}" width="27%">
											@endif
											@if($i <= sizeof($dshinhanh)-1)
											<img src="upload/hinhanh/{{$dshinhanh[$i++]->hinhanh}}" width="27%">
											@endif
											@if($i <= sizeof($dshinhanh)-1)
											<img src="upload/hinhanh/{{$dshinhanh[$i++]->hinhanh}}" width="27%">
											@endif
										</div>
										@endwhile
									</div>

										 <!-- Controls -->
									<a class="left item-control" href="#similar-product" data-slide="prev">
										<i class="fa fa-angle-left"></i>
									</a>
									<a class="right item-control" href="#similar-product" data-slide="next">
										<i class="fa fa-angle-right"></i>
									</a>
								</div>

								<div class="view-product" id="img" >
									<img src="upload/sanpham/{{$sanpham->hinhanh}}" alt="" id="img_kq"  style="height: auto; margin-top: 10px"/>
									<h3 style="padding: 8px 10px"><i class="glyphicon glyphicon-search"></i></h3>
								</div>

								</div>
								<div class="col-sm-7">
									<div class="product-information"><!--/product-information-->
										<h2>{{$sanpham->hangsx.' '.$sanpham->ten}}</h2>
										<p><b>ID:</b> {{$sanpham->id}}</p>

										<p><b>Tình trạng:</b> {{$sanpham->sl}}</p>
										<p><b>Hãng:</b> {{$sanpham->hangsx}}</p>
										<p><b>KM:</b>{!!$sanpham->km!!}</p>

										<span><span> {{number_format($sanpham->gia)}}đ</span> </span> <br>
										
										<a target="_blank" href="{!! url('add-to-cart', [$sanpham->id, base64_encode('checkout')]) !!}"> 
											<img style="margin-bottom: 10px" src="images/thanhtoan.png" />
										</a> 
										<a href="{!! url('add-to-cart', [$sanpham->id, base64_encode(url()->current())]) !!}"
											type="button" class="btn btn-fefault cart" style="color: #fff">
											<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
										</a>
									</div><!--/product-information-->
								</div>
							</div><!--/product-details-->
							
							<div class="category-tab shop-details-tab"><!--category-tab-->
								<div class="col-sm-12">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#details" data-toggle="tab">Chi tiết</a></li>
										<li><a href="#companyprofile" data-toggle="tab">{{$sanpham->loaisp}}</a></li>
										<li><a href="#tag" data-toggle="tab">{{$sanpham->hangsx}}</a></li>
										<li><a href="#reviews" data-toggle="tab">Bình luận</a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade active in" id="details" >
										<div class="col-sm-12" style="padding: 5px">
											<p>
												<b>Display: </b>{!!$sanpham->manhinh!!}</p>
											<p>
												<b>OS: </b>{!!$sanpham->hdh!!}</p>
											<p>
												<b>CPU: </b>{!!$sanpham->cpu!!}</p>
											<p>
												<b>Camera: </b>{!!$sanpham->camera!!}</p>
											<p>
												<b>Pin: </b>{!!$sanpham->pin!!}</p>
											<p>
												<b>KM: </b>{!!$sanpham->km!!}</p>
											<p>
												<b>Other: </b>{!!$sanpham->nhieuhon!!}</p>
										</div>
										
									</div>
									
									<div class="tab-pane fade" id="companyprofile" >
										
									<?php  $timkiem = App\SanPham::timkiem($sanpham->loaisp)->take(12)->get() ?>
									@foreach($timkiem as $sp)
										<div class="col-sm-4">
											@include('layout.product-small')
										</div>
									@endforeach

									</div>
									
									<div class="tab-pane fade" id="tag" >
									<?php  $timkiem = App\SanPham::timkiem($sanpham->hangsx)->take(12)->get() ?>
									@foreach($timkiem as $sp)
										<div class="col-sm-4">
											@include('layout.product-small')
										</div>
									@endforeach
									</div>
									
									<div class="tab-pane fade active in" id="reviews" >
										<div class="col-sm-12">
										<!--
										<ul>
											<li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
											<li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
											<li><a href=""><i class="fa fa-calendar-o"></i>31 DEC
													2014</a></li>
										</ul>  
										-->
											<div class="fb-comments"
												data-href="http://www.thiensu.com/DAJAVA/?ac=sanpham&stt=<%=sp.getStt()%>"
												data-colorscheme="light" data-numposts="5" data-width="100%"></div>
										</div>
									</div>
									
								</div>
							</div><!--/category-tab-->
							
							@include('layout.recommend')
							
						</div>
					</div>
                    
                </div>
            </div>
        </section>
    <!-- end Page Content -->
    @endsection

@endif