package kethua.qlsv;

import java.io.Serializable;
import java.util.ArrayList;

public class SinhVien implements Serializable {
	private String ten;
	private DiaChi diaChi;
	private int diemRenLuyen;
	private ArrayList<Diem> dsDiem;

	@Override
	public String toString() {
		return "SinhVien[" + ten +"," + diemRenLuyen + "," + dsDiem
				+ "]";
	}

	public SinhVien(String ten, DiaChi diaChi, int diemRenLuyen) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.diemRenLuyen = diemRenLuyen;
		this.dsDiem = new ArrayList<>();
	}

	public SinhVien() {
		super();
		this.dsDiem = new ArrayList<>();
	}

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

	public int getDiemRenLuyen() {
		return diemRenLuyen;
	}

	public void setDiemRenLuyen(int diemRenLuyen) {
		this.diemRenLuyen = diemRenLuyen;
	}

	public ArrayList<Diem> getDsDiem() {
		return dsDiem;
	}

	public void setDsDiem(ArrayList<Diem> dsDiem) {
		this.dsDiem = dsDiem;
	}
	
	public double tinhDiemTB(){
		double tong = 0;
		int count = 0;
		for (Diem i : getDsDiem()) {
			tong += i.getDiemSo();
			count++;
		}
		return tong /= count;
	}
	
	public String xepLoaiSV() {
		double tb = tinhDiemTB();		
		System.out.println("\n" + tb);
		if (tb < 5)
			return "yeu";
		else if (tb < 7)
			return "trung binh";
		else if (tb < 8)
			return "kha";
		else if (tb < 9)
			return "gioi";
		else
			return "xuat sac";
	}

}
