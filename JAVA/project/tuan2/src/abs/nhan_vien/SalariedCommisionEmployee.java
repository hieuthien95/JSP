package abs.nhan_vien;

public class SalariedCommisionEmployee extends SalariedEmployee {
	private double doanhThu;

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

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
		return super.getLuongCoDinh();
	}

	public void setLuongCoDinh(double luongCoDinh) {
		super.setLuongCoDinh(luongCoDinh);
	}

	public SalariedCommisionEmployee() {
		super();
	}

	public SalariedCommisionEmployee(String ten, String cmnd, double luongCoDinh, double doanhThu) {
		super(ten, cmnd, luongCoDinh);
		this.doanhThu = doanhThu;
	}

	@Override
	public String toString() {
		return "SalariedCommisionEmployee [Ten=" + getTen() + ", " + getLuong()  + "]";
	}

	@Override
	public double getLuong() {
		return getLuongCoDinh()+doanhThu*30/100;
	}
}
