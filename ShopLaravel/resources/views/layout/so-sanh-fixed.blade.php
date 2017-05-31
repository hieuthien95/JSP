
    <?php 
        $link = '';
        $sosanh = Cart::instance('sosanh')->content();
    ?>

    @if($sosanh!=null && sizeof($sosanh)>0)
        <div class="hidden-xs"
            style="position: fixed; z-index: 999999; bottom: 0; left: 0; 
            background: #fff; box-shadow: 4px -2px 10px rgba(0, 0, 0, 0.1); 
            padding: 5px; padding-right: 10px">
        
        @foreach ($sosanh as $sp)
            <?php $link .= $sp->id."/";  ?> 
    
            <div style="float: left; margin: 10px 15px 5px 10px">
                <img style="float: left; margin-right: 5px; height: 50px" src="upload/sanpham/{!! $sp->options['hinhanh'] !!}">
                <div style="float: left; height: 50px">
                    <h5 style="float: left; margin-top: 10; margin-bottom: 5px;">
                        <a href="product/{{$sp->id}}/{{changeTitle($sp->name)}}" style="color: black"> 
                            {{$sp->name}}
                        </a>
                    </h5>
                    <h5 style="float: left; margin-top: 10; margin-bottom: 5px; 
                        margin-left: 5px">
                        <a style="color: red; padding-left: 10px" href="{!! url('remove-in-so-sanh', [$sp->rowId, base64_encode(url()->current())]) !!}">o </a>
                    </h5>
                    <p>{{number_format($sp->price)}}đ</p>
                </div>
            </div>
        
        @endforeach

        <div class="clearfix"></div>
    
        <a style="position: absolute; top: 0; right: 5px" href="so-sanh/{{$link}}san-pham">
            <?php if(sizeof($sosanh)==2) {echo "o o o";}  ?> 
        </a>
        <a style="position: absolute; top: 0; right: 5px; color: red">
            <?php if(sizeof($sosanh)>2){echo 'x x x';} ?>
        </a>
    </div>
    
    @endif

