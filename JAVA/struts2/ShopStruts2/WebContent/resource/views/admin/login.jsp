<!DOCTYPE html>
<html lang="en">
<head>        
    
    
    
    <jsp:include page="layout/head.jsp"/>
    
    
    
</head>
<body>
    
    <div class="loginBox">        
        <div class="loginHead">
            <img src="img/logo.png" alt="Aquarius -  responsive admin panel" title="Aquarius -  responsive admin panel"/>
        </div>
        <form class="form-horizontal" action="index.html" method="POST">            
            <div class="control-group">
                <label for="inputEmail">Email</label>                
                <input type="text" id="inputEmail"/>
            </div>
            <div class="control-group">
                <label for="inputPassword">Password</label>                
                <input type="password" id="inputPassword"/>                
            </div>
            <div class="control-group" style="margin-bottom: 5px;">                
                <label class="checkbox"><input type="checkbox"> Remember me</label>                                                
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-block">Sign in</button>
            </div>
        </form>        
        
    </div>    
    
</body>
</html>
