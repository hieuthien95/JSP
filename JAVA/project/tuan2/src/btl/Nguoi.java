package btl;

import java.io.Serializable;

public abstract class Nguoi implements Serializable {
	private int cmnd;
	private String ten;
	private String sdt;

	public int getCmnd() {
		return cmnd;
	}

	public String getTen() {
		return ten;
	}

	public String getSdt() {
		return sdt;
	}

	public Nguoi() {
		super();
		cmnd = 0;
		ten = "";
		sdt = "";
	}

	public Nguoi(int cmnd, String ten, String sdt) {
		super();
		this.cmnd = cmnd;
		this.ten = ten;
		this.sdt = sdt;
	}

	@Override
	public abstract String toString();

}
