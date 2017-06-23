package model;

public class Video {
	private int stt;
	private String ten;
	private String hinhanh;
	private int trangthai;
	private String duongdan;
	private String noidung;

	public Video(int stt, String ten, String hinhanh, int trangthai, String duongdan, String noidung) {
		super();
		this.stt = stt;
		this.ten = ten;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.duongdan = duongdan;
		this.noidung = noidung;
	}

	public Video() {
		super();
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getDuongdan() {
		return duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + ten + ", " + hinhanh + ", " + trangthai + "\n" + duongdan + ", " + noidung + "]";
	}

}
