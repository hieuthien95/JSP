package btl.khachsan;

import java.util.ArrayList;
import java.util.Date;

public class KhachSan {
	public static ArrayList<Phong> dsPhong;
	private ArrayList<KhachTro> dsKhachTro;

	private ArrayList<LanThuePhong> dsLanThuePhong;
	private ArrayList<LanThanhToan> dsLanThanhToan;

	public KhachSan() {
		dsPhong = new ArrayList<>();
		dsKhachTro = new ArrayList<>();
		dsLanThanhToan = new ArrayList<>();
		dsLanThuePhong = new ArrayList<>();
	}

	public ArrayList<Phong> getDsPhong() {
		return dsPhong;
	}

	public ArrayList<KhachTro> getDsKhachTro() {
		return dsKhachTro;
	}

	public ArrayList<LanThanhToan> getDsLanThanhToan() {
		return dsLanThanhToan;
	}

	public ArrayList<LanThuePhong> getDsLanThuePhong() {
		return dsLanThuePhong;
	}

	@Override
	public String toString() {
		return "KhachSan [dsPhong=" + dsPhong + ", dsKhachTro=" + dsKhachTro + ", dsLanThanhToan=" + dsLanThanhToan
				+ ", dsLanThuePhong=" + dsLanThuePhong + "]";
	}

	public boolean themPhong(Phong p) {
		for (Phong i : dsPhong)
			if (i.getMaPhong().equals(p.getMaPhong()))
				return false;
		return dsPhong.add(p);
	}

	public boolean themKhachTro(KhachTro kh) {
		for (KhachTro i : dsKhachTro)
			if (i.getMaKhach().equals(kh.getMaKhach()))
				return false;
		return dsKhachTro.add(kh);
	}

	public void xemPhongCon() {
		for (Phong i : dsPhong)
			if (i.getTinhTrang().equals(TinhTrangPhong.Con.getS()))
				System.out.println(i);
	}

	public boolean datPhong(long cmnd, String maPhong, String ngayBD, String ngayKT) {
		for (Phong i : dsPhong)
			if (i.getMaPhong().equals(maPhong))
				if (i.getTinhTrang().equals(TinhTrangPhong.Con.getS())) {
					i.setTinhTrang(TinhTrangPhong.Het.getS());
					dsLanThuePhong.add(new LanThuePhong(i, cmnd, ngayBD, ngayKT));
					return true;
				} else
					System.out.println("Phòng trọ đã được đặt");
		System.out.println("Không tìm thấy mã phòng");
		return false;
	}

	public boolean huyPhong(long maKH, String maPhong) {
		for (LanThuePhong i : dsLanThuePhong)
			if (i.getMaPhong().equals(maPhong) && i.getCmnd() == maKH)
				return dsLanThuePhong.remove(i);
		return false;
	}

	public double thanhToan(String maPhong, double tienDV, int thoiGianThue) {
		for (LanThuePhong i : dsLanThuePhong)
			if (i.getMaPhong().equals(maPhong)) {
				double tienPhong = thoiGianThue * i.getPhongThue().getDonGia();
				dsLanThanhToan.add(new LanThanhToan(new Date(System.currentTimeMillis()), tienPhong, tienDV));
				dsLanThuePhong.remove(i);
				return tienPhong;
			}
		return 0;
	}

	public double thongKe() {
		double tienTK = 0;
		for (LanThanhToan i : dsLanThanhToan)
			tienTK = tienTK + i.getSoTienPhong() + i.getSoTienDV();
		return tienTK;
	}
}
