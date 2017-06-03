package da_dien;

public class HinhChuNhat {
	private int dai;
	private int rong;
	
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	public int getRong() {
		return rong;
	}
	public void setRong(int rong) {
		this.rong = rong;
	}
	
	public HinhChuNhat() {
		super();
		this.dai = 0;
		this.rong = 0;
	}
	
	public HinhChuNhat(int dai, int rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	
	@Override
	public String toString() {
		return "HinhChuNhat [dai=" + dai + ", rong=" + rong + "]";
	}
	
	public double tinhDTHCN(){
		return dai*rong;
	}
	
	public double tinhCVHCN(){
		return (dai+rong)*2;
	}

}
