package my_date;

public class Main {
	public static int month =6;

	public static void main(String []args){
		MyDate A = new MyDate();
		MyDate B = new MyDate(29,1,2016);
		
		System.out.println(A);
		System.out.println(B);
		
		System.out.println("kiem tra: " + B.kiemTraHopLy());
		System.out.println("cong: " + A.congNgayThangNam(B));
		System.out.println("so sanh: " + A.soSanhNTN(B));
		
		MyDate a = new MyDate(15, 6, 2016);
		System.out.println(a);
		System.out.println(MyDate.daysOfYear + " " + MyDate.monthsOfYear);
		System.out.println(MyDate.daysOfMonth(month));
		System.out.println(MyDate.getCurrentYear());
		MyDate myBirthDay = new MyDate(15, 6, 2016);
		System.out.println("My birth day is " + myBirthDay);
	}
}
