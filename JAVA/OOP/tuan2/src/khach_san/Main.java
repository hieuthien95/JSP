package khach_san;

import java.util.ArrayList;

public class Main {

	public static void main(String []args){
		KhachSan k1 = new KhachSan("Khach san 1", "278 Thai Phien, P8, Q11", "01653990370", "hieuthien95@gmail.com");
		ArrayList<ThietBi> dstb1= new ArrayList<ThietBi>();
		dstb1.add(new ThietBi("TB1", "Quat", TinhTrang.HOAT_DONG, true));
		
		Phong p1 = new Phong(1, 1, 50000);
		Phong p2 = new Phong(2, 1, 70000);
		Phong p3 = new Phong(3, 1, 60000);
		Phong p4 = new Phong(4, 1, 80000);
		p1.setDsThietBi(dstb1);
		
		k1.themPhong(p1);
		k1.themPhong(p2);
		k1.themPhong(p3);
		k1.themPhong(p4);
		
//		System.out.println(k1);
//		System.out.println(k1.getDsPhong());
		System.out.println(k1.layDSPhongCoTBTinhPhi());
	}
}
