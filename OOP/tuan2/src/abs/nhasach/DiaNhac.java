package abs.nhasach;

public class DiaNhac extends Dia {
	private int thoiLuong;
	
	public String getTenDia() {
		return super.getTenDia();
	}

	public void setTenDia(String tenDia) {
		super.setTenDia(tenDia);
	}

	public String getMaDia() {
		return super.getMaDia();
	}

	public void setMaDia(String maDia) {
		super.setMaDia(maDia);
	}

	public int getGiaBan() {
		return super.getGiaBan();
	}

	public void setGiaBan(int giaBan) {
		super.setGiaBan(giaBan);
	}

	public int getSoLuong() {
		return super.getSoLuong();
	}

	public void setSoLuong(int soLuong) {
		super.setSoLuong(soLuong);
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public DiaNhac() {
		super();
	}

	public DiaNhac(String tenDia, String maDia, int giaBan, int soLuong, int thoiLuong) {
		super(tenDia, maDia, giaBan, soLuong);
		this.thoiLuong = thoiLuong;
	}

	@Override
	public String toString() {
		return "DiaNhac [thoiLuong=" + thoiLuong + "]";
	}
	
	

}
