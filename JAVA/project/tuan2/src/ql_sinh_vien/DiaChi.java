package ql_sinh_vien;

public class DiaChi{
	private String tenduong;
	private String tenquan;
	private String sonha;
	
	public String getTenduong() {
		return tenduong;
	}
	public void setTenduong(String tenduong) {
		this.tenduong = tenduong;
	}
	public String getTenquan() {
		return tenquan;
	}
	public void setTenquan(String tenquan) {
		this.tenquan = tenquan;
	}
	public String getSonha() {
		return sonha;
	}
	public void setSonha(String sonha) {
		this.sonha = sonha;
	}
	
	public DiaChi(String tenduong, String tenquan, String sonha) {
		super();
		this.tenduong = tenduong;
		this.tenquan = tenquan;
		this.sonha = sonha;
	}
	
	public DiaChi() {
		super();
		this.tenduong = "";
		this.tenquan = "";
		this.sonha = "";
	}
	
	@Override
	public String toString() {
		return "DiaChi [tenduong=" + tenduong + ", tenquan=" + tenquan + ", sonha=" + sonha + "]";
	}	
}