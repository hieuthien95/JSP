			<div class="col-lg-3 col-md-4  col-sm-4">
                <ul class="list-group" id="menu">

                    @foreach($theloai as $tl)

                    <li class="list-group-item menu1 wow fadeInLeft">
                    	<a href="#{{$tl->TenKhongDau}}">{{$tl->Ten}}</a>
                    </li>

                    <ul style="padding-left: 0">
                    @foreach($tl->loaitin as $lt)
                		<li class="list-group-item" style="background: #f4f4f4">
                			<a href="loaitin/{{$lt->id}}/{{$lt->TenKhongDau}}.html">{{$lt->Ten}}</a>
                		</li>
                    @endforeach
                    </ul>

                    @endforeach

                </ul>

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