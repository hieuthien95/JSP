package kethua.ql_giang_vien;

import java.util.Date;

@SuppressWarnings("deprecation")
public class ThinhGiang extends GiangVien implements ThuLao {
	private String hocKyDay;
	private int soGioThucGiang;

	public String getHocKyDay() {
		return hocKyDay;
	}

	public void setHocKyDay(String hocKyDay) {
		this.hocKyDay = hocKyDay;
	}

	public int getSoGioThucGiang() {
		return soGioThucGiang;
	}

	public void setSoGioThucGiang(int soGioThucGiang) {
		this.soGioThucGiang = soGioThucGiang;
	}

	public ThinhGiang() {
		super();
	}

	public ThinhGiang(String maSo, String ten, Date ngaySinh, HocVi hocVi, Date ngayVaoTruong, SoYeuLyLich soYeuLyLich,
			String hocKyDay, int soGioThucGiang) {
		super(maSo, ten, ngaySinh, hocVi, ngayVaoTruong, soYeuLyLich);
		this.hocKyDay = hocKyDay;
		this.soGioThucGiang = soGioThucGiang;
	}

	@Override
	public String toString() {
		return "ThinhGiang[" + getMaSo() + " - " + (getNgayVaoTruong().getYear() + 1900) + " - " + getHocVi() + "]";
	}

	@Override
	public double tinhThuLao() {
		return 100000 * getSoGioThucGiang()*0.9;
	}

}
