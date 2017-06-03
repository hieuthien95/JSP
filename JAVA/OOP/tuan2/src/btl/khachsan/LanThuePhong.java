package btl.khachsan;

public class LanThuePhong {
	private Phong phongThue;
	private String ngayBatDau;
	private String ngayKetThuc;
	private long cmnd;

	public LanThuePhong() {
		super();
	}

	public LanThuePhong(Phong phongThue, long cmnd, String ngayBatDau, String ngayKetThuc) {
		super();
		this.phongThue = phongThue;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.cmnd = cmnd;
	}

	public LanThuePhong(Phong phongThue, long cmnd, String ngayBatDau) {
		super();
		this.phongThue = phongThue;
		this.cmnd = cmnd;
		this.ngayBatDau = ngayBatDau;
	}

	public Phong getPhongThue() {
		return phongThue;
	}

	public String getMaPhong() {
		return phongThue.getMaPhong();
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public long getCmnd() {
		return cmnd;
	}

	@Override
	public String toString() {
		return "LanThuePhong [phongThue=" + phongThue + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc
				+ ", cmnd=" + cmnd + "]";
	}

}
