package abs.nhan_vien;

import java.util.ArrayList;

public class Cty {
	ArrayList<NhanVien> dsNV = new ArrayList<>();

	public Cty() {
		super();
		dsNV = new ArrayList<>();
	}

	public ArrayList<NhanVien> getDsNV() {
		return dsNV;
	}

	public double soGioLamViec(NhanVien nv) {
		if (nv instanceof HourlyEmployee){
			System.out.println(((HourlyEmployee) nv).getGioLam());
			return ((HourlyEmployee) nv).getGioLam();
		}
		else {
			System.out.println("khong xac dinh");
			return 0;
		}
	}

	public double tongTienPhaiTra() {
		double tong = 0;
		for (NhanVien i : dsNV)
			tong += i.getLuong();
		return tong;
	}

	public NhanVien layNVLuongCaoNhat() {
		double luongMax = dsNV.get(0).getLuong();

		for (NhanVien i : dsNV)
			if (i.getLuong() > luongMax)
				luongMax = i.getLuong();

		for (NhanVien i : dsNV)
			if (i.getLuong() == luongMax)
				return i;
		return null;
	}
	
	public void inNVHourly40(){
		for(NhanVien i: dsNV)
			if(i instanceof HourlyEmployee)
				if(((HourlyEmployee) i).getGioLam()<40)
					System.out.println(i);
	}
}
