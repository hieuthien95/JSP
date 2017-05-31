@extends('admin.layout.index')

@section('content')     
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Tin tức
                            <small>Thêm</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        @if(count($errors) > 0)
                            <div class="col-lg-12 alert alert-danger">
                                @foreach ($errors->all() as $err)
                                        {{$err}}<br>
                                @endforeach
                            </div>
                        @endif

                        @if(session('thongbao'))
                            <div class="col-lg-12 alert alert-success">
                                {{session('thongbao')}}
                            </div>
                        @endif

                        @if(session('loi'))
                            <div class="col-lg-12 alert alert-danger">
                                {{session('loi')}}
                            </div>
                        @endif
                        
                        <form action="admin/tintuc/them" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="_token" value="{{csrf_token()}}">

                            <div class="form-group">
                                <label>Tiêu đề</label>
                                <input class="form-control" name="TieuDe" placeholder="Nhập tiêu đề" />
                            </div>

<script type="text/javascript" src="admin_asset/ckeditor/ckeditor.js"></script>

                            <div class="form-group">
                                <label>Tóm tắt</label>
                                <textarea class="form-control" name="TomTat" rows="3"></textarea>
                            </div>

                            <div class="form-group">
                                <label>Nội dung</label>
                                <textarea class="form-control ckeditor" name="NoiDung" rows="3"></textarea>
                            </div>

                            <div class="form-group">
                                <label>Hình</label>
                                <input type="file" name="Hinh" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>Nổi bật</label><br>
                                <label class="radio-inline">
                                    <input name="NoiBat" value="1" checked="" type="radio">Có
                                </label>
                                <label class="radio-inline">
                                    <input name="NoiBat" value="0" type="radio">Không
                                </label>
                            </div>

                            <div class="form-group">
                                <label>Thể loại</label>
                                <select id="TheLoai" name="TheLoai" class="form-control">
                                @foreach($theloai as $tl)
                                    <option value="{{$tl->id}}">{{$tl->Ten}}</option>
                                @endforeach
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Loại tin</label>
                                <select id="LoaiTin" name="LoaiTin" class="form-control">
                                @foreach($loaitin as $lt)
                                    <option value="{{$lt->id}}">{{$lt->Ten}}</option>
                                @endforeach
                                </select>
                            </div>

                            <button type="submit" class="btn btn-default">Thêm</button>
                        <form>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
@endsection

@section('script')
    <script type="text/javascript">
        $(document) .ready(function(){
            $("#TheLoai").change(function(){
                var idTheLoai = $(this).val();

                $.get("admin/ajax/loaitin/" + idTheLoai, function(data){
                    $("#LoaiTin").html(data);
                });
            });
        });     
    </script>
@endsection