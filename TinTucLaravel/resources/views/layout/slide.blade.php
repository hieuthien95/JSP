    	<!-- slider -->
    	<div class="row carousel-holder wow fadeInDown">
            <div class="col-md-12">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                    <?php $i = 0 ?>
                    @foreach($slide as $sl)
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="{{$i++==0?"active":""}}"></li>
                    @endforeach
                    </ol>

                    <div class="carousel-inner">

                    <?php $i = 0 ?>
                    @foreach($slide as $sl)

                        <div class="item {{$i++==0?"active":""}}">
                            <img class="slide-image" src="upload/slide/{{$sl->Hinh}}" alt="">
                        </div>

                    @endforeach

                    </div>
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
        <!-- end slide -->

        <div class="space20"></div>