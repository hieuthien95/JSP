package kethua.person;

public class GiaoVien extends Person {
	protected double luong;
	
	public double getSalary(){
		return luong;
	}
	
	public GiaoVien() {
		super();
	}

	public GiaoVien(String ten, String cmnd, int namsinh, String diachi, double luong) {
		super(ten, cmnd, namsinh, diachi);
		this.luong = luong;
	}

	public String getInfo(){
		return "I'm a s teacher (" + (2016-super.namsinh) + ") with salary " + luong + " " + super.getInfo();
	}

	@Override
	public String toString() {
		return "GiaoVien [luong=" + luong + "]";
	}
}
