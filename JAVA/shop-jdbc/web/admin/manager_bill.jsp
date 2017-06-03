<%-- 
    Document   : manager_bill
    Created on : Jan 1, 2017, 1:30:05 PM
    Author     : hieut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 

                <div id="rightContent">
                    <h3>Tabel</h3>

                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">No</th>
                            <th class="data">Nama</th>
                            <th class="data">Email</th>
                            <th class="data">Telepon</th>
                            <th class="data" width="75px">Pilihan</th>
                        </tr>
                        <tr class="data">
                            <td class="data" width="30px">1</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data" width="75px">
                        <center>
                            <a href="#"><img src="../img/oke.png"></a>&nbsp;&nbsp;&nbsp;
                            <a href="#"><img src="../img/detail.png"></a>
                        </center>
                        </td>
                        </tr>
                    </table>
                </div>
                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>

    </body>
</html>
