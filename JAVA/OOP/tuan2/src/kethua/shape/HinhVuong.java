package kethua.shape;

public class HinhVuong extends HinhChuNhat{
	
	
	public HinhVuong() {
		super();
	}

	public HinhVuong(int w, int h) {
		super(w, h);
	}

	String drawing(){
		if(super.h==super.w)
			return "Drawing Square";
		else return "Drawing HinhChuNhat";
	}	
}
