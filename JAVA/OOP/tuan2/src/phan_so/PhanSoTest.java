package phan_so;

import org.junit.Assert;
import org.junit.Test;

public class PhanSoTest {
	

	@Test
	public void test() {
		PhanSo A = new PhanSo(21,28);
		PhanSo B = new PhanSo(3,4);
		
		Assert.assertEquals(A.rutGonPS().getTu(), 3);
		
		Assert.assertEquals(A.rutGonPS().getMau(), 4);
		
		Assert.assertEquals(A.soSanhPS(B), true);
		
		Assert.assertEquals(A.congPS(B).getTu(), 3);
		Assert.assertEquals(A.congPS(B).getMau(), 2);
		
		Assert.assertEquals(A.truPS(B).getTu(), 0);
		
		Assert.assertEquals(A.nhanPS(B).getTu(), 9);
		Assert.assertEquals(A.nhanPS(B).getMau(),16);
		
		Assert.assertEquals(A.chiaPS(B).getTu(), 1);
		Assert.assertEquals(A.chiaPS(B).getMau(),1);
	}

}
