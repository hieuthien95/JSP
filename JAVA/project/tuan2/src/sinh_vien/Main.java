package sinh_vien;

public class Main {

	public static void main(String []args){
		SinhVien A = new SinhVien();
		SinhVien B = new SinhVien(51303402, "Bùi Hiếu Thiện", "278, Thái Phiên, P8, Q.11", "hieuthien95@gmail.com", "01653990370");
		
		System.out.println(A);
		System.out.println(B);
		
		A.setMsv(51303403);
		A.setTen("Nguyễn �?ại Thịnh");
		System.out.println(A.soSanhSV(B));
		
		System.out.println(A.kiemTraMSVTrungVoiMaNhap());
		System.out.println(B.kiemTraSVDungDiaChi());
	}
}
