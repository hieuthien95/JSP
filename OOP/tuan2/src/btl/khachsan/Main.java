package btl.khachsan;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		KhachSan ks = new KhachSan();

		ks.themPhong(new Phong("P001", LoaiPhong.CaoCap.getS(), 6, 250000, TinhTrangPhong.Con.getS()));
		ks.themPhong(new Phong("P002", LoaiPhong.Thuong.getS(), 6, 250000, TinhTrangPhong.Het.getS()));
		ks.themPhong(new Phong("P003", LoaiPhong.CaoCap.getS(), 6, 260000, TinhTrangPhong.Con.getS()));
		ks.themPhong(new Phong("P004", LoaiPhong.Thuong.getS(), 6, 250000, TinhTrangPhong.Con.getS()));
		ks.themPhong(new Phong("P101", LoaiPhong.CaoCap.getS(), 6, 250000, TinhTrangPhong.Con.getS()));
		ks.themPhong(new Phong("P102", LoaiPhong.Thuong.getS(), 6, 250000, TinhTrangPhong.Het.getS()));
		ks.themPhong(new Phong("P103", LoaiPhong.CaoCap.getS(), 6, 250000, TinhTrangPhong.Con.getS()));
		ks.themPhong(new Phong("P104", LoaiPhong.CaoCap.getS(), 6, 250000, TinhTrangPhong.Con.getS()));

		ks.themKhachTro(new KhachTro("KH1", "Bùi Hiếu Thiện", 312226740, "278 Thái Phiên, P8, Q11", "Việt Nam"));
		ks.themKhachTro(new KhachTro("KH2", "Bùi Hiếu Thịnh", 312226740, "Bùi Viện, P8, Q11", "Việt Nam"));
		ks.themKhachTro(new KhachTro("KH3", "Bùi Ngọc Bảo Thi", 312226740, "Nguyễn Thị Nhỏ, P8, Q11", "Việt Nam"));
		ks.themKhachTro(new KhachTro("KH4", "Bùi Hiếu An", 312226740, "123 CMT8, P8, Q11", "Việt Nam"));
		ks.themKhachTro(new KhachTro("KH5", "Bùi Hiếu Nghĩa", 312226740, "Ngô Tất Tố, P8, Q11", "Việt Nam"));

		boolean brk = true;
		int quyen = 0;
		int chucnang = 0;

		do {
			System.out.println("1. Quyen admin \n2. Quyen khach tro \n0. Thoat");

			sc = new Scanner(System.in);
			quyen = sc.nextInt();

			switch (quyen) {
			case 1:
				System.out.println("Quyền admin");

				do {
					System.out.println(
							"1.Xem phong trong  2.Dat phong  3.Huy phong  4.Them khach tro  5.Them phong tro 6.Tong ket 0.Thoat");
					chucnang = sc.nextInt();
					switch (chucnang) {
					case 1:
						ks.xemPhongCon();
						break;
					case 2:
						Scanner ad2 = new Scanner(System.in);
						System.out.print("cmnd khach tro: ");
						long cmnd = ad2.nextLong();
						System.out.print("Ma phong tro: ");
						String maP = ad2.nextLine();
						System.out.print("Ngay bat dau: ");
						String ngayBD = ad2.nextLine();
						System.out.print("Ngay ket thuc: ");
						String ngayKT = ad2.nextLine();

						ks.datPhong(cmnd, maP, ngayBD, ngayKT);

						break;
					case 3:
						break;
					case 4:
						Scanner ad4 = new Scanner(System.in);
						System.out.print("Ma khach tro: ");
						String maKhach = ad4.nextLine();
						System.out.print("Ho ten: ");
						String hoTen = ad4.nextLine();
						System.out.print("CMND: ");
						cmnd = ad4.nextLong();
						System.out.print("Dia chi: ");
						String diaChi = ad4.nextLine();
						System.out.print("Quoc tich: ");
						String quocTich = ad4.nextLine();

						KhachTro khachTro = new KhachTro(maKhach, hoTen, cmnd, diaChi, quocTich);
						ks.themKhachTro(khachTro);
						break;
					case 5:
						Scanner ad5 = new Scanner(System.in);
						System.out.print("Ma phong tro: ");
						String maPhong = ad5.nextLine();
						System.out.print("Loai phong: ");
						String loaiPhong = ad5.nextLine();
						System.out.print("Suc chua: ");
						int sucChua = ad5.nextInt();
						System.out.print("Don gia: ");
						double donGia = ad5.nextDouble();
						System.out.print("Tinh trang: ");
						String tinhTrang = ad5.nextLine();

						Phong phong = new Phong(maPhong, loaiPhong, sucChua, donGia, tinhTrang);
						ks.themPhong(phong);
						break;
					case 6:
						System.out.println("Tong ket hang thang: " + ks.thongKe());
						break;
					case 0:
						brk = false;
						break;
					default:
						break;
					}
				} while (brk);

				break;
			case 2:
				System.out.println("Quyền khach tro");

				do {
					System.out.println("1.Xem phong trong  2.Dat phong  3.Huy phong  0.Thoat");
					chucnang = sc.nextInt();
					switch (chucnang) {
					case 1:
						ks.xemPhongCon();
						break;
					case 2:
						Scanner kh2 = new Scanner(System.in);
						System.out.print("Ma khach tro: ");
						Long cmnd = kh2.nextLong();
						System.out.print("Ma phong tro: ");
						String maPhong = kh2.nextLine();
						System.out.print("Ngay bat dau: ");
						String ngayBD = kh2.nextLine();
						System.out.print("Ngay ket thuc: ");
						String ngayKT = kh2.nextLine();

						ks.datPhong(cmnd, maPhong, ngayBD, ngayKT);

						break;
					case 3:
						break;
					case 0:
						brk = false;
						System.out.println("Da Thoat");
						break;
					default:
						break;
					}
				} while (brk);

				break;
			case 0:
				brk = false;
				System.out.println("Da Thoat");
				break;
			default:
				break;
			}
		} while (brk);

	}

}
