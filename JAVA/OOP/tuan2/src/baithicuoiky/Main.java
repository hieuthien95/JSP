package baithicuoiky;


public class Main {

	public static void main(String []args){
		BenhVien bv1 = new BenhVien();
		bv1.themBenhNhan(new BenhNhanUngThu("51333740", "Thien", 1995, true, GiaiDoan.mot));
		bv1.themBenhNhan(new BenhNhanChanThuong("32226740", "Su", 1995, true, 20));
		bv1.themBenhNhan(new BenhNhanUngThu());
		bv1.themBenhNhan(new BenhNhanChanThuong());
		System.out.println(bv1.themBenhNhan(new BenhNhanUngThu("123456", "Thien", 1995, true, GiaiDoan.mot)));
		System.out.println(bv1.themBenhNhan(new BenhNhanUngThu("23456", "Thien", 1995, true, GiaiDoan.mot)));
		System.out.println(bv1.themBenhNhan(new BenhNhanUngThu("51333740", "Thien", 1995, true, GiaiDoan.mot)));
		System.out.println(bv1.themBenhNhan(new BenhNhanUngThu("51333740", "Thien", 1995, true, GiaiDoan.mot)));
		System.out.println(bv1.getDsBenhNhan().get(0).tinhPhi(20));
		System.out.println(bv1.getDsBenhNhan().get(1).tinhPhi(30));
		
		BenhNhanUngThu ut1 = new BenhNhanUngThu("13356", "Thien", 1995, false, GiaiDoan.mot);
		BenhNhanChanThuong ct1 = new BenhNhanChanThuong("125", "Thien", 1995, false, 40);
		bv1.themBenhNhan(ut1);
		System.out.println(bv1.themBenhNhan(ut1));
		System.out.println(bv1.themBenhNhan(ct1));
		
		System.out.println(ut1.tinhPhi(60));
		System.out.println(ct1.tinhPhi(20));
		
	}
}
