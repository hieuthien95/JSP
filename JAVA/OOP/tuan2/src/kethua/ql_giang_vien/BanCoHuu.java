package kethua.ql_giang_vien;

import java.util.Date;

@SuppressWarnings("deprecation")
public class BanCoHuu extends GiangVien implements LuongThang, NghiaVu {

	@Override
	public int getSoGioNghiaVu() {
		if (this.getHocVi().equals(HocVi.CUNHAN.getS()) || this.getHocVi().equals(HocVi.THACSI.getS()))
			return 460 * 30 / 100;
		if (this.getHocVi().equals(HocVi.TIENSI.getS()) || this.getHocVi().equals(HocVi.PHOGIAOSU.getS())
				|| this.getHocVi().equals(HocVi.GIAOSU.getS()))
			return 560 * 30 / 100;
		return 0;
	}

	public void setSoGioNghiaVu(int soGioNghiaVu) {
	}

	public BanCoHuu() {
		super();
	}

	public BanCoHuu(String maSo, String ten, Date ngaySinh, HocVi hocVi, Date ngayVaoTruong, SoYeuLyLich soYeuLyLich) {
		super(maSo, ten, ngaySinh, hocVi, ngayVaoTruong, soYeuLyLich);
	}

	@Override
	public String toString() {
		return "BanCoHuu[" + getMaSo() + " - " + (getNgayVaoTruong().getYear() + 1900) + " - " + getHocVi() + "]";
	}

	// 4
	@Override
	public double tinhLuong() {
		return GiangVien.luongCoBan;
	}
}
