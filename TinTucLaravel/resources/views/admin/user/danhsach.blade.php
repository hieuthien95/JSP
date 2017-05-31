@extends('admin.layout.index')

@section('content')		
		<!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">User
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
                                <th>Name</th>
                                <th>Email</th>
                                <th>Quyền</th>
                                <th>Xóa</th>
                                <th>Sửa</th>
                            </tr>
                        </thead>
                        <tbody>
                        @foreach($user as $us)
                            <tr class="odd gradeX" align="center">
                                <td>{{$us->id}}</td>
                                <td>{{$us->name}}<br>
                                    <img src="upload/user/{{$us->Hinh}}" width="50">
                                </td>
                                <td>{{$us->email}}</td>
                                <td>{{$us->quyen}}</td>
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="admin/user/xoa/{{$us->id}}"> Xóa</a></td>
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="admin/user/sua/{{$us->id}}">Sửa</a></td>
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