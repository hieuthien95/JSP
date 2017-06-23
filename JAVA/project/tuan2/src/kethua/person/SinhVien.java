package kethua.person;

public class SinhVien extends Person {
	private String mssv;
	private double diemTB;

	public SinhVien(String ten, String cmnd, int namsinh, String diachi, String mssv, double diemTB) {
		super(ten, cmnd, namsinh, diachi);
		this.mssv = mssv;
		this.diemTB = diemTB;
	}

	public SinhVien() {
		super();
	}

	@Override
	public String toString() {
		return "SinhVien [mssv=" + mssv + ", diemTB=" + diemTB + "]";
	}

	public String getGrade() {
		if (diemTB < 5)
			return "Yeu";
		else if (diemTB >= 5 && diemTB < 6.5)
			return "Trung binh";
		else if (diemTB >= 6.5 && diemTB < 8)
			return "Kha";
		else
			return "Gioi";
	}

	public String getInfo() {
		return "I'm a student (" + (2016 - super.namsinh) + ") with grade: " + getGrade() + " " + super.getInfo();
	}
	
}
