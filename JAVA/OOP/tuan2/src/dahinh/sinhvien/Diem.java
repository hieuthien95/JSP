package dahinh.sinhvien;

public class Diem {
	private String hocKy;
	private String tenMon;
	private double diemSo;

	public String getHocKy() {
		return hocKy;
	}

	public void setHocKy(String hocKy) {
		this.hocKy = hocKy;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public double getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(double diemSo) {
		this.diemSo = diemSo;
	}

	public Diem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diem(String hocKy, String tenMon, double diemSo) {
		super();
		this.hocKy = hocKy;
		this.tenMon = tenMon;
		this.diemSo = diemSo;
	}

	@Override
	public String toString() {
		return "Diem [hocKy=" + hocKy + ", tenMon=" + tenMon + ", diemSo=" + diemSo + "]";
	}

}
