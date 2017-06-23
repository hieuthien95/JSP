package kethua.ct_van_chuyen_TB_DT;

import java.io.Serializable;

enum LoaiMay {
	DEBAN("De ban"), XACHTAY("Xach tay");

	String s;

	LoaiMay(String s) {
		this.s = s;
	}

	String getS() {
		return s;
	}
}

public class MayTinh extends ThietBiDienTu implements Serializable{
	private String diaChiNhan;
	private String hoTenNguoiNhan;
	private String loaiMay;

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

	public String getLoaiMay() {
		return loaiMay;
	}

	public void setLoaiMay(String loaiMay) {
		this.loaiMay = loaiMay;
	}

	@Override
	public double getPhiVanChuyen() {
		if (this.getLoaiMay().equals(LoaiMay.DEBAN.getS()))
			return 100000;
		else
			return 50000;
	}

	public MayTinh() {
		super();
	}

	public MayTinh(String maSo, String ten, int namSX, String diaChiNhan, String hoTenNguoiNhan, LoaiMay loaiMay) {
		super(maSo, ten, namSX);
		this.diaChiNhan = diaChiNhan;
		this.hoTenNguoiNhan = hoTenNguoiNhan;
		this.loaiMay = loaiMay.getS();
	}

	@Override
	public String toString() {
		return "MayTinh [" + this.ten + " " + this.getPhiVanChuyen() + "]";
	}

}
