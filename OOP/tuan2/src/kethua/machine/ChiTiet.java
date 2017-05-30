package kethua.machine;

public abstract class ChiTiet {
	private String maSo;

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public ChiTiet() {
		super();
	}

	public ChiTiet(String maSo) {
		super();
		this.maSo = maSo;
	}
	
	public abstract double tinhTien();
	
}
