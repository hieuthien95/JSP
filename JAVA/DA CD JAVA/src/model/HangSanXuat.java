package model;

public class HangSanXuat {
	private int stt;
	private String maHang;
	private String tenHang;
	private String sttloaisp;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getSttloaisp() {
		return sttloaisp;
	}

	public void setSttloaisp(String sttloaisp) {
		this.sttloaisp = sttloaisp;
	}

	public HangSanXuat(int stt, String maHang, String tenHang, String sttloaisp) {
		super();
		this.stt = stt;
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.sttloaisp = sttloaisp;
	}

	public HangSanXuat() {
		super();
	}

	@Override
	public String toString() {
		return "HangSanXuat [maHang=" + maHang + ", tenHang=" + tenHang + ", sttloaisp=" + sttloaisp + "]";
	}

}
