package complex;

import java.util.ArrayList;

public class Complex {

	private int a;
	private int b;	

	//cau b
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	//cau a
	public Complex() {
		super();
		this.a = 0;
		this.b = 0;
	}
	
	public Complex(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	//cau c
	public Complex congSP(Complex A){
		Complex C = new Complex();
		C.a = this.a + A.a;
		C.b = this.b + A.b;
		return C;		
	}
	
	public Complex truSP(Complex A){
		Complex C = new Complex();
		C.a = this.a - A.a;
		C.b = this.b - A.b;
		return C;		
	}
	
	public Complex binhPhuongSP(){
		Complex C = new Complex();
		C.a = this.a*this.a - this.b*this.b;
		C.b = this.a*this.b + this.a*this.b;
		return C;		
	}

	//cau d
	@Override
	public String toString(){
		return "so phuc: " + this.a + "+" + this.b + "i";		
	}
	
	//cau f
	public static String inDanhSachSP(ArrayList<Complex> ds){
		String s="";
		for(int i=0; i<ds.size(); i++)
			s = s + ds.get(i).toString()+"\n";		
		return s;		
				
	}
	
}
