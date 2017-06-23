package kethua.shape;

public class HinhChuNhat {
	int w,h;
	
	String Drawing(){
		return "Drawing HCN or HV";
	}

	public HinhChuNhat(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	public HinhChuNhat() {
		super();
	}

	@Override
	public String toString() {
		return "HinhChuNhat [w=" + w + ", h=" + h + "]";
	}

	
}
