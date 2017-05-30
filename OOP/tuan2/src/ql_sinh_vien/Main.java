package ql_sinh_vien;

public class Main {

	public static void main(String []args){
		
		DiaChi dcA = new DiaChi("Thai Phien","Q11","278");
		BangDiem bdA = new BangDiem(4,10,9);
		SinhVien A = new SinhVien("Bui Hieu Thien", 21, dcA, bdA);
		
		DiaChi dcB = new DiaChi("Thai Phien","Q11","279");
		
		BangDiem bdB = new BangDiem(4,10,9);
		
		SinhVien B = new SinhVien("Bui Hieu Thien", 21, dcB, bdB);
		
		System.out.println(A);
		
		System.out.println("Tong diem: " + A.tongDiemSV());
		System.out.println("Kiem tra dau rot: " + A.ktDauRot());
		
		System.out.println("Kiem tra cung dia chi: " + A.kiemTra2SVCungDC(B));
		
		System.out.println("Kiem tra dia chi nhap vao: " + A.ktSVCoCungDCNhap());
	}
}
