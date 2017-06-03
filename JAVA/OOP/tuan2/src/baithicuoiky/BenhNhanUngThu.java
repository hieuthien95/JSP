package baithicuoiky;

public class BenhNhanUngThu extends BenhNhan {
	private String giaiDoan;

	public String getGiaiDoan() {
		return giaiDoan;
	}

	public void setGiaiDoan(String giaiDoan) {
		this.giaiDoan = giaiDoan;
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

	public BenhNhanUngThu() {
		super();
		giaiDoan = "";
	}

	public BenhNhanUngThu(String sCmnd, String sHoTen, int iNamSinh, boolean co, GiaiDoan gGiaiDoan) {
		super(sCmnd, sHoTen, iNamSinh, co);
		giaiDoan = gGiaiDoan.getS();
	}

	@Override
	public double tinhPhi(int soNgay) {
		double tong=0;
		double vienPhi = soNgay*15;
		if(giaiDoan.equals(GiaiDoan.mot.getS()))
			tong = soNgay*1000 + vienPhi;
		else if(giaiDoan.equals(GiaiDoan.hai.getS()))
			tong = soNgay*2500 + vienPhi;
		else if(giaiDoan.equals(GiaiDoan.ba.getS()))
			tong = soNgay*6000 + vienPhi;
		if(isCoBHYT()==true)
			return tong*0.7;
		return tong;
	}

}
