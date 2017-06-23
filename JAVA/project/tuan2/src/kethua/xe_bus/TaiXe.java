package kethua.xe_bus;

public class TaiXe {
	private String maSo;
	private String ten;
	private String diaChi;
	private String sdt;

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiXe() {
		super();
	}

	public TaiXe(String maSo, String ten, String diaChi, String sdt) {
		super();
		this.maSo = maSo;
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "TaiXe [maSo=" + maSo + ", ten=" + ten + ", diaChi=" + diaChi
				+ ", sdt=" + sdt + "]";
	}

}
