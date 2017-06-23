package abs.nhan_vien;

public class CommissionEmployee extends NhanVien {
	private double doanhThu;

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

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public CommissionEmployee() {
		super();
	}

	public CommissionEmployee(String ten, String cmnd, double doanhThu) {
		super(ten, cmnd);
		this.doanhThu = doanhThu;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [Ten=" + getTen() + ", " + getLuong()  + "]";
	}

	@Override
	public double getLuong() {
		return doanhThu*30/100;
	}

}
