package ql_sinh_vien;

import java.util.Scanner;

public class SinhVien {
	private String ten;
	private int tuoi;
	private DiaChi diachi;
	private BangDiem bangdiem;
	private Scanner input;
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public DiaChi getDiachi() {
		return diachi;
	}

	public void setDiachi(DiaChi diachi) {
		this.diachi = diachi;
	}

	public BangDiem getBangdiem() {
		return bangdiem;
	}

	public void setBangdiem(BangDiem bangdiem) {
		this.bangdiem = bangdiem;
	}
	
	public SinhVien() {
		super();
		this.ten = "";
		this.tuoi = 0;
		this.diachi = null;
		this.bangdiem = null;
	}

	public SinhVien(String ten, int tuoi, DiaChi diachi, BangDiem bangdiem) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.bangdiem = bangdiem;
	}

	public float tongDiemSV(){
		return this.bangdiem.getDtoan()+this.bangdiem.getDly()+this.bangdiem.getDhoa();
	}
	
	public boolean ktDauRot(){
		if(this.bangdiem.getDtoan()<5 || this.bangdiem.getDly()<5 || this.bangdiem.getDhoa() <5)
			return false;
		else if(this.tongDiemSV()>18)
			return true;
		return false;
	}
	
	public boolean kiemTra2SVCungDC(SinhVien A){
		if(this.diachi.getTenduong().equals(A.diachi.getTenduong()) && this.diachi.getSonha().equals(A.diachi.getSonha()) && this.diachi.getTenquan().equals(A.diachi.getTenquan()))
			return true;
		return false;
	}
	
	public boolean ktSVCoCungDCNhap(){
		
		System.out.print("Nhap dia chi moi: ");
		input = new Scanner(System.in);
		String dc = input.nextLine();
		
		String DcSVThis = this.diachi.getSonha()+ ", " +this.diachi.getTenduong()+ ", " +this.diachi.getTenquan();
		
		if(dc.equals(DcSVThis))
			return true;
		
		return false;
		
	}
	
	@Override
	public String toString() {
		return "SinhVien [ten=" + ten + ", tuoi=" + tuoi + ", diachi=" + diachi + ", bangdiem=" + bangdiem + "]";
	}
	
}

