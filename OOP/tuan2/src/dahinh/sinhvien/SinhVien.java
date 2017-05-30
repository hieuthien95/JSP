package dahinh.sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVien {
	private String ten;
	private DiaChi diaChi;
	private int drl;
	private ArrayList<Diem> dsDiem;
	private Scanner sc;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public int getDrl() {
		return drl;
	}

	public void setDrl(int drl) {
		this.drl = drl;
	}

	public ArrayList<Diem> getDsDiem() {
		return dsDiem;
	}

	public void setDsDiem(ArrayList<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}

	public SinhVien() {
		super();
		dsDiem = new ArrayList<>();
	}

	public SinhVien(String ten, DiaChi diaChi, int drl) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.drl = drl;
		dsDiem = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "SinhVien [ten=" + ten + ", diaChi=" + diaChi + ", drl=" + drl + ", dsDiem=" + dsDiem + "]";
	}
	
	public SinhVien nhapSV(){
		sc = new Scanner(System.in);
		
		System.out.println("ten: ");
		ten = sc.nextLine();
		
		DiaChi dc = new DiaChi();
		System.out.println("So nha: ");
		dc.setSoNha(sc.nextLine());
		System.out.println("Ten duong: ");
		dc.setTenDuong(sc.nextLine());
		System.out.println("Ten quan: ");
		dc.setTenQuan(sc.nextLine());

		System.out.println("Diem ren luyen: ");
		drl = sc.nextInt();		
		
		return new SinhVien(ten, dc, drl);
	}
	
	public void getInfo(){
		System.out.println("SinhVien [ten=" + ten + ", diaChi=" + diaChi + ", drl=" + drl + ", dsDiem=" + dsDiem + "]");
	}
	
//	public SinhVien laySVCaoNhat(String hk){
//		for(SinhVien i:ds)
//	}

}
