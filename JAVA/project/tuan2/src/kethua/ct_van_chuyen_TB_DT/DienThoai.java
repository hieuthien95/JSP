package kethua.ct_van_chuyen_TB_DT;

import java.io.Serializable;

public class DienThoai extends ThietBiDienTu implements Serializable{
	private String diaChiNhan;
	private String hoTenNguoiNhan;
	private double trongLuong;

	public String getDiaChiNhan() {
		return diaChiNhan;
	}

	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}

	public String getHoTenNguoiNhan() {
		return hoTenNguoiNhan;
	}

	public void setHoTenNguoiNhan(String hoTenNguoiNhan) {
		this.hoTenNguoiNhan = hoTenNguoiNhan;
	}

	public double getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(double trongLuong) {
		this.trongLuong = trongLuong;
	}

	@Override
	public double getPhiVanChuyen() {
		return trongLuong * 15000;
	}

	public DienThoai() {
		super();
	}

	public DienThoai(String maSo, String ten, int namSX, String diaChiNhan, String hoTenNguoiNhan, double trongLuong) {
		super(maSo, ten, namSX);
		this.diaChiNhan = diaChiNhan;
		this.hoTenNguoiNhan = hoTenNguoiNhan;
		this.trongLuong = trongLuong;
	}

	@Override
	public String toString() {
		return "DienThoai [" + this.getTen() + " " + this.getPhiVanChuyen() + "]";
	}

}
