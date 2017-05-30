package kethua.machine;

public class ChiTietDon extends ChiTiet {
	private double giaTien;

	public String getMaSo() {
		return super.getMaSo();
	}

	public void setMaSo(String maSo) {
		super.setMaSo(maSo);
	}

	public ChiTietDon() {
		super();
	}

	public ChiTietDon(String maSo, double dgiaTien) {
		super(maSo);
		giaTien = dgiaTien;
	}

	public double tinhTien() {
		return giaTien;
	}

	@Override
	public String toString() {
		return "ChiTietDon [MaSo=" + this.getMaSo() + "]";
	}

	
}
