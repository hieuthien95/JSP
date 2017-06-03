                        <div class="col-lg-3 col-md-4 col-sm-4 wow fadeInUp">
                            <div class="product-image-wrapper">
                                <div class="single-products" style="">
                                    <div class="productinfo text-center" style="padding: 10px; height: 100%">
                                        <img src="upload/sanpham/{{$sp->hinhanh}}" style="width: 80%" />
                                        <h2 style="font-size: 18px">{{number_format($sp->gia)}}đ </h2>
                                        <p>{{$sp->hangsx.' '.$sp->ten}}</p>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <p>
                                                <b>Display: </b>{{$sp->manhinh}}</p>
                                            <p>
                                                <b>OS: </b>{{$sp->hdh}}</p>
                                            <p>
                                                <b>CPU: </b>{{$sp->cpu}}</p>
                                            <p>
                                                <b>Camera: </b>{{$sp->camera}}</p>
                                            <p>
                                                <b>Pin: </b>{{$sp->pin}}</p>
                                            <p>
                                                <b>KM: </b>{!!$sp->km!!}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a
                                            href="{!! url('add-to-cart', [$sp->id, base64_encode(url()->current())]) !!}"><i
                                                class="fa fa-shopping-cart"></i>Thêm</a></li>
                                        <li><a
                                            href="{!! url('add-to-so-sanh', [$sp->id, base64_encode(url()->current())]) !!}"><i
                                                class="fa fa-plus-square"></i>So sánh</a></li>
                                        <li><a
                                            href="product/{{$sp->id}}/{{changeTitle($sp->ten)}}">o
                                                o o</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>