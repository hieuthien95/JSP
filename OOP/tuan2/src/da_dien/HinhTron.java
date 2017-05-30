package da_dien;

public class HinhTron {
	public static final double PI=3.14;
	private int bankinh;
	
	public int getBankinh() {
		return bankinh;
	}
	public void setBankinh(int bankinh) {
		this.bankinh = bankinh;
	}
	
	public HinhTron() {
		super();
		this.bankinh = 0;
	}
	
	public HinhTron(int bankinh) {
		super();
		this.bankinh = bankinh;
	}
	
	@Override
	public String toString() {
		return "HinhTron [bankinh=" + bankinh + "]";
	}
	
	public double tinhDTHT(){
		return bankinh*bankinh*2*PI;
	}
	
	public double tinhCVHT(){
		return bankinh*2*PI;
	}

	
}
