                         
                                    <a href="product/{{$sp->id}}/{{changeTitle($sp->ten)}}">
                                    <div class="product-image-wrapper">
                                        <div class="single-products" style="padding: 10px">
                                            <div class="productinfo text-center">
                                                <img src="upload/sanpham/{{$sp->hinhanh}}" alt="" style="width: 60%"  />
                                                <h2>{{number_format($sp->gia)}} VNĐ</h2>
                                                <p>{{$sp->hangsx.' '.$sp->ten}}</p>
                                                <a href="{!! url('add-to-cart', [$sp->id, base64_encode(url()->current())]) !!}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    </a>
       