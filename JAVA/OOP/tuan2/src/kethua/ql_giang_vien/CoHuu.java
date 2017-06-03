package kethua.ql_giang_vien;

import java.util.Date;

@SuppressWarnings("deprecation")
public class CoHuu extends GiangVien implements LuongThang, NghiaVu {
	private int soGioNghienCuu;

	@Override
	public int getSoGioNghiaVu() {
		if (this.getHocVi().equals(HocVi.CUNHAN.getS()) || this.getHocVi().equals(HocVi.THACSI.getS()))
			return 460;
		if (this.getHocVi().equals(HocVi.TIENSI.getS()) || this.getHocVi().equals(HocVi.PHOGIAOSU.getS())
				|| this.getHocVi().equals(HocVi.GIAOSU.getS()))
			return 560;
		return 0;
	}

	public void setSoGioNghienCuu(int soGioNghienCuu) {
		this.soGioNghienCuu = soGioNghienCuu;
	}

	public int getSoGioNghienCuu() {
		return soGioNghienCuu;
	}

	public CoHuu() {
		super();
	}

	public CoHuu(String maSo, String ten, Date ngaySinh, HocVi hocVi, Date ngayVaoTruong, SoYeuLyLich soYeuLyLich,
			int soGioNghienCuu) {
		super(maSo, ten, ngaySinh, hocVi, ngayVaoTruong, soYeuLyLich);
		this.soGioNghienCuu = soGioNghienCuu;
	}

	@Override
	public String toString() {
		return "CoHuu[" + getMaSo() + " - " + (getNgayVaoTruong().getYear() + 1900) + " - " + getHocVi() + "]";
	}

	// 4
	@Override
	public double tinhLuong() {
		if (getHocVi().equals(HocVi.CUNHAN.getS()))
			return GiangVien.luongCoBan + GiangVien.luongCoBan * 15 / 100;
		if (getHocVi().equals(HocVi.THACSI.getS()))
			return GiangVien.luongCoBan + GiangVien.luongCoBan * 30 / 100;
		if (getHocVi().equals(HocVi.TIENSI.getS()))
			return GiangVien.luongCoBan + GiangVien.luongCoBan * 50 / 100;
		if (getHocVi().equals(HocVi.PHOGIAOSU.getS()) || getHocVi().equals(HocVi.GIAOSU.getS()))
			return GiangVien.luongCoBan + GiangVien.luongCoBan * 70 / 100;
		return 0;
	}

	// 6
	public double tinhThuLaoVuotChuan(int giothucte) {
		if (giothucte < getSoGioNghiaVu() || (giothucte - getSoGioNghiaVu()) < soGioNghienCuu)
			return 0;
		else
			return (giothucte - getSoGioNghiaVu()) * 80000 * 0.9;

	}

}
