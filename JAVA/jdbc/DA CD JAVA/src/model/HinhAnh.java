package model;

public class HinhAnh {
	private int stt;
	private String loaiHinh;
	private int sttSp;
	private String hinhAnh;

	public HinhAnh() {
		super();
	}

	public HinhAnh(int stt, String loaiHinh, int sttSp, String hinhAnh) {
		super();
		this.stt = stt;
		this.loaiHinh = loaiHinh;
		this.sttSp = sttSp;
		this.hinhAnh = hinhAnh;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public int getSttSp() {
		return sttSp;
	}

	public void setSttSp(int sttSp) {
		this.sttSp = sttSp;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + loaiHinh + ", " + sttSp + ", " + hinhAnh + "]";
	}

}
