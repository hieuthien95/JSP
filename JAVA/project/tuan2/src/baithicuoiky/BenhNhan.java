package baithicuoiky;

public abstract class BenhNhan {
	private String cmnd;
	private String hoTen;
	private int namSinh;
	private boolean coBHYT;

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public boolean isCoBHYT() {
		return coBHYT;
	}

	public void setCoBHYT(boolean coBHYT) {
		this.coBHYT = coBHYT;
	}

	public BenhNhan() {
		this.cmnd = "";
		this.hoTen = "";
		this.namSinh = 0;
		this.coBHYT = false;
	}

	public BenhNhan(String cmnd, String hoTen, int namSinh, boolean coBHYT) {
		super();
		this.cmnd = cmnd;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.coBHYT = coBHYT;
	}

	public abstract double tinhPhi(int soNgay);

}
