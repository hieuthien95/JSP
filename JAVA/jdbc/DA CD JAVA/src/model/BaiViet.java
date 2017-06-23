package model;

public class BaiViet {
	private int stt;
	private String loaitin;
	private String tieude;
	private String tomtat;
	private String hinhanh;
	private String noidung;
	private int trangthai;

	public BaiViet() {
		super();
	}

	public BaiViet(int stt, String loaitin, String tieude, String tomtat, String hinhanh, String noidung,
			int trangthai) {
		super();
		this.stt = stt;
		this.loaitin = loaitin;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.hinhanh = hinhanh;
		this.noidung = noidung;
		this.trangthai = trangthai;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getLoaitin() {
		return loaitin;
	}

	public void setLoaitin(String loaitin) {
		this.loaitin = loaitin;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getTomtat() {
		return tomtat;
	}

	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + loaitin + ", " + tieude + 
				"\n" + tomtat
				+ ", " + hinhanh + ", " + trangthai + 
				"\n" + noidung + "]";
	}

}
