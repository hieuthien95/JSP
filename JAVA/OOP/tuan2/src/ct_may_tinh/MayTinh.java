package ct_may_tinh;

import java.util.ArrayList;

public class MayTinh {
	private String maso;
	private String ten;
	private double giaban;
	private int sonambh;
	private ArrayList<PhuKien> dspk;
	
	public String getMaso() {
		return maso;
	}
	public void setMaso(String maso) {
		this.maso = maso;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getGiaban() {
		return giaban;
	}
	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
	public int getSonambh() {
		return sonambh;
	}
	public void setSonambh(int sonambh) {
		this.sonambh = sonambh;
	}
	public ArrayList<PhuKien> getDspk() {
		return dspk;
	}
	public void setDspk(ArrayList<PhuKien> dspk) {
		this.dspk = dspk;
	}
	
	public MayTinh() {
		super();
		this.maso = "";
		this.ten = "";
		this.giaban = 0;
		this.sonambh = 0;
		this.dspk = new ArrayList<PhuKien>();
	}
	
	public MayTinh(String maso, String ten, double giaban, int sonambh,
			ArrayList<PhuKien> dspk) {
		super();
		this.maso = maso;
		this.ten = ten;
		this.giaban = giaban;
		this.sonambh = sonambh;
		this.dspk = new ArrayList<PhuKien>();
		this.dspk = dspk;
	}
	
	@Override
	public String toString() {
		return "MayTinh [maso=" + maso + ", ten=" + ten + ", giaban=" + giaban
				+ ", sonambh=" + sonambh + ", dspk=" + dspk + "]";
	}
	
	public double tinhGiaBan(int thang){
		if(thang== 11 ||  thang ==12 || thang == 10)
			return this.giaban*0.9;
		if(thang== 7 ||  thang == 8 || thang == 9)
			return this.giaban*0.92;
		if(thang== 5 ||  thang == 4 || thang == 6)
			return this.giaban*0.95;
		return this.giaban;
	}	
	
}
