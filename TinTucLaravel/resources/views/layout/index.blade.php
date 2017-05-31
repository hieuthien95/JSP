<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>@yield('title')</title>

    <base href="{{asset('')}}">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
    <link href="css/my.css" rel="stylesheet">

    <link rel='stylesheet' href='https://cdn.rawgit.com/daneden/animate.css/v3.1.0/animate.min.css'>
    <script src='https://cdn.rawgit.com/matthieua/WOW/1.0.1/dist/wow.min.js'></script>

    <script>
        new WOW().init();
    </script>

    <!-- sá»± kiÃªn scroll -->
    <script>
        $(function() {
            $('a[href*=#]:not([href=#])').click(function() {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.substr(1) +']');
                if (target.length) {
                    $('html,body').animate({
                      scrollTop: target.offset().top
                    }, 2000);
                    return false;
                }
            });
        });
    </script>
<!-- /cá»§a phÃ¢n trang -->

    @yield('css')

</head>

<body>

    @include('layout.header')

    
    @yield('content')


    @include('layout.footer')
    
    <!-- end Footer -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/my.js"></script>

	@yield('script')

</body>

</html>
