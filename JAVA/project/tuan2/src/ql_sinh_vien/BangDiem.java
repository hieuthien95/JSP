package ql_sinh_vien;

public class BangDiem{
	private float dtoan;
	private float dly;
	private float dhoa;
	public float getDtoan() {
		return dtoan;
	}
	public void setDtoan(float dtoan) {
		this.dtoan = dtoan;
	}
	public float getDly() {
		return dly;
	}
	public void setDly(float dly) {
		this.dly = dly;
	}
	public float getDhoa() {
		return dhoa;
	}
	public void setDhoa(float dhoa) {
		this.dhoa = dhoa;
	}
	
	public BangDiem() {
		super();
		this.dtoan = 0;
		this.dly = 0;
		this.dhoa = 0;
	}
	
	public BangDiem(float dtoan, float dly, float dhoa) {
		super();
		this.dtoan = dtoan;
		this.dly = dly;
		this.dhoa = dhoa;
	}
	
	@Override
	public String toString() {
		return "BangDiem [dtoan=" + dtoan + ", dly=" + dly + ", dhoa=" + dhoa + "]";
	}			
}