<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

        <title>Aquarius - responsive admin panel</title>

        <link rel="icon" type="image/ico" href="favicon.ico"/>

        <link href="css/stylesheets.css" rel="stylesheet" type="text/css" />
        <link rel='stylesheet' type='text/css' href='css/fullcalendar.print.css' media='print' />

        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js'></script>
        <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js'></script>
        <script type='text/javascript' src='js/plugins/jquery/jquery.mousewheel.min.js'></script>

        <script type='text/javascript' src='js/plugins/cookie/jquery.cookies.2.2.0.min.js'></script>

        <script type='text/javascript' src='js/plugins/bootstrap.min.js'></script>

        <script type='text/javascript' src='js/plugins/charts/excanvas.min.js'></script>
        <script type='text/javascript' src='js/plugins/charts/jquery.flot.js'></script>    
        <script type='text/javascript' src='js/plugins/charts/jquery.flot.stack.js'></script>    
        <script type='text/javascript' src='js/plugins/charts/jquery.flot.pie.js'></script>
        <script type='text/javascript' src='js/plugins/charts/jquery.flot.resize.js'></script>

        <script type='text/javascript' src='js/plugins/sparklines/jquery.sparkline.min.js'></script>

        <script type='text/javascript' src='js/plugins/fullcalendar/fullcalendar.min.js'></script>

        <script type='text/javascript' src='js/plugins/select2/select2.min.js'></script>

        <script type='text/javascript' src='js/plugins/uniform/uniform.js'></script>

        <script type='text/javascript' src='js/plugins/maskedinput/jquery.maskedinput-1.3.min.js'></script>

        <script type='text/javascript' src='js/plugins/validation/languages/jquery.validationEngine-en.js' charset='utf-8'></script>
        <script type='text/javascript' src='js/plugins/validation/jquery.validationEngine.js' charset='utf-8'></script>

        <script type='text/javascript' src='js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js'></script>
        <script type='text/javascript' src='js/plugins/animatedprogressbar/animated_progressbar.js'></script>

        <script type='text/javascript' src='js/plugins/qtip/jquery.qtip-1.0.0-rc3.min.js'></script>

        <script type='text/javascript' src='js/plugins/cleditor/jquery.cleditor.js'></script>

        <script type='text/javascript' src='js/plugins/dataTables/jquery.dataTables.min.js'></script>    

        <script type='text/javascript' src='js/plugins/fancybox/jquery.fancybox.pack.js'></script>

        <script type='text/javascript' src='js/cookies.js'></script>
        <script type='text/javascript' src='js/actions.js'></script>
        <script type='text/javascript' src='js/charts.js'></script>
        <script type='text/javascript' src='js/plugins.js'></script>

    </head>
    <body>

        <div class="header">
            <a class="logo" href="index.html"><img src="img/logo.png" alt="Aquarius -  responsive admin panel" title="Aquarius -  responsive admin panel"/></a>
            <ul class="header_menu">
                <li class="list_icon"><a href="#">&nbsp;</a></li>
            </ul>    
        </div>

        <div class="menu">       

            <ul class="navigation">            
                <li class="active">
                    <a href="index.html">
                        <span class="isw-grid"></span><span class="text">Home</span>
                    </a>
                </li>
                <li class="openable">
                    <a href="#">
                        <span class="isw-list"></span><span class="text">UI elements</span>
                    </a>
                    <ul>
                        <li>
                            <a href="ui.html">
                                <span class="icon-th"></span><span class="text">UI Elements</span>
                            </a>                  
                        </li>                        
                    </ul>                
                </li>                                           
                <li class="openable">
                    <a href="#">
                        <span class="isw-zoom"></span><span class="text">Other</span>                    
                    </a>
                    <ul>
                        <li>
                            <a href="gallery.html">
                                <span class="icon-picture"></span><span class="text">Gallery</span>
                            </a>
                        </li>                   
                    </ul>
                </li>                                              
            </ul>

            <div class="dr"><span></span></div>

            <div class="widget-fluid">
                <div id="menuDatepicker"></div>
            </div>


        </div>

        <div class="content">


            <div class="breadLine">

                <ul class="breadcrumb">
                    <li><a href="#">Simple Admin</a> <span class="divider">></span></li>                
                    <li class="active">Dashboard</li>
                </ul>

                <ul class="buttons">
                    <li>
                        <a href="#" class="link_bcPopupList"><span class="icon-user"></span><span class="text">Users list</span></a>

                        <div id="bcPopupList" class="popup">
                            <div class="head">
                                <div class="arrow"></div>
                                <span class="isw-users"></span>
                                <span class="name">List users</span>
                                <div class="clear"></div>
                            </div>
                            <div class="body-fluid users">

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/aqvatarius.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Aqvatarius</a>                                    
                                        <span>online</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/olga.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Olga</a>                                
                                        <span>online</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>                        

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/alexey.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Alexey</a>  
                                        <span>online</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>                              

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/dmitry.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Dmitry</a>                                    
                                        <span>online</span>
                                    </div>
                                    <div class="clear"></div>
                                </div>                         

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/helen.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Helen</a>                                                                        
                                    </div>
                                    <div class="clear"></div>
                                </div>                                  

                                <div class="item">
                                    <div class="image"><a href="#"><img src="img/users/alexander.jpg" width="32"/></a></div>
                                    <div class="info">
                                        <a href="#" class="name">Alexander</a>                                                                        
                                    </div>
                                    <div class="clear"></div>
                                </div>                                  

                            </div>
                            <div class="footer">
                                <button class="btn" type="button">Add new</button>
                                <button class="btn btn-danger link_bcPopupList" type="button">Close</button>
                            </div>
                        </div>                    

                    </li>                
                    <li>
                        <a href="#" class="link_bcPopupSearch"><span class="icon-search"></span><span class="text">Search</span></a>

                        <div id="bcPopupSearch" class="popup">
                            <div class="head">
                                <div class="arrow"></div>
                                <span class="isw-zoom"></span>
                                <span class="name">Search</span>
                                <div class="clear"></div>
                            </div>
                            <div class="body search">
                                <input type="text" placeholder="Some text for search..." name="search"/>
                            </div>
                            <div class="footer">
                                <button class="btn" type="button">Search</button>
                                <button class="btn btn-danger link_bcPopupSearch" type="button">Close</button>
                            </div>
                        </div>                
                    </li>
                </ul>

            </div>

            <div class="workplace">       
                <div class="row-fluid">

                    <div class="span12">                    
                        <div class="head">
                            <div class="isw-grid"></div>
                            <h1>Sortable table</h1>                               
                            <div class="clear"></div>
                        </div>
                        <div class="block-fluid table-sorting">
                            <table cellpadding="0" cellspacing="0" width="100%" class="table" id="tSortable">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" name="checkall"/></th>
                                        <th width="25%">ID</th>
                                        <th width="25%">Name</th>
                                        <th width="25%">E-mail</th>
                                        <th width="25%">Phone</th>                                    
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input type="checkbox" name="checkbox"/></td>
                                        <td>101</td>
                                        <td>Dmitry</td>
                                        <td>dmitry@domain.com</td>
                                        <td>+98(765)432-10-98</td>                                    
                                    </tr>
                                </tbody>
                            </table>
                            <div class="clear"></div>
                        </div>
                    </div>                                

                </div>      

            </div>

        </div>   

    </body>
</html>
