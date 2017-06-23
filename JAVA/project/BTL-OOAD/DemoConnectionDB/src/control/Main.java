package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
//	private static Scanner sc;

	public static void main(String[] args) throws ParseException, SQLException {
//		KhachSan ks = new KhachSan();
//
//		// ks.themPhong(new Phong("P006", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P002", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P003", LoaiPhong.CaoCap.getS(), 6, 260000));
//		// ks.themPhong(new Phong("P004", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P101", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P102", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P103", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P104", LoaiPhong.CaoCap.getS(), 6, 250000));
//		//
//		// ks.themPhong(new Phong("P201", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P202", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P203", LoaiPhong.CaoCap.getS(), 6, 260000));
//		// ks.themPhong(new Phong("P204", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P301", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P302", LoaiPhong.Thuong.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P303", LoaiPhong.CaoCap.getS(), 6, 250000));
//		// ks.themPhong(new Phong("P304", LoaiPhong.CaoCap.getS(), 6, 250000));
//
//		// ks.themKhachTro(new KhachTro(1, "Nguyễn Văn An", 312226748, "278 Tạ
//		// Quang Bữu, Q8", "Việtt Nam"));
//		// ks.themKhachTro(new KhachTro(2, "Thiện Hiếu Bùi", 312226741, "BÃ¹i
//		// Viá»‡n, P8, Q11", "Viá»‡t Nam"));
//		// ks.themKhachTro(new KhachTro(3, "Bùi Thiện", 312226742, "123 CMT8,
//		// P8, Q11", "Viá»‡t Nam"));
//		// ks.themKhachTro(new KhachTro(4, "Thiện Bùi", 312226743, "NgÃ´ Táº¥t
//		// Tá»‘, P8, Q11", "Viá»‡t Nam"));
//
//		boolean brk = true;
//		int quyen = 0;
//		int chucnang = 0;
//
//		do {
//			System.out.println("1. Quyen admin \n2. Quyen khach tro \n0. Thoat");
//
//			sc = new Scanner(System.in);
//			quyen = sc.nextInt();
//
//			switch (quyen) {
//			case 1:
//				System.out.println("Quyá»�n admin");
//
//				do {
//					System.out.println(
//							"1.Xem phong trong 2.Dat phong 3.Huy phong 4.Them khach tro 5.Them phong tro 6.Tong ket 0.Thoat");
//					chucnang = sc.nextInt();
//					switch (chucnang) {
//					case 1:
//						ks.xemPhongCon();
//						break;
//					case 2:
//						Scanner ad2 = new Scanner(System.in);
//						System.out.print("cmnd khach tro: ");
//						long cmnd = ad2.nextLong();
//						System.out.print("Ma phong tro: ");
//						String maP = ad2.nextLine();
//						System.out.print("Ngay bat dau: ");
//						String ngayBD = ad2.nextLine();
//						System.out.print("Ngay ket thuc: ");
//						String ngayKT = ad2.nextLine();
//
//						ks.datPhong(cmnd, maP, ngayBD, ngayKT);
//
//						break;
//					case 3:
//						break;
//					case 4:
//						Scanner ad4 = new Scanner(System.in);
//						System.out.print("Ma khach tro: ");
//						int maKhach = ad4.nextInt();
//						System.out.print("Ho ten: ");
//						String hoTen = ad4.nextLine();
//						System.out.print("CMND: ");
//						cmnd = ad4.nextLong();
//						System.out.print("Dia chi: ");
//						String diaChi = ad4.nextLine();
//						System.out.print("Quoc tich: ");
//						String quocTich = ad4.nextLine();
//
//						KhachTro khachTro = new KhachTro(maKhach, hoTen, cmnd, diaChi, quocTich);
//						ks.themKhachTro(khachTro);
//						break;
//					case 5:
//						Scanner ad5 = new Scanner(System.in);
//						System.out.print("Ma phong tro: ");
//						String maPhong = ad5.nextLine();
//						System.out.print("Loai phong: ");
//						String loaiPhong = ad5.nextLine();
//						System.out.print("Suc chua: ");
//						int sucChua = ad5.nextInt();
//						System.out.print("Don gia: ");
//						int donGia = ad5.nextInt();
//
//						Phong phong = new Phong(maPhong, loaiPhong, sucChua, donGia);
//						ks.themPhong(phong);
//						break;
//					case 6:
//						// System.out.println("Tong ket hang thang: " +
//						// ks.thongKeTienPhong(9));
//						break;
//					case 0:
//						brk = false;
//						break;
//					default:
//						break;
//					}
//				} while (brk);
//
//				break;
//			case 2:
//				System.out.println("Quyá»�n khach tro");
//
//				do {
//					System.out.println("1.Xem phong trong 2.Dat phong 3.Huy phong 0.Thoat");
//					chucnang = sc.nextInt();
//					switch (chucnang) {
//					case 1:
//						ks.xemPhongCon();
//						break;
//					case 2:
//						Scanner kh2 = new Scanner(System.in);
//						System.out.print("Ma khach tro: ");
//						Long cmnd = kh2.nextLong();
//						System.out.print("Ma phong tro: ");
//						String maPhong = kh2.nextLine();
//						System.out.print("Ngay bat dau: ");
//						String ngayBD = kh2.nextLine();
//						System.out.print("Ngay ket thuc: ");
//						String ngayKT = kh2.nextLine();
//
//						ks.datPhong(cmnd, maPhong, ngayBD, ngayKT);
//
//						break;
//					case 3:
//						break;
//					case 0:
//						brk = false;
//						System.out.println("Da Thoat");
//						break;
//					default:
//						break;
//					}
//				} while (brk);
//
//				break;
//			case 0:
//				brk = false;
//				System.out.println("Da Thoat");
//				break;
//			default:
//				break;
//			}
//		} while (brk);
//
//		ks.datPhong(312226741, "P004", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P002", "09:00 05/08/2016", "11:30 05/08/2016");
//		ks.datPhong(312226741, "P001", "15:30 05/09/2016", "17:30 01/08/2016");
//		ks.datPhong(312226741, "P003", "03:30 05/09/2016", "10:00 03/09/2016");
//		ks.thanhToan("P004", 0, 3);
//		ks.thanhToan("P002", 0, 3);
//		ks.thanhToan("P001", 0, 3);
//		ks.thanhToan("P003", 0, 3);
//
//		ks.datPhong(312226741, "P004", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P002", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P001", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P003", "03:30 05/09/2016", "10:00 03/09/2016");
//		ks.thanhToan("P004", 0, 3);
//		ks.thanhToan("P002", 0, 3);
//		ks.thanhToan("P001", 0, 3);
//		ks.thanhToan("P003", 0, 3);
//
//		ks.datPhong(312226741, "P004", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P002", "03:30 05/09/2016", "10:00 03/09/2016");
//		ks.datPhong(312226741, "P001", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.datPhong(312226741, "P003", "03:30 05/09/2016", "10:00 03/09/2016");
//		ks.thanhToan("P004", 0, 3);
//		ks.thanhToan("P002", 0, 3);
//		ks.thanhToan("P001", 0, 3);
//		ks.thanhToan("P003", 0, 3);
//
//		// System.out.println(ks.getDsPhongDangSuDung());
//
//		ks.datPhong(312226741, "P001", "11:30 05/09/2016", "15:00 05/09/2016");
//		ks.huyPhong("P001");
//
//		// ks.thongKeTienPhong(9);

		final SimpleDateFormat sdf_ddMMyy = new SimpleDateFormat("hh:mm aa dd/MM/yy");

		System.out.println(sdf_ddMMyy.parse("00:00 PM 01/01/2016"));
		
	}

}
