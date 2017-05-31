@extends('admin.layout.index')

@section('content')     
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Thể loại
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
                        <form action="admin/loaitin/sua/{{$loaitin->id}}" method="POST">
                            <input type="hidden" name="_token" value="{{csrf_token()}}">
                            <div class="form-group">
                                <label>Thể loại: </label>
                                <select name="TheLoai" class="form-control">
                                <option value="{{$loaitin->idTheLoai}}">{{$loaitin->idTheLoai}}</option>
                                @foreach($theloai as $tl)
                                    <option value="{{$tl->id}}">{{$tl->Ten}}</option>
                                @endforeach
                                </select>

                                <label>Tên: </label>
                                <input class="form-control" name="Ten" placeholder="Nhập tên thể loại" value="{{$loaitin->Ten}}" />
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
@endsection