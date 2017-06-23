package abs.nhan_vien;

public class HourlyEmployee extends NhanVien {
	private int gioLam;

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

	public int getGioLam() {
		return gioLam;
	}

	public void setGioLam(int gioLam) {
		this.gioLam = gioLam;
	}

	public HourlyEmployee() {
		super();
	}

	public HourlyEmployee(String ten, String cmnd, int gioLam) {
		super(ten, cmnd);
		this.gioLam = gioLam;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [Ten=" + getTen() + ", " + getLuong()  + "]";
	}

	@Override
	public double getLuong() {
		return gioLam*500;
	}

}
