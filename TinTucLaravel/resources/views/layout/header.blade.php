	<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="background: url('image/header.jpg'); color: #fff !important">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a style="color: #fff"  class="navbar-brand" href="trangchu">Icon Club</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Giới thiệu</a>
                    </li>
                    <li>
                        <a href="lienhe">Liên hệ</a>
                    </li>
                </ul>

			    <ul class="nav navbar-nav pull-right">
                    
                    <?php if(Auth::user()) { ?>

                    <li>
                    	<a href="nguoidung">
                    		<span class ="glyphicon glyphicon-user"></span>
                    		{{Auth::user()->name}}
                    	</a>
                    </li>

                    <li>
                    	<a href="dangxuat">Đăng xuất</a>
                    </li>

                    <?php } else { ?>

                    <li>
                        <a style="color: #fff"  href="dangnhap">Đăng nhập</a>
                    </li>

                    <li>
                        <a style="color: #fff" href="dangky">Đăng ký</a>
                    </li>

                    <?php } ?>
                    
                </ul>

                <form class="navbar-form navbar-right" action="timkiem" method="POST">

                    <input type="hidden" name="_token" value="{{csrf_token()}}">

                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="Từ khóa cần tìm" name="TuKhoa">
                    </div>
                    <!-- button type="submit" class="btn btn-default">Tìm</button -->
                </form>

            </div>


            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>