package abs.nhasach;

public class Sach {
	private String ten, maSo, tacGia, nxb;
	private int namXB, soTrang;
	private double giaBan;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNxb() {
		return nxb;
	}
	public void setNxb(String nxb) {
		this.nxb = nxb;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public Sach() {
		super();
	}
	public Sach(String ten, String maSo, String tacGia, String nxb, int namXB, int soTrang, double giaBan) {
		super();
		this.ten = ten;
		this.maSo = maSo;
		this.tacGia = tacGia;
		this.nxb = nxb;
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.giaBan = giaBan;
	}
	@Override
	public String toString() {
		return "Sach [ten=" + ten + ", maSo=" + maSo + ", tacGia=" + tacGia + ", nxb=" + nxb + ", namXB=" + namXB
				+ ", soTrang=" + soTrang + ", giaBan=" + giaBan + "]";
	}
	
	
	

}
