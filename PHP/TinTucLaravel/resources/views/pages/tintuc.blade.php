   
   <?php 
        use App\User;
   ?>

    @extends('layout.index')

    @section('title', 'Tin tức')

    @section('content')
    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <!-- Blog Post Content Column -->
            <div class="col-lg-9">

                <!-- Blog Post -->

                <!-- Title -->
                <h1>{{$tintuc->TieuDe}}</h1>

                <!-- Author -->
                <p class="lead">
                    by <a href="#"> Admin </a>
                </p>

                <!-- Preview Image -->
                <img class="img-responsive" src="upload/tintuc/{{$tintuc->Hinh}}" alt="">

                <!-- Date/Time -->
                <p><span class="glyphicon glyphicon-time"></span> Posted on {{$tintuc->created_at}}</p>
                <hr>

                <!-- Post Content -->
                <p class="lead">{!!$tintuc->NoiDung!!}</p>

                <hr>

                <!-- Blog Comments -->

                <?php if(Auth::user()) { ?>
                <!-- Comments Form -->
                <div class="well">
                    <h4>Viết bình luận ...<span class="glyphicon glyphicon-pencil"></span></h4>

                    <form method="Post" action="comment/{{$tintuc->id}}">
                        <input type="hidden" name="_token" value="{{csrf_token()}}">
                        
                        <div class="form-group">
                            <textarea class="form-control" rows="3" name="NoiDung"></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">Gửi</button>
                    </form>

                </div>
                        @if(count($errors) > 0)
                            <div class="col-lg-12 alert alert-danger">
                                @foreach ($errors->all() as $err)
                                        {{$err}}<br>
                                @endforeach
                            </div>
                        @endif

                        @if(session('thongbao'))
                            <div class="col-lg-12 alert alert-success">
                                {{session('thongbao')}}
                            </div>
                        @endif

                        @if(session('loi'))
                            <div class="col-lg-12 alert alert-danger">
                                {{session('loi')}}
                            </div>
                        @endif

                <?php } ?>

                <hr>

                <!-- Posted Comments -->

                <!-- Comment -->

                @foreach($tintuc->comment as $cm)

                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="upload/user/{{User::find($cm->idUser)->Hinh}}" alt="" width="64">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">{{User::find($cm->idUser)->name}}
                            <small>{{$cm->created_at}}</small>
                        </h4>
                        {{$cm->NoiDung}}
                    </div>
                </div>

                @endforeach

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-3">

                <div class="panel panel-default">
                    <div class="panel-heading"><b>Tin liên quan</b></div>
                    <div class="panel-body">

                        <!-- item -->

                        @foreach($tinlienquan as $tlq)

                        <div class="row" style="margin-top: 10px;">
                            <div class="col-md-5">
                                <a href="tintuc/{{$tlq->id}}/{{$tlq->TieuDeKhongDau}}">
                                    <img class="img-responsive" src="upload/tintuc/{{$tlq->Hinh}}" alt="">
                                </a>
                            </div>
                            <div class="col-md-7">
                                <a href="tintuc/{{$tlq->id}}/{{$tlq->TieuDeKhongDau}}"><b>{{$tlq->TieuDe}}</b></a>
                            </div>
                        </div>
                        <!-- end item -->

                        @endforeach

                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading"><b>Tin nổi bật</b></div>
                    <div class="panel-body">

                        <!-- item -->

                        @foreach($tinnoibat as $tnb)

                        <div class="row" style="margin-top: 10px;">
                            <div class="col-md-5">
                                <a href="tintuc/{{$tnb->id}}/-{{$tnb->TieuDeKhongDau}}">
                                    <img class="img-responsive" src="upload/tintuc/{{$tnb->Hinh}}" alt="">
                                </a>
                            </div>
                            <div class="col-md-7">
                                <a href="tintuc/{{$tnb->id}}/-{{$tnb->TieuDeKhongDau}}"><b>{{$tnb->TieuDe}}</b></a>
                            </div>
                        </div>

                        @endforeach

                        <!-- end item -->
                    </div>
                </div>
                
            </div>

        </div>
        <!-- /.row -->
    </div>
    <!-- end Page Content -->
    @endsection