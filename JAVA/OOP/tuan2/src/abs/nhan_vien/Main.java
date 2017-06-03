package abs.nhan_vien;

import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String []args){
		Cty ct = new Cty();	
		ct.getDsNV().add(new SalariedEmployee("Nguyen Van Csa","12345", 3800));
		ct.getDsNV().add(new HourlyEmployee("Nguyen Van Ba","312223236", 54));
		ct.getDsNV().add(new HourlyEmployee("Nguyen Van Da","312223236", 30));
		ct.getDsNV().add(new HourlyEmployee("Nguyen Van Am","312223236", 39));
		ct.getDsNV().add(new HourlyEmployee("Nguyen Van Fuc","312223236", 57));
		ct.getDsNV().add(new CommissionEmployee("Nguyen Van Em","312223236", 7500));
		ct.getDsNV().add(new SalariedCommisionEmployee("Nguyen Van Anh","312223236", 3800, 7500));
		
		System.out.println(ct.getDsNV());
		
		ct.soGioLamViec(ct.getDsNV().get(0));
		
		System.out.println(ct.tongTienPhaiTra());
		
		System.out.println(ct.layNVLuongCaoNhat());
		
		ct.inNVHourly40();
		
		Collections.sort(ct.getDsNV(), new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return -(int) (o1.getLuong()-o2.getLuong());
			}
		});
		System.out.println(ct.getDsNV());
		
		for(NhanVien i: ct.getDsNV())
			if(i.getCmnd().equals("12345"))
				ct.getDsNV().remove(i);
		System.out.println(ct.getDsNV());
		
		Collections.sort(ct.getDsNV(), new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				return o1.getTen().compareTo(o2.getTen());
			}
		});
		
		System.out.println(ct.getDsNV());
		
	}
}
