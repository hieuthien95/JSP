package btl;

import java.io.Serializable;

import btl.enums.CapDoHoiVien;

public class HoiVien extends Nguoi implements Serializable {
	private int diemTichLuy;
	private String capDoHoiVien;

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public String getCapDoHoiVien() {
		if (diemTichLuy <= 2000)
			return capDoHoiVien = CapDoHoiVien.NORMAL.getS();
		else if (diemTichLuy <= 5000)
			return capDoHoiVien = CapDoHoiVien.VIP.getS();
		else
			return capDoHoiVien = CapDoHoiVien.VVIP.getS();
	}

	public HoiVien() {
		super();
		diemTichLuy = 0;
		capDoHoiVien = getCapDoHoiVien();
	}

	public HoiVien(int cmnd, String ten, String sdt) {
		super(cmnd, ten, sdt);
		diemTichLuy = 0;
		capDoHoiVien = getCapDoHoiVien();
	}

	public HoiVien(int cmnd, String ten, String sdt, int diemTichLuy) {
		super(cmnd, ten, sdt);
		if (diemTichLuy < 0)
			diemTichLuy = 0;
		this.diemTichLuy = diemTichLuy;
		capDoHoiVien = getCapDoHoiVien();
	}

	@Override
	public String toString() {
		return getCmnd() + ", " + getTen() + ", " + diemTichLuy + "đ, " + capDoHoiVien;
	}

	// 5
	public void muaVe(Phim p) {
		p.setDoanhThu(p.getDoanhThu() + p.getGiaVe());

		if (capDoHoiVien.equals(CapDoHoiVien.NORMAL.getS()))
			diemTichLuy = diemTichLuy + (int) p.getGiaVe() * 5 / 100;
		else if (capDoHoiVien.equals(CapDoHoiVien.VIP.getS()))
			diemTichLuy = diemTichLuy + (int) p.getGiaVe() * 8 / 100;
		else if (capDoHoiVien.equals(CapDoHoiVien.VVIP.getS()))
			diemTichLuy = diemTichLuy + (int) p.getGiaVe() * 10 / 100;

		capDoHoiVien=getCapDoHoiVien();
	}

}
