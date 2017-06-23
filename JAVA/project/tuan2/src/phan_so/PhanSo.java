package phan_so;

public class PhanSo {

	private int tu;
	private int mau;

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public int getMau() {
		return mau;
	}

	public void setMau(int mau) {
		this.mau = mau;
	}

	public PhanSo() {
		super();
		this.tu = 0;
		this.mau = 1;
	}

	public PhanSo(int tu, int mau) {
		super();
		this.tu = tu;
		this.mau = mau;
	}

	public PhanSo rutGonPS() {
		// int ucln = 1;
		//
		// for (int i = 1; i <= this.tu; i++) {
		// if ((this.tu % i == 0) && (this.mau % i == 0)) {
		// ucln = i;
		// } else
		// ucln = 1;
		// this.tu = this.tu / ucln;
		// this.mau = this.mau / ucln;
		// }
		//
		// for (int i = 1; i <= this.tu; i++) {
		// if ((this.tu % i == 0) && (this.mau % i == 0)) {
		// ucln = i;
		// } else
		// ucln = 1;
		// this.tu = this.tu / ucln;
		// this.mau = this.mau / ucln;
		// }
		//
		// return this;
		
		int ucln=1; 
		for (int i = 1; i <= this.tu; i++) {
			ucln = ucln(this.tu, this.mau);
			this.tu = this.tu / ucln;
			this.mau = this.mau / ucln;			
		}
		return this;
	}

	public boolean soSanhPS(PhanSo A) {
		this.rutGonPS();
		A.rutGonPS();
		if (this.tu == A.tu && this.mau == A.mau)
			return true;
		return false;
	}

	public PhanSo congPS(PhanSo A) {
		PhanSo C = new PhanSo();
		C.tu = this.tu * A.mau + A.tu * this.mau;
		C.mau = this.mau * A.mau;

		C.rutGonPS();
		return C;
	}

	public PhanSo truPS(PhanSo A) {
		PhanSo C = new PhanSo();
		C.tu = this.tu * A.mau - A.tu * this.mau;
		C.mau = this.mau * A.mau;

		C.rutGonPS();
		return C;
	}

	public PhanSo nhanPS(PhanSo A) {
		PhanSo C = new PhanSo();
		C.tu = this.tu * A.tu;
		C.mau = this.mau * A.mau;

		C.rutGonPS();
		return C;
	}

	public PhanSo chiaPS(PhanSo A) {
		PhanSo C = new PhanSo();
		C.tu = this.tu * A.mau;
		C.mau = this.mau * A.tu;

		C.rutGonPS();
		return C;
	}

	private int ucln(int a, int b) {
		if (b == 0)
			return a;
		return ucln(b, a % b);
	}

	@Override
	public String toString() {
		if (this.tu == 0)
			return "Phan So: " + 0;
		else if(this.mau==1)
			return "Phan So: " + this.tu;
		else if (this.tu == this.mau)
			return "Phan So: " + 1;
		return "Phan So: " + tu + "/" + mau;
	}

}
