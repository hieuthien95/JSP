package kethua.cty_van_tai;

import java.io.Serializable;

public class XeKhach extends Xe implements Serializable{
	private int soChoNgoi;
	private String tuyenDuong;
	private double giaVe;

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

	public String getTuyenDuong() {
		return tuyenDuong;
	}

	public void setTuyenDuong(String tuyenDuong) {
		this.tuyenDuong = tuyenDuong;
	}

	public double getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(double giaVe) {
		this.giaVe = giaVe;
	}

	public XeKhach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public XeKhach(String ma, String ten, int namSX, String mau, int soChoNgoi, String tuyenDuong, double giaVe, TaiXe taiXe) {
		super(ma, ten, namSX, mau,taiXe);
		this.soChoNgoi = soChoNgoi;
		this.tuyenDuong = tuyenDuong;
		this.giaVe = giaVe;
	}

	@Override
	public String toString() {
		return "XeKhach [soChoNgoi=" + soChoNgoi + ", tuyenDuong=" + tuyenDuong + ", giaVe=" + giaVe + "]";
	}

}
