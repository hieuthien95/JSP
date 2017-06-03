				<div class="col-md-3 col-sm-4">
                    <div class="left-sidebar">




                        <script type="text/javascript">
                            function accc() {
                                var vl = $("#sl2").data('slider').getValue();
                                $('#minmaxvl').val(vl);
                            }
                        </script>

                        <h2 class=" wow fadeInLeft">Tìm theo giá</h2>
                        <div class="price-range wow fadeInLeft">
                            <!--price-range-->
                            <form class="well text-center" action="loc-theo-gia" method="get" style="width: 100%">

                                <input type="text" class="span2" data-slider-min="100000"
                                    data-slider-max="100000000" data-slider-step="100000"
                                    data-slider-value="[100000,50000000]" id="sl2">
                                <input type="hidden" name="minmax" id="minmaxvl">
                                <br /> <b class="pull-left">100K</b> <b class="pull-right">100Tr</b>
                                
                                <button class="btn btn-default" style="margin-top: 10px" type="submit" 
                                    onclick="accc()">Lọc</button>
                            </form>
                        </div>
                        <!--/price-range-->





                        <h2 class=" wow fadeInLeft">Danh mục</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            
                        @foreach($dsloaisp as $lsp)

                            <div class="panel panel-default wow fadeInLeft">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian" href="#LS{{$lsp->id}}">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                            {{$lsp->ten}}
                                        </a>
                                    </h4>
                                </div>
                                <div id="LS{{$lsp->id}}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                        <?php $dshangsx = $lsp->getAllHangsxByIdparent($lsp->id); ?>
                                        @foreach($dshangsx as $hsx)
                                            <li><a href="./tim-kiem/{{$lsp->ten.' '.$hsx->ten}}">{{$hsx->ten}}</a></li>
                                        @endforeach    
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        @endforeach

                            <div class="panel panel-default wow fadeInLeft">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian" href="#LS{{$lsp->id}}">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                            Tin tức
                                        </a>
                                    </h4>
                                </div>
                                <div id="LS{{$lsp->id}}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                            <li><a href="bai-viet-list">Bài viết</a></li>
                                            <li><a href="bai-viet-list">Video</a></li> 
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            
                        </div><!--/category-products-->





                        <div class="left-sidebar hidden-xs" id="tintuc">
                            <!--brands_products-->
                            <h2 class=" wow fadeInLeft"><a href="bai-viet-list">Bài viết</a></h2>
                            <div class="brands-name" style="padding: 0">
                                <ul style="padding: 0; margin: 0">
                                
                                <?php $count = 0; ?>
                                
                                @foreach($dsbaiviet as $bv)
                                    @if(++$count <= 6)
                                    
                                    <li style="padding: 5px" class=" wow fadeInLeft">
                                        <img src="upload/baiviet/{{$bv->hinhanh}}" width="20%"/>
                                        <a href="bai-viet/{{$bv->id}}/{{changeTitle($bv->tieude)}}.html" style="color: #000; padding-left: 5px">
                                            {{$bv->tieude}}
                                        </a>
                                    </li>
                                    
                                    @endif
                                @endforeach
                                </ul>
                            </div>
                        </div>




                        <div class="left-sidebar hidden-xs">
                            <!--brands_products-->
                            <h2 class=" wow fadeInLeft" style="margin-top: 30px"><a href="video-list">Video</a></h2>
                            <div class="brands-name wow fadeInLeft" style="padding: 0">
                                <ul style="padding: 0; margin: 0">
                                
                                <?php $count = 0; ?>
                                
                                @foreach($dsvideo as $vd)
                                    @if(++$count <= 6)
                                    
                                    <li style="padding: 5px" class=" wow fadeInLeft">
                                        <img src="upload/video/{{$vd->hinhanh}}" width="20%"/>
                                        <a href="video/{{$vd->id}}/{{changeTitle($vd->ten)}}.html" style="color: #000; padding-left: 5px">
                                            {{$vd->ten}}
                                        </a>
                                    </li>
                                    
                                    @endif
                                @endforeach
                                </ul>
                            </div>
                        </div>



                    
                        
                        <div class="shipping text-center wow fadeInLeft hidden-xs"><!--shipping-->
                            <img src="images/home/shipping.jpg" alt="" />
                        </div><!--/shipping-->




                        @include("layout.facebook-fanpage")



                    </div>
                </div>