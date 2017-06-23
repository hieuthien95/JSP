package kethua.ql_giang_vien;

import java.io.Serializable;
import java.util.Date;

public abstract class GiangVien implements Serializable {
	public static double luongCoBan = 3800000;

	private String maSo;
	private String ten;
	private Date ngaySinh;
	private String hocVi;
	private Date ngayVaoTruong;
	private SoYeuLyLich soYeuLyLich;
	private boolean nghi;

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getHocVi() {
		return hocVi;
	}

	public void setHocVi(String hocVi) {
		this.hocVi = hocVi;
	}

	public Date getNgayVaoTruong() {
		return ngayVaoTruong;
	}

	public void setNgayVaoTruong(Date ngayVaoTruong) {
		this.ngayVaoTruong = ngayVaoTruong;
	}

	public SoYeuLyLich getSoYeuLyLich() {
		return soYeuLyLich;
	}

	public void setSoYeuLyLich(SoYeuLyLich soYeuLyLich) {
		this.soYeuLyLich = soYeuLyLich;
	}

	public boolean isNghi() {
		return nghi;
	}

	public void setNghi(boolean nghi) {
		this.nghi = nghi;
	}

	public GiangVien() {
		super();
	}

	public GiangVien(String maSo, String ten, Date ngaySinh, HocVi hocVi,
			Date ngayVaoTruong, SoYeuLyLich soYeuLyLich) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.hocVi = hocVi.getS();
		this.ngayVaoTruong = ngayVaoTruong;
		this.soYeuLyLich = soYeuLyLich;
		this.nghi = false;
	}

	public abstract String toString();

	// 3
	public boolean xinNghi() {
		if (nghi == true)
			return false;
		else
			return nghi = true;
	}

	// 15
	public boolean ktNghienCuuKH(int giothucte) {
		if (this instanceof CoHuu)
			return ((CoHuu) this).getSoGioNghiaVu() <= giothucte;
		if (this instanceof BanCoHuu)
			return ((BanCoHuu) this).getSoGioNghiaVu() <= giothucte;
		if (this instanceof ThinhGiang)
			return ((ThinhGiang) this).getSoGioThucGiang() <= giothucte;
		return false;
	}

	// 16
	public boolean ktHoanThanhNV(int gioNVthucte, int giNCthucte) {
		if (this instanceof CoHuu)
			return ((CoHuu) this).getSoGioNghiaVu() <= gioNVthucte
					&& ((CoHuu) this).getSoGioNghienCuu() <=giNCthucte;
		if (this instanceof BanCoHuu)
			return ((BanCoHuu) this).getSoGioNghiaVu() <= gioNVthucte;
		if (this instanceof ThinhGiang)
			return ((ThinhGiang) this).getSoGioThucGiang() <= gioNVthucte;
		return false;
	}

}
