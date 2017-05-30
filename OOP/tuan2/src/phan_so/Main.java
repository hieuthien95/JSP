package phan_so;

public class Main {

	public static void main(String []args){
		PhanSo A = new PhanSo(21,28);
		PhanSo B = new PhanSo(3,4);

		System.out.println("Rut Gon " + A.rutGonPS());
		
		System.out.println(A.soSanhPS(B));
		
		System.out.println("Cong " + A.congPS(B));
		System.out.println("Tru " + A.truPS(B));
		System.out.println("Nhan " + A.nhanPS(B));
		System.out.println("Chia " + A.chiaPS(B));
	}
}
