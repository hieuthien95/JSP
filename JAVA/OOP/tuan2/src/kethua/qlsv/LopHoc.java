package kethua.qlsv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LopHoc implements Serializable {
	private String maLop;
	private String Khoa;
	private ArrayList<SinhVien> dsSV;

	private Scanner sc;

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public ArrayList<SinhVien> getDsSV() {
		return dsSV;
	}

	public void setDsSV(ArrayList<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}

	public boolean themSV(SinhVien sv) {
		return dsSV.add(sv);
	}

	public SinhVien themSV() {
		sc = new Scanner(System.in);
		System.out.println("Ten: ");
		String ten = sc.nextLine();
		System.out.println("Ten duong: ");
		String tenDuong = sc.nextLine();
		System.out.println("Ten quan: ");
		String tenQuan = sc.nextLine();
		System.out.println("So nha: ");
		String soNha = sc.nextLine();
		System.out.println("Diem ren luyen: ");
		int diemRenLuyen = sc.nextInt();

		SinhVien sv = new SinhVien(ten, new DiaChi(tenDuong, tenQuan, soNha), diemRenLuyen);
		dsSV.add(sv);
		return sv;
	}

	public String layDiemCaoNhatTrongHK(String hk) {
		double diemMax = dsSV.get(0).getDsDiem().get(0).getDiemSo();
		String monMax = dsSV.get(0).getDsDiem().get(0).getTenMon();
		for (SinhVien i : dsSV)
			for (Diem j : i.getDsDiem())
				if (j.getHocKy().equals(hk))
					if (j.getDiemSo() > diemMax) {
						diemMax = j.getDiemSo();
						monMax = j.getTenMon();
					}
		return monMax;
	}

	public LopHoc() {
		super();
		dsSV = new ArrayList<>();
	}

	public LopHoc(String maLop, String khoa) {
		super();
		this.maLop = maLop;
		Khoa = khoa;
		this.dsSV = new ArrayList<>();
	}

	public void thongTinSVSX(){
		SinhVien svmax = dsSV.get(0);
		double max = dsSV.get(0).tinhDiemTB()*0.8+dsSV.get(0).getDiemRenLuyen()*0.2;
		for(SinhVien i:dsSV){
			if(i.tinhDiemTB()*0.2+i.getDiemRenLuyen()*0.8>max){
				max=i.tinhDiemTB()*0.2+i.getDiemRenLuyen()*0.8;
				svmax = i;
			}
		}
		System.out.println(svmax);
	}
	
	public ArrayList<SinhVien> sapXepDSSVBTBTLGiam(){
		Collections.sort(dsSV, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				double tmp1= sv1.tinhDiemTB()*0.2+sv1.getDiemRenLuyen()*0.8;
				double tmp2= sv2.tinhDiemTB()*0.2+sv2.getDiemRenLuyen()*0.8;
				System.out.println(tmp1 +" " + tmp2);
				
				if(tmp1 < tmp2)
					return 1;
				if(tmp1 == tmp2)
					return 0;
				else return -1;
			}
		});
		return dsSV;
	}

}
