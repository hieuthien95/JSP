package kethua.person;

public class Person {
	protected String ten, cmnd, diachi;
	protected int namsinh;
	public final String tentruong="TDT";
	
	public Person(String ten, String cmnd, int namsinh, String diachi) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
		this.namsinh = namsinh;
		this.diachi = diachi;
	}
	
	public Person() {
		super();
	}
	
	public int getAge(){
		return namsinh;
	}
	
	public String getInfo(){
		return "I'm working at " + tentruong;
	}

	@Override
	public String toString() {
		return "Person [ten=" + ten + ", cmnd=" + cmnd + ", diachi=" + diachi + ", namsinh=" + namsinh + ", tentruong="
				+ tentruong + "]";
	}
	
	
}
