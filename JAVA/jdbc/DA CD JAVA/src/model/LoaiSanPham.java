package model;

public class LoaiSanPham {
	private int stt;
	private String tenloai;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public LoaiSanPham() {
		super();
	}

	public LoaiSanPham(int stt, String tenloai) {
		super();
		this.stt = stt;
		this.tenloai = tenloai;
	}

	@Override
	public String toString() {
		return "[" + stt + ", " + tenloai + "]";
	}

}
