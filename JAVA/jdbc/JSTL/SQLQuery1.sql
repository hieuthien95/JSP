use master
go
drop database MOBILE_SHOP
go
create database MOBILE_SHOP
go
use MOBILE_SHOP
go

create table DIENTHOAI(
id int not null IDENTITY primary key,
name nvarchar(50),
price float)

create table PHUKIEN(
id int not null IDENTITY primary key,
name nvarchar(50),
price float,
)

insert into DIENTHOAI values('Galaxy S3', 300)
insert into DIENTHOAI values('Galaxy S4', 350)
insert into DIENTHOAI values('Galaxy S5', 400)
insert into DIENTHOAI values('iPhone 4S', 450)
insert into DIENTHOAI values('iPhone 5S', 500)
insert into DIENTHOAI values('iPhone 6S', 550)
insert into DIENTHOAI values('iPad Pro', 600)
insert into DIENTHOAI values('iPhone 7S', 650)
insert into DIENTHOAI values('iPut 9S', 700)


insert into PHUKIEN values(N'Tai nghe iPhone',25)
insert into PHUKIEN values(N'Dán màn hình',3)
insert into PHUKIEN values(N'Pin Nokia',6)
insert into PHUKIEN values(N'Cục sạc dự phòng',13)
insert into PHUKIEN values(N'Túi chống xóc',4)
insert into PHUKIEN values(N'Ốp lưng iPhone',3)

select * from DIENTHOAI
select * from PHUKIEN