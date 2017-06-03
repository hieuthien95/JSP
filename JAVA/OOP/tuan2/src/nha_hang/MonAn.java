package nha_hang;

public class MonAn {
	private int maso;
	private String mota;
	private double gia;
	
	public int getMaso() {
		return maso;
	}
	public void setMaso(int maso) {
		this.maso = maso;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
	public MonAn() {
		super();
		this.maso = 0;
		this.mota = "";
		this.gia = 0;
	}
	
	public MonAn(int maso, String mota, double gia) {
		super();
		this.maso = maso;
		this.mota = mota;
		this.gia = gia;
	}
	
	@Override
	public String toString() {
		return "MonAn [maso=" + maso + ", mota=" + mota + ", gia=" + gia + "]";
	}
	
	
	
	
	

}
