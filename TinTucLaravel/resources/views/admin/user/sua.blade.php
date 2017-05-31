@extends('admin.layout.index')

@section('content')     
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">User
                            <small>Sửa</small>
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
                        
                        <form action="admin/user/sua/{{$user->id}}" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="_token" value="{{csrf_token()}}">

                            <div class="form-group">
                                <label>Tên</label>
                                <input class="form-control" name="Name" placeholder="Nhập tên" value="{{$user->name}}" />
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="Email" class="form-control" name="Email" placeholder="Nhập Email" value="{{$user->email}}" readonly />
                            </div>

                            <div class="form-group">
                                <label>Hình</label><br>
                                <img src="upload/user/{{$user->Hinh}}" width="50">
                                <input type="file" class="form-control" name="Hinh" />
                            </div>
                            <div class="form-group">
                                <label>Quyền</label>
                                <select class="form-control" name="Quyen">
                                    <option value="{{$user->quyen}}">{{$user->quyen}}</option>
                                    <option value="0">Người dùng</option>
                                    <option value="2">Nhân viên</option>
                                    <option value="1">Admin</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" class="form-control" name="Password" placeholder="Nhập password" />
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