package kethua.ct_van_chuyen_TB_DT;

import java.io.Serializable;

public abstract class ThietBiDienTu implements Serializable{
	protected String maSo;
	protected String ten;
	protected int namSX;

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

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public ThietBiDienTu() {
		super();
	}

	public ThietBiDienTu(String maSo, String ten, int namSX) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.namSX = namSX;
	}

	@Override
	public String toString() {
		return "ThietBiDienTu [maSo=" + maSo + ", ten=" + ten + ", namSX=" + namSX + "]";
	}

	public abstract double getPhiVanChuyen();
}
