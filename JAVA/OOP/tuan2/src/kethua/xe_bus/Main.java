package kethua.xe_bus;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		TaiXe tx1 = new TaiXe("SG001", "Nguyen Van A", "278 Thai Phien, P8, Q11", "01653990370");
		ArrayList<TaiXe> dsTX1 = new ArrayList<>();
		dsTX1.add(tx1);
		
		TuyenDuong td1 = new TuyenDuong("Sai Gon", "My Tho", 60000);
		TuyenDuong td2 = new TuyenDuong("Sai Gon", "Ben Tre", 80000);
		TuyenDuong td3 = new TuyenDuong("Sai Gon", "Long An", 50000);
		TuyenDuong td4 = new TuyenDuong("Long An", "My Tho", 30000);
		ArrayList<TuyenDuong> dsTD1 = new ArrayList<>();
		dsTD1.add(td1);
		dsTD1.add(td2);
		dsTD1.add(td3);
		dsTD1.add(td4);
		
		Xe x1 = new Xe("Duy Quy", "Xe khach 24 cho");
		x1.setDsTuyeDuong(dsTD1);
		x1.setDsTaiXe(dsTX1);
		
		System.out.println(x1);
		System.out.println(x1.layTuyeDuongGiaCaoNhat());
		System.out.println(x1.layDSTDGiaNhoHon(60000));
		System.out.println(x1.sapXepGiaTuyenDuong());	
		System.out.println(x1.layDSCoDiemBD("Sai Gon"));	
	}
}
