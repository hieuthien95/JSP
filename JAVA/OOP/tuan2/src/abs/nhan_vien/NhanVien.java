package abs.nhan_vien;

public abstract class NhanVien {
	private String ten, cmnd;

	public abstract double getLuong();

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String ten, String cmnd) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
	}

	@Override
	public String toString() {
		return "NhanVien [ten=" + ten + ", cmnd=" + cmnd + "]";
	}

}
