package kethua.cty_van_tai;

import java.io.Serializable;

public class XeTai extends Xe implements Serializable{
	private double trongLuong;
	private double giaChuyenCho;

	public double getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(double trongLuong) {
		this.trongLuong = trongLuong;
	}

	public double getGiaChuyenCho() {
		return giaChuyenCho;
	}

	public void setGiaChuyenCho(double giaChuyenCho) {
		this.giaChuyenCho = giaChuyenCho;
	}

	public XeTai() {
		super();
	}

	public XeTai(String ma, String ten, int namSX, String mau, double trongLuong, double giaChuyenCho, TaiXe taiXe) {
		super(ma, ten, namSX, mau, taiXe);
		this.trongLuong = trongLuong;
		this.giaChuyenCho = giaChuyenCho;
	}

	@Override
	public String toString() {
		return "XeTai [trongLuong=" + trongLuong + ", giaChuyenCho=" + giaChuyenCho + "]";
	}

}
