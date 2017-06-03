package abs.nhan_vien;

public class SalariedEmployee extends NhanVien {
	private double luongCoDinh;

	public String getTen() {
		return super.getTen();
	}

	public void setTen(String ten) {
		super.setTen(ten);
	}

	public String getCmnd() {
		return super.getCmnd();
	}

	public void setCmnd(String cmnd) {
		super.setCmnd(cmnd);
	}

	public double getLuongCoDinh() {
		return luongCoDinh;
	}

	public void setLuongCoDinh(double luongCoDinh) {
		this.luongCoDinh = luongCoDinh;
	}

	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(String ten, String cmnd, double luongCoDinh) {
		super(ten, cmnd);
		this.luongCoDinh = luongCoDinh;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [Ten=" + getTen() + ", " + getLuong() + "]";
	}

	@Override
	public double getLuong() {
		return luongCoDinh;
	}
}
