package btl;

import java.io.Serializable;

import btl.enums.ChucVuNhanVien;

public class NhanVien extends Nguoi implements Serializable {
	public static double LUONG_CO_BAN = 3700000;

	private String thongTinCoBan;
	private double soGioTangCa;
	private String chucVuNhanVien;

	public String getThongTinCoBan() {
		return thongTinCoBan;
	}

	public double getSoGioTangCa() {
		return soGioTangCa;
	}

	public String getChucVuNhanVien() {
		return chucVuNhanVien;
	}

	public NhanVien() {
		super();
		thongTinCoBan = "";
		soGioTangCa = 0;
		chucVuNhanVien = ChucVuNhanVien.NHANVIEN.getS();
	}

	public NhanVien(int cmnd, String ten, String sdt, String thongTinCoBan, double soGioTangCa, String chucVunhanvien) {
		super(cmnd, ten, sdt);
		this.thongTinCoBan = thongTinCoBan;
		this.soGioTangCa = soGioTangCa;
		this.chucVuNhanVien = chucVunhanvien;
	}

	public NhanVien(int cmnd, String ten, String sdt, String thongTinCoBan, String chucVunhanvien) {
		super(cmnd, ten, sdt);
		this.thongTinCoBan = thongTinCoBan;
		this.soGioTangCa = 0;
		this.chucVuNhanVien = chucVunhanvien;
	}

	@Override
	public String toString() {
		return getCmnd() + ", " + getTen() + ", " + soGioTangCa + "h, " + chucVuNhanVien;
	}

	// 4
	public double tinhLuong() {
		if (chucVuNhanVien.equals(ChucVuNhanVien.GIAMDOC.getS()))
			return LUONG_CO_BAN + soGioTangCa * 110000 + LUONG_CO_BAN * 8 / 100;
		else if (chucVuNhanVien.equals(ChucVuNhanVien.QUANLY.getS()))
			return LUONG_CO_BAN + soGioTangCa * 110000 + LUONG_CO_BAN * 5 / 100;
		else
			return LUONG_CO_BAN + soGioTangCa * 110000;
	}

}
