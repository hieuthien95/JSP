	<header id="header"><!--header-->
        <div class="header_top" style="background: url('images/header.jpg');"><!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-phone" style="color: #FFF"></i> 01653990370</a></li>
                                <li><a href="http://www.thientdt.esy.es/congnghe/"
                                    style="color: #FFF"><i class="fa fa-envelope"
                                        style="color: #FFF"></i> Admin thientdt.esy.es</a></li>
                            </ul>

                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="https://www.facebook.com/thien.hieu.tdt" style="color: #FFF"><i
                                        class="fa fa-facebook"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-twitter"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-linkedin"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-dribbble"></i></a></li>
                                <li><a href="#" style="color: #FFF"><i
                                        class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header_top-->

        <div class="header-middle" style="background: #F5F5F5">
            <!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="logo pull-left">
                            <a href="./"><img src="images/logo.png" alt="" height="40"  /></a>
                        </div>


                        

                        <!-- Tìm kiếm -->

                        <script src="js/my-tim-kiem.js"></script>
                        <!-- kem theo rout ajaxTimKiem -->
                        
                        <form action="postTimKiem" name="frmSearch" method="post" style="position: relative;" class="hidden-xs">
                            <input type="hidden" name="_token" value="{{ csrf_token() }}">
                            
                            <div class="search_box pull-right">
                                <input type="text" name="tukhoa" autocomplete="off" placeholder="Tìm kiếm" onkeyup="search()"/>
                            </div>

                            <!-- nơi hiện kết quả -->
                            <span id="valueSearch"
                                style="position: absolute; right: 0; background: #FFF; z-index: 9999; top: 40px; box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);">
                            </span>
                        </form>

                        <!-- /tìm kiếm -->





                    </div>
                    

                    <div class="col-sm-6 col-xs-12" style="padding: 0">

                        <div class="shop-menu pull-right">

                            <!-- Tìm kiếm -->

                            <form action="postTimKiem" name="frmSearch2" method="post" style="position: relative;" class="visible-xs col-xs-12">
                                <input type="hidden" name="_token" value="{{ csrf_token() }}">
                                
                                <div class="input-group">
                                    <input type="text" class="form-control" name="tukhoa" onkeyup="search2()" 
                                        style="margin-top: 10px;" autocomplete="off" />
                                    <span class="input-group-btn"> 
                                        <input type="submit" class="btn btn-default" value="Tìm" style="margin-top: 10px;" />
                                    </span>
                                </div>

                                <!-- nơi hiện kết quả -->
                                <span id="valueSearch2"
                                    style="position: absolute; right: 0; background: #FFF; z-index: 9999; top: 40px; box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);">
                                </span>
                            </form>

                            <!-- /tìm kiếm -->

                            <ul class="nav navbar-nav">
                                @if(Cart::instance('shopping')->count()>0)
                                    <li><a href="./checkout"><i class="fa fa-crosshairs"></i> Thanh toán</a></li>
                                    <li><a href="./cart"><i class="fa fa-shopping-cart"></i> Giỏ hàng({{Cart::instance('shopping')->count()}})</a></li>
                                @endif
                                                
                                @if(Auth::user())
                                    <li><a href="./profile"> <i class="fa fa-user"></i>{{Auth::user()->name}}</a></li>
                                @else
                                    <li><a href="./login"><i class="fa fa-lock"></i>Đăng nhập</a></li>
                                @endif
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    
        <div class="header-bottom hidden-xs"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li><a href="#sanpham" class="active">Sản phẩm</a></li>
                                @foreach($dsloaisp as $lsp)
                                <li class="dropdown"><a href="./tim-kiem/{{$lsp->ten}}">{{$lsp->ten}}<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                    
                                    <?php $dshangsx = $lsp->getAllHangsxByIdparent($lsp->id); ?>
                                    @foreach($dshangsx as $hsx)
                                        <li><a href="./tim-kiem/{{$lsp->ten.' '.$hsx->ten}}">{{$hsx->ten}}</a></li>
                                    @endforeach       
                                    </ul>
                                </li> 
                                @endforeach

                                <li class="dropdown"><a href="#tintuc">Tin tức<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="bai-viet-list">Bài viết</a></li>
                                        <li><a href="video-list">Video</a></li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div><!--/header-bottom-->



                                                <div class="clearfix"></div>
                                                @if(count($errors) > 0)
                                                    <div class="col-lg-12 alert alert-danger" align="center">
                                                        @foreach ($errors->all() as $err)
                                                            {{$err}}<br>
                                                        @endforeach
                                                    </div>
                                                @endif

                                                @if(session('success'))
                                                    <div class="col-lg-12 alert alert-success" align="center">
                                                        {{session('success')}}
                                                    </div>
                                                @endif

                                                @if(session('error'))
                                                    <div class="col-lg-12 alert alert-danger" align="center">
                                                        {{session('error')}}
                                                    </div>
                                                @endif
                                                <div class="clearfix"></div>
    </header><!--/header-->
