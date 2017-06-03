package ct_may_tinh;

import java.util.ArrayList;

public class Main {

	public static void main(String []args){
		MayTinh mt1 = new MayTinh("ASUS102", "Asus Tranformer Book", 15, 2, new ArrayList<PhuKien>());
		MayTinh mt2 = new MayTinh("HP450", "HP Probook 450", 16, 2, new ArrayList<PhuKien>());
		MayTinh mt3 = new MayTinh("MAC13A", "Macbook Air 12 ich", 21, 1, new ArrayList<PhuKien>());
		MayTinh mt4 = new MayTinh("SN120", "Sony Vio 12 ich", 18, 1, new ArrayList<PhuKien>());
	
		CTMayTinh ct1 = new CTMayTinh("BK Computer","260 Ly thuong kiet");
		ct1.themMayTinh(mt1);
		ct1.themMayTinh(mt2);
		ct1.themMayTinh(mt3);
		ct1.themMayTinh(mt4);
		
		PhuKien pk1 = new PhuKien("pk1", "Loa", BanOrTang.BAN);
		PhuKien pk2 = new PhuKien("pk2", "tai nghe", BanOrTang.BAN);
		PhuKien pk3 = new PhuKien("pk3", "usb", BanOrTang.TANG_KEM);
		PhuKien pk4 = new PhuKien("pk4", "the nho", BanOrTang.TANG_KEM);
		
		mt1.getDspk().add(pk1);
		mt1.getDspk().add(pk2);
		mt2.getDspk().add(pk4);
		mt2.getDspk().add(pk3);
		
		mt1.setDspk(mt1.getDspk());
		mt2.setDspk(mt2.getDspk());
		
		System.out.println(ct1);
		
		System.out.println(ct1.layDSMTKM());
		
		System.out.println(mt1.tinhGiaBan(12));
		
		System.out.println(ct1.sapXepGiaMTTangDan());
	}
}
