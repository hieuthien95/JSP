@extends('admin.layout.index')

@section('content')     
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Category
                            <small>Add</small>
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
                        <form action="admin/slide/sua/{{$slide->id}}" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="_token" value="{{csrf_token()}}">

                            <div class="form-group">
                                <label>Tên</label>
                                <input class="form-control" name="Ten" placeholder="Nhập tên" value="{{$slide->Ten}}" />
                            </div>

                            <div class="form-group">
                                <label>Hình</label><br>
                                <img src="upload/slide/{{$slide->Hinh}}" width="50">
                                <input type="file" name="Hinh" class="form-control">
                            </div>

<script type="text/javascript" src="admin_asset/ckeditor/ckeditor.js"></script>

                            <div class="form-group">
                                <label>Nội dung</label>
                                <textarea class="form-control ckeditor" name="NoiDung" rows="3">{{$slide->NoiDung}}</textarea>
                            </div>

                            <div class="form-group">
                                <label>Link</label>
                                <input class="form-control" name="Link" placeholder="Nhập link" value="{{$slide->link}}" />
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