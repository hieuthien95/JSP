<%-- 
    Document   : single
    Created on : Dec 29, 2016, 12:10:36 PM
    Author     : hieut
--%>

<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bonfire a Ecommerce Category Flat Bootstarp Responsive Website Template | Single :: w3layouts</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <link rel="stylesheet" href="css/etalage.css">
        <script src="js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close').on('click', function (c) {
                    $('.message').fadeOut('slow', function (c) {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close1').on('click', function (c) {
                    $('.message1').fadeOut('slow', function (c) {
                        $('.message1').remove();
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="header">
            <div class="header-top">
                <div class="container">	
                    <div class="header-top-in">			
                        <div class="logo">
                            <a href="index.jsp"><img src="images/logo.png" alt=" " ></a>
                        </div>
                        <div class="header-in">
                            <ul class="icon1 sub-icon1">
                                <li  ><a href="wishlist.html">WISH LIST (0)</a> </li>
                                <li  ><a href="login.jsp">  MY ACCOUNT</a></li>
                                <li ><a href="#" > SHOPPING CART</a></li>
                                <li > <a href="checkout.html" >CHECKOUT</a> </li>	
                                <li><div class="cart">
                                        <a href="#" class="cart-in"> </a>
                                        <span> 0</span>
                                    </div>
                                    <ul class="sub-icon1 list">
                                        <h3>Recently added items(2)</h3>
                                        <div class="shopping_cart">
                                            <div class="cart_box">
                                                <div class="message">
                                                    <div class="alert-close"> </div> 
                                                    <div class="list_img"><img src="images/14.jpg" class="img-responsive" alt=""></div>
                                                    <div class="list_desc"><h4><a href="#">velit esse molestie</a></h4>1 x<span class="actual">
                                                            $12.00</span></div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                            <div class="cart_box1">
                                                <div class="message1">
                                                    <div class="alert-close1"> </div> 
                                                    <div class="list_img"><img src="images/15.jpg" class="img-responsive" alt=""></div>
                                                    <div class="list_desc"><h4><a href="#">velit esse molestie</a></h4>1 x<span class="actual">
                                                            $12.00</span></div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="total">
                                            <div class="total_left">CartSubtotal : </div>
                                            <div class="total_right">$250.00</div>
                                            <div class="clearfix"> </div>
                                        </div>
                                        <div class="login_buttons">
                                            <div class="check_button"><a href="checkout.html">Check out</a></div>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom">
                <div class="container">
                    <div class="h_menu4">
                        <a class="toggleMenu" href="#">Menu</a>
                        <ul class="nav">
                            <li class="active"><a href="index.jsp"><i> </i>Desktops</a></li>
                            <li ><a href="#" >Laptops & Notebooks</a>
                                <ul class="drop">
                                    <li><a href="products.jsp">Sony(2)</a></li>
                                    <li><a href="products.jsp">Android(4)</a></li>
                                    <li><a href="products.jsp">Apple(7)</a></li>
                                    <li><a href="products.jsp">Acer(53)</a></li>
                                    <li><a href="products.jsp">HP(78)</a></li>
                                    <li><a href="products.jsp">Intel(5)</a></li>
                                </ul>
                            </li> 						
                            <li><a href="products.jsp" >  Tablets</a></li>            
                            <li><a href="products.jsp" >Components</a></li>						  				 
                            <li><a href="products.jsp" >Software</a></li>
                            <li><a href="products.jsp" >Phones & PDAs </a></li>
                            <li><a href="products.jsp" >  Cameras  </a></li>
                            <li><a href="contact.jsp" >Contact </a></li>

                        </ul>
                        <script type="text/javascript" src="js/nav.js"></script>
                    </div>
                </div>
            </div>
            <div class="header-bottom-in">
                <div class="container">
                    <div class="header-bottom-on">
                        <p class="wel"><a href="#">Welcome visitor you can login or create an account.</a></p>
                        <div class="header-can">
                            <ul class="social-in">
                                <li><a href="#"><i> </i></a></li>
                                <li><a href="#"><i class="facebook"> </i></a></li>
                                <li><a href="#"><i class="twitter"> </i></a></li>					
                                <li><a href="#"><i class="skype"> </i></a></li>
                            </ul>	
                            <div class="down-top">		
                                <select class="in-drop">
                                    <option value="Dollars" class="in-of">Dollars</option>
                                    <option value="Euro" class="in-of">Euro</option>
                                    <option value="Yen" class="in-of">Yen</option>
                                </select>
                            </div>
                            <div class="search">
                                <form>
                                    <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = '';
                                            }">
                                    <input type="submit" value="">
                                </form>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
        <!---->
        <%
            ProductDAO dao = new ProductDAO();
            String product_id = "";
            Product product = new Product();
            if (request.getParameter("productID") != null) {
                product_id = request.getParameter("productID");
                product = dao.getProduct(Long.parseLong(product_id));
            }
        %>
        <div class="container">
            <div class="single">
                <div class="col-md-9 top-in-single">
                    <div class="col-md-5 single-top">	
                        <ul id="etalage">
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image img-responsive" src="<%=product.getProductImage()%>" alt="" >
                                    <img class="etalage_source_image img-responsive" src="<%=product.getProductImage()%>" alt="" >
                                </a>
                            </li>
                        </ul>

                    </div>	
                    <div class="col-md-7 single-top-in">
                        <div class="single-para">
                            <h4><%=product.getProductName()%></h4>
                            <div class="para-grid">
                                <span  class="add-to">$<%=product.getProductPrice()%></span>
                                <a href="#" class="hvr-shutter-in-vertical cart-to">Add to Cart</a>					
                                <div class="clearfix"></div>
                            </div>
                            <h5>100 items in stock</h5>
                            <div class="available">
                                <h6>Available Options :</h6>
                                <ul>
                                    <li>Color:
                                        <select>
                                            <option>Silver</option>
                                            <option>Black</option>
                                            <option>Dark Black</option>
                                            <option>Red</option>
                                        </select></li>
                                    <li>Size:<select>
                                            <option>Large</option>
                                            <option>Medium</option>
                                            <option>small</option>
                                            <option>Large</option>
                                            <option>small</option>
                                        </select></li>
                                    <li>Quality:<select>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select></li>
                                </ul>
                            </div>
                            <p><%=product.getProductDescription()%></p>

                            <a href="#" class="hvr-shutter-in-vertical ">More details</a>

                        </div>
                    </div>
                    <div class="clearfix"> </div>
                    <div class="content-top-in">
                        <div class="col-md-4 top-single">
                            <div class="col-md">
                                <img  src="images/pic8.jpg" alt="" />	
                                <div class="top-content">
                                    <h5>Mascot Kitty - White</h5>
                                    <div class="white">
                                        <a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>							
                            </div>
                        </div>
                        <div class="col-md-4 top-single">
                            <div class="col-md">
                                <img  src="images/pic9.jpg" alt="" />	
                                <div class="top-content">
                                    <h5>Mascot Kitty - White</h5>
                                    <div class="white">
                                        <a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>							
                            </div>
                        </div>
                        <div class="col-md-4 top-single-in">
                            <div class="col-md">
                                <img  src="images/pic10.jpg" alt="" />	
                                <div class="top-content">
                                    <h5>Mascot Kitty - White</h5>
                                    <div class="white">
                                        <a href="#" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
                                        <p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>							
                            </div>
                        </div>

                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="single-bottom">
                        <h4>Categories</h4>
                        <ul>
                            <li><a href="#"><i> </i>Fusce feugiat</a></li>
                            <li><a href="#"><i> </i>Mascot Kitty</a></li>
                            <li><a href="#"><i> </i>Fusce feugiat</a></li>
                            <li><a href="#"><i> </i>Mascot Kitty</a></li>
                            <li><a href="#"><i> </i>Fusce feugiat</a></li>
                        </ul>
                    </div>
                    <div class="single-bottom">
                        <h4>Product Categories</h4>
                        <ul>
                            <li><a href="#"><i> </i>feugiat(5)</a></li>
                            <li><a href="#"><i> </i>Fusce (4)</a></li>
                            <li><a href="#"><i> </i> feugiat (4)</a></li>
                            <li><a href="#"><i> </i>Fusce (4)</a></li>
                            <li><a href="#"><i> </i> feugiat(2)</a></li>
                        </ul>
                    </div>
                    <div class="single-bottom">
                        <h4>Product Categories</h4>
                        <div class="product">
                            <img class="img-responsive fashion" src="images/st1.jpg" alt="">
                            <div class="grid-product">
                                <a href="#" class="elit">Consectetuer adipiscing elit</a>
                                <span class="price price-in"><small>$500.00</small> $400.00</span>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="product">
                            <img class="img-responsive fashion" src="images/st2.jpg" alt="">
                            <div class="grid-product">
                                <a href="#" class="elit">Consectetuer adipiscing elit</a>
                                <span class="price price-in"><small>$500.00</small> $400.00</span>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="product">
                            <img class="img-responsive fashion" src="images/st3.jpg" alt="">
                            <div class="grid-product">
                                <a href="#" class="elit">Consectetuer adipiscing elit</a>
                                <span class="price price-in"><small>$500.00</small> $400.00</span>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>

        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '168660906912545',
                    xfbml: true,
                    version: 'v2.7'
                });
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <div class="fb-comments" data-href="http://www.thiensu.com/WebDemo/?ac=thongtin" 
             data-colorscheme="light" data-numposts="5" data-width="100%">
        </div>
        <jsp:include page ="footer.jsp"></jsp:include>
    </body>
</html>
