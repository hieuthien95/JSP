package dahinh.sinhvien;

public class Main {

	public static void main(String []args){
		//SinhVien sv = new SinhVien();
		//System.out.println(sv = sv.nhapSV()); 
		SinhVien sv1 = new SinhVien("Thien", new DiaChi("Thai Phien", "11", "278"), 50);
		sv1.getInfo();
	}
}
