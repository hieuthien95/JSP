<?php 
use App\TheLoai;
use App\LoaiTin;
?>

@extends('admin.layout.index')

@section('content')     
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Tin tức
                            <small>Danh sách</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
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

                        @if(session('loi'))
                            <div class="col-lg-12 alert alert-danger">
                                {{session('loi')}}
                            </div>
                        @endif
                        <thead>
                            <tr align="center">
                                <th>ID</th>
                                <th>Tiêu đề</th>
                                <th>Tóm tắt</th>
                                <th>Thể loại</th>
                                <th>Loại tin</th>
                                <th>Xem</th>
                                <th>Nổi bật</th>
                                <th>Xóa</th>
                                <th>Sửa</th>
                            </tr>
                        </thead>
                        <tbody>

                        @foreach($tintuc as $tt)
                            <?php 
                            $tenLoaiTin = LoaiTin::find($tt->idLoaiTin)->Ten;
                            $tenTheLoai = TheLoai::find(LoaiTin::find($tt->idLoaiTin)->idTheLoai)->Ten;
                            ?>
                            <tr class="odd gradeX" align="center">
                                <td>{{$tt->id}}</td>
                                <td>
                                    {{$tt->TieuDe}}
                                    <br><img width="50" src="upload/tintuc/{{$tt->Hinh}}">
                                </td>
                                <td>{{$tt->TomTat}}</td>
                                <td>{{$tenTheLoai}}</td>
                                <td>{{$tenLoaiTin}}</td>
                                <td>{{$tt->SoLuotXem}}</td>
                                <td>{{$tt->NoiBat==1?"Có":"Không"}}</td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="admin/tintuc/xoa/{{$tt->id}}"> Xóa</a></td>
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="admin/tintuc/sua/{{$tt->id}}">Sửa</a></td>
                            </tr>

                        @endforeach
                            
                        </tbody>
                    </table>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
@endsection