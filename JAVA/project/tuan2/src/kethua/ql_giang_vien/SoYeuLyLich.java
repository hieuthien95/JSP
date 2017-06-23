package kethua.ql_giang_vien;

import java.util.ArrayList;

public class SoYeuLyLich {
	private String ten;
	private String gioiTinh;
	private String email;
	private String sdt;

	ArrayList<BangCap> dsBangCap;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public SoYeuLyLich() {
		super();
		dsBangCap = new ArrayList<>();
	}

	public SoYeuLyLich(String ten, String gioiTinh, String email, String sdt) {
		super();
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdt = sdt;
		dsBangCap = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "SoYeuLyLich[ten=" + ten + ", gioiTinh=" + gioiTinh + ", email=" + email + ", sdt=" + sdt + "]";
	}

}
