package btl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import btl.enums.ChucVuNhanVien;
import btl.enums.DinhDang;
import btl.enums.TheLoai;

public class Main {

	private static ArrayList<String> dsTheLoai;

	public static void ghiRapVaoFile(Rap r) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeObject(r);
		oos.close();
	}

	public static Rap nhapRapTuFile() throws IOException, ClassNotFoundException {
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("data.txt"));
		Rap r = (Rap) ios.readObject();
		ios.close();
		return r;
	}

	public static String chucNangSwitch(String s) {
		boolean brk = true;

		do {
			if (s.equals("TheLoai")) {
				System.out.println("\nChọn thể loại: " + "\n1.Hành động " + "\n2.Kinh dị " + "\n3.Hai "
						+ "\n4.Hoạt hình " + "\n5.KHVT " + "\n6.Kinh dị " + "\n7.Tâm lý " + "\n8.Tình cảm");
				Scanner sctl = new Scanner(System.in);
				int i = sctl.nextInt();
				switch (i) {
				case 1:
					return TheLoai.HANHDONG.getS();
				case 2:
					return TheLoai.KINHDI.getS();
				case 3:
					return TheLoai.HAI.getS();
				case 4:
					return TheLoai.HOATHINH.getS();
				case 5:
					return TheLoai.KHOAHOCVIENTUONG.getS();
				case 6:
					return TheLoai.KINHDI.getS();
				case 7:
					return TheLoai.TAMLY.getS();
				case 8:
					return TheLoai.TINHCAM.getS();
				default:
					break;
				}
			} else if (s.equals("DinhDang")) {
				System.out.println("\nChọn định dạng: " + "\n1.2D " + "\n2.3D " + "\n3.4DX");
				Scanner scdd = new Scanner(System.in);
				int i = scdd.nextInt();
				switch (i) {
				case 1:
					return DinhDang.DD.getS();
				case 2:
					return DinhDang.DDD.getS();
				case 3:
					return DinhDang.DDDDX.getS();
				default:
					break;
				}
			} else if (s.equals("ChucVuNhanVien")) {
				System.out.println("\nChọn chức vụ: " + "\n1.Nhân viên " + "\n2.Quảng lý " + "\n3.Giám đốc");
				Scanner scdd = new Scanner(System.in);
				int i = scdd.nextInt();
				switch (i) {
				case 1:
					return ChucVuNhanVien.QUANLY.getS();
				case 2:
					return ChucVuNhanVien.QUANLY.getS();
				case 3:
					return ChucVuNhanVien.QUANLY.getS();
				default:
					break;
				}
			}
		} while (brk);
		return null;

	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		Rap rap = new Rap("Lotte Cinema", "081222555", "250 Nguyễn Hữu Thọ");

		rap.themHoiVien(new HoiVien(312222210, "Trần Anh Văn", "01653990370", 1500));
		rap.themHoiVien(new HoiVien(312222211, "Nguyễn Anh Tuấn", "0165391125", 7200));
		rap.themHoiVien(new HoiVien(312222212, "Bùi Tuấn Thi", "0165392315", 2100));
		rap.themHoiVien(new HoiVien(312222213, "Trần Anh Thịnh", "0165120370", 5100));
		rap.themHoiVien(new HoiVien(312222214, "Trần Nga", "01653990370", 1400));
		rap.themHoiVien(new HoiVien(312222215, "Nguyễn Thịnh", "0165391125", 3650));
		rap.themHoiVien(new HoiVien(312222216, "Bùi Tuấn Anh", "0165392315", 2500));
		rap.themHoiVien(new HoiVien(312222217, "Trần Thị Như", "0165120370", 5120));
		rap.themHoiVien(new HoiVien(312222218, "Trần Việt Trinh", "01653990370", 6800));
		rap.themHoiVien(new HoiVien(312222219, "Nguyễn Thị Tuyết Liên", "0165391125", 3700));
		rap.themHoiVien(new HoiVien(312222220, "Bùi Anh Đào", "0165392315", 5));
		rap.themHoiVien(new HoiVien(312222221, "Trần Anh Trúc", "0165120370", 10));
		rap.themHoiVien(new HoiVien(312222222, "Bùi Duy Anh", "01653990370", 15));
		rap.themHoiVien(new HoiVien(312222223, "Đỗ Ngọc Trâm", "0165391125", 1810));
		rap.themHoiVien(new HoiVien(312222224, "Bùi Ngọc Bảo Thi", "0165392315", 250));
		rap.themHoiVien(new HoiVien(312222225, "Trần Như Ý", "0165120370", 5200));
		rap.themHoiVien(new HoiVien(312222226, "Trần Văn Khải", "01653990370", 1100));
		rap.themHoiVien(new HoiVien(312222227, "Trần Anh Tài", "0165391125", 6000));
		rap.themHoiVien(new HoiVien(312222228, "Bùi Tuấn An", "0165392315", 3100));
		rap.themHoiVien(new HoiVien(312222229, "Bùi Trần Anh Tuấn", "0165120370", 20));
		rap.themHoiVien(new HoiVien(312222230, "Nguyễn Trần An", "01653990370", 90));
		rap.themHoiVien(new HoiVien(312222231, "Trần Nguyễn Anh Tài", "0165391125", 120));
		rap.themHoiVien(new HoiVien(312222232, "Bùi Bảo Ngọc", "0165392315", 5100));
		rap.themHoiVien(new HoiVien(312222233, "Trần Anh Trí", "0165120370", 5600));
		rap.themHoiVien(new HoiVien(312222234, "Nguyễn Anh Nam", "0165120370", 480));
		rap.themHoiVien(new HoiVien(312222235, "Trần Anh Tài", "0165120370", 3200));

		rap.themNhanVien(
				new NhanVien(111111111, "Đào Duy Nhất", "0161111111", "...", 5, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(
				new NhanVien(111111112, "Hùynh Văn An", "0161111112", "...", 7, ChucVuNhanVien.GIAMDOC.getS()));
		rap.themNhanVien(
				new NhanVien(111111113, "Trần Quốc Đại", "0161111113", "...", 3, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111114, "Nguyễn Anh Nguyên", "0161111114", "...", 4, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(
				new NhanVien(111111115, "Bùi Hiếu Thiện", "0161111115", "...", 5, ChucVuNhanVien.GIAMDOC.getS()));
		rap.themNhanVien(
				new NhanVien(111111116, "Nguyễn Đại Thịnh", "0161111116", "...", 7, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(
				new NhanVien(111111117, "Bùi Ngọc Bảo Thi", "0161111117", "...", 3, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111118, "Nguyễn Huỳnh như", "0161111118", "...", 4, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(
				new NhanVien(111111119, "Đào Duy Anh", "0161111119", "...", 5, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(
				new NhanVien(111111120, "Hùynh Văn Anh Tài", "016111120", "...", 7, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(new NhanVien(111111121, "Trần Anh Đại", "016111121", "...", 3, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111122, "Nguyễn Anh Tài", "016111122", "...", 4, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(new NhanVien(111111123, "Trần Khánh", "016111123", "...", 5, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(new NhanVien(111111124, "Hùynh An", "016111124", "...", 7, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(new NhanVien(111111125, "Trần Quốc An", "0165122512", "...", 3, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111126, "Nguyễn Anh Tuấn", "0163521888", "...", 4, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111127, "Trần Anh Tài", "0163521528", "...", 4, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(new NhanVien(111111128, "Bùi Văn Dũng", "016351256", "...", 4, ChucVuNhanVien.QUANLY.getS()));
		rap.themNhanVien(
				new NhanVien(111111129, "Nguyễn Thị Loan", "0163595682", "...", 4, ChucVuNhanVien.NHANVIEN.getS()));
		rap.themNhanVien(new NhanVien(111111130, "Đổ Ngọc Trâm", "0163525532", "...", 4, ChucVuNhanVien.QUANLY.getS()));

		dsTheLoai = new ArrayList<>();

		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.HOATHINH.getS());
		rap.themPhim(new Phim(1, "FINDING DORY", 3, 103, "...", 50, 15000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.TAMLY.getS());
		rap.themPhim(new Phim(2, "CENTRAL INTELLIGENCE", 2, 107, "...", 55, 12000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		dsTheLoai.add(TheLoai.KHOAHOCVIENTUONG.getS());
		rap.themPhim(new Phim(3, "MONEY MONSTER", 2, 98, "...", 45, 15000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		dsTheLoai.add(TheLoai.KHOAHOCVIENTUONG.getS());
		rap.themPhim(new Phim(4, "WARCRAFT", 5, 123, "...", 55, 25000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(5, "NOW YOU SEE ME 2", 3, 115, "...", 50, 17000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.KINHDI.getS());
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(6, "THE CONJURING 2", 2, 134, "...", 60, 15000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.TAMLY.getS());
		dsTheLoai.add(TheLoai.TINHCAM.getS());
		rap.themPhim(new Phim(7, "ME BEFORE YOU", 1, 103, "...", 50, 11000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		rap.themPhim(new Phim(8, "BẢO MẪU SIÊU QUẬY 2", 5, 95, "...", 40, 12000, dsTheLoai, DinhDang.DD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(9, "X-MEN: APOCALYPSE", 5, 133, "...", 55, 15000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(10, "CAPTON AMERIACA", 4, 112, "...", 30, 12000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		dsTheLoai.add(TheLoai.TAMLY.getS());
		rap.themPhim(new Phim(11, "DR STRANGE", 4, 112, "...", 55, 19500, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(12, "DEEDPOOL", 3, 112, "...", 20, 13000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(13, "WOLWORIN", 1, 112, "...", 80, 11200, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(14, "X-MEN 4", 3, 112, "...", 65, 10000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(15, "LẬT MẶT", 1, 112, "...", 45, 14000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.TAMLY.getS());
		dsTheLoai.add(TheLoai.TINHCAM.getS());
		rap.themPhim(new Phim(16, "YÊU", 2, 112, "...", 40, 100000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(17, "CHINA TOWN", 3, 112, "...", 30, 16600, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(18, "SUPER MAN AND BAD MAN", 4, 112, "...", 60, 17000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.HOATHINH.getS());
		rap.themPhim(new Phim(19, "MẬT DAH 47", 2, 112, "...", 25, 10500, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.TAMLY.getS());
		dsTheLoai.add(TheLoai.COTRANG.getS());
		rap.themPhim(new Phim(20, "VIỆT NAM 1505", 1, 112, "...", 90, 18520, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		dsTheLoai.add(TheLoai.KHOAHOCVIENTUONG.getS());
		rap.themPhim(new Phim(21, "GRAVITY", 4, 112, "...", 80, 15920, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		dsTheLoai.add(TheLoai.KHOAHOCVIENTUONG.getS());
		rap.themPhim(new Phim(22, "AVATAR", 5, 112, "...", 45, 56000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HOATHINH.getS());
		rap.themPhim(new Phim(23, "INSIDER", 3, 112, "...", 55, 22000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HAI.getS());
		dsTheLoai.add(TheLoai.HOATHINH.getS());
		rap.themPhim(new Phim(24, "ANGRY BIRD", 4, 112, "...", 45, 32000, dsTheLoai, DinhDang.DDD.getS()));
		dsTheLoai = new ArrayList<>();;
		dsTheLoai.add(TheLoai.HANHDONG.getS());
		rap.themPhim(new Phim(25, "IRON MAN", 3, 112, "...", 55, 12500, dsTheLoai, DinhDang.DDD.getS()));

		ghiRapVaoFile(rap);

//		Rap rap1 = nhapRapTuFile();

//		boolean brk = true;
//		do {
//			System.out.println("\nLựa chọn chức năng: " + "\n2. [Xem danh sach] Phim(21) Hội viên(22) Nhân viên(23)"
//					+ "\n3. Thêm phim(31) Thêm hội viên(32) Thêm nhân viên(33) " + "\n4. Tính lương nhân viên"
//					+ "\n5. Mua vé"
//					+ "\n6. [Xem ds phim] rate cao(61) Doanh thu cao(62) Hành động(63) Ds nhân viên QL(64) Ds hội viên VVIP(65)"
//					+ "\n7. Ds tăng dần giá vé(71) Ds tăng dần tích lũy(72)" + "\n8. Lưu và thoát");
//
//			Scanner sc = new Scanner(System.in);
//			int choice = sc.nextInt();
//
//			switch (choice) {
//			case 2:
//			case 21:
//				System.out.println(rap1.getDsPhim());
//				break;
//			case 22:
//				System.out.println(rap1.getDsHoiVien());
//				break;
//			case 23:
//				System.out.println(rap1.getDsNhanVien());
//				break;
//
//			case 3:
//			case 31:
//				Scanner sc11 = new Scanner(System.in);
//				int maSo = rap1.getDsPhim().size() + 1;
//				System.out.print("Nhập tên phim: ");
//				String tenPhim = sc11.nextLine();
//				System.out.print("Nhập đánh giá: ");
//				int danhGia = sc.nextInt();
//				System.out.print("Nhập thời lượng: ");
//				int thoiLuong = sc.nextInt();
//				System.out.print("Nhập mô tả: ");
//				String moTa = sc11.nextLine();
//				System.out.print("Nhập gia vé: ");
//				int giaVe = sc.nextInt();
//				System.out.print("Nhập doanh thu: ");
//				int doanhThu = sc.nextInt();
//				String theLoai = chucNangSwitch("TheLoai");
//				String dinhDang = chucNangSwitch("DinhDang");
//
//				rap1.themPhim(new Phim(maSo, tenPhim, danhGia, thoiLuong, moTa, giaVe, doanhThu, theLoai, dinhDang));
//				System.out.println(rap1.getDsPhim().get(rap1.getDsPhim().size() - 1));
//				break;
//			case 32:
//				Scanner sc12 = new Scanner(System.in);
//				System.out.println("nhập CMND hội viên: ");
//				int cmnd = sc.nextInt();
//				System.out.println("Nhập tên hội viên: ");
//				String ten = sc12.nextLine();
//				System.out.println("Nhập sdt hội viên: ");
//				String sdt = sc12.nextLine();
//				System.out.println("Nhập điểm hội viên: ");
//				int diemTichLuy = sc.nextInt();
//
//				rap1.themHoiVien(new HoiVien(cmnd, ten, sdt, diemTichLuy));
//				System.out.println(rap1.getDsHoiVien().get(rap1.getDsHoiVien().size() - 1));
//				break;
//			case 33:
//				Scanner sc13 = new Scanner(System.in);
//				System.out.println("Nhập CMND nhân viên: ");
//				cmnd = sc.nextInt();
//				System.out.println("Nhập tên nhân viên: ");
//				ten = sc13.nextLine();
//				System.out.println("Nhập sdt nhân viên: ");
//				sdt = sc13.nextLine();
//				System.out.println("Nhập thông tin nhân viên: ");
//				String thongTinCoBan = sc13.nextLine();
//				System.out.println("Nhập số giờ tăng ca nhân viên: ");
//				double soGioTangCa = sc.nextDouble();
//				String chucVuNhanvien = chucNangSwitch("ChucVuNhanVien");
//
//				rap1.themNhanVien(new NhanVien(cmnd, ten, sdt, thongTinCoBan, soGioTangCa, chucVuNhanvien));
//				System.out.println(rap1.getDsNhanVien().get(rap1.getDsNhanVien().size() - 1));
//				break;
//
//			case 4:
//				Scanner sc4 = new Scanner(System.in);
//				System.out.print("Nhập CMND nhân viên: ");
//				cmnd = sc4.nextInt();
//
//				for (NhanVien i : rap1.getDsNhanVien())
//					if (i.getCmnd() == cmnd) {
//						System.out.println(i);
//						System.out.println(rap1.tinhLuong(i));
//					}
//				break;
//
//			case 5:
//				Scanner sc5 = new Scanner(System.in);
//				System.out.print("Nhập CMND hội viên: ");
//				cmnd = sc5.nextInt();
//				System.out.print("Nhập mã số phim: ");
//				maSo = sc5.nextInt();
//
//				for (Phim i : rap1.getDsPhim())
//					if (i.getMaSo() == maSo)
//						for (HoiVien j : rap1.getDsHoiVien())
//							if (j.getCmnd() == cmnd) {
//								System.out.println("Before: " + i.getDoanhThu());
//								System.out.println("Before: " + j);
//								rap1.muaVe(j, i);
//								System.out.println("After: " + i.getDoanhThu());
//								System.out.println("After: " + j);
//							}
//				break;
//
//			case 6:
//			case 61:
//				System.out.println(rap1.sapXepRatingPhim());
//				break;
//			case 62:
//				System.out.println(rap1.sapXepDoanhThuPhim());
//				break;
//			case 63:
//				System.out.println(rap1.layDSPhimHanhDong());
//				break;
//			case 64:
//				System.out.println(rap1.layDSQuanLy());
//				break;
//			case 65:
//				System.out.println(rap1.layDSHoiVienVVIP());
//				break;
//
//			case 7:
//			case 71:
//				System.out.println(Rap.sapXepGiaPhim(rap1.getDsPhim()));
//				break;
//			case 72:
//				System.out.println(Rap.sapXepTangDiemHV(rap1.getDsHoiVien()));
//				break;
//
//			case 8:
//				ghiRapVaoFile(rap1);
//				brk = false;
//				System.out.println("Lưu thành công");
//				break;
//
//			default:
//				System.out.println("Vui lòng chọn đúng chức năng");
//				break;
//			}
//		} while (brk);
	}
}
