package sinh_vien;

import org.junit.Test;

public class TestSV {

	@Test
	public void test() {
		SinhVien A = new SinhVien();
		SinhVien B = new SinhVien(51303402, "Bùi Hiếu Thiện", "278, Thái Phiên, P8, Q.11", "hieuthien95@gmail.com", "01653990370");
		A.setMsv(51303403);
		A.setTen("Nguyễn �?ại Thịnh");
		System.out.println(A.soSanhSV(B));
		
		//assertEquals(A.soSanhSV(B), false);
		//assertEquals(A.kiemTraMSVTrungVoiMaNhap(), true);
		//assertEquals(B.kiemTraSVDungDiaChi(), false);
	}

}
