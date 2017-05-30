package khach_san;

enum TinhTrang{
	HOAT_DONG("Hoat dong"), HU_HONG("Hu Hong");
	String s;

	TinhTrang(String str) {
		s = str;
	}

	public String getS() {
		return s;
	}
}

public class ThietBi {
	private String maSo;
	private String ten;
	private String tinhTrang;
	private boolean tinhPhi;

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

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public boolean isTinhPhi() {
		return tinhPhi;
	}

	public void setTinhPhi(boolean tinhPhi) {
		this.tinhPhi = tinhPhi;
	}

	public ThietBi() {
		super();
	}

	public ThietBi(String maSo, String ten, TinhTrang tt, boolean tinhPhi) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.tinhTrang = tt.getS();
		this.tinhPhi = tinhPhi;
	}

	@Override
	public String toString() {
		return "ThietBi [maSo=" + maSo + ", ten=" + ten + ", tinhTrang="
				+ tinhTrang + ", tinhPhi=" + tinhPhi + "]";
	}

}
