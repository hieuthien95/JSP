package kethua.cty_van_tai;

import java.io.Serializable;

public class XeTaxi extends Xe implements Serializable{
	private int soChoNgoi;
	private double giaCuoc;

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

	public double getGiaCuoc() {
		return giaCuoc;
	}

	public void setGiaCuoc(double giaCuoc) {
		this.giaCuoc = giaCuoc;
	}

	public XeTaxi() {
		super();
	}

	public XeTaxi(String ma, String ten, int namSX, String mau, int soChoNgoi, double giaCuoc, TaiXe taiXe) {
		super(ma, ten, namSX, mau, taiXe);
		this.soChoNgoi = soChoNgoi;
		this.giaCuoc = giaCuoc;
	}

	@Override
	public String toString() {
		return "XeTaxi [soChoNgoi=" + soChoNgoi + ", giaCuoc=" + giaCuoc + "]";
	}

}
