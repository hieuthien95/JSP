package kethua.person;

public class Main {

	public static void main(String []args){
		SinhVien sv1 = new SinhVien("Bui Hieu Thien", "312226740", 1995, "278 Thai Phien, P8, Q11", "51303402", 7.9);
		System.out.println(sv1.getInfo());
		System.out.println(new GiaoVien("Bui Hieu Thien", "312226740", 1995, "278 Thai Phien, P8, Q11", 10000000).getInfo());
	}
}
