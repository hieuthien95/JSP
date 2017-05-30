package kethua.machine;

public class Main {

	public static void main(String []args){
		May m1=new May();		

//		ChiTietPhuc p4 = new ChiTietPhuc("P4");
//		p4.themChiTiet(new ChiTietDon("A41", 50));
//		p4.themChiTiet(new ChiTietDon("A42", 150));
//		
		ChiTietPhuc p3 = new ChiTietPhuc("P3");
//		p3.themChiTiet(new ChiTietDon("A31", 50));
//		p3.themChiTiet(new ChiTietDon("A32", 150));
//		p3.themChiTiet(p4);		
		
		ChiTietPhuc p2 = new ChiTietPhuc("P2");
		p2.themChiTiet(new ChiTietDon("B21", 100));
		p2.themChiTiet(p3);
		
		ChiTietPhuc p1 = new ChiTietPhuc("P1");
		p1.themChiTiet(new ChiTietDon("A11", 100));
//		p1.themChiTiet(new ChiTietDon("A12", 200));
		p1.themChiTiet(p2);
		
//		m1.themChiTiet(new ChiTietDon("A1", 100));
//		m1.themChiTiet(new ChiTietDon("A2", 200));
//		m1.themChiTiet(new ChiTietDon("A3", 100));
//		m1.themChiTiet(p1);
		
//		System.out.println(m1);
//		
//		System.out.println(m1.timChiTiet("A41"));
		
		System.out.println("tien " + p1.tinhTien());
		
//		System.out.println(m1.getDsChiTiets());
//		
//		int countCTDon=0;
//		for(ChiTiet i: m1.getDsChiTiets())
//			if(i instanceof ChiTietDon)
//				countCTDon++;
//		System.out.println(countCTDon);
	}
}
