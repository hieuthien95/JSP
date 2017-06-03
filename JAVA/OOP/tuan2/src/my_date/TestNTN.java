package my_date;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNTN {

	@Test
	public void test() {
		MyDate A = new MyDate();
		MyDate B = new MyDate(29,1,2016);
		
		//System.out.println(A.congNgayThangNam(B));
		assertEquals(B.kiemTraHopLy(), true);
		assertEquals(B.congNgayThangNam(A).getNgay(),1);
		assertEquals(B.congNgayThangNam(A).getThang(),3);
		assertEquals(B.congNgayThangNam(A).getNam(),3986);
		assertEquals(A.soSanhNTN(B),false);
	}

}
