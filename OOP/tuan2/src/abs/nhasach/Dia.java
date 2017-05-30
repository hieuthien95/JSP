package abs.nhasach;

public class Dia {
	private String tenDia, maDia;
	private int giaBan, soLuong;

	public String getTenDia() {
		return tenDia;
	}

	public void setTenDia(String tenDia) {
		this.tenDia = tenDia;
	}

	public String getMaDia() {
		return maDia;
	}

	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Dia() {
		super();
	}

	public Dia(String tenDia, String maDia, int giaBan, int soLuong) {
		super();
		this.tenDia = tenDia;
		this.maDia = maDia;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
	}

}
