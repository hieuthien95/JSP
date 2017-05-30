package sinh_vien;

import java.util.Scanner;

public class SinhVien {
	private int msv;
	private String ten;
	private String diachi;
	private String email;
	private String sdt;
	private Scanner input;
	
	public int getMsv() {
		return msv;
	}
	public void setMsv(int msv) {
		this.msv = msv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public SinhVien() {
		super();
		this.msv = 0;
		this.ten = null;
		this.diachi = null;
		this.email = null;
		this.sdt = null;
	}
	
	public SinhVien(int msv, String ten, String diachi, String email, String sdt) {
		super();
		this.msv = msv;
		this.ten = ten;
		this.diachi = diachi;
		this.email = email;
		this.sdt = sdt;
	}
	
	public boolean soSanhSV(SinhVien A){
		if(this.msv != A.msv )
			return false;
		if(!this.ten.equals(A.ten))
			return false;
		return true;
	}
	
	public boolean kiemTraMSVTrungVoiMaNhap(){
		System.out.print("Nhap MSSV: ");
		input = new Scanner(System.in);
		int ma = input.nextInt();
		if(ma==this.msv)
			return true;
		else return false;
	}
	
	public boolean kiemTraSVDungDiaChi(){
		System.out.print("Nhap Dia Chi: ");
		input = new Scanner(System.in);
		String diachi = input.nextLine();
		if(diachi.equals(this.diachi))
			return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "SinhVien: msv " + msv + ", ten " + ten + ", diachi " + diachi + ", email " + email + ", sdt " + sdt;
	}
	
	
	
	

}
