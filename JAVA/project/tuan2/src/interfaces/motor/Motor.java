package interfaces.motor;

public abstract class Motor implements IMotor{
	private String code; // Mã xe
	private String name; // Tên loại xe
	private double capacity; // Dung tích xi lanh
	private int num; // Kiểu truyền lực là mấy số

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Motor() {
		super();
	}

	public Motor(String code, String name, double capacity, int num) {
		super();
		this.code = code;
		this.name = name;
		this.capacity = capacity;
		this.num = num;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public abstract int getWarranty();
	

}
