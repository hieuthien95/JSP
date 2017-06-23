package abs.nhasach;

public class SachNgoaiNgu extends Sach {
	private String thongTinNN, maDia;

	public String getThongTinNN() {
		return thongTinNN;
	}

	public void setThongTinNN(String thongTinNN) {
		this.thongTinNN = thongTinNN;
	}

	public String getMaDia() {
		return maDia;
	}

	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}

	public SachNgoaiNgu() {
		super();
	}

	public SachNgoaiNgu(String ten, String maSo, String tacGia, String nxb, int namXB, int soTrang, double giaBan, String thongTinSach, String maDia) {
		super(ten, maSo, tacGia, nxb, namXB, soTrang, giaBan);
		this.thongTinNN=thongTinSach;
		this.maDia=maDia;
	}

	@Override
	public String toString() {
		return "SachNgoaiNgu [thongTinNN=" + thongTinNN + ", maDia=" + maDia + "]";
	}

	
	
	

	
	
	

}
