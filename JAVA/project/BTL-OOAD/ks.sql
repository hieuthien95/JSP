create database quanlykhachsan
use quanlykhachsan
go

drop table DangNhap
drop table ThanhVienThue
drop table LanThuePhong
drop table PhongDangSuDung
drop table LanThanhToan
drop table Phong
drop table KhachTro


CREATE TABLE DangNhap
(id NVARCHAR(15) PRIMARY KEY,
 pass NVARCHAR(30) NOT NULL,
 quyen NVARCHAR(30) NOT NULL,
)
INSERT INTO DangNhap VALUES('admin','admin','admin')
INSERT INTO DangNhap VALUES('nhanvien1','nhanvien1','nhanvien')
INSERT INTO DangNhap VALUES('nhanvien2','nhanvien2','nhanvien')
INSERT INTO DangNhap VALUES('a','a','admin')

CREATE TABLE Phong
(maphong NVARCHAR(15) PRIMARY KEY,
 loaiphong NVARCHAR(30) NOT NULL,
 succhua int NOT NULL,
 dongia int NOT NULL
)
INSERT INTO Phong VALUES('P001',N'Cao Cấp',4, 120000)
INSERT INTO Phong VALUES('P002',N'Thường',2,100000)
INSERT INTO Phong VALUES('P003',N'Cao Cấp',4, 120000)
INSERT INTO Phong VALUES('P004',N'Thường',2,100000)
INSERT INTO Phong VALUES('P101',N'Cao Cấp',4, 120000)
INSERT INTO Phong VALUES('P102',N'Thường',2,100000)
INSERT INTO Phong VALUES('P103',N'Cao Cấp',4, 120000)
INSERT INTO Phong VALUES('P104',N'Thường',2,100000)
INSERT INTO Phong VALUES('P201',N'Thường',2,100000)
INSERT INTO Phong VALUES('P202',N'Thường',2,100000)
INSERT INTO Phong VALUES('P203',N'Thường',2,100000)
INSERT INTO Phong VALUES('P204',N'Thường',2,100000)

CREATE TABLE KhachTro
(makhach int PRIMARY KEY IDENTITY( 1, 1 ),
 hoten NVARCHAR(30) NOT NULL,
 cmnd int NOT NULL,
 diachi NVARCHAR(100),
 quoctich NVARCHAR(30) NOT NULL,
)
INSERT INTO KhachTro VALUES(N'Bùi Hiếu Thiện',51303402, N'280 Thái Phiên', N'Việt Nam')
INSERT INTO KhachTro VALUES(N'Hiếu Bùi Thiện',51303403, N'298 Thành Thái', N'Việt Nam')
INSERT INTO KhachTro VALUES(N'Thiện Bùi Hiếu',51303404, N'308 Thái Phiên', N'Việt Nam')
INSERT INTO KhachTro VALUES(N'Hiếu Thiện Bùi',51303405, N'408 Thái Phiên', N'Việt Nam')
INSERT INTO KhachTro VALUES(N'Bùi Hiếu',51303406, N'278 Thái Phiên', N'Việt Nam')
INSERT INTO KhachTro VALUES(N'Thiện Bùi Hiếu',51303407, N'278 Thái An', N'Việt Nam')

CREATE TABLE LanThanhToan
(	mathanhtoan int PRIMARY KEY IDENTITY( 1, 1 ),
	ngaythanhtoan NVARCHAR(100) NOT NULL,
	tienphong int NOT NULL,
	tiendichvu int NOT NULL,
	mathuephong int NOT NULL,
)

CREATE TABLE PhongDangSuDung
(	maphongthue NVARCHAR(15) NOT NULL,
	ngaybatdau NVARCHAR(100) NOT NULL,
	ngayketthuc NVARCHAR(100) NOT NULL,
	cmnd int NOT NULL,
	FOREIGN KEY (maphongthue) REFERENCES Phong(maphong)
)

CREATE TABLE LanThuePhong
(	mathuephong int PRIMARY KEY IDENTITY( 1, 1 ),
	maphongthue NVARCHAR(15) NOT NULL,
	ngaybatdau NVARCHAR(100) NOT NULL,
	ngayketthuc NVARCHAR(100) NOT NULL,
	cmnd int NOT NULL,
)

CREATE TABLE ThanhVienThue
(	cmnd int NOT NULL,
	hoten NVARCHAR(30) NOT NULL,
	mathuephong int NOT NULL,
	FOREIGN KEY (mathuephong) REFERENCES LanThuePhong(mathuephong)
)

select * from DangNhap
select * from KhachTro

select * from Phong

select * from LanThanhToan

select * from PhongDangSuDung
select * from LanThuePhong 

select * from ThanhVienThue