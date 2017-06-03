package da_dien;

public class Main {

	public static void main(String []args){
		HinhTron ht1 = new HinhTron(2);
		HinhChuNhat hcn1 = new HinhChuNhat(2,3);
		HinhTamGiac htg1 = new HinhTamGiac(3, 4, 5);
		
		System.out.println(ht1.tinhCVHT());
		System.out.println(ht1.tinhDTHT());
		
		System.out.println(hcn1.tinhCVHCN());
		System.out.println(hcn1.tinhDTHCN());
		
		System.out.println(htg1.tinhCVTG());
		System.out.println(htg1.tinhDTTG());
	}
}
