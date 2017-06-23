package kethua.cty_van_tai;

import java.io.Serializable;

public class TaiXe implements Serializable{
	private String ten;
	private String maso;
	private String sdt;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaso() {
		return maso;
	}

	public void setMaso(String maso) {
		this.maso = maso;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiXe() {
		super();
	}

	public TaiXe(String ten, String maso, String sdt) {
		super();
		this.ten = ten;
		this.maso = maso;
		this.sdt = sdt;
	}

}
