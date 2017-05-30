package baithicuoiky;

public class BenhNhanChanThuong extends BenhNhan {
	private int capDo;

	public int getCapDo() {
		return capDo;
	}

	public void setCapDo(int capDo) {
		this.capDo = capDo;
	}

	public String getCmnd() {
		return super.getCmnd();
	}

	public void setCmnd(String cmnd) {
		super.setCmnd(cmnd);
	}

	public String getHoTen() {
		return super.getHoTen();
	}

	public void setHoTen(String hoTen) {
		super.setHoTen(hoTen);
	}

	public int getNamSinh() {
		return super.getNamSinh();
	}

	public void setNamSinh(int namSinh) {
		super.setNamSinh(namSinh);
	}

	public boolean isCoBHYT() {
		return super.isCoBHYT();
	}

	public void setCoBHYT(boolean coBHYT) {
		super.setCoBHYT(coBHYT);
	}

	public BenhNhanChanThuong() {
		super();
		capDo = 0;
	}

	public BenhNhanChanThuong(String cmnd, String hoTen, int namSinh, boolean coBHYT, int iCapDo) {
		super(cmnd, hoTen, namSinh, coBHYT);
		if (iCapDo >= 0 && iCapDo < 100)
			capDo = iCapDo;
		else if (iCapDo <= 0)
			capDo = 0;
		else if (iCapDo >= 100)
			capDo = 100;
	}

	@Override
	public double tinhPhi(int soNgay) {
		if (isCoBHYT() == true)
			return soNgay * 65 * 0.7;
		return soNgay * 65;
	}

}
