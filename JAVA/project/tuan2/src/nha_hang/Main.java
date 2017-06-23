package nha_hang;

import java.util.ArrayList;

public class Main {

	public static void main(String []args){
		DiaChi dcA = new DiaChi("278", "Thai Phien", "Q11", "TPHCM");
		
		MonAn mon1 = new MonAn(1, "com chien", 25000);
		MonAn mon2 = new MonAn(2, "my xao", 26000);
		MonAn mon3 = new MonAn(3, "canh chua", 27000);
		MonAn mon4 = new MonAn(4, "ca kho", 28000);
		
		NhaHang A = new NhaHang("Vien Dong", dcA);
		A.themMonAn(mon1);
		A.themMonAn(mon2);
		A.themMonAn(mon3);
		A.themMonAn(mon4);
		
		System.out.println(A);
		
		System.out.println("Kiem tra mon an ton tai: " + A.kiemTraMonAnTonTai("my xao"));
		
		ArrayList<MonAn> dsMAChon = new ArrayList<MonAn>();
		dsMAChon.add(mon1);	
		dsMAChon.add(mon2);	
		dsMAChon.add(mon3);	
		dsMAChon.add(mon4);			
		System.out.println("Tinh tien: " + A.tinhTien(dsMAChon));
		
		
	}
}
