	<section id="slider"><!--slider-->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#slider-carousel" data-slide-to="1"></li>
                            <li data-target="#slider-carousel" data-slide-to="2"></li>
                            <li data-target="#slider-carousel" data-slide-to="3"></li>
                            <li data-target="#slider-carousel" data-slide-to="4"></li>
                        </ol>
                        
                        <div class="carousel-inner">

                        <?php $count = 0; ?>
                        @foreach($dstopsanpham as $sp)
                        <?php if(++$count<=5) { ?>
                            <div class="item {{$count==1?'active':''}}">

                            @if(rand(0,1)==0)
                                <div class="col-sm-6 wow fadeInUpBig">
                                    <h1><span>ICON</span>Club</h1>
                                    <h2>{{$sp->hangsx.' '.$sp->ten}}</h2>
                                    <p>{{$sp->cpu." ".$sp->pin." ".$sp->hangsx." ".$sp->hdh}}</p>
                                    <a type="button" class="btn btn-default get" style="color: #FFF" href="product/{{$sp->id}}/{{changeTitle($sp->ten)}}">Mua ngay</a>
                                </div>
                                
                                <a href="./product/{{$sp->id}}/{{changeTitle($sp->ten)}}">
                                <div class="col-sm-6 wow fadeInDownBig">
                                    <img src="upload/sanpham/{{$sp->hinhanh}}" class="girl img-responsive" style="padding: 15px; width: 70%" />
                                </div>
                                </a>
                                
                            @else

                                <a href="./product/{{$sp->id}}/{{changeTitle($sp->ten)}}">
                                <div class="col-sm-6 wow fadeInDownBig">
                                    <img src="upload/sanpham/{{$sp->hinhanh}}" class="girl img-responsive" style="padding: 15px; width: 70%" />
                                </div>
                                </a>

                                <div class="col-sm-6 wow fadeInUpBig">
                                    <h1><span>ICON</span>Club</h1>
                                    <h2>{{$sp->hangsx.' '.$sp->ten}}</h2>
                                    <p>{{$sp->cpu." ".$sp->pin." ".$sp->hangsx." ".$sp->hdh}}</p>
                                    <a type="button" class="btn btn-default get" style="color: #FFF" href="product/{{$sp->id}}/{{changeTitle($sp->ten)}}">Mua ngay</a>
                                </div>

                            @endif

                            </div>
                        <?php } ?>
                        @endforeach
                            
                        </div>
                        
                        <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                    
                </div>
            </div>
        </div>
    </section><!--/slider-->
