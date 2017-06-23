package kethua.cty_van_tai;

import java.io.Serializable;

public class Xe implements Serializable{
	private String ma;
	private String ten;
	private int namSX;
	private String mau;
	private TaiXe taiXe;

	public TaiXe getTaiXe() {
		return taiXe;
	}

	public void setTaiXe(TaiXe taiXe) {
		this.taiXe = taiXe;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
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

	public String getMau() {
		return mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}

	public Xe() {
		super();
	}

	public Xe(String ma, String ten, int namSX, String mau, TaiXe taiXe) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.namSX = namSX;
		this.mau = mau;
		this.taiXe = taiXe;
	}

	@Override
	public String toString() {
		return "Xe [ma=" + ma + ", ten=" + ten + ", namSX=" + namSX + ", mau=" + mau + "]";
	}

}
