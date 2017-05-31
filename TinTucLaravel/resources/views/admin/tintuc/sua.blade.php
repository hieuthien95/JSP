<?php 
use App\User;
?>

@extends('admin.layout.index')

@section('content')		
		<!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Tin tức
                            <small>Sửa</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:20px">
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

                        <form action="admin/tintuc/sua/{{$tintuc->id}}" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="_token" value="{{csrf_token()}}">

                            <div class="form-group">
                                <label>Tiêu đề</label>
                                <input class="form-control" name="TieuDe" placeholder="Nhập tiêu đề" value="{{$tintuc->TieuDe}}" />
                            </div>

<script type="text/javascript" src="admin_asset/ckeditor/ckeditor.js"></script>

                            <div class="form-group">
                                <label>Tóm tắt</label>
                                <textarea class="form-control" name="TomTat" rows="3">{{$tintuc->TomTat}}</textarea>
                            </div>

                            <div class="form-group">
                                <label>Nội dung</label>
                                <textarea class="form-control ckeditor" name="NoiDung" rows="3">{{$tintuc->NoiDung}}</textarea>
                            </div>

                            <div class="form-group">
                                <label>Hình</label><br>                                
                                <img width="100" src="upload/tintuc/{{$tintuc->Hinh}}">
                                <input type="file" name="Hinh" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>Nổi bật</label><br>
                                <label class="radio-inline">
                                    <input value="1" {{$tintuc->NoiBat==1?"checked=''":""}} type="radio" name="NoiBat" >Có
                                </label>
                                <label class="radio-inline">
                                    <input value="0"  {{$tintuc->NoiBat==0?"checked=''":""}} type="radio" name="NoiBat" >Không
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

                            <button type="submit" class="btn btn-default">Sửa</button>
                        <form>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Comment
                            <small>Danh sách</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->


                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
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
                    <thead>
                        <tr align="center">
                            <th>ID</th>
                            <th>Người dùng</th>
                            <th>Nội dung</th>
                            <th>Ngày đăng</th>
                            <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody>

                       @foreach($comment as $cm)

                            <tr class="odd gradeX" align="center">
                                <td>{{$cm->id}}</td>
                                <td>{{User::find($cm->idUser)->name}}</td>
                                <td>{{$cm->NoiDung}}</td>
                                <td>{{$cm->created_at}}</td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="admin/comment/xoa/{{$cm->id}}/{{$tintuc->id}}"> Xóa</a></td>
                            </tr>

                        @endforeach
                            
                    </tbody>
                </table>

                


            </div>
            <!-- /.container-fluid -->
        </div>
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