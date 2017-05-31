<? 
include("view/editor/editor1.php");
?>

<div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
    <form method="get" style="margin-top:15px" autocomplete="off">
        <div class="input-group">
            <input type="text" class="form-control" name="search-product" id="search-keyword"/>
            <span class="input-group-btn">
                <input type="submit" class="btn btn-default" name="ac" value="Tìm" />
            </span>
        </div><!-- /input-group -->
    </form>
    <div id="searchresultdata" class="faq-articles"> </div>
    
    <h4 align="center" style="margin-top: 20px"><strong>THÊM SẢN PHẨM</strong></h4>
    
    <form action="view/modules/hanghoa/xuly.php" method="post" enctype="multipart/form-data" > 
        <div>
            <table width="100%" border="0">
              <tr height="40px">
                <td>
                    <select name="loaisp">
                        <option value="Điện thoại" selected="selected">Điện thoại</option>
                        <option value="Máy tính bảng">Máy tính bảng</option>
                        <option value="Laptop">Laptop</option>
                        <option value="Máy ảnh">Máy ảnh</option>
                        <option value="Phụ kiện">Phụ kiện</option>
                    </select>
                    
                    <select name="hangsx">
                        <?php
                            foreach($brandList as $brands)
                            {
                        ?>
                            <option value="<? echo $brands["tenhang"] ?>"><? echo $brands["tenhang"] ?></option>
                    
                        <? 	} ?>
                    </select>
                    
                    <select name="trangthai" style="float:right">
                        <option value="1" selected="selected">Hiển thị</option>
                        <option value="0">Không hiển thị</option>
                    </select>
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input placeholder="Tên máy" type="text" name="ten" id="ten" style="width:100%">
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input placeholder="Giá" type="text" name="gia" id="gia" style="width:100%">
                </td>
              </tr>
              <tr height="40px">
                <td>
                    Số lượng
                    <select name="sl" style="float:right">
                        <option value="Còn hàng" selected="selected">Còn hàng</option>
                        <option value="Hàng sắp về">Hàng sắp về</option>
                        <option value="Hết hàng">Hết hàng</option>
                        <option value="Sản phẩm không còn kinh doanh">Sản phẩm không còn kinh doanh</option>
                        <option value="Máy củ">Máy củ</option>
                    </select>
                </td>
              </tr>
              <tr height="40px">
                <td>
                    
                    <select name="camera">
                        <?php
                            foreach($cameraList as $camera)
                            {
                        ?>
                            <option value="<? echo $camera["phangiai"] ?>"><? echo $camera["phangiai"] ?></option>
                        <? } ?>
                    </select>
                    
                    
                    <select name="manhinh">
                        <?php
                            foreach($manHinhList as $manhinh)
                            {
                        ?>
                            <option value="<? echo $manhinh["manhinh"] ?>"><? echo $manhinh["manhinh"] ?></option>
                        <? } ?>
                        
                    </select>
                    
                    <select name="hdh" style="float:right">
                        <?php
                            foreach($hdhList as $hdh)
                            {
                        ?>
                            <option value="<? echo $hdh["tenhdh"] ?>"><? echo $hdh["tenhdh"] ?></option>
                        <? } ?>
                    </select>
                </td>
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input placeholder="CPU" type="text" name="cpu" id="cpu" style="width:100%">
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input placeholder="Pin" type="text" name="pin" id="pin" style="width:100%">
                </td>
              </tr>
              <tr height="40px">
                <td>
                    Thông tin khác
                    <textarea name="nhieuhon" style="width:100%"></textarea>
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <textarea name="km" style="width:100%"></textarea>
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input type="file" name="anhminhhoa" />
                </td>
              </tr>
              <tr height="40px">
                <td>
                    <input type="submit" name="them" id="them" value="  Thêm  ">
                    <input type="reset" name="reset" id="Reset" value="  Xoá  ">
                </td>
              </tr>
            </table>
        </div>
    </form>
</div>
