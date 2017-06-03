package abs.nhasach;

public class DiaPhim extends DiaNhac {

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
		return super.getThoiLuong();
	}

	public void setThoiLuong(int thoiLuong) {
		super.setThoiLuong(thoiLuong);
	}

	public DiaPhim() {
		super();
	}

	public DiaPhim(String tenDia, String maDia, int giaBan, int soLuong, int thoiLuong) {
		super(tenDia, maDia, giaBan, soLuong, thoiLuong);
	}

	@Override
	public String toString() {
		return "DiaPhim [thoiLuong=" + getThoiLuong() + "]";
	}

}
