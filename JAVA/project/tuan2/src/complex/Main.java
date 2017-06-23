package complex;

import java.util.ArrayList;

public class Main {

	public static void main(String []args){
		//cau a
		Complex A = new Complex(1,2);
		Complex B = new Complex(3,4);
		
		//cau c
		System.out.println(A.congSP(B));
		System.out.println(B.truSP(A));
		System.out.println(B.binhPhuongSP());
		
		//cau e
		ArrayList<Complex> ds = new ArrayList<Complex>();
		ds.add(A);
		ds.add(B);
		ds.add(new Complex(2,3));
		
		//cau f
		System.out.println(Complex.inDanhSachSP(ds));
		
		//cau g
		System.out.println("cong: " + ds.get(0).congSP(ds.get(1)));
		System.out.println("tru: " + ds.get(0).truSP(ds.get(1)));
	}
}
