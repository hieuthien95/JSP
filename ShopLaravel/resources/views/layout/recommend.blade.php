					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center wow fadeInUp">Sản phẩm nổi bật</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									
									<?php $count = 0; ?>
									@foreach($dssanpham as $sp)
									<?php if(++$count<=3){ ?>
									
									<div class="col-sm-4 wow fadeInUp">
										@include('layout.product-small')
									</div>
									<?php } ?>
									@endforeach


								</div>
								<div class="item">	

									<?php $count = 0; ?>
									@foreach($dssanpham as $sp)
									<?php if(++$count>3 && $count<=6){ ?>
									
									<div class="col-sm-4">
										@include('layout.product-small')
									</div>

									<?php } ?>
									@endforeach

								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->